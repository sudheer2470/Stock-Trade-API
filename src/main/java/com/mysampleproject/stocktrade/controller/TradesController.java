package com.mysampleproject.stocktrade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysampleproject.stocktrade.model.Trade;
import com.mysampleproject.stocktrade.service.TradeService;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {

	@Autowired
	TradeService tradeService;

	@PostMapping
	public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {
		Trade existingTrade = tradeService.findTradeById(trade.getId());

		if (existingTrade != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			Trade createdTrade = tradeService.createTrade(trade);
			return new ResponseEntity<>(createdTrade, HttpStatus.CREATED);
		}
	}

	@GetMapping
	public ResponseEntity<List<Trade>> findAllTrades() {
		List<Trade> createdTrade = tradeService.findAllTrades();
		return new ResponseEntity<>(createdTrade, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Trade> findTradeById(@PathVariable Long id) {
		Trade trade = tradeService.findTradeById(id);
		if (trade != null && trade.getId() > 0) {
			return new ResponseEntity<Trade>(trade, HttpStatus.OK);
		} else {
			return new ResponseEntity<Trade>(new Trade(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<List<Trade>> findAllTradesByUserId(@PathVariable Long id) {
		List<Trade> trades = tradeService.findAllTradesByUserId(id);
		if (trades != null && trades.size() > 0) {
			return new ResponseEntity<List<Trade>>(trades, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Trade>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/stocks/{symbol}")
	public ResponseEntity<List<Trade>> findAllTradesByStockSymbol(@PathVariable String symbol) {
		List<Trade> trades = tradeService.findAllTradesByStockSymbol(symbol);
		if (trades != null && trades.size() > 0) {
			return new ResponseEntity<List<Trade>>(trades, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Trade>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/users/{id}/stocks/{symbol}")
	public ResponseEntity<List<Trade>> findAllTradesByUserIdAndStockId(@PathVariable Long id,
			@PathVariable String symbol) {
		List<Trade> trades = tradeService.findAllTradesByUserIdAndStockId(id, symbol);
		if (trades != null && trades.size() > 0) {
			return new ResponseEntity<List<Trade>>(trades, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Trade>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}
	}

}
