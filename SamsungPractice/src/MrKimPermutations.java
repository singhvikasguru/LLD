public class MrKimPermutations {
    static int[][] locations; // Store coordinates of office, home, and customers
    static int n; // Number of customers
    static int minDistance = Integer.MAX_VALUE; // Minimum distance

    public static void main(String[] args) {
        // Example input
        locations = new int[][] {
                {0, 0},  // Office
                {100, 100},  // Home
                {70, 40}, {30, 10}, {10, 5}, {50, 20}, {90, 70} // Customers
        };
        n = locations.length - 2; // Number of customers (excluding office and home)

        // Array to track customer indices for permutation
        int[] customers = new int[n];
        for (int i = 0; i < n; i++) {
            customers[i] = i + 2; // Customer indices start from 2
        }

        // Generate all permutations and calculate distances
        permute(customers, 0);

        // Output the shortest distance
        System.out.println("The shortest path distance is: " + minDistance);
    }

    // Method to calculate Manhattan distance
    static int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    // Method to generate all permutations of the customers array
    static void permute(int[] arr, int l) {
        if (l == arr.length) {
            calculatePathDistance(arr); // Calculate distance for this permutation
        } else {
            for (int i = l; i < arr.length; i++) {
                swap(arr, l, i);
                permute(arr, l + 1);
                swap(arr, l, i); // Backtrack
            }
        }
    }

    // Method to swap two elements in an array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to calculate the total path distance for a given permutation
    static void calculatePathDistance(int[] order) {
        int totalDistance = 0;

        // Distance from office to the first customer
        totalDistance += manhattanDistance(locations[0], locations[order[0]]);

        // Distance between customers
        for (int i = 0; i < order.length - 1; i++) {
            totalDistance += manhattanDistance(locations[order[i]], locations[order[i + 1]]);
        }

        // Distance from the last customer to home
        totalDistance += manhattanDistance(locations[order[order.length - 1]], locations[1]);

        // Update minimum distance
        minDistance = Math.min(minDistance, totalDistance);
    }
}
