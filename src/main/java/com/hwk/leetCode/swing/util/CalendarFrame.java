package com.hwk.leetCode.swing.util;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 2010-7-2
 * 
 * @author mkk 
 * 实现日期选择器<br>
 *  扩展: 提供一个类似JColorChooser的静态方法获取选择的日期
 */
public class CalendarFrame implements ActionListener, ItemListener {

	/**
	 * constructor
	 */
	CalendarFrame() {
		this.calendar = Calendar.getInstance();
		this.year1 = this.calendar.get(Calendar.YEAR);
		this.month1 = this.calendar.get(Calendar.MONTH);
		this.day1 = this.calendar.get(Calendar.DAY_OF_MONTH);
		this.years = new String[DEFAULT_SHOW_YEARS];
		this.months = new String[12];
		// init
		this.initDatas();
	}

	/**
	 * 初始化数据
	 */
	private void initDatas() {
		// init label1
		label1 = new JLabel();
		label1.setForeground(Color.MAGENTA);
		// init months
		for (int i = 0; i < this.months.length; i++) {
			this.months[i] = " " + formatDay(i + 1);
		}
		// init years
		int start = this.year1 - 50;
		for (int i = start; i < start + 100; i++) {
			this.years[i - start] = String.valueOf(i);
		}
		// show info
		this.setInfo("当前日期: " + this.year1 + "-"
				+ this.formatDay(this.month1 + 1) + "-" + formatDay(this.day1)
				+ "            ", Color.BLUE);

	}

	/**
	 * 扩展方法 调用此方法可获取选择的日期值
	 * 
	 * @return
	 */
	public Date getSelectDate() {
		Date d = this.calendar.getTime();
		return d;
	}

	/**
	 * 设置UI 默认为windows
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
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				setUI();
				CalendarFrame frame = new CalendarFrame();
				frame.showFrame();
			}
		});
	}

	/**
	 * 根据界面的长度与宽度确定界面的左上角坐标值
	 * 
	 * @param width
	 *            长度
	 * @param height
	 *            宽度
	 * @return
	 */
	private Dimension getStartDimension(int width, int height) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		dim.width = dim.width / 2 - width / 2;
		dim.height = dim.height / 2 - height / 2;
		return dim;
	}

	private void showFrame() {
		f = new JFrame("日期选择器");
		// 北面面板
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		showNorthPanel(panel3);
		f.add(panel3, BorderLayout.NORTH);
		// 中间面板
		f.add(printCalendar(), BorderLayout.CENTER);
		// 南边面板
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.showSouthPanel(panel2);
		f.add(panel2, BorderLayout.SOUTH);

		// frame set
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		Dimension dim = getStartDimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		f.setLocation(dim.width, dim.height);
		f.setVisible(true);
	}

	/**
	 * 显示北面面板
	 * 
	 * @param panel
	 */
	private void showNorthPanel(JPanel panel) {
		this.button2 = new JButton("上一月");
		this.button2.setToolTipText("上一月");
		this.button2.addActionListener(this);
		panel.add(this.button2);
		this.comboBox1 = new JComboBox(this.years);
		this.comboBox1.setSelectedItem(String.valueOf(year1));
		this.comboBox1.setToolTipText("选择年份");
		this.comboBox1.addItemListener(this);
		panel.add(this.comboBox1);
		this.comboBox2 = new JComboBox(this.months);
		this.comboBox2.setSelectedItem(" " + formatDay(month1 + 1));
		this.comboBox2.setToolTipText("选择月份");
		this.comboBox2.addItemListener(this);
		panel.add(this.comboBox2);
		this.button3 = new JButton("下一月");
		this.button3.setToolTipText("下一月");
		this.button3.addActionListener(this);
		panel.add(this.button3);
	}

	/**
	 * 显示南边面板信息
	 * 
	 * @param panel
	 */
	private void showSouthPanel(JPanel panel) {
		// 状态栏
		panel.add(label1);
		this.button1 = new JButton("确定");
		this.button1.setToolTipText("确定");
		this.button1.addActionListener(this);
		panel.add(button1);
		panel.add(new JLabel(" "));
	}

	/**
	 * 输出日期的面板
	 *
	 * @return
	 */
	private JPanel printCalendar() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(7, 7, 0, 0));
		panel.setBorder(BorderFactory.createRaisedBevelBorder());
		int year2 = calendar.get(Calendar.YEAR);
		int month2 = calendar.get(Calendar.MONTH);
		// 将日期设为当月第一天
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		// 获取第一天是星期几
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		// 打印标头
		JButton b = null;
		for (int i = 0; i < tits.length; i++) {
			b = new JButton("<html><b>" + tits[i] + "</b></html>");
			b.setForeground(Color.BLACK);
			b.setBackground(Color.WHITE);
			b.setBorder(BorderFactory.createEmptyBorder());
			b.setEnabled(false);
			panel.add(b);
		}
		int count = 0;
		for (int i = Calendar.SUNDAY; i < weekDay; i++) {
			b = new JButton(" ");
			b.setEnabled(false);
			panel.add(b);
			count++;
		}
		int currday = 0;
		String dayStr = null;
		do {
			currday = calendar.get(Calendar.DAY_OF_MONTH);
			dayStr = formatDay(currday);
			// 日,月,年相等则显示
			if (currday == day1 && month1 == month2 && year1 == year2) {
				b = new JButton("["+dayStr+"]");
				b.setForeground(Color.RED);
			} else {
				b = new JButton(dayStr);
				b.setForeground(Color.BLUE);
			}
			count++;
			b
					.setToolTipText(year2 + "-" + formatDay(month2 + 1) + "-"
							+ dayStr);
			b.setBorder(BorderFactory.createEtchedBorder());
			b.addActionListener(this);
			panel.add(b);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			// 循环完成时月份实际上已经加1
		} while (calendar.get(Calendar.MONTH) == month2);
		// 减1,保持为当前月
		this.calendar.add(Calendar.MONTH, -1);
		for (int i = count; i < 42; i++) {
			b = new JButton(" ");
			b.setEnabled(false);
			panel.add(b);
		}
		return panel;
	}

	/**
	 * 状态栏显示
	 * 
	 * @param info
	 */
	private void setInfo(String info, Color c) {
		if (this.label1 != null && c != null) {
			this.label1.setText(info);
			this.label1.setForeground(c);
		}
	}

	/**
	 * 设置显示的数字,若小于10则在前面加0
	 * 
	 * @param day
	 * @return
	 */
	private String formatDay(int day) {
		if (day < 10) {
			return "0" + day;
		}
		return String.valueOf(day);
	}

	/**
	 * 响应点击事件
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("下一月".equals(command)) {
			// 1.月份加一
			this.calendar.add(Calendar.MONTH, 1);
			// 2.更新显示的年与月
			int year5 = calendar.get(Calendar.YEAR);
			// 判断是否超出显示的最大范围
			int maxYear = this.year1 + 49;
			if (year5 > maxYear) {
				this.calendar.add(Calendar.MONTH, -1);
				this.setInfo("年份越界: [" + year5 + " > " + maxYear + "]      ",
						Color.RED);
				return;
			}
			int month5 = calendar.get(Calendar.MONTH) + 1;
			this.comboBox1.setSelectedItem(String.valueOf(year5));
			this.comboBox2.setSelectedItem(" " + this.formatDay(month5));
			// 3.更新界面
			this.updatePanel();
		} else if ("上一月".equals(command)) {
			// 1.月份减一
			this.calendar.add(Calendar.MONTH, -1);
			// 2.更新显示的年与月
			int year5 = calendar.get(Calendar.YEAR);
			// 判断是否超出显示的最大范围
			int minYear = this.year1 - 50;
			if (year5 < minYear) {
				this.calendar.add(Calendar.MONTH, 1);
				this.setInfo("年份越界: [" + year5 + " < " + minYear + "]      ",
						Color.RED);
				return;
			}
			int month5 = calendar.get(Calendar.MONTH) + 1;
			this.comboBox1.setSelectedItem(String.valueOf(year5));
			this.comboBox2.setSelectedItem(" " + this.formatDay(month5));
			// 3.更新界面
			this.updatePanel();
		} else if ("确定".equals(command)) {
			String str = this.calendar.get(Calendar.YEAR) + "-"
					+ this.formatDay(this.calendar.get(Calendar.MONTH) + 1)
					+ "-"
					+ this.formatDay(this.calendar.get(Calendar.DAY_OF_MONTH));
			JOptionPane.showMessageDialog(this.f, str, "结果",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (command.matches("^\\d+$")) {
			int day9 = Integer.parseInt(command);
			this.calendar.set(Calendar.DAY_OF_MONTH, day9);
			String str = this.calendar.get(Calendar.YEAR) + "-"
					+ this.formatDay(this.calendar.get(Calendar.MONTH) + 1)
					+ "-"
					+ this.formatDay(this.calendar.get(Calendar.DAY_OF_MONTH));
			this.setInfo("你选择日期为: " + str + "      ", getRandomColor());
		}
	}

	/**
	 * 获取一个随机的颜色值
	 * 
	 * @return
	 */
	private Color getRandomColor() {
		Random random = new Random();
		Color c = new Color(random.nextInt(255), random.nextInt(255), random
				.nextInt(255));
		return c;
	}

	/**
	 * 更新界面
	 */
	private void updatePanel() {
		this.f.remove(this.panel);
		this.f.add(this.printCalendar(), BorderLayout.CENTER);
		this.f.validate();
	}

	/**
	 * 下拉框属性改变事件
	 * 
	 * @param e
	 */
	public void itemStateChanged(ItemEvent e) {
		int type = 0;
		String s = e.getItemSelectable().getSelectedObjects()[0].toString()
				.trim();
		if (s.length() == 2) {
			type = 1;
		}
		int value = Integer.parseInt(s);
		if (tempValue == 0) {
			tempValue = value;
			this.processStateChanged(value, type);
		} else {
			if (value != tempValue) {
				this.processStateChanged(value, type);
				tempValue = value;
			}
		}
	}

	/**
	 * 处理选择年份与月份的事件
	 * 
	 * @param value
	 * @param type
	 *            类型 0表示年份改变 1表示月份改变
	 */
	private void processStateChanged(int value, int type) {
		if (0 == type) {
			this.calendar.set(Calendar.YEAR, value);
		} else if (1 == type) {
			this.calendar.set(Calendar.MONTH, value - 1);
		}
		// 更新界面
		this.updatePanel();
	}

	// 临时变量值
	private int tempValue = 0;
	// 默认宽度与高度
	private static final int DEFAULT_WIDTH = 280;
	private static final int DEFAULT_HEIGHT = 280;
	// 默认显示的年份为100年,即当年的前后50年
	private static final int DEFAULT_SHOW_YEARS = 100;
	// 状态栏与确认按钮
	// 状态栏最多放置17个汉字
	private JLabel label1 = null;
	private JButton button1 = null;
	private JFrame f = null;
	// 上一个月,下一个月按钮
	private JButton button2 = null;
	private JButton button3 = null;
	// 选择年与月的下拉框
	private JComboBox comboBox1 = null;
	private JComboBox comboBox2 = null;
	// 日历对象
	private Calendar calendar = null;
	// 年与月的选择集合对象
	private String[] years = null;
	private String[] months = null;
	// 当前年,月,日
	private int year1, month1, day1;
	private JPanel panel = null;
	private String tits[] = { "日", "一", "二", "三", "四", "五", "六" };
}
