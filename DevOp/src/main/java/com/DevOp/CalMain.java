package com.DevOp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal=new Calculator();
		JFrame frame = new JFrame("Answer");
		
		double n1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter 1st number to add?"));
		double n2=Integer.parseInt(JOptionPane.showInputDialog("Please enter 2st number to add?"));
		double answerAdd=cal.add(n1,n2);
		JOptionPane.showMessageDialog(frame, answerAdd);
		double s1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter 1st number to subtract?"));
		double s2=Integer.parseInt(JOptionPane.showInputDialog("Please enter 2st number to subtract?"));
		double answerSubtract=cal.subtract(s1, s2);
		JOptionPane.showMessageDialog(frame, answerSubtract);
		
		

	}

}
