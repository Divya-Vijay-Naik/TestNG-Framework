package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class JavaUtility {
public int getRandomNumber() {
	Random ram=new Random();
	int num=ram.nextInt(1000);
	return num;
}

public String getCurrentDate() {
	Date date=new Date();
	SimpleDateFormat simp=new SimpleDateFormat("dd-MM-yyyy");
	String currentDate=simp.format(date);
	return currentDate;
}
public String getRequiredDate(int Days) {
	Date date=new Date();
	SimpleDateFormat simp=new SimpleDateFormat("dd-MM-yyyy");
	String currentDate=simp.format(date);
	Calendar cal=simp.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, Days);
	String dateReq=simp.format(cal.getTime());
	return dateReq;
}
//random data generator
public String RandomData() {
	UUID data = UUID.randomUUID();
	String randomData = data.toString().replaceAll("[^a-zA-z]", "");
	return randomData;
}

//10 digit num
public long getTenDigitRandomNum() {
	Random ran=new Random();
	long num=(long) (1000000000L+(ran.nextDouble()*9999999999L));
	return num;
}
}
