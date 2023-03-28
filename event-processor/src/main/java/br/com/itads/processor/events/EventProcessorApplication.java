package br.com.itads.processor.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@SpringBootApplication
@EnableFeignClients
public class EventProcessorApplication {


  /**
   * 
   * @param args
   */
  public static void main(String[] args) {

    /**
     * 
     */
    SpringApplication.run(EventProcessorApplication.class, args);
  }

}
