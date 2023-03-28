package br.com.itads.processor.transaction.services.interfaces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.itads.miniauth.commons.dto.TransactionDTO;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public interface TransactionService {


  /**
   * 
   * @param cardDTO
   * @return
   */
  @RequestMapping(value = "/transactionService",
            produces = { "application/json" }, 
            consumes = { "application/json" }, 
            method = RequestMethod.POST)
  void createNewTransaction(TransactionDTO body);  
  
}
