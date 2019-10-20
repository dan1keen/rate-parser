package com.example.parser.Services;

import com.example.parser.Entities.Currency;
import com.example.parser.Repositories.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class SaveCurrencyService implements SaveService {
    RateRepository rateRepository;
    @Autowired
    public SaveCurrencyService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public Iterable<Currency> listAllRates() {
        return rateRepository.findAll();
    }

    @Override
    public Currency saveRates(Currency currency) {
        return rateRepository.save(currency);
    }


}
