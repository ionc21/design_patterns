package chain_of_responsability.chain.handler;

public interface ChainHandler {

	String KEY_ATM_PIN = "key.atm.pin";
	String KEY_ATM_REQUESTED_AMOUNT = "key.atm.requested.amount";

	String KEY_ATM_MESSAGE = "key.atm.message";
	
	void run(ATMContext ctx) throws Exception;
}
