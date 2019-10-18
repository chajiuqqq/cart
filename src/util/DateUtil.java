package util;

import java.sql.Date;
import java.util.Comparator;

public class DateUtil {
	public static Date getDate() {
		java.util.Date date=new java.util.Date();
		long time=date.getTime();
		return new Date(time);
	}
	
}
