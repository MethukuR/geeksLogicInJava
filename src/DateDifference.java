import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Write a java program to find the difference between two dates in years, days, hours, 
 * minutes and seconds. Your program should take start date and end date from the user 
 * and print the difference between these two dates in terms of years, days, hours, 
 * minutes and seconds.
 * 
 * @author Raju Rockzz :P
 *
 */
public class DateDifference {

	public static void main(String[] args) {
		String startDate="01-01-2001/01:01:01";
		String endDate="07-07-2007/07:07:07";
		
		try {
			findDifferenceInDatesOne(startDate,endDate);
			findDifferenceInDatesTwo(startDate,endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void findDifferenceInDatesTwo(String startDate,String endDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy/HH:mm:ss");
		Date sDate=formatter.parse(startDate);
		Date eDate=formatter.parse(endDate);
		long diffMilliSecs=eDate.getTime()-sDate.getTime();
		System.out.println("diffMilliSecs "+diffMilliSecs);
		long seconds=TimeUnit.MILLISECONDS.toSeconds(diffMilliSecs)%60;
		long minutes=TimeUnit.MILLISECONDS.toMinutes(diffMilliSecs)%60;
		long hours=TimeUnit.MILLISECONDS.toSeconds(diffMilliSecs)%24;
		long days=TimeUnit.MILLISECONDS.toDays(diffMilliSecs)%365;
		long years=TimeUnit.MILLISECONDS.toDays(diffMilliSecs)/365l;
		
		System.out.println("Difference is ---> ");
         
        System.out.println(years+" years, " +days+" days, "+hours+" hours, "+minutes+" minutes, "+seconds+" seconds");
    
	}

	private static void findDifferenceInDatesOne(String startDate, String endDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy/HH:mm:ss");
		Date sDate=formatter.parse(startDate);
		Date eDate=formatter.parse(endDate);
		long diffMilliSecs=eDate.getTime()-sDate.getTime();
		System.out.println("diffMilliSecs "+diffMilliSecs);
		long seconds=(diffMilliSecs/1000)%60;
		long minutes=(diffMilliSecs/(1000*60))%60;
		long hours=(diffMilliSecs/(1000*60*60))%24;
		long days=(diffMilliSecs/(1000*60*60*24))%365;
		long years=(diffMilliSecs/(1000l*60*60*24*365));
		
		 System.out.println("Difference is ---> ");
         
         System.out.println(years+" years, " +days+" days, "+hours+" hours, "+minutes+" minutes, "+seconds+" seconds");
    
	}

}
