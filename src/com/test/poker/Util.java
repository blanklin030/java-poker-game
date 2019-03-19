package com.test.poker;

public class Util {

    /**
     * 判断字符串是否为数字
     * @param str String
     * @return boolean
     */
    public static boolean isNumberic(String str) {
        boolean res = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))){
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * 通过卡片的数值获取卡片的面值
     * @param number
     * @return
     */
    public static int getValueByNumber(String number) {
        int value = 0;
        switch (number){
            case "大王":
                value = 1000;
                break;
            case "小王":
                value = 888;
                break;
            case "A":
                value = 14;
                break;
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K":
                value = 13;
                break;
            default:
                value = Integer.valueOf(number);
                break;
        }
        return value;
    }

    /**
     * 通过卡片的花色获取卡片的权值
     * @param color
     * @return
     */
    public static int getWeightByColor(String color){
        int value = 0;
        switch (color){
            case "黑桃":
                value = 4;
                break;
            case "红桃":
                value = 3;
                break;
            case "梅花":
                value = 2;
                break;
            case "方块":
                value = 1;
                break;
        }
        return value;
    }
}
