package com.learning.maven.jms.spring.integration.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public MessageConverter jacksonMessageConverter(){
        MappingJackson2MessageConverter jackson2MessageConverter = new MappingJackson2MessageConverter();
        jackson2MessageConverter.setTargetType(MessageType.TEXT);
        jackson2MessageConverter.setTypeIdPropertyName("_type");
        return jackson2MessageConverter;
    }

//    @Bean
//    public JmsListenerContainerFactory warehouseFactory(ConnectionFactory factory, DefaultJmsListenerContainerFactoryConfigurer configurer){
//        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
//        defaultJmsListenerContainerFactory.setConcurrency("1-1");
//        defaultJmsListenerContainerFactory.setMessageConverter(jacksonMessageConverter());
//        configurer.configure(defaultJmsListenerContainerFactory,factory);
//        return defaultJmsListenerContainerFactory;
//    }



    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        return new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");
    }



//    @Bean
//    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
//        return new JmsTemplate(connectionFactory);
//    }

}
