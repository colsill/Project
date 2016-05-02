package com.DevOp;

import junit.runner.Version;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CalMain {

	public static void main(String[] args) {
		
		Calculator cal=new Calculator();
		JFrame frame = new JFrame("Answer");
		System.out.println("JUnit version is: " + Version.id());
		
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter 1st number to add?"));
		int n2=Integer.parseInt(JOptionPane.showInputDialog("Please enter 2st number to add?"));
		int answerAdd=cal.add(n1,n2);
		JOptionPane.showMessageDialog(frame, answerAdd);
		int s1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter 1st number to subtract?"));
		int s2=Integer.parseInt(JOptionPane.showInputDialog("Please enter 2st number to subtract?"));
		int answerSubtract=cal.subtract(s1, s2);
		JOptionPane.showMessageDialog(frame, answerSubtract);
		int m1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter 1st number to multiply?"));
		int m2=Integer.parseInt(JOptionPane.showInputDialog("Please enter 2st number to multiply?"));
		int answerMulti=cal.multiply(m1, 2);
		JOptionPane.showMessageDialog(frame, answerMulti);
		
		

	}

}
