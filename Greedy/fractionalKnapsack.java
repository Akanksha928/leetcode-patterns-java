
import java.util.Arrays;

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class fractionalKnapsack {

    public double solution(int[] val, int[] wt, long cap) {

        Item[] items = new Item[val.length];

        // Convert and add both arrays as Item objects

        for (int i = 0; i < val.length; i++) {
            items[i] = new Item(val[i], wt[i]);

        }

        // Sort in desc order according to value/weight ratio

        Arrays.sort(items, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        });

        double totalVal = 0;

        // If item's weight <= cap, add or else, compute fractional value

        for (Item item : items) {
            if (item.weight <= cap) {
                totalVal += item.value;
                cap -= item.weight;
            } else {
                totalVal += ((double) item.value / item.weight) * (double) cap;
                break;
            }
        }

        return totalVal;
    }

    public static void main(String[] args) {
        fractionalKnapsack solver = new fractionalKnapsack();

        int[] val = { 60, 100, 120 };
        int[] wt = { 10, 20, 30 };
        long capacity = 50;

        double result = solver.solution(val, wt, capacity);
        System.out.println("Maximum value in knapsack: " + result);
    }
}
