package br.unitins.unibio.application;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Util {
	public static void addInfoMessage(String message) {
		addMessage(message, FacesMessage.SEVERITY_INFO);
	}

	public static void addWarnMessage(String message) {
		addMessage(message, FacesMessage.SEVERITY_WARN);
	}

	public static void addErroMessage(String message) {
		addMessage(message, FacesMessage.SEVERITY_ERROR);
	}

	private static void addMessage(String message, Severity type) {
		FacesContext.getCurrentInstance().addMessage(" ", new FacesMessage(type, message, message));
	}
	
	public static String encrypt(String value) {
		try {
			// Classe utilizada para gerar a criptografia em hash
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] digest = messageDigest.digest(value.getBytes("UTF-8"));
			
			// convertendo um array bite em hexadecimal
			StringBuilder stringBuilder = new StringBuilder();
			for (byte b : digest) {
				stringBuilder.append(String.format("%02X", 0xFF & b));
			}
			String valueHexadecimal = stringBuilder.toString();
			
			return valueHexadecimal;
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "Erro ao encriptar";
	}
	
	public static void redirect(String page) {
		FacesContext context = FacesContext.getCurrentInstance();
         try {
        	 context.getExternalContext().redirect(page);
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	}
	
	
	public static String getData() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String getHora() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static  String getDia() {
		Date d = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(d);
		String nome = "";
		int dia = c.get(c.DAY_OF_WEEK);
		switch (dia) {
		case Calendar.SUNDAY:
			nome = "Domingo";
			break;
		case Calendar.MONDAY:
			nome = "Segunda-Feira";
			break;
		case Calendar.TUESDAY:
			nome = "Terça-Feira";
			break;
		case Calendar.WEDNESDAY:
			nome = "Quarta-Feira";
			break;
		case Calendar.THURSDAY:
			nome = "Quinta-Feira";
			break;
		case Calendar.FRIDAY:
			nome = "Sexta-Feira";
			break;
		case Calendar.SATURDAY:
			nome = "sábado";
			break;
		}

		return nome;
	}

}
