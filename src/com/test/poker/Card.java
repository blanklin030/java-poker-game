package com.test.poker;

import java.util.ArrayList;
import java.util.List;

public class Card {
    /**
     * 卡片数值
     */
    private String number;
    /**
     * 卡片花色
     */
    private String color;

    /**
     * 卡片实际面值
     */
    private Integer value;

    public Card(String color, String number, Integer value) {
        this.color = color;
        this.number = number;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
