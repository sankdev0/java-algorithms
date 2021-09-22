package com.sankdev.datastructures;

// TODO: Improve this implementation.
public class QueueImpl {

  int[] queue = new int[10];
  int size;
  int front;
  int rear;

  public void enQueue(int data) {
    queue[rear] = data;
    rear = rear + 1;
    size = size + 1;
  }

  public int deQueue() {
    int data = queue[front];
    for (int i = 0; i < rear - 1; i++) {
      queue[i] = queue[i + 1];
    }

    size = size - 1;
    rear--;
    return data;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void show() {
    System.out.print("Elements :");
    for (int i = 0; i < rear; i++) {
      System.out.print(queue[front + i] + " ");
    }
  }
}
