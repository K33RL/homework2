package com.homework;

import lombok.Data;

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
        T object = (T) head.getObject();
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

    public Object get(int index) {

        if (size == 0 || index >= size || index < 0) {
            throw new IndexOutOfBoundsException(index);
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
        private Object object;
        private ObjectBox next;
    }
}
