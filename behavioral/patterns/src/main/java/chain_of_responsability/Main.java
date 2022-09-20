package chain_of_responsability;

import chain_of_responsability.chain.ATMChainDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		new Main().execute();
	}

	private void execute() {
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringContext.class)) {
			ATMChainDispatcher boot = ctx.getBean(ATMChainDispatcher.class);
			boot.run();
		} catch (Exception e) {
			LOG.error("Error", e);
		}
	}
}
