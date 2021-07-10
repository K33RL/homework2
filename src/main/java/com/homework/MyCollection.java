package com.homework;

import lombok.Getter;
import lombok.Setter;

public class MyCollection<T> {

    private ObjectBox head = null; // 1st element
    private ObjectBox tail = null; // last element
    private int size; //


    public void push(T obj) {
        //add new object in queue
        ObjectBox objectBox = new ObjectBox();
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
            return null;
        }
        ObjectBox current = head;

        int pos = 0;

        while (pos < index) {
            current = current.getNext();

            pos++;
        }
        Object object = current.getObject();
        return object;
    }


    private class ObjectBox {
        @Getter
        @Setter
        private Object object;
        @Getter
        @Setter
        private ObjectBox next;
    }
}
