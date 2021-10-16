package com.wyu.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class RandomUtils {
	//当前时间 + 随机数
	public static String createActive(){
		
		return getTime()+Integer.toHexString(new Random().nextInt(900)+100);
	}
	public static String getTime(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
	}
	//生成订单编号
	public static String createOrderId(){
		return getTime();
	}
}
