package com.test.poker;

import java.util.*;

public class Game {
    private List<Card> cardList;

    private List<String> colorList;

    private Map<String,Player> playerList;

    public Game() {
        this.initColorList();
        this.initCardList();
        this.initPlayerList();
        this.createCardList();
        this.disorderCard();
    }

    /**
     * 初始化卡牌花色
     */
    private void initColorList() {
        this.colorList = new ArrayList<String>();
        this.colorList.add("黑桃");
        this.colorList.add("红桃");
        this.colorList.add("梅花");
        this.colorList.add("方块");
    }

    /**
     * 初始化卡牌
     */
    private void initCardList() {
        this.cardList = new ArrayList<Card>();
        this.cardList.add(new Card("大王",null,1000));
        this.cardList.add(new Card("小王",null,888));
    }

    private void initPlayerList() {
        this.playerList = new HashMap<String,Player>();
    }

    /**
     * 创建卡牌
     */
    private void createCardList() {
        for (int i = 0; i < colorList.size(); i++) {
            String color = colorList.get(i);
            String number;
            Integer value;
            for (int j = 0; j < 13; j++) {
                switch (j) {
                    case 0:
                        number = "A";
                        break;
                    case 10:
                        number = "J";
                        break;
                    case 11:
                        number = "Q";
                        break;
                    case 12:
                        number = "K";
                        break;
                    default:
                        number = String.valueOf(j+1);
                        break;
                }
                value = Util.getValueByNumber(number) + Util.getWeightByColor(color);
                this.cardList.add(new Card(color, number, value));
            }
        }
        System.out.println("*洗牌前*");
        for (int i = 0; i < this.cardList.size(); i++) {
            Card card= this.cardList.get(i);
            System.out.print(card.getColor()+card.getNumber()+",");
        }

    }

    /**
     * 洗牌
     */
    private void disorderCard() {
        Random random = new Random();
        Integer total = this.cardList.size();
        ArrayList<Card> newOrderCardList = new ArrayList<Card>();
        for (int i = 0; i < total; i++) {
            Integer cur = random.nextInt(total);
            Card card = this.cardList.get(cur);
            newOrderCardList.add(card);
        }
        this.cardList = newOrderCardList;
        System.out.println("\n*洗牌后*");
        for (int i = 0; i < this.cardList.size(); i++) {
            Card card= this.cardList.get(i);
            System.out.print(card.getColor()+card.getNumber()+",");
        }
        System.out.println("\n");
    }

    /**
     * 创建玩家
     */
    private Player createPlayer() {
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        System.out.println("\n请输入玩家ID");
        id = scanner.next();
        while (!Util.isNumberic(id)) {
            System.out.println("输入的玩家ID不是数字，请重新输入");
            id = scanner.next();
            if (Util.isNumberic(id)){
                break;
            }
        }
        while (this.playerList.containsKey(id)) {
            System.out.println("输入的玩家ID已存在，请重新输入\n");
            id = scanner.next();
            if (!this.playerList.containsKey(id)){
                break;
            }
        }
        System.out.println("请输入玩家姓名");
        name = scanner.next();
        System.out.println("玩家："+name+"获得的牌为：");
        ArrayList<Card> ownCardList = this.dealCard();
        return new Player(id,name,ownCardList);
    }

    /**
     * 给玩家发牌
     */
    private ArrayList<Card> dealCard() {
        Random random = new Random();
        ArrayList<Card> ownCardList = new ArrayList<Card>();
        for (int i = 0; i < 5; i++) {
            int cur = random.nextInt(this.cardList.size());
            Card card = this.cardList.get(cur);
            ownCardList.add(card);
            System.out.print(card.getColor()+ card.getNumber()+" ");
        }
        return ownCardList;
    }

    /**
     * 获取玩家的比分
     */
    public void Play() {
        System.out.println("*创建第1个玩家*");
        Player player1 = this.createPlayer();
        this.playerList.put(player1.getId(),player1);
        System.out.println("\n*发牌成功*");

        System.out.println("*创建第2个玩家*");
        Player player2 = this.createPlayer();
        this.playerList.put(player2.getId(),player2);
        System.out.println("*发牌成功*");

        List<Card> cardList1 = player1.getCardList();
        List<Card> cardList2 = player2.getCardList();
        Integer res1 = 0;
        Integer res2 = 0;
        for (int j = 0; j < cardList1.size(); j++) {
            Card card1 = cardList1.get(j);
            Card card2 = cardList2.get(j);
            if (card1.getValue() > card2.getValue()) {
                res1 = res1+1;
            }
            if (card1.getValue() < card2.getValue()) {
                res2 = res2+1;
            }
        }
        if (res1.equals(res2)) {
            System.out.println("平局了！");
        }
        if (res1>res2) {
            System.out.println(player1.getName()+"获胜了！");
        }
        if (res1<res2) {
            System.out.println(player2.getName()+"获胜了！");
        }
    }
}
