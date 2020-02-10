package com.mysampleproject.stocktrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysampleproject.stocktrade.service.TradeService;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {

	@Autowired
	TradeService tradeService;

	@DeleteMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteTrades() {
		tradeService.deleteTrades();
		return new ResponseEntity(HttpStatus.OK);
	}
}
