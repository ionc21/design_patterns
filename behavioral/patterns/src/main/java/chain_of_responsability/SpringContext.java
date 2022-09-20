package chain_of_responsability;

import chain_of_responsability.chain.ATMService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackageClasses = {ATMService.class})
@PropertySource(
        value={"classpath:configuration.properties"})
public class SpringContext {

}
