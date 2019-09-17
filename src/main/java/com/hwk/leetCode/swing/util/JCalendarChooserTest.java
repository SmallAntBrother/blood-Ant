package com.hwk.leetCode.swing.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * 2010-7-10 下午10:25:26
 */
public class JCalendarChooserTest extends JFrame {

	private static final long serialVersionUID = 1L;

	private JFrame main;

	public JCalendarChooserTest() {

		main = this;
		this.setTitle("测试JCalendarChooser");

		final JLabel l1 = new JLabel("-----");
		this.add(l1, BorderLayout.SOUTH);

		JButton b1 = new JButton("选择日期");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Point p=new Point(700,290);
				JCalendarChooser chooser = new JCalendarChooser(main,"我的日期",p,60);
				Calendar d = chooser.showCalendarDialog();
				l1.setText(d.get(Calendar.YEAR) + "-"
						+ (d.get(Calendar.MONTH) + 1) + "-"
						+ d.get(Calendar.DAY_OF_MONTH));
			}
		});
		this.add(b1, BorderLayout.CENTER);

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(300, 200, 600, 400);
		this.setVisible(true);
	}

	/**
	 * 设置UI 默认为windows
	 */
	/**
	 * javax.swing.plaf.metal.MetalLookAndFeel
	 * com.sun.java.swing.plaf.motif.MotifLookAndFeel
	 * com.sun.java.swing.plaf.windows.WindowsLookAndFeel
	 * com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel
	 * 
	 */
	private static void setUI() {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
			System.out.println("Exception UI: " + e.getMessage());
		}
	}
	public static void main(String[] args) {
		setUI() ;
		new JCalendarChooserTest();
	}

}
