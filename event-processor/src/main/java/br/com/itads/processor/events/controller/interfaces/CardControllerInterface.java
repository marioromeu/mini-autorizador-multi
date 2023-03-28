package br.com.itads.processor.events.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.itads.miniauth.commons.dto.CardDTO;
import br.com.itads.miniauth.commons.responses.CardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public interface CardControllerInterface {

  /**
   * 
   * @param header
   * @param body
   * @return
   * 
   * 
    Possíveis respostas:
    
    Criação com sucesso:
       Status Code: 201
       Body (json):
       {
          "senha": "1234",
          "numeroCartao": "6549873025634501"
       } 
    -----------------------------------------
    Caso o cartão já exista:
       Status Code: 422
       Body (json):
       {
          "senha": "1234",
          "numeroCartao": "6549873025634501"
       }  
   */
  @Operation(summary = "Create New Card", description = "Create New Card", tags={  })
  @ApiResponses(value = { 
          @ApiResponse(responseCode = "201", description = "Processed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardResponse.class))),
          
          @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardResponse.class))) 
      }
  )
  @RequestMapping(value = "/cartoes", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
  ResponseEntity<CardResponse> createNewCard(
      @RequestHeader(value = "header", required = true) MultiValueMap<String, String> header,
      @RequestBody CardDTO body);

  /**
   * 
   * @param header
   * @param numeroCartao
   * @return
   * 
      Obtenção com sucesso:
         Status Code: 200
         Body: 495.15 
      -----------------------------------------
      Caso o cartão não exista:
         Status Code: 404 
         Sem Body
   * 
   * 
   * 
   */
  @Operation(summary = "Get Card", description = "Get Card", tags={  })
  @ApiResponses(value = { 
          @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardResponse.class))),
          
          @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardResponse.class))) 
      }
  )
  @RequestMapping(value = "/cartoes/{numeroCartao}", produces = { "application/json" }, method = RequestMethod.GET)
  ResponseEntity<CardResponse> findCardByNumber(
      @RequestHeader(value = "header", required = true) MultiValueMap<String, String> header,
      @PathVariable String numeroCartao);
  
}
