package heaps;

import java.util.Arrays;

public class MinHeap {

    private int size;
    private int capacity;
    private int[] items;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.items = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    public boolean hasParent(int index) {
        return parent(index) >= 0;

    }

    public boolean hasLeft(int index) {
        return left(index) < size;
    }

    public boolean hasRight(int index) {
        return right(index) < size;
    }

    public void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public void swap(int a, int b) {
        int temp = items[a];
        items[a] = items[b];
        items[b] = temp;

    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();

    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        items[size] = 0;
        return item;
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && items[parent(index)] > items[index]) {
            swap(index, parent(index));
            index = parent(index);
        }

    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeft(index)) {
            int smallerIndex = left(index);
            if (hasRight(index) && items[right(index)] < items[left(index)]) {
                smallerIndex = right(index);
            }

            if (items[index] <= items[smallerIndex]) {
                break;
            } else {
                swap(index, smallerIndex);
            }

            index = smallerIndex;
        }
    }

    public static void main(String[] args) {

        MinHeap heap = new MinHeap(5);

        // Insert elements
        heap.add(15);
        heap.add(10);
        heap.add(20);
        heap.add(8);

        // Peek should give the smallest element (8)
        System.out.println("Peek: " + heap.peek()); // expect 8

        // Poll elements one by one (should come out sorted: 8, 10, 15, 20)
        while (true) {
            try {
                int val = heap.poll();
                System.out.println("Polled: " + val);
            } catch (IllegalStateException e) {
                break; // heap is empty
            }
        }

    }
}
