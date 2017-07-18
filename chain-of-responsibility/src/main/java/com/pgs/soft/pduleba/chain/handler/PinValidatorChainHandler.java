package com.pgs.soft.pduleba.chain.handler;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PinValidatorChainHandler extends AbstractChainHandler {
	
	private String pin;

	@Autowired
	public PinValidatorChainHandler(AmountValidatorChainHandler nextChain, @Value("${atm.pin}") String pin) {
		super(nextChain);
		Objects.requireNonNull(pin, "Pin is null");
		this.pin = pin;
	}

	@Override
	protected void doHandle(ATMContext ctx) {
		ctx.set(KEY_ATM_MESSAGE, "Invalid pin provided");
	}

	@Override
	protected boolean isHandable(ATMContext ctx) {
		return pin.equalsIgnoreCase(ctx.get(KEY_ATM_PIN)) == false;
	}

}
