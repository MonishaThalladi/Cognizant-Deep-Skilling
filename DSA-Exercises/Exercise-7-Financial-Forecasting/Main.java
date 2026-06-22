public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 7: Financial Forecasting ===\n");

        // Test data
        double initialInvestment = 10000.0;
        double growthRate = 10.0; // 10% per year
        int years = 5;

        System.out.println("Initial Investment: $" + String.format("%,.2f", initialInvestment));
        System.out.println("Growth Rate: " + growthRate + "% per year");
        System.out.println("Forecast Years: " + years);

        // ===== RECURSIVE METHOD =====
        System.out.println("\n=== Recursive Method (O(n) Time, O(n) Space) ===");
        long startTime = System.nanoTime();
        double futureValueRecursive = FinancialForecast.predictFutureValueRecursive(initialInvestment, growthRate, years);
        long endTime = System.nanoTime();
        System.out.println("Future Value: $" + String.format("%,.2f", futureValueRecursive));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        // Show year-by-year breakdown
        FinancialForecast.displayYearByYear(initialInvestment, growthRate, years);

        // ===== ITERATIVE METHOD =====
        System.out.println("\n=== Iterative Method (O(n) Time, O(1) Space) ===");
        startTime = System.nanoTime();
        double futureValueIterative = FinancialForecast.predictFutureValueIterative(initialInvestment, growthRate, years);
        endTime = System.nanoTime();
        System.out.println("Future Value: $" + String.format("%,.2f", futureValueIterative));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        // ===== TAIL RECURSION =====
        System.out.println("\n=== Tail Recursion (Optimized Space) ===");
        startTime = System.nanoTime();
        double futureValueTail = FinancialForecast.predictFutureValueTailRecursive(initialInvestment, growthRate, years);
        endTime = System.nanoTime();
        System.out.println("Future Value: $" + String.format("%,.2f", futureValueTail));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        // ===== MEMOIZED RECURSION =====
        System.out.println("\n=== Memoized Recursion (Caching) ===");
        FinancialForecast.clearCache();
        startTime = System.nanoTime();
        double futureValueMemoized1 = FinancialForecast.predictFutureValueMemoized(initialInvestment, growthRate, years);
        endTime = System.nanoTime();
        System.out.println("First call - Future Value: $" + String.format("%,.2f", futureValueMemoized1));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        // Second call with same years - should be faster (cache hit)
        startTime = System.nanoTime();
        double futureValueMemoized2 = FinancialForecast.predictFutureValueMemoized(initialInvestment, growthRate, years);
        endTime = System.nanoTime();
        System.out.println("Second call (cached) - Future Value: $" + String.format("%,.2f", futureValueMemoized2));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        // ===== COMPLEXITY ANALYSIS =====
        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("1. Simple Recursion:");
        System.out.println("   - Time Complexity: O(n)");
        System.out.println("   - Space Complexity: O(n) (call stack)");
        System.out.println("   - Explanation: Each recursive call adds to stack");

        System.out.println("\n2. Iterative Method:");
        System.out.println("   - Time Complexity: O(n)");
        System.out.println("   - Space Complexity: O(1)");
        System.out.println("   - Explanation: Single loop, no stack overhead");

        System.out.println("\n3. Tail Recursion:");
        System.out.println("   - Time Complexity: O(n)");
        System.out.println("   - Space Complexity: O(1) (if optimized by compiler)");
        System.out.println("   - Explanation: Recursive call is the last operation");

        System.out.println("\n4. Memoized Recursion:");
        System.out.println("   - Time Complexity: O(n) for first call, O(1) for subsequent");
        System.out.println("   - Space Complexity: O(n) (cache storage)");
        System.out.println("   - Explanation: Caches results for future use");

        // ===== OPTIMIZATION DISCUSSION =====
        System.out.println("\n=== Optimization Strategies ===");
        System.out.println("1. Use Iterative Method:");
        System.out.println("   - Best for simple linear calculations");
        System.out.println("   - Uses less memory (no stack)");
        System.out.println("   - Faster in most cases");

        System.out.println("\n2. Use Tail Recursion:");
        System.out.println("   - If recursive approach is preferred");
        System.out.println("   - Allows compiler to optimize to iterative");
        System.out.println("   - Reduces stack usage");

        System.out.println("\n3. Use Memoization:");
        System.out.println("   - Cache results for repeated calculations");
        System.out.println("   - Useful when forecasting multiple scenarios");
        System.out.println("   - Saves computation time for repeated years");

        System.out.println("\n4. Use Mathematical Formula (if possible):");
        System.out.println("   - Compound interest: FV = PV × (1 + r)^n");
        System.out.println("   - O(1) time complexity");
        System.out.println("   - Most efficient for simple growth");

        // ===== RECOMMENDATION =====
        System.out.println("\n=== Recommendation ===");
        System.out.println("For financial forecasting:");
        System.out.println("1. For simple growth: Use iterative method");
        System.out.println("2. For complex calculations: Use memoized recursion");
        System.out.println("3. For real-time systems: Use mathematical formula");
        System.out.println("4. For educational purposes: Use simple recursion");

        System.out.println("\n=== Additional Example ===");
        // Example with different values
        System.out.println("\nExample: $5,000 at 7.5% for 10 years");
        double exampleValue = 5000;
        double exampleRate = 7.5;
        int exampleYears = 10;
        double exampleResult = FinancialForecast.predictFutureValueIterative(exampleValue, exampleRate, exampleYears);
        System.out.printf("$%,.2f at %.1f%% for %d years = $%,.2f%n", 
            exampleValue, exampleRate, exampleYears, exampleResult);
    }
}
