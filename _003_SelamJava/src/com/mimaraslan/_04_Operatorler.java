package com.mimaraslan;

public class _04_Operatorler {
	static double sonuc = 0;
	static double sayi1 = 3;
	static double sayi2 = 2;


	public static void main(String[] args) {

		sonuc = sayi1 + sayi2;
		System.out.println("Toplama  + operatoru : " +  sonuc);

		sonuc = sayi1 - sayi2;
		System.out.println("Cikarma  - operatoru : " +  sonuc);

		sonuc = sayi1 * sayi2;
		System.out.println("Carpma   * operatoru : " +  sonuc);

		sonuc = sayi1 / sayi2;
		System.out.println("Bolme    / operatoru : " +  sonuc);
		
		sonuc = sayi1 % sayi2;
		System.out.println("Mod alma % operatoru : " +  sonuc);
	}

}
