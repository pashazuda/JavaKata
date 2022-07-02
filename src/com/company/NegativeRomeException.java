package com.company;
/** Класс ошибки отсутсвия отрицательных римских цифр*/
class NegativeRomeException extends Exception{
    NegativeRomeException(String description){
        super(description);
    }
}
