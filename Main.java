import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Main{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("enter date in thif formate(yyyy-mm-dd)):");
		String date1Str=input.nextLine();
		System.out.println("enter second date in thif formate(yyyu-mm-dd):");
		String date2Str=input.nextLine();
		
		LocalDate date1=LocalDate.parse(date1Str);
		
		LocalDate date2=LocalDate.parse(date2Str);
		
		long sub=ChronoUnit.DAYS.between(date1,date2);
		
		System.out.println("the diffrence between these two dates is:"+Math.abs(sub)+"days");
	}
}