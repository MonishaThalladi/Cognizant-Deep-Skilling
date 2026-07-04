package com.library.repository;

import com.library.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Find by code and date between
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // Find by code and close greater than
    List<Stock> findByCodeAndCloseGreaterThan(String code, double amount);

    // Top 3 by volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Top 3 lowest by close for a specific code
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
