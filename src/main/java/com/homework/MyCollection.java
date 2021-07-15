package com.homework;

import lombok.Data;
import lombok.SneakyThrows;

public class MyCollection<T> {

    private ObjectBox<T> head = null; // 1st element
    private ObjectBox<T> tail = null; // last element
    private int size; //


    public void push(T obj) {
        //add new object in queue
        ObjectBox<T> objectBox = new ObjectBox();
        objectBox.setObject(obj);
        if (head == null) {
            head = objectBox;
        } else {
            tail.setNext(objectBox);
        }
        tail = objectBox;
        size++;
    }

    public T pull() {
        if (size == 0) {
            return null;
        }
        T object = head.getObject();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return object;
    }

    public int size() {
        return size;
    }

    @SneakyThrows
    public void removeAll() {
        if (size == 0) {
            throw new EmptyQueueException();
        }
        while (size != 0 || head != null){
            T object = head.getObject();
            head = head.getNext();
            size--;
        }
        tail = null;



    }

    public Object get(int index) {

        if (size == 0 || index >= size || index < 0) {
            throw new MyException(index);
        }
        ObjectBox<T> current = head;

        int pos = 0;

        while (pos < index) {
            current = current.getNext();
            pos++;
        }
        Object object = current.getObject();
        return object;
    }

    @Data
    private class ObjectBox<T> {
        private T object;
        private ObjectBox next;
    }
}
