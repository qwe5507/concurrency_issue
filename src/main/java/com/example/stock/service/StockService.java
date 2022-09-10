package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    // 스프링의 @Transactional은 프록시 객체를 만든다.
    // 프록시 객체의 타겟의 로직실행 -> 트랜잭션 종료 그 사이에 다른 요청의 타겟의 로직이 실행될 수 있다.
    // 테스트 통과를 위해 @Transactional을 주석처리 한다.
//    @Transactional
    public synchronized void decrease(Long id, Long quantity) {
        // get stock
        // 재고 감소
        // 저장

        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        stockRepository.saveAndFlush(stock);
    }
}
