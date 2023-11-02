import java.util.Arrays;

public class Statistics {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        Statistics statistics = new Statistics(data);

        System.out.println("Average: " + statistics.getAverage());
        System.out.println("Standard Deviation: " + statistics.getStandardDeviation());
    }

    private int[] numbers;

    public Statistics(int[] numbers) {
        this.numbers = numbers;
    }

    public double getAverage() {
        if (numbers.length == 0) {
            return 0.0;
        }

        int sum = Arrays.stream(numbers).sum();
        return (double) sum / numbers.length;
    }

    public double getStandardDeviation() {
        if (numbers.length == 0) {
            return 0.0;
        }

        double average = getAverage();
        double variance = Arrays.stream(numbers)
                .mapToDouble(num -> Math.pow(num - average, 2))
                .average()
                .orElse(0.0);

        return Math.sqrt(variance);
    }
}