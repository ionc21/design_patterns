package com.pgs.soft.pduleba;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.pgs.soft.pduleba.chain.ATMService;

@Configuration
@ComponentScan(basePackageClasses = {ATMService.class})
@PropertySource(
        value={"classpath:configuration.properties"})
public class SpringContext {

}
