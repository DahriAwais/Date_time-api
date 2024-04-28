import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birth date (YYYY-MM-DD): ");
        String birthDateStr = scanner.nextLine();
        
      //get the local date
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        
        // diffrece b/w current date and local date
        Period age = Period.between(birthDate, currentDate);
        
        // Display the calculated age
        System.out.println("Your current age is: " + age.getYears() + " years.");
        
        scanner.close();
    }
}