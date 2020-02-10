package com.mysampleproject.stocktrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysampleproject.stocktrade.model.Trade;

public interface TradeRepository extends JpaRepository<Trade, Long> {

	List<Trade> findByUserId(Long id);

	List<Trade> findBySymbol(String symbol);

	List<Trade> findBySymbolAndUserId(String symbol, Long id);

}
