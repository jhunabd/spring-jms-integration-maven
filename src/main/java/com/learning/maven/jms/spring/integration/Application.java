package com.learning.maven.jms.spring.integration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@EnableJms
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(Application.class);
		Sender sender = context.getBean(Sender.class);
		sender.send("test.queue","ceyhun test");
//		System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
	}

	@Bean
	public JmsListenerContainerFactory warehouseFactory(ConnectionFactory factory, DefaultJmsListenerContainerFactoryConfigurer configurer){
		DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		defaultJmsListenerContainerFactory.setConcurrency("1-1");
		configurer.configure(defaultJmsListenerContainerFactory,factory);
		return defaultJmsListenerContainerFactory;
	}



	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory(){
		return new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");
	}



	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
		return new JmsTemplate(connectionFactory);
	}

}
