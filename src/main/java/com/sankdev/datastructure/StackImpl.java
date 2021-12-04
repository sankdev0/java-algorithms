package com.sankdev.datastructure;

public class StackImpl {

  private int stackSize;
  private int[] stackArray;
  private int top;

  /**
   * constructor to create stack with size
   *
   * @param size - the initial size of created stack
   */
  public StackImpl(int size) {
    this.stackSize = size;
    this.stackArray = new int[stackSize];
    this.top = -1;
  }

  /**
   * Adds new entry to the top of the stack
   *
   * @param entry - the value to add to the stack
   */
  public void push(int entry) {
    if (this.isStackFull()) {
      System.out.println("Stack Overflow. Increasing capacity.");
      this.increaseStackCapacity();
    }
    System.out.println("Adding: " + entry);
    this.stackArray[++top] = entry;
  }

  /**
   * Removes an entry from the top of the stack.
   *
   * @return the popped value
   */
  // TODO: might throw appropriate exception!
  public int pop() {
    if (this.isStackEmpty()) {
      System.out.println("Stack underflow - is empty!");
    }
    int entry = this.stackArray[top--];
    System.out.println("Removed entry: " + entry);
    return entry;
  }

  /**
   * Returns top of the stack without removing it.
   *
   * @return the top element value without removing it.
   */
  public int peek() {
    return stackArray[top];
  }

  /**
   * Returns true if the stack is empty
   *
   * @return true if the stack is empty.
   */
  public boolean isStackEmpty() {
    return (top == -1);
  }

  /**
   * Returns true if the stack is full
   *
   * @return true if the stack is full.
   */
  public boolean isStackFull() {
    return (top == stackSize - 1);
  }

  /**
   * Increase stack capacity
   */
  private void increaseStackCapacity() {
    int[] newStack = new int[this.stackSize * 2];
    for (int i = 0; i < stackSize; i++) {
      newStack[i] = this.stackArray[i];
    }
    this.stackArray = newStack;
    this.stackSize = this.stackSize * 2;
  }

}
