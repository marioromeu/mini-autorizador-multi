package br.com.itads.processor.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.itads.processor.transaction.model.Card;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

  /**
   * 
   * @param cardNumber
   * @return
   */
  Card findCardByNumber(String cardNumber);

  /**
   * 
   */
  Card save(Card card);
  
}