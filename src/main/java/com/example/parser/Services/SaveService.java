package com.example.parser.Services;

import com.example.parser.Entities.Currency;
import org.springframework.stereotype.Service;


public interface SaveService {
    Iterable<Currency> listAllRates();
    Currency saveRates(Currency currency);
}
