package com.xworkz.tester;

import com.xworkz.mathproject.MathOperations;
import com.xworkz.mathproject.MathOperationsImpl;

public class MathTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MathOperations mop = new MathOperationsImpl();
		System.out.println("Addition of 2 no: "+mop.addition(20, 10));
		System.out.println("Subtraction of 2 no: "+mop.subtraction(20, 10));
		System.out.println("Multiplication of 2 no: "+mop.multiplication(20, 10));
		System.out.println("Division of 2 no: "+mop.division(20, 0));
		System.out.println("Modulus of 2 no: "+mop.modulus(20, 0));
	}

}
