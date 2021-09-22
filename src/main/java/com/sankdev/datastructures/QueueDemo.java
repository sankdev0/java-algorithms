package com.sankdev.datastructures;

public class QueueDemo {

  public static void main(String[] args) {
    QueueImpl queue = new QueueImpl();
    queue.enQueue(2);
    queue.enQueue(5);
    queue.show();
    queue.deQueue();
    queue.enQueue(12);
    queue.show();
  }

}
