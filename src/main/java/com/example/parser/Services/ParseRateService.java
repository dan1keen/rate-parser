package com.example.parser.Services;

import org.jsoup.nodes.Document;

public interface ParseRateService {
    Document getConnection(String url);

    Double getRateBuy(Document doc);

    Double getRateSell(Document doc);

    Double getOverallRate(Document doc);
    String getDate();

}
