package br.com.itads.miniauth.commons.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {

  /**
   * 
   */
  private String senha;
  
  /**
   * 
   */
  private String numeroCartao;
  
}
