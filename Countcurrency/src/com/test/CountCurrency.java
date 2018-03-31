package com.test;

public class CountCurrency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CountCurrency.countNotes(1730.75));

	}

	 static int countNotes(double n) {
		// TODO Auto-generated method stub
		 int count=0;
		 System.out.println(n);
		 while(n > 0){
			 
			 if(n >= 2000){
				 n=n-2000;
				 count++;
			 } else if(n >= 1000){
				 n=n-1000;
				 count++;
				 
			 }else if(n >= 500){
				 n=n-500;
				 count++;
			 }else if(n >= 200){
				 n=n-200;
				 count++;
			 }else if(n >= 100){
				 n=n-100;
				 count++;
			 }else if(n >= 50){
				 n=n-50;
				 count++;
			 }else if(n >= 20){
				 n=n-20;
				 count++;
			 }
			 else if(n >= 10){
				 n=n-10;
				 count++;
			 }else if(n >= 5){
				 n=n-5;
				 count++;
			 }else if(n >= 1){
				 n=n-1;
				 count++;
			 }else if(n >= 0.50){
				 n=n-0.50;
				 count++;
			 }else if(n >= 0.25) {
				 n=n-0.25;
				 count++;
			 }
		 }
		 
		return count;
	}

}
