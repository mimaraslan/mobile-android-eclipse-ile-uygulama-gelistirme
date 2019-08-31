package com.mimaraslan;

public class _02_Veritipleri_Ve_Degiskenler {

	
	static short short_tipindeki_degiskenimiz;
	static int int_tipindeki_degiskenimiz;
	static long long_tipindeki_degiskenimiz;
	static char char_tipindeki_degiskenimiz;
	static float float_tipindeki_degiskenimiz;
	static double double_tipindeki_degiskenimiz;
	static boolean boolean_tipindeki_degiskenimiz;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 byte byte_tipindeki_degiskenimiz;

		byte_tipindeki_degiskenimiz = 11;
		short_tipindeki_degiskenimiz = 632;
		int_tipindeki_degiskenimiz = 1923;
		long_tipindeki_degiskenimiz = 14531517;
		char_tipindeki_degiskenimiz = 'a';
		float_tipindeki_degiskenimiz = 57.1f;
		double_tipindeki_degiskenimiz = 2013.1071;
		boolean_tipindeki_degiskenimiz = true;

		System.out.println("Tamsayi sayi veri tipleri : byte - short - int - long - char");
		System.out.println("byte : " + byte_tipindeki_degiskenimiz);
		System.out.println("short :" + short_tipindeki_degiskenimiz);
		System.out.println("int : " + int_tipindeki_degiskenimiz);
		System.out.println("long : " + long_tipindeki_degiskenimiz);
		System.out.println("char : " + char_tipindeki_degiskenimiz);

		System.out.println("Kesirli sayi veri tipleri : float - double");
		System.out.println("float : " + float_tipindeki_degiskenimiz);
		System.out.println("double : " + double_tipindeki_degiskenimiz);

		System.out.println("Mantiksal veri tipleri : boolean");
		System.out.println("boolean : " + boolean_tipindeki_degiskenimiz + " \n");

	}

}
