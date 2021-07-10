package com.homework;

public class MyException extends IndexOutOfBoundsException {

    public MyException(int index) {
        super(index);
    }
}
