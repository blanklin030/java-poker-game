package com.test.poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String id;
    private String name;
    private List<Card> cardList;

    public Player(String id, String name, ArrayList<Card> cardList) {
        this.id = id;
        this.name = name;
        this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
