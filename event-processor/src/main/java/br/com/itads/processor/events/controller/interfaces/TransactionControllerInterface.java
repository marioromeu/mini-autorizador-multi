package br.com.itads.processor.events.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.itads.miniauth.commons.dto.TransactionDTO;
import br.com.itads.miniauth.commons.responses.TransactionResponse;
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
public interface TransactionControllerInterface {

  /**
   * 
   * @param header
   * @param body
   * @return
   */
  @Operation(summary = "Process Transaction", description = "Process Transaction", tags={  })
  @ApiResponses(value = { 
          @ApiResponse(responseCode = "201", description = "Processed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionResponse.class))),
          
          @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionResponse.class))) 
      }
  )
  @RequestMapping(value = "/transacoes", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
  ResponseEntity<TransactionResponse> createNewTransaction(
      @RequestHeader(value = "header", required = true) MultiValueMap<String, String> header,
      @RequestBody TransactionDTO body);

}
