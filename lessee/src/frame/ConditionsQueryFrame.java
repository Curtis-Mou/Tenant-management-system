package frame;

import dao.ManageHelper;
import model.lesseemodel;
import util.CreateSql;
import util.WindowUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//多条件查询界面
public class ConditionsQueryFrame extends JDialog{
    private JLabel lessee_ID;    //"编号"标签。
    private JLabel lessee_Name;	//"姓名"标签。
    private JLabel sex_Label;	//"性别"标签。
    private JLabel age_Label;	//"年龄标签"。
    private JLabel time_Label;	//"时间"标签。
    private JLabel rent_Label;	//"租金"标签。
    private JTextField lessee_IDText;	//"遍编号文本域。
    private JTextField lessee_NameText;	//"姓名"文本域。
    private JTextField sex_Text;	//性别选项
    private JTextField age_Text;	//年龄选项
    private JTextField rent_Text;	//租金
    private JTextField time_Text;	//时间
    private JButton conditions_button;	//多条件查询按钮 
    private ManageHelper helper;
    private JDialog jd;	//当前窗口
    /**
	 * 
	 * @param owner 它的父窗口
	 * @param title 窗口名
	 * @param modal 指定的模式窗口，还有非模式窗口
	 */
    public ConditionsQueryFrame(JDialog owner, String title, boolean modal, JTable jt){
    	super(owner, title, modal);
    	this.jd = this;
    	this.setLayout(null);
    	
    	lessee_ID = new JLabel("编号:");
    	lessee_ID.setBounds(29, 19, 30, 20);
    	this.add(lessee_ID);
    	
    	lessee_IDText = new JTextField();
    	lessee_IDText.setBounds(65, 19, 100, 20);
    	this.add(lessee_IDText);
    	
    	lessee_Name = new JLabel("姓名:");
    	lessee_Name.setBounds(200, 19, 30, 20);
    	this.add(lessee_Name);
    	
    	lessee_NameText = new JTextField();
    	lessee_NameText.setBounds(240, 19, 100, 20);
    	this.add(lessee_NameText);
    	
    	sex_Label = new JLabel("性别:");
    	sex_Label.setBounds(29, 50, 30, 20);
    	this.add(sex_Label);
    	
    	sex_Text = new JTextField();
    	sex_Text.setBounds(65, 50, 100, 20);
    	this.add(sex_Text);
    	
    	age_Label = new JLabel("年龄:");
    	age_Label.setBounds(200, 50, 30, 20);
    	this.add(age_Label);
    	
    	age_Text = new JTextField();
    	age_Text.setBounds(240, 50, 100, 20);
    	this.add(age_Text);
    	
    	rent_Label = new JLabel("租金:");
    	rent_Label.setBounds(29, 83, 30, 20);
    	this.add(rent_Label);
    	
    	rent_Text = new JTextField();
    	rent_Text.setBounds(65, 83, 100, 20);
    	this.add(rent_Text);
    	
    	time_Label = new JLabel("时间:");
    	time_Label.setBounds(200, 83, 30, 20);
    	this.add(time_Label);
    	
    	time_Text = new JTextField();
    	time_Text.setBounds(240, 83, 100, 20);
    	this.add(time_Text);

    	conditions_button = new JButton("多条件查询");
    	conditions_button.setBounds(230, 130, 100, 30);
    	//注册"多条件查询"按钮事件监听
    	conditions_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = lessee_IDText.getText().trim();
				String name = lessee_NameText.getText().trim();
				String sex = sex_Text.getText().trim();
				String age = age_Text.getText().trim();
				String rent = rent_Text.getText().trim();
				String time = time_Text.getText().trim();
				if(id.equals("")&&name.equals("")&&sex.equals("")&&age.equals("")&&rent.equals("")&&time.equals("")){
					JOptionPane.showMessageDialog(jd, "条件不能为空！", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}else{
					String sql = CreateSql.getConditions_Sql(id, name, sex, age, rent, time);
					lesseemodel sm = new lesseemodel(sql,jd);
					jt.setModel(sm);
					jd.dispose();
				}
				
			}
		});
    	this.add(conditions_button);
    	
    	
    	this.setSize(411, 222);
    	this.setResizable(false);
    	WindowUtil.setFrameCenter(this);
    	this.setVisible(true);
    }
}
