package com.example.parser.Repositories;

import com.example.parser.Entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Currency, Integer> {
}
