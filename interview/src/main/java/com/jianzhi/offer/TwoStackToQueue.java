package com.jianzhi.offer;

import java.util.Stack;

public class TwoStackToQueue {

    public static class MList<T> {

        private Stack<T> stack1= new Stack<T>();
        private Stack<T> stack2= new Stack<T>();

        public MList() {

        }

        public void addTail(T t) {
            stack1.push(t);
        }

        public T deleteHead() {

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }

            if (stack2.isEmpty()) {
                throw new RuntimeException("No More Element");
            }

            return stack2.pop();
        }

    }

    public static void main(String[] args) {




    }


}
