/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque;

import com.banque.banque.rmi.BanqueRmiRemote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 *
 * @author HP
 */
@Configuration
public class MyConfig {

    @Bean
    public SimpleJaxWsServiceExporter getJWS() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8089/maBanque");
        return exporter;
    }

    @Bean
    public RmiServiceExporter getRmiService(ApplicationContext ctx) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(ctx.getBean("myRmiService"));
        exporter.setRegistryPort(1099);
        exporter.setServiceInterface(BanqueRmiRemote.class);
        exporter.setServiceName("BK");
        return exporter;
    }
}
