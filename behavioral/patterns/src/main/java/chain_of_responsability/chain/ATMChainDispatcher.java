package chain_of_responsability.chain;

import java.util.Objects;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chain_of_responsability.chain.handler.ATMContext;
import chain_of_responsability.chain.handler.ChainHandler;
import chain_of_responsability.chain.handler.PinValidatorChainHandler;

@Service
public class ATMChainDispatcher {

	public static final Logger LOG = LoggerFactory.getLogger(ATMChainDispatcher.class);

	private PinValidatorChainHandler init;

	@Autowired
	public ATMChainDispatcher(PinValidatorChainHandler initChain) {
		super();
		Objects.requireNonNull(initChain, "PinValidatorChainHandler is null");
		this.init = initChain;
	}

	public void run() throws Exception {
		
		try (Scanner input = new Scanner(System.in)) {
			while (true) {
				ATMContext ctx = new ATMContext();
				
				System.out.println("Enter pin:");
				ctx.set(ChainHandler.KEY_ATM_PIN, input.next());
				System.out.println("Enter requested amount:");
				ctx.set(ChainHandler.KEY_ATM_REQUESTED_AMOUNT, input.next());
				
				init.run(ctx);
				
				LOG.info("RESULT :: {} ", ctx.result());
				System.out.println("Ok?");
			}
		}
	}

}
