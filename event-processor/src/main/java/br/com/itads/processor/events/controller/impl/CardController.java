package br.com.itads.processor.events.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import br.com.itads.miniauth.commons.dto.CardDTO;
import br.com.itads.miniauth.commons.exception.CardAlreadyExists;
import br.com.itads.miniauth.commons.exception.CardNotFoundException;
import br.com.itads.miniauth.commons.responses.CardResponse;
import br.com.itads.processor.events.controller.interfaces.CardControllerInterface;
import br.com.itads.processor.events.services.MiniAuthFeignClient;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@RestController
public class CardController implements CardControllerInterface {

  /**
   * 
   */
  @Autowired
  private MiniAuthFeignClient service;

  /**
   * 
   */
  @Override
  public ResponseEntity<CardResponse> createNewCard(
      MultiValueMap<String, String> header,
      CardDTO body) {

    ResponseEntity<CardResponse> responseEntity = null;

    try {

      service.createNewCard(body);

      CardResponse cardResponse =
          CardResponse.builder()
          .senha(body.getSenha())
          .numeroCartao(body.getNumeroCartao())
          .build();

      responseEntity = new ResponseEntity<CardResponse>(cardResponse, HttpStatus.OK);

    } catch (CardAlreadyExists e) {

      responseEntity = new ResponseEntity<CardResponse>(HttpStatus.NOT_FOUND);

    }

    return responseEntity;

  }

  /**
   * 
   */
  @Override
  public ResponseEntity<CardResponse> findCardByNumber(MultiValueMap<String, String> header,
      String numeroCartao) {

    ResponseEntity<CardResponse> responseEntity = null;

    try {

      CardDTO dto = service.findCardByNumber(numeroCartao);

      CardResponse cardResponse =
          CardResponse.builder().senha(dto.getSenha()).numeroCartao(dto.getNumeroCartao()).build();

      responseEntity = new ResponseEntity<CardResponse>(cardResponse, HttpStatus.OK);

    } catch (CardNotFoundException e) {

      responseEntity = new ResponseEntity<CardResponse>(HttpStatus.NOT_FOUND);

    }

    return responseEntity;

  }

}
