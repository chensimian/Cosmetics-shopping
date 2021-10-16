package com.wyu.utils;
//×Ö·û´®¹«¾ôÀà ÅĞ¶¨×Ö·û´®ÊÇ·ñÎª¿Õ
public class StrUtils {
	public static boolean empty(String msg){
		return msg!=null && msg.length()>0;
	}
	public static boolean empty(String...msg){
		boolean res = true;
		for(String s:msg){
			res = (s!=null && s.length()>0);
			if(!res){
				break;
			}
		}
		return res;
	}
}
