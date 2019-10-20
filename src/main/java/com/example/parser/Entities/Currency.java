package com.example.parser.Entities;

import javax.persistence.*;

@Entity
@Table(name = "rate")
public class Currency {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ACTUAL")
    private double actual;
    @Column(name = "BUY")
    private double buy;
    @Column(name = "SELL")
    private double sell;
    @Column(name = "ACTUAL_TO")
    private String date;

    public int getId() {
        return id;
    }

    public double getActual() {
        return actual;
    }

    public void setActual(double actual) {
        this.actual = actual;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
