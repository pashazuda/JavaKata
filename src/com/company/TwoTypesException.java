package com.company;
/** Класс ошибки когда используются одновременно разные системы счисления*/
class TwoTypesException extends Exception{
    TwoTypesException(String description){
        super(description);
    }
}
