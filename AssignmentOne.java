import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssignmentOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // String userInput = "Mohammad(317856) 1. Yousuf  2. Ibrahim 3. Nabila";

        
        System.out.print("Enter the name(ID),and at most 3 children's names (separated by number then '.' Dot)");
        String userInput = scanner.nextLine();
        
         Pattern namePattern = Pattern.compile("^(.*?)\\((\\d+)\\)");
        Pattern childrenPattern = Pattern.compile("(\\d+)\\.\\s+(\\S+)");

        Matcher nameMatcher = namePattern.matcher(userInput);
        Matcher childrenMatcher = childrenPattern.matcher(userInput);

        String name = "";
        String id = "";
        int childCount = 0;
        String[] children = new String[3]; 

         if (nameMatcher.find()) {
            name = nameMatcher.group(1);
            id = nameMatcher.group(2);
        }
        
         while (childrenMatcher.find() && childCount < 3) {
            int childNumber = Integer.parseInt(childrenMatcher.group(1));
            String childName = childrenMatcher.group(2);

            children[childNumber - 1] = childName;
            childCount++;
        }

         System.out.println("Your Name: " + name);
        System.out.println("Your ID: " + id);

        for (int i = 0; i < childCount; i++) {
            System.out.println("Your " + ordinal(i + 1) + " child: " + children[i]);
        }

        System.out.println("Your Password: " + passwordGen(children, id));

        scanner.close();
        
    }

     public static String ordinal(int number) {
        if (number % 100 >= 11 && number % 100 <= 13) {
            return number + "th";
        } else {
            switch (number % 10) {
                case 1:
                    return "first";
                case 2:
                    return "second";
                case 3:
                    return "third";
                default:
                    return number + "th";
            }
        }
     }

public static String passwordGen(String[] childrenNames, String id) {
    StringBuilder password = new StringBuilder();

    for (String childName : childrenNames) {
        if (childName != null && !childName.isEmpty()) {
            char lastCharacter = childName.charAt(childName.length() - 1);
            password.append(lastCharacter);
        }
    }

    if (id.length() >= 3) {
        password.append(id.substring(id.length() - 3));
    } else {
        password.insert(0, id);
    }

    return password.toString();
}
}

