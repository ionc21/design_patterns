package chain_of_responsability.chain.handler;

import org.springframework.beans.factory.annotation.Autowired;

class NullObjectChainHandler extends AbstractChainHandler {

	private static volatile ChainHandler INSTANCE = null;

	private NullObjectChainHandler() {
		// TODO Auto-generated constructor stub
	}

	public static ChainHandler getInstance() {
		synchronized (NullObjectChainHandler.class) {
			if (INSTANCE == null) {
				synchronized (NullObjectChainHandler.class) {
					INSTANCE = new NullObjectChainHandler();
				}
			}
		}
		
		return INSTANCE;
	}
	
	@Autowired
	public NullObjectChainHandler(ChainHandler nextChain) {
		super(nextChain);
	}

	@Override
	protected void doHandle(ATMContext ctx) {
		throw new IllegalStateException("Not callable");
	}

	@Override
	protected boolean isHandable(ATMContext ctx) {
		return true;
	}

}
