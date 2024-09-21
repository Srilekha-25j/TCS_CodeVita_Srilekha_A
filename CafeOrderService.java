import java.util.*;

public class CafeOrderService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of orders
        int N = scanner.nextInt();
        
        // Input the priorities of the orders
        int[] priorities = new int[N];
        for (int i = 0; i < N; i++) {
            priorities[i] = scanner.nextInt();
        }
        
        // Input the position of Raj's friend in the queue
        int K = scanner.nextInt();
        
        // Calculate how many orders will be served before Raj's friend's order
        int result = calculateOrdersServedBefore(priorities, K - 1); // K - 1 for 0-based index
        
        // Output the result
        System.out.println(result);
        
        scanner.close();
    }

    private static int calculateOrdersServedBefore(int[] priorities, int friendIndex) {
        int servedCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int priority : priorities) {
            queue.add(priority);
        }
        
        // Get the priority of Raj's friend's order
        int friendPriority = priorities[friendIndex];
        
        while (!queue.isEmpty()) {
            int currentPriority = queue.poll();
            boolean isHighest = true;

            // Check if the current priority is the highest
            for (int p : queue) {
                if (p > currentPriority) {
                    isHighest = false;
                    break;
                }
            }

            if (isHighest) {
                // If it's the friend's order, return the count of served orders
                if (currentPriority == friendPriority) {
                    return servedCount + 1; // Include this order
                }
                // Increment the served count
                servedCount++;
            } else {
                // Reinsert the current order back to the queue
                queue.add(currentPriority);
            }
        }
        
        return servedCount; // This line should never be reached as friend's order will be served
    }
}
