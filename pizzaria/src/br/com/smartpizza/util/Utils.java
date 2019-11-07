package br.com.smartpizza.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
		 public static Date formataDataBanco(String date) {
		 try {
		 SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		 Date novaData = new Date(format.parse(date).getTime());
		 return novaData;
		 } catch (Exception e) {
		 return null;
		 }
		 
		}
}
