package com.sap.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.sap.pojo.Employee;
import com.sap.service.EmployeeService;

public class SearchFrame extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Label l;
	TextField tf;
	Button b;
	Employee employeeId;

	public SearchFrame() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Employee Search");
		this.setLayout(new FlowLayout());
		this.setBackground(Color.GREEN);

		l = new Label("Employee Id");
		tf = new TextField(20);
		b = new Button("Search");
		b.addActionListener(this);

		Font f = new Font("arial", Font.BOLD, 20);
		l.setFont(f);
		tf.setFont(f);
		b.setFont(f);

		this.add(l);
		this.add(tf);
		this.add(b);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int eid = Integer.parseInt(tf.getText());
		System.out.println(eid);
		EmployeeService employeeService = new EmployeeService();
		employeeId = employeeService.search(eid);
		repaint();
	}

	public void paint(Graphics g) {
		Font f = new Font("arial", Font.BOLD, 30);
		this.setForeground(Color.red);
		g.setFont(f);

		if (employeeId == null) {
			g.drawString("Employee  Id not existed",50,300);
		} else {
			g.drawString("Employee  Id" + employeeId.getEmployeeId(), 50, 300);
			g.drawString("Employee  Name" + employeeId.getEmployeeName(), 50, 350);
			g.drawString("Employee  Salary" + employeeId.getEmployeeSalary(), 50,400);
		}
	}

}
