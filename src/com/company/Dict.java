package com.company;

import java.util.HashMap;

class Dict {
    static int calculation(int a, String operator, int b){
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }

    /* Метод получения ключа по значению */
    static String getKeyFromValue(HashMap dict, Object value){
        for (Object o : dict.keySet()) {
            if (dict.get(o).equals(value)) {
                return (String) o;
            }
        }
        return null;
    }
}
