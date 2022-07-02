package com.company;

import java.util.HashSet;

/** Класс для проверки соответсвия математической операции из ТЗ*/
class RMO {
    static void isRightMathematicOperation(String[] subStr) throws NotMathematicOperation {
        HashSet<String> operators = new HashSet<>();{
            operators.add("+");
            operators.add("-");
            operators.add("/");
            operators.add("*");
        }
        HashSet<String> digits = new HashSet<>();{
            digits.add("1");
            digits.add("2");
            digits.add("3");
            digits.add("4");
            digits.add("5");
            digits.add("6");
            digits.add("7");
            digits.add("8");
            digits.add("9");
            digits.add("10");
            digits.add("I");
            digits.add("II");
            digits.add("III");
            digits.add("IV");
            digits.add("V");
            digits.add("VI");
            digits.add("VII");
            digits.add("VIII");
            digits.add("IX");
            digits.add("X");
        }
        if (subStr.length < 3){throw new NotMathematicOperation("Cтрока не является математической операцией");}
        if ((subStr.length > 3) || !(operators.contains(subStr[1]) && digits.contains(subStr[0]) && digits.contains(subStr[2]))){
            throw new NotMathematicOperation("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
}
