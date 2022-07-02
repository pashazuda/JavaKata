package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws TwoTypesException, NegativeRomeException, NotMathematicOperation {
        while (true){
            Scanner console = new Scanner(System.in);
            String input = console.nextLine();
            System.out.println(calc(input));
        }
    }
    public static String calc(String input) throws NegativeRomeException, TwoTypesException, NotMathematicOperation {
        /* Инициализация словарей с римскими и арабскими цифрами*/
        HashMap<String, Integer> romeDict = new HashMap<>();
        {
            romeDict.put("I", 1);
            romeDict.put("II", 2);
            romeDict.put("III", 3);
            romeDict.put("IV", 4);
            romeDict.put("V", 5);
            romeDict.put("VI", 6);
            romeDict.put("VII", 7);
            romeDict.put("VIII", 8);
            romeDict.put("IX", 9);
            romeDict.put("X", 10);
            romeDict.put("C", 100);
        }
        HashMap<String, Integer> arabicDict = new HashMap<>();
        {
            arabicDict.put("1", 1);
            arabicDict.put("2", 2);
            arabicDict.put("3", 3);
            arabicDict.put("4", 4);
            arabicDict.put("5", 5);
            arabicDict.put("6", 6);
            arabicDict.put("7", 7);
            arabicDict.put("8", 8);
            arabicDict.put("9", 9);
            arabicDict.put("10", 10);
        }
        HashMap<String, Integer> extraRomeDict = new HashMap<>();
        {
            extraRomeDict.put("X", 1); //10
            extraRomeDict.put("XX", 2); //20
            extraRomeDict.put("XXX", 3); //30
            extraRomeDict.put("XL", 4); //40
            extraRomeDict.put("L", 5); //50
            extraRomeDict.put("LX", 6); //60
            extraRomeDict.put("LXX", 7); //70
            extraRomeDict.put("LXXX", 8); //80
            extraRomeDict.put("XC", 9); //90
        }

        String[] subStr;
        String delimeter = " ";
        subStr = input.split(delimeter);
        /* Обработка символов полученной строки*/
        RMO.isRightMathematicOperation(subStr);
        /* Нахождения типа системы счисления*/
        Calculator calcType = Calculator.NOTYPE;
        if (romeDict.containsKey(subStr[0]) && romeDict.containsKey(subStr[2])){calcType = Calculator.ROME;}
        else if (arabicDict.containsKey(subStr[0]) && arabicDict.containsKey(subStr[2])){calcType = Calculator.ARABIC;}
        else if ((romeDict.containsKey(subStr[0]) && arabicDict.containsKey(subStr[2])) ||
                (arabicDict.containsKey(subStr[0]) && romeDict.containsKey(subStr[2])) ) {
            throw new TwoTypesException("Используются одновременно разные системы счисления");
        }
        /* Произведение вычислений и вывод результата */
        switch (calcType) {
            case ROME -> {
                int a = Dict.calculation(romeDict.get(subStr[0]), subStr[1], romeDict.get(subStr[2]));
                if (a <= 0) {
                    throw new NegativeRomeException("В римской системе нет отрицательных чисел и нуля");
                }
                if ((10 < a) && (a < 100)) {
                    return (Dict.getKeyFromValue(extraRomeDict, a / 10) + Dict.getKeyFromValue(romeDict, a % 10));
                } else return Dict.getKeyFromValue(romeDict, a);
            }
            case ARABIC -> {
                return Integer.toString(Dict.calculation(arabicDict.get(subStr[0]), subStr[1], arabicDict.get(subStr[2])));
            }
        }
        return null;
    }
}
