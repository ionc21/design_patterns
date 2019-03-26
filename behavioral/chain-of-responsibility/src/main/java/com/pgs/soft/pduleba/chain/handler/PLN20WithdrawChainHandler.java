package com.pgs.soft.pduleba.chain.handler;

import java.text.MessageFormat;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pgs.soft.pduleba.chain.ATMService;

@Component
public class PLN20WithdrawChainHandler extends AbstractChainHandler {

	private ATMService atm;

	@Autowired
	public PLN20WithdrawChainHandler(PLN10WithdrawChainHandler nextChain, ATMService atm) {
		super(nextChain);
		Objects.requireNonNull(atm, "ATM is null");
		this.atm = atm;
	}

	@Override
	protected void doHandle(ATMContext ctx) {
		atm.withdraw(ctx.getRequestedAmount());
		ctx.set(KEY_ATM_MESSAGE, MessageFormat.format("Withdraw by PLN20 Chain :: Saldo {0}", atm.saldo()));
	}

	@Override
	protected boolean isHandable(ATMContext ctx) {
		return atm.contains(20) && atm.contains(ctx.getRequestedAmount());
	}

}
