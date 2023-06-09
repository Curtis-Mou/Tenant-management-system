package frame;

import bean.lessee;
import dao.ManageHelper;
import util.Tools;
import util.WindowUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

//添加租户界面
public class AddlesseeFrame extends JDialog{//JDialog窗体
	 	private JButton add_Button;	//"添加"按钮。
	    private JButton cancel_Button;	//"取消"按钮。
	    private JComboBox sex_Box;	//"性别"选项。
	    private JLabel lessee_ID;    //"编号"标签。
	    private JLabel lessee_Name;	//"姓名"标签。
	    private JLabel sex_Label;	//"性别"标签。
	    private JLabel age_Label;	//"年龄标签"。
	    private JLabel time_Label;	//"时间"标签。
	    private JLabel rent_Label;	//"租金"标签。
	    private JTextField lessee_IDText;	//"编号"文本域。
	    private JTextField lessee_NameText;	//"姓名"文本域。
	    private JTextField age_Box;	//"年龄"文本域。
	    private JTextField rentText; //租金文本域
	    private JTextField time_Text;  //时间文本域
	    private JDialog jd;	//当前窗口。
	    private ManageHelper helper;	//数据库业务处理对象
	/**
	 * 
	 * @param owner 它的父窗口
	 * @param title 窗口名
	 * @param modal 指定的模式窗口，还有非模式窗口
	 */
	public AddlesseeFrame(JFrame owner, String title, boolean modal){
		super(owner, title, modal);
		helper = new ManageHelper();	//创建数据库业务处理对象

		this.jd = this;
		this.setSize(350,429);	//设置窗体大小。
		this.setLayout(null);	//设置空布局。
		
		lessee_ID = new JLabel("编号:");
		lessee_ID.setBounds(78, 48, 30, 20);	
		this.add(lessee_ID);	
		
		lessee_IDText = new JTextField();
		lessee_IDText.setBounds(116, 48, 150, 20);
		this.add(lessee_IDText);
		
		lessee_Name = new JLabel("姓名:");
		lessee_Name.setBounds(78, 88, 30, 20);
		this.add(lessee_Name);
		
		
		lessee_NameText = new JTextField();
		lessee_NameText.setBounds(116, 88, 150, 20);
		this.add(lessee_NameText);
		
		sex_Label = new JLabel("性别:");
		sex_Label.setBounds(78, 128, 30, 20);
		this.add(sex_Label);
		
		sex_Box = new JComboBox(new String[]{"","男","女"});
		sex_Box.setBounds(116, 128, 60, 20);
		this.add(sex_Box);

		age_Label = new JLabel("年龄:");
		age_Label.setBounds(78, 168, 30, 20);
		this.add(age_Label);
		
		age_Box = new JTextField();
		age_Box.setBounds(116, 168, 150, 20);
		this.add(age_Box);


		rent_Label = new JLabel("租金:");
		rent_Label.setBounds(78, 208, 30, 20);
		this.add(rent_Label);

		rentText = new JTextField();
		rentText.setBounds(116, 208, 150, 20);
		this.add(rentText);

		time_Label = new JLabel("时间:");
		time_Label.setBounds(78, 248, 30, 20);
		this.add(time_Label);

		time_Text = new JTextField();
		time_Text.setBounds(116, 248, 150, 20);
		this.add(time_Text);
		
		add_Button = new JButton("添加");
		add_Button.setBounds(70, 330, 60, 25);
		
		//注册"确认"按钮事件监听
		add_Button.addActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {
				lessee _lessee = new lessee();
				String sid = lessee_IDText.getText().trim();
				String name = lessee_NameText.getText().trim();
				String sex = sex_Box.getSelectedItem().toString();
				String age = age_Box.getText().trim();
				String rent = rentText.getText().trim();
				String time = time_Text.getText().trim();
				//数据校验部分
				if(sid.equals("")){
					JOptionPane.showMessageDialog(jd, "编号不能为空！", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(name.equals("")){
					JOptionPane.showMessageDialog(jd, "姓名不能为空！", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(sex.equals("")){
					JOptionPane.showMessageDialog(jd, "性别不能为空！", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(age.equals("")){
					JOptionPane.showMessageDialog(jd, "年龄不能为空！", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(rent.equals("")){	//先检查再用
					JOptionPane.showMessageDialog(jd, "租金不能为空！", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(time.equals("")){
					JOptionPane.showMessageDialog(jd, "时间不能为空！", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				_lessee.setLesseeID(sid);
				_lessee.setLesseeNAME(name);
				_lessee.setLesseeSEX(sex);
				_lessee.setLesseeAGE(age);
				_lessee.setlesseeMoney(rent);
				_lessee.setlesseetime(time);
				if(helper.addlessee(_lessee)){
					JOptionPane.showMessageDialog(jd, "添加成功！");
					jd.dispose();	//关闭当前窗口
					return ;
				}else{
					JOptionPane.showMessageDialog(jd, "添加失败！", "", JOptionPane.WARNING_MESSAGE);
					jd.dispose();	//关闭当前窗口
					return ;
				}
				
				
			}
		});
		this.add(add_Button);
		
		cancel_Button = new JButton("取消");
		cancel_Button.setBounds(230, 330, 60, 25);
		//注册"取消"按钮事件监听
		cancel_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jd.dispose();
				
			}
		});
		this.add(cancel_Button);
		
		WindowUtil.setFrameCenter(this);
		this.setResizable(false);
		this.setVisible(true);
	}
}
