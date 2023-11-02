import java.util.Scanner;

public class AssignmentTwo {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a set of values(numbers) separated by spaces: ");
        String input = scanner.nextLine();
        
        String[] values = input.split(" ");
    

        int count = 0;
        double sum = 0;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;

         for (String strValue : values) {
            try {
                double value = Double.parseDouble(strValue);
                count++;
                sum += value;
                max = Math.max(max, value);
                min = Math.min(min, value);
            } catch (NumberFormatException e) {

            }
        }
        
        double average = (count > 0) ?  sum / count : 0;
        
        double variance = 0;

         for (String strValue : values) {
            try {
                double value = Double.parseDouble(strValue);
                variance += Math.pow(value - average, 2);
            } catch (NumberFormatException e) {
                
            }
        }
        double stdDeviation = Math.sqrt(variance / count);

        System.out.println("There are " + count + " data");
        System.out.println("The maximum value is " + max);
        System.out.println("The minimum value is " + min);
        System.out.println("The sum is " + sum);
        System.out.println("The average is " + String.format("%.2f", average));
        System.out.println("The standard deviation is " + String.format("%.4f", stdDeviation));
        
        scanner.close();
    }
}
