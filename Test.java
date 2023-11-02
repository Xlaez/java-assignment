import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total count of numbers: ");
        int totalCount = scanner.nextInt();

        int[] numbers = new int[totalCount];

        for (int i = 0; i < totalCount; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        Statistics statistics = new Statistics(numbers);

        System.out.println("Average: " + String.format("%.2f",statistics.getAverage()));
        System.out.println("Standard Deviation: " + String.format("%.4f", statistics.getStandardDeviation()));

        System.out.print("Please enter the number to search : ");
        int searchNumber = scanner.nextInt();

        int found = -1; // I set it to an unrealistic index
        for (int i =0 ; i < numbers.length; i++) {
            if (numbers[i] == searchNumber) {
                found = i;
                break;
            }
        }

        if (found != -1 ) {
            System.out.println("The number exists at index " + found);
        } else {
            System.out.println("The number does not exist");
        }

        scanner.close();
    }
}
