package br.com.itads.discover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server Application
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        /**
         * 
         */
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}