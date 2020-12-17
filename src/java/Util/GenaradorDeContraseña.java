/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author ortiz
 */
public class GenaradorDeContraseña {
 
	public static String numeros = "0123456789";
 
	public static String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
	public static String minusculas = "abcdefghijklmnopqrstuvwxyz";
 
	public static String especiales = "ñÑ";
 
	//
 
	public static String getPassword(String key, int length) {
		String pswd = "";
 
		for (int i = 0; i < length; i++) {
			pswd+=(key.charAt((int)(Math.random() * key.length())));
		}
 
		return pswd;
	}

}
