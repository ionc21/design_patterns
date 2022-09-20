package chain_of_responsability.chain.handler;

import java.util.HashMap;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PROTECTED) 
public class ATMContext {

	private int requestedAmount = -1;
	
	private HashMap<String, String> bag = new HashMap<>();
	
	public String get(final String key) {
		return bag.get(key);
	}

	public void set(String key, String value) {
		bag.put(key, value);
	}

	public boolean contains(String key) {
		return bag.containsKey(key);
	}

	
	public String result() {
		return get(ChainHandler.KEY_ATM_MESSAGE);
	}
}
