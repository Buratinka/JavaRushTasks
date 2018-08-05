package com.javarush.task.task26.task2607;

/* 
Вежливость - это искусственно созданное хорошее настроение
*/
public class Solution {

    public static class IntegerHolder
    {
        public synchronized int get() {
            return value;
        }

        public synchronized void set(int value) {
            this.value = value;
        }

        private int value;
    }

    public static void main(String[] args) {
    }
}
