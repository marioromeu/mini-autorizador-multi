package br.com.itads.processor.transaction.services.impl;

import org.springframework.web.bind.annotation.RestController;
import br.com.itads.miniauth.commons.dto.TransactionDTO;
import br.com.itads.processor.transaction.services.interfaces.TransactionService;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@RestController
public class TransactionServiceImpl implements TransactionService {

  /**
   * 
   */
  @Override
  public void createNewTransaction(TransactionDTO body) {

  }
  
}
