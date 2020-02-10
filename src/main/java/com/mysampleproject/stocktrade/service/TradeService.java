package com.mysampleproject.stocktrade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysampleproject.stocktrade.model.Trade;
import com.mysampleproject.stocktrade.repository.TradeRepository;

@Service
public class TradeService {

	@Autowired
	TradeRepository tradeRepository;

	public void deleteTrades() {
		tradeRepository.deleteAll();
	}

	public Trade createTrade(Trade trade) {
		return tradeRepository.save(trade);
	}

	public Trade findTradeById(Long id) {
		return tradeRepository.findById(id).orElse(null);
	}

	public List<Trade> findAllTrades() {
		return tradeRepository.findAll();
	}

	public List<Trade> findAllTradesByUserId(Long id) {
		return tradeRepository.findByUserId(id);
	}

	public List<Trade> findAllTradesByStockSymbol(String symbol) {
		return tradeRepository.findBySymbol(symbol);
	}

	public List<Trade> findAllTradesByUserIdAndStockId(Long id, String symbol) {
		return tradeRepository.findBySymbolAndUserId(symbol, id);
	}

}
