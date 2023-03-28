package br.com.itads.processor.events.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import br.com.itads.miniauth.commons.dto.TransactionDTO;
import br.com.itads.miniauth.commons.exception.TransactionNotAllowedException;
import br.com.itads.miniauth.commons.responses.TransactionResponse;
import br.com.itads.processor.events.controller.interfaces.TransactionControllerInterface;
import br.com.itads.processor.events.services.MiniAuthFeignClient;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@RestController
public class TransactionController implements TransactionControllerInterface {

  /**
   * 
   */
  @Autowired
  private MiniAuthFeignClient service;

  /**
   * 
   */
  @Override
  public ResponseEntity<TransactionResponse> createNewTransaction(
      MultiValueMap<String, String> header, TransactionDTO body) {

    ResponseEntity<TransactionResponse> responseEntity;

    try {

      service.createNewTransaction(body);

      responseEntity = new ResponseEntity<TransactionResponse>(HttpStatus.OK);

    } catch (TransactionNotAllowedException e) {

      responseEntity = new ResponseEntity<TransactionResponse>(HttpStatus.NOT_FOUND);

    }

    return responseEntity;

  }

}
