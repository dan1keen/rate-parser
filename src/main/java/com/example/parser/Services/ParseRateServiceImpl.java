package com.example.parser.Services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParseRateServiceImpl implements ParseRateService {
    @Override
    public Document getConnection(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            return doc;
        }catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Double getRateBuy(Document doc) {
        Element element = doc.select("a[href=/exchange/almaty/USD?sort=-buyingPrice1]").first();
        String result = element.getElementsByClass("currency-rate-big").text().replace("₸","");
        return Double.parseDouble(result);
    }

    @Override
    public Double getRateSell(Document doc) {
        Element element = doc.select("a[href=/exchange/almaty/USD?sort=sellingPrice1]").first();
        String result = element.getElementsByClass("currency-rate-big").text().replace("₸","");
        return Double.parseDouble(result);
    }

    @Override
    public Double getOverallRate(Document doc) {
        Element element = doc.select("a[href=/nbrk/USD]").first();
        String result = element.getElementsByClass("currency-rate-big").text().replace("₸","");
        return Double.parseDouble(result);
    }

    @Override
    public String getDate() {
        String now = String.valueOf(java.time.LocalDate.now());
        return now;
    }
}
