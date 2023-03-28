package br.com.itads.processor.events.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.itads.miniauth.commons.dto.CardDTO;
import br.com.itads.miniauth.commons.dto.TransactionDTO;
import br.com.itads.miniauth.commons.exception.CardAlreadyExists;
import br.com.itads.miniauth.commons.exception.CardNotFoundException;
import br.com.itads.miniauth.commons.exception.TransactionNotAllowedException;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@FeignClient("transaction-processor")
public interface MiniAuthFeignClient {

  /**
   * 
   * @param cardDTO
   * @return
   */
  @RequestMapping(value = "/createNewCard",
            produces = { "application/json" }, 
            consumes = { "application/json" }, 
            method = RequestMethod.POST)
  public void createNewCard(CardDTO cardDTO) throws CardAlreadyExists;
  
  /**
   * 
   * @param numeroCartao
   * @return
   */
  @RequestMapping(value = "/findCardByNumber",
      produces = { "application/json" }, 
      consumes = { "application/json" }, 
      method = RequestMethod.GET)
  public CardDTO findCardByNumber(String numeroCartao) throws CardNotFoundException;
  
  /**
   * 
   * @param body
   * @return
   */
  @RequestMapping(value = "/createNewTransaction",
      produces = { "application/json" }, 
      consumes = { "application/json" }, 
      method = RequestMethod.POST)  
  public void createNewTransaction(TransactionDTO body) throws TransactionNotAllowedException;    
  
}
