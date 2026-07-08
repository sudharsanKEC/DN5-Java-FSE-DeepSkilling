public class FinancialForecast {

    public static double futureValue(double presentValue, double growthRate, int years) {

        // Base case
        if (years == 0) {
            return presentValue;
        }

        // Recursive case
        return futureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {

        double presentValue = 10000;
        double growthRate = 0.10;   // 10%
        int years = 5;

        double future = futureValue(presentValue, growthRate, years);

        System.out.printf("Future Value after %d years = %.2f", years, future);
    }
}

// TC: O(n)
// SC: O(n)








