package ucanuup.cc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 文件名： com.bozhon.utils.date.DateUtil.java
 * 作者：   WenBin
 * 日期：   2017年10月31日
 * 功能说明： 本对象为对 joda-time jar 包信息的封装
 * =========================================================
 * 修改记录：
 * 修改作者    日期      修改内容
 * =========================================================
 *  Copyright (c) 2010-2011 .All rights reserved.
 */
public class DateUtil {

	/**
	 * Description:私有化构造器,禁止new 对象
	 */
	private DateUtil(){}
	private static final String BZ_NYR_OTHER = "yyyyMMdd";
	private static final String BZ_NYR_OTHERSFM = "HHmmss";
	private static final String BZ_NYR_OTHER2 = "yyyy/MM/dd HH:mm:ss";

	private static final String BZ_NYR = "yyyy-MM-dd";

	private static final String BZ_NYR_SFM = "yyyy-MM-dd HH:mm:ss";
	
	private static final String BZ_NYR_SF = "yyyy-MM-dd HH:mm";

	/**
	 * @Method: com.bozhon.utils.date.DateUtil.bzDate
	 * @Description: 年月日  yyyy-MM-dd 格式
	 * @author: WenBin
	 * @date: 2018年1月18日
	 * @version: 1.0
	 * @param dateTimeString
	 * @return
	 * Date
	 * @update [日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public static Date praseDateNYR(String dateTimeString){
		if(dateTimeString==null || dateTimeString.trim().equals("")||dateTimeString.equals("-")) {
			return null;
		}
		DateTimeFormatter df=DateTimeFormat.forPattern(BZ_NYR);
		DateTime dateTime = DateTime.parse(dateTimeString, df);
		return dateTime.toDate();
	}
	

	
	public static Date erpDate(String dateTimeString){
		if(dateTimeString.length()<8) {
			return null;
		}
		DateTimeFormatter df=DateTimeFormat.forPattern(BZ_NYR_OTHER);
		DateTime dateTime = DateTime.parse(dateTimeString, df);
		return dateTime.toDate();
	}
	
	public static Date erpDateSFM(String dateTimeString){
		if(dateTimeString.length()<6) {
			return null;
		}
		DateTimeFormatter df=DateTimeFormat.forPattern(BZ_NYR_OTHERSFM);
		DateTime dateTime = DateTime.parse(dateTimeString, df);
		return dateTime.toDate();
	}
	
	public static Date erpDate2(String dateTimeString){
		DateTimeFormatter df=DateTimeFormat.forPattern(BZ_NYR_OTHER2);
		DateTime dateTime = DateTime.parse(dateTimeString, df);
		return dateTime.toDate();
	}

	/**
	 * @Method: com.bozhon.utils.date.DateUtil.bzDateNYRSFM
	 * @Description:  年月日 时分秒  yyyy-MM-dd hh:mm:ss 格式
	 * @author: WenBin
	 * @date: 2018年1月18日
	 * @version: 1.0
	 * @param dateTimeString
	 * @return
	 * Date
	 * @update [日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public static Date bzDateNYRSFM(String dateTimeString){
		DateTimeFormatter df=DateTimeFormat.forPattern(BZ_NYR_SFM);
		DateTime dateTime = DateTime.parse(dateTimeString, df);
		return dateTime.toDate();
	}
	
	//modify by mibin 2018-10-11
	public static String formartDateNYRSF(Date date){
		if(date==null) {
			//return "-";
			return "";
		}
		DateTime dateTime=new DateTime(date,DateTimeZone.forID("Asia/Shanghai"));
		return dateTime.toString(BZ_NYR_SF);
	}
	
	//modify by mibin 2018-10-11
	public static String bzDateNYRSFM(Date date){
		if(date==null) {
			//return "-";
			return "";
		}
		DateTime dateTime=new DateTime(date,DateTimeZone.forID("Asia/Shanghai"));
		return dateTime.toString(BZ_NYR_SFM);
	}

	// 测试
	public static void main(String[] args) {
		System.out.println(getThisMonthLastDay());
	}

	/**
	 * @Method: com.bozhon.utils.date.DateUtil.getThisMonthFirstDay
	 * @Description:  获取这个月的第一天   年月日  yyyy-MM-dd 格式
	 * @author: WenBin
	 * @date: 2018年1月18日
	 * @version: 1.0
	 * @return
	 * String
	 * @update [日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public static String getThisMonthFirstDay(){
		DateTime dt=new DateTime().withDayOfMonth(1);
		return dt.toString(BZ_NYR);
	}
	
	public static Date getThisMonthFirstDateDay(){
		DateTime dt=new DateTime().withDayOfMonth(1);
		return dt.toDate();
	}

	/**
	 * @Method: com.bozhon.utils.date.DateUtil.getThisMonthLastDay
	 * @Description:  获取这个月的最后一天   年月日  yyyy-MM-dd 格式
	 * @author: WenBin
	 * @date: 2018年1月18日
	 * @version: 1.0
	 * @return
	 * String
	 * @update [日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public static String getThisMonthLastDay(){
		return new DateTime().dayOfMonth().withMaximumValue().toString(BZ_NYR);
	}

	public static Date getThisMonthLastDateDay(){
		return new DateTime().dayOfMonth().withMaximumValue().toDate();
	}
	/**
	 * @Method: com.bozhon.utils.date.DateUtil.compareTime
	 * @Description: 比较2个时间的大小， 判断 A是否比B大， 是真 ，非假
	 * @author: WenBin
	 * @date: 2018年1月18日
	 * @version: 1.0
	 * @param a 被减 时间
	 * @param b 减除 时间
	 * @param area  相差事件长度
	 * @return
	 * boolean
	 * @update [日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public static boolean compareTime(Date a,Date b,long area){
		long time = a.getTime() - b.getTime();
		if(time/1000 - area >0){
			return true;
		}
		return false;
	}
	
	public static String dateToBZNYR(Date date) {
		if(date==null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(BZ_NYR);
		format.format(date);
		return format.format(date);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		if(date==null) {
			return "";
		}
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 字符串转日期 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 * add by mibin 
	 */
	public static Date String2Date(String dateStr, Object... pattern) {
		if(dateStr==null || dateStr.trim().equals("")) {
			return null;
		}
		DateTimeFormatter df = null;
		if (pattern != null && pattern.length > 0) {
			df=DateTimeFormat.forPattern( pattern[0].toString());
		} else {
			df=DateTimeFormat.forPattern("yyyy-MM-dd");
		}
		DateTime dateTime = DateTime.parse(dateStr, df);
		return dateTime.toDate();
	}
	
	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}
	
	/**
	 * <p>Title: isOutTimeBetween2Date</p>
	 * <p>Description: 判断第二个时间是否大于第一个时间 是真 非假</p>
	 * @param before
	 * @param now
	 * @return
	 * @author WenBin
	 */
	public static boolean isOutTimeBetween2Date(Date before, Date now) {
		if(before == null || now == null) {
			return false;
		}
		long beforeTime = before.getTime();
		long afterTime = now.getTime();
		return afterTime >= beforeTime;
	}
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date now) {
		long beforeTime = before.getTime();
		long afterTime = now.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	
	public static double getAbsoluteDistanceOfTwoDate(Date before, Date now) {
		double day = getDistanceOfTwoDate(before,now);
		if(day <0) {
			return - day ;
		}
		return day;
	}
}
