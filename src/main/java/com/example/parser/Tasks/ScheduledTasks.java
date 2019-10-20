package com.example.parser.Tasks;

import com.example.parser.Entities.Currency;
import com.example.parser.Services.ParseRateService;
import com.example.parser.Services.SaveService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledTasks {
    SaveService saveService;
    ParseRateService parseRateService;

    public ScheduledTasks(SaveService saveService, ParseRateService parseRateService) {
        this.saveService = saveService;
        this.parseRateService = parseRateService;
    }

    @Scheduled(cron = "0 0 13 * * *",zone="Asia/Almaty")
    public void scheduleTask() {
        Currency currency = new Currency();
        String url = "https://ifin.kz/";
        Document conn = parseRateService.getConnection(url);
        ArrayList<Double> rates = new ArrayList<>();
        rates.add(parseRateService.getOverallRate(conn));
        rates.add(parseRateService.getRateBuy(conn));
        rates.add(parseRateService.getRateSell(conn));
        String dateString = parseRateService.getDate();

        currency.setActual(rates.get(0));
        currency.setBuy(rates.get(1));
        currency.setSell(rates.get(2));
        currency.setDate(dateString);
        saveService.saveRates(currency);

    }
}
