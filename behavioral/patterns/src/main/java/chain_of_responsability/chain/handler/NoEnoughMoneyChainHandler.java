package chain_of_responsability.chain.handler;

import java.text.MessageFormat;
import java.util.Objects;

import chain_of_responsability.chain.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoEnoughMoneyChainHandler extends AbstractChainHandler {

	private ATMService atm;

	@Autowired
	public NoEnoughMoneyChainHandler(ATMService atm) {
		super(NullObjectChainHandler.getInstance());
		Objects.requireNonNull(atm, "ATM is null");
		this.atm = atm;
	}

	@Override
	protected void doHandle(ATMContext ctx) {
		ctx.set(KEY_ATM_MESSAGE, MessageFormat.format("Not enough money in ATM :: Saldo :: {0}", atm.saldo()));
	}

	@Override
	protected boolean isHandable(ATMContext ctx) {
		return true;
	}

}
