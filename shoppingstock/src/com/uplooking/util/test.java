package com.uplooking.util;


import java.util.Scanner;
import java.io.*;

public class test {

	public static void main(String[] args) {
		//scanner
		Scanner scnr = new Scanner(System.in);

		int total=0,count=0;
		int userInput = scnr.nextInt();

		while (userInput>0){
		 	total+=userInput;
		 	count++;
			userInput = scnr.nextInt();
		 }
		//System.out.println(total+" "+count);
		}
	}


