package br.com.itads.processor.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories("br.com.itads.*")
@ComponentScan(basePackages = { "br.com.itads.*" })
@EntityScan("br.com.itads.*")   
public class TransactionProcessorApplication {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {

    /**
     * 
     */
    SpringApplication.run(TransactionProcessorApplication.class, args);
  }

}
