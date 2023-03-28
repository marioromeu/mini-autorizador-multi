package br.com.itads.processor.transaction.services.interfaces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.itads.miniauth.commons.dto.CardDTO;
import br.com.itads.miniauth.commons.exception.CardAlreadyExists;
import br.com.itads.miniauth.commons.exception.CardNotFoundException;
import br.com.itads.processor.transaction.model.Card;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public interface CardService {

  /**
   * 
   * @param cardDTO
   * @return
   */
  @RequestMapping(value = "/createNewCard",
            produces = { "application/json" }, 
            consumes = { "application/json" }, 
            method = RequestMethod.POST)
  void createNewCard(CardDTO cardDTO) throws CardAlreadyExists;
  
  /**
   * 
   * @param numeroCartao
   * @return
   */
  @RequestMapping(value = "/findCardByNumber",
      produces = { "application/json" }, 
      consumes = { "application/json" }, 
      method = RequestMethod.GET)
  Card findCardByNumber(String cardNumber) throws CardNotFoundException;
  
}
