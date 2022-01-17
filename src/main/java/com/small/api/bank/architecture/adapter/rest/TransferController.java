package com.small.api.bank.architecture.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.small.api.bank.architecture.domain.dto.TransferDto;
import com.small.api.bank.architecture.domain.dto.TransferRequestDto;
import com.small.api.bank.architecture.port.TransferService;

/**
 * The class defines a REST controller which is a primary adapter and invokes
 * the inbound port of the application.
 */
@RestController
@CrossOrigin
public class TransferController {

	private TransferService transferService;

	@Autowired
	public TransferController(TransferService transferService) {
		this.transferService = transferService;
	}

	@PostMapping("/transfer")
	public ResponseEntity<?> doTransfer(@RequestBody TransferRequestDto transfer) {

		TransferDto transferDto = new TransferDto(null, transfer.getFrom(), transfer.getTo(), transfer.getAmount(),
				null);

		TransferDto saved;
		try {
			saved = this.transferService.doTransfer(transferDto);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Transfer failed");
		}
		if (saved == null) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Transfer failed");
		}
		return new ResponseEntity<>(saved, HttpStatus.CREATED);

	}

}
