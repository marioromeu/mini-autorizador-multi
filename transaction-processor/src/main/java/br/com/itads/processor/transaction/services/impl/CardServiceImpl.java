package br.com.itads.processor.transaction.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import br.com.itads.miniauth.commons.dto.CardDTO;
import br.com.itads.processor.transaction.model.Card;
import br.com.itads.processor.transaction.repository.CardRepository;
import br.com.itads.processor.transaction.services.interfaces.CardService;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@RestController
public class CardServiceImpl implements CardService {

  /**
   * 
   */
  @Autowired
  private CardRepository repository;
  
  /**
   * 
   */
  @Override
  public void createNewCard(CardDTO cardDTO) {

    Card card = Card.builder()
        .funds(500d)        
        .number(cardDTO.getNumeroCartao())        
        .password(cardDTO.getSenha())
        .build();
    
    repository.save(card);

  }

  /**
   * 
   */
  @Override
  public Card findCardByNumber(String cardNumber) {
    return repository.findCardByNumber(cardNumber);
  }

}
