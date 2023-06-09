package frame;


import bean.lessee;
import dao.ManageHelper;
import model.lesseemodel;
import util.WindowUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//修改租户信息界面
public class ModifyFrame extends JDialog{
 	private JButton modify_Button;	//"修改"按钮。
    private JButton cancel_Button;	//"取消"按钮。
    private JComboBox sex_Box;	//"性别"选项。
    private JLabel lessee_ID; //"编号"标签。
    private JLabel lessee_Name;	//"姓名"标签。
    private JLabel sex_Label;	//"性别"标签。
    private JLabel age_Label;	//"年龄标签"。
	private JTextField age_Text;	//"编号"文本域。
    private JLabel time_Label;	//"时间"标签。
	private JTextField time_Text;	//"时间"文本域。
    private JLabel rent_Label;	//"租金"标签。
	private JTextField rent_Text;	//"租金"文本域。
    private JTextField lessee_IDText;	//"编号"文本域。
    private JTextField lessee_NameText;	//"姓名"文本域。
    private JDialog jd;	//当前窗口。
    private lesseemodel sm;	//租户数据模型对象
	private ManageHelper helper;
	/**
	 * 
	 * @param owner 它的父窗口
	 * @param title 窗口名
	 * @param modal 指定的模式窗口，还有非模式窗口
	 */
	public ModifyFrame(JDialog owner, String title, boolean modal, int rowNum, lesseemodel sm){
		super(owner, title, modal);
		helper = new ManageHelper();	//创建数据库业务处理对象
		this.jd = this;
		this.sm = sm;
		this.setSize(350,429);	//设置窗体大小。
		this.setLayout(null);	//设置空布局。
		//获取信息
		String lessee_id = sm.getValueAt(rowNum, 0).toString();
		String lessee_name = sm.getValueAt(rowNum, 2).toString();
		String lessee_sex = sm.getValueAt(rowNum, 1).toString();
		String lessee_age = sm.getValueAt(rowNum, 3).toString();
		String lessee_rent = sm.getValueAt(rowNum, 4).toString();
		String lessee_time = sm.getValueAt(rowNum,5).toString();
		lessee_ID = new JLabel("编号:");
		lessee_ID.setBounds(78, 48, 30, 20);	
		this.add(lessee_ID);	
		
		lessee_IDText = new JTextField();
		lessee_IDText.setBounds(116, 48, 150, 20);
		lessee_IDText.setText(lessee_id);	//获取编号并显示
		this.add(lessee_IDText);
		
		lessee_Name = new JLabel("姓名:");
		lessee_Name.setBounds(78, 88, 30, 20);
		this.add(lessee_Name);
		
		
		lessee_NameText = new JTextField();
		lessee_NameText.setBounds(116, 88, 150, 20);
		lessee_NameText.setText(lessee_name);	//设置租户姓名并显示
		this.add(lessee_NameText);
		
		sex_Label = new JLabel("性别:");
		sex_Label.setBounds(78, 128, 30, 20);
		this.add(sex_Label);
		
		sex_Box = new JComboBox(new String[]{"","男","女"});
		sex_Box.setSelectedItem(sm.getValueAt(rowNum, 2));
		sex_Box.setBounds(116, 128, 60, 20);
		this.add(sex_Box);
		
		
		age_Label = new JLabel("年龄:");
		age_Label.setBounds(78, 168, 30, 20);
		this.add(age_Label);

		age_Text = new JTextField();
		age_Text.setBounds(116, 168, 150, 20);
		age_Text.setText(lessee_age);	//设置租户年龄并显示
		this.add(age_Text);

		rent_Label = new JLabel("租金:");
		rent_Label.setBounds(78, 208, 30, 20);
		this.add(rent_Label);

		rent_Text = new JTextField();
		rent_Text.setBounds(116, 208, 150, 20);
		rent_Text.setText(lessee_rent);	//设置租户租金并显示
		this.add(rent_Text);

	
		time_Label = new JLabel("时间:");
		time_Label.setBounds(78, 248, 30, 20);	
		this.add(time_Label);

		time_Text = new JTextField();
		time_Text.setBounds(116, 248, 150, 20);
		time_Text.setText(lessee_time);	//设置租户时间并显示
		this.add(time_Text);

		modify_Button = new JButton("修改");
		modify_Button.setBounds(70, 330, 60, 25);
		
		
		//注册"修改"按钮事件监听
		modify_Button.addActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {
				lessee newlessee = new lessee();
				String id = lessee_IDText.getText().trim();
				String name = lessee_NameText.getText().trim();
				String sex = sex_Box.getSelectedItem().toString();
				String age = age_Text.getText().trim();
				String rent_Name = rent_Text.getText().trim();
				String time_Name = time_Text.getText().trim();
				//数据校验部分
				if(id.equals("")){
					JOptionPane.showMessageDialog(jd, "编号不能为空！", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(id.length()!=2){
					JOptionPane.showMessageDialog(jd, "编号必须是两位数！", "", JOptionPane.WARNING_MESSAGE);
					lessee_IDText.setText("");
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

				if(rent_Name.equals("")){
					JOptionPane.showMessageDialog(jd, "租金不能为空！", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(time_Name.equals("")){
					JOptionPane.showMessageDialog(jd, "时间不能为空！", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}

				newlessee.setLesseeID(id);
				newlessee.setLesseeNAME(name);
				newlessee.setLesseeSEX(sex);
				newlessee.setLesseeAGE(age);
				newlessee.setlesseetime(time_Name);
				newlessee.setlesseeMoney(rent_Name);
				if(helper.updateSlessee(newlessee, lessee_id)){
					JOptionPane.showMessageDialog(jd, "修改成功！");
					jd.dispose();	//关闭当前窗口
					return ;
				}else{
					JOptionPane.showMessageDialog(jd, "修改失败！", "", JOptionPane.WARNING_MESSAGE);
					jd.dispose();	//关闭当前窗口
					return ;
				}
			}
			
		});
		this.add(modify_Button);
		
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
