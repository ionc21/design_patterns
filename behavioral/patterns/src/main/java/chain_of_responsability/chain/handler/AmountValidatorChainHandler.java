package chain_of_responsability.chain.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmountValidatorChainHandler extends AbstractChainHandler {

	@Autowired
	public AmountValidatorChainHandler(PLN50WithdrawChainHandler nextChain) {
		super(nextChain);
	}

	@Override
	protected void doHandle(ATMContext ctx) {
		ctx.set(KEY_ATM_MESSAGE, "Invalid requested amount");
	}

	@Override
	protected boolean isHandable(ATMContext ctx) {
		boolean result = true;
		try {
			String requestedAmount = ctx.get(KEY_ATM_REQUESTED_AMOUNT);
			if (requestedAmount == null || requestedAmount.isEmpty()) {
				result = true;
			} else {
				ctx.setRequestedAmount(Integer.valueOf(requestedAmount));
				result = false;
			}
		} catch (Exception e) {
			result = true;
		} 
		
		return result;
	}

}
