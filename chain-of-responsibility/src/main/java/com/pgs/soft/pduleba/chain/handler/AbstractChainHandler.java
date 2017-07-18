package com.pgs.soft.pduleba.chain.handler;

import java.util.Objects;

public abstract class AbstractChainHandler implements ChainHandler {

	private ChainHandler chain;

	// default for NullObjectChainHandler
	AbstractChainHandler() {
		super();
	}

	public AbstractChainHandler(ChainHandler nextChain) {
		super();
		Objects.requireNonNull(nextChain, "Next chain can not be null");
		this.chain = nextChain;
	}

	@Override
	public final void run(ATMContext ctx) throws Exception {
		if (isHandable(ctx)) {
			doHandle(ctx);
		} else {
			chain.run(ctx);
		}
	}

	protected abstract void doHandle(ATMContext ctx);

	protected abstract boolean isHandable(ATMContext ctx);

}
