package frame;


import model.lesseemodel;
import util.WindowUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//详细信息界面
public class DetailsFrame extends JDialog{
	private JButton confirm_Button;	//"确认"按钮。
    private JTextField sex_Text;	//"性别"选项。
    private JTextField time_Text;	//"时间"选项。
    private JTextField rent_Text;	//"租金"选项。
    private JLabel lessee_ID;  //"编号"标签。
    private JLabel lessee_Name;	//"姓名"标签。
    private JLabel sex_Label;	//"性别"标签。
    private JLabel age_Label;	//"年龄标签"。
    private JLabel time_Label;	//"时间"标签。
    private JLabel rent_Label;	//"租金"标签。
    private JTextField lessee_IDText;	//"编号"文本域。
    private JTextField lessee_NameText;	//"姓名"文本域。
    private JTextField age_Text;	//"年龄"文本域。
    private lesseemodel sm;	//传入的租户数据模型
    private JDialog jd;	//当前窗口。
/**
 * 
 * @param owner 它的父窗口
 * @param title 窗口名
 * @param modal 指定的模式窗口，还有非模式窗口
 */
public DetailsFrame(JDialog owner, String title, boolean modal, int rowNum, lesseemodel sm){
	super(owner, title, modal);
	this.sm = sm;	//传入租户数据模型
	this.jd = this;
	this.setSize(350,429);	//设置窗体大小。
	this.setLayout(null);	//设置空布局。
	
	lessee_ID = new JLabel("编号:");
	lessee_ID.setBounds(78, 48, 30, 20);	
	this.add(lessee_ID);	
	
	lessee_IDText = new JTextField();
	lessee_IDText.setEditable(false);	//不可编辑
	lessee_IDText.setText(sm.getValueAt(rowNum, 0).toString());	//获取编号并显示
	lessee_IDText.setBounds(116, 48, 150, 20);
	this.add(lessee_IDText);
	
	lessee_Name = new JLabel("姓名:");
	lessee_Name.setBounds(78, 88, 30, 20);
	this.add(lessee_Name);
	
	
	lessee_NameText = new JTextField();
	lessee_NameText.setBounds(116, 88, 150, 20);
	lessee_NameText.setEditable(false);//不可编辑
	lessee_NameText.setText(sm.getValueAt(rowNum, 2).toString());	//设置租户姓名并显示
	this.add(lessee_NameText);
	
	sex_Label = new JLabel("性别:");
	sex_Label.setBounds(78, 128, 30, 20);
	this.add(sex_Label);
	
	sex_Text = new JTextField();
	sex_Text.setBounds(116, 128, 60, 20);
	sex_Text.setEditable(false);//不可编辑
	sex_Text.setText(sm.getValueAt(rowNum, 1).toString());	//设置租户性别并显示
	this.add(sex_Text);
	
	age_Label = new JLabel("年龄:");
	age_Label.setBounds(78, 168, 30, 20);
	this.add(age_Label);
	
	age_Text = new JTextField();
	age_Text.setBounds(116, 168, 150, 20);
	age_Text.setEditable(false);
	age_Text.setText(sm.getValueAt(rowNum, 3).toString());	//设置租户年龄并显示
	this.add(age_Text);
		
	rent_Label = new JLabel("租金:");
	rent_Label.setBounds(78, 208, 30, 20);
	
	this.add(rent_Label);
	
	rent_Text = new JTextField();
	rent_Text.setEditable(false);
	rent_Text.setText(sm.getValueAt(rowNum, 4).toString());
	rent_Text.setBounds(116, 208, 150, 20);
	this.add(rent_Text);

	time_Label = new JLabel("时间:");

	time_Label.setBounds(78, 248, 30, 20);
	this.add(time_Label);
	
	time_Text = new JTextField();
	time_Text.setEditable(false);
	time_Text.setBounds(116, 248, 150, 20);
	time_Text.setText(sm.getValueAt(rowNum, 5).toString());
	this.add(time_Text);
	
	confirm_Button = new JButton("确认");
	//注册"确定"按钮事件监听
	confirm_Button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jd.dispose();//关闭当前窗口
		}
	});
	confirm_Button.setBounds(150, 330, 60, 25);
	
	this.add(confirm_Button);

	
	WindowUtil.setFrameCenter(this);
	this.setResizable(false);
	this.setVisible(true);
	}
}
