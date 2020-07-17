package prac.A_Queue;

class MyCircularQueue {
    // the size of this queue
    int size;
    // the array to store data
    int[] data;
    // the position of queue head
    int head;
    // the position of queue tail
    int tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        size = k;
        data = new int[size];
        head = -1;
        tail = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (!isFull()) {
            if (head == -1) {
                head = 0;
            }
            tail = (tail + 1) % size;
            data[tail] = value;
            return true;
        } else {
            return false;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (!isEmpty()) {
            if (head == tail) {
                head = -1;
                tail = -1;
            } else {
                head = (head + 1) % size;
            }
            return true;
        } else {
            return false;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        return (isEmpty())?-1:data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return (isEmpty())?-1:data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1 & tail == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % size == head;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
