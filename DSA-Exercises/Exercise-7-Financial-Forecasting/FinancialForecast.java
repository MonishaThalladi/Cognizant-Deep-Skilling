public class FinancialForecast {

    // ===== RECURSIVE METHOD =====
    // Time Complexity: O(n) where n is number of years
    // Space Complexity: O(n) due to recursive call stack
    public static double predictFutureValueRecursive(double currentValue, double growthRate, int years) {
        // Base case: If no years left, return current value
        if (years == 0) {
            return currentValue;
        }

        // Recursive case: Calculate next year's value
        double nextValue = currentValue * (1 + growthRate / 100);
        return predictFutureValueRecursive(nextValue, growthRate, years - 1);
    }

    // ===== ITERATIVE METHOD (for comparison) =====
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static double predictFutureValueIterative(double currentValue, double growthRate, int years) {
        double value = currentValue;
        for (int i = 0; i < years; i++) {
            value = value * (1 + growthRate / 100);
        }
        return value;
    }

    // ===== TAIL RECURSION OPTIMIZATION =====
    // This is more efficient as it doesn't need to keep previous calls on stack
    // Uses an accumulator parameter
    public static double predictFutureValueTailRecursive(double currentValue, double growthRate, int years) {
        return tailRecursiveHelper(currentValue, growthRate, years, 0);
    }

    private static double tailRecursiveHelper(double currentValue, double growthRate, int years, double acc) {
        if (years == 0) {
            return acc == 0 ? currentValue : acc;
        }

        // If this is the first call, start with currentValue
        double currentAcc = (acc == 0) ? currentValue : acc;
        double nextValue = currentAcc * (1 + growthRate / 100);
        return tailRecursiveHelper(currentValue, growthRate, years - 1, nextValue);
    }

    // ===== RECURSIVE WITH MEMOIZATION =====
    // Uses caching to avoid repeated calculations
    // Particularly useful if same years are calculated multiple times
    private static java.util.HashMap<Integer, Double> memo = new java.util.HashMap<>();

    public static double predictFutureValueMemoized(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }

        // Check if result is already cached
        if (memo.containsKey(years)) {
            System.out.println("Cache hit for year " + years + "!");
            return memo.get(years);
        }

        double nextValue = currentValue * (1 + growthRate / 100);
        double result = predictFutureValueMemoized(nextValue, growthRate, years - 1);
        memo.put(years, result);
        return result;
    }

    // Clear memoization cache
    public static void clearCache() {
        memo.clear();
    }

    // ===== DISPLAY YEAR BY YEAR BREAKDOWN =====
    public static void displayYearByYear(double currentValue, double growthRate, int years) {
        System.out.println("\nYear-by-Year Breakdown:");
        double value = currentValue;
        for (int i = 1; i <= years; i++) {
            value = value * (1 + growthRate / 100);
            System.out.printf("Year %2d: $%,.2f%n", i, value);
        }
    }
}
