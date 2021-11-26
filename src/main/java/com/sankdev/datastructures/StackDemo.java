package com.sankdev.datastructures;

public class StackDemo {

  public static void main(String[] args) {
    StackImpl stack = new StackImpl(3);
    try {
      for (int i = 1; i < 10; i++) {
        stack.push(i);
      }
      for (int i = 1; i < 4; i++) {
        stack.pop();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
