package frame;

import bean.user;
import dao.ManageHelper;
import util.WindowUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

//主界面
public class lesseeSystemMainFrame extends JFrame {
	private JMenuBar menuBar;	//应用菜单条。
	private JMenu lessee_Management;	//"租户管理"菜单。

/*	private JMenu score_Management;	//"成绩管理"菜单。*/

	private JMenu personal_Management;	//"个人管理"菜单。
	private JMenuItem add_lessee;	//"添加租户"菜单项。
	private JMenuItem query_lessee;	//"查询租户信息"菜单项。
	private JMenuItem modify_lessee;	//"修改租户信息"菜单项。
	private JMenuItem delete_lessee;	//"删除租户"菜单项。

	/*private JMenuItem add_Score;	//"添加租户成绩"菜单项。
	private JMenuItem modify_Score;	//"修改租户成绩"菜单项。
	private JMenuItem query_Score;	//"成绩查询"菜单项。
	private JMenuItem score_Statistics;	//"成绩统计"菜单项。*/

	private JMenuItem change_Password;	//"修改密码"菜单项。
	private JMenuItem logout;	//"退出登录"菜单项。
	private JFrame jf;	//当前窗口。
	private user user;//当前用户。
	public lesseeSystemMainFrame(user user){
		super("租户管理系统,欢迎你"+user.getUsername());
		this.user = user;
		this.jf = this;
		menuBar = new JMenuBar();	//创建菜单条。
		this.setJMenuBar(menuBar);	//添加菜单条。
		
		lessee_Management = new JMenu("租户管理");	//创建"租户管理"菜单。
		menuBar.add(lessee_Management);	//添加"租户管理"菜单。
		
		add_lessee = new JMenuItem("添加租户");	//创建"添加租户"菜单项。
		//注册"添加租户"菜单项事件监听
		add_lessee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddlesseeFrame addlesseeFrame = new AddlesseeFrame(jf,"添加租户",true);
			}
		});
		lessee_Management.add(add_lessee);	//添加"添加租户"菜单项。
		
		query_lessee = new JMenuItem("查询租户信息");	//创建"查询租户"菜单项。
		//注册"查询租户"菜单项事件监听。
		query_lessee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				QuerylesseeFrame querylesseeFrame = new QuerylesseeFrame(jf, "查询租户信息", true);
				
			}
		});
		lessee_Management.add(query_lessee);	//添加"查询租户信息"菜单项。
		
		modify_lessee = new JMenuItem("修改租户信息");	//创建"修改租户信息"菜单项。
		//注册"修改租户信息"菜单项事件监听
		modify_lessee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ModifylesseeFrame modifylesseeFrame = new ModifylesseeFrame(jf, "修改租户信息", true);
				
			}
		});
		lessee_Management.add(modify_lessee);	//添加"修改租户"菜单项。
		
		delete_lessee = new JMenuItem("删除租户");	//创建"删除租户"菜单项。
		//注册"删除租户"按钮事件监听
		delete_lessee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeletelesseeFrame deletelesseeFrame = new DeletelesseeFrame(jf, "删除租户", true);
				
			}
		});
		lessee_Management.add(delete_lessee);	//添加"删除租户"菜单项.
		
		personal_Management = new JMenu("个人管理");	//创建"个人管理"菜单。
		menuBar.add(personal_Management);	//添加"个人管理"菜单。
		
		change_Password = new JMenuItem("修改密码");	//创建"修改密码"菜单项。
		//注册"修改密码"菜单项事件监听
		change_Password.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdatePasswordFrame frame = new UpdatePasswordFrame(jf, "修改密码", true,user);
			}
		});
		personal_Management.add(change_Password);	//添加"修改密码"菜单项。
		
		logout = new JMenuItem("退出登录");	//创建"退出登录"菜单项。
		//注册"退出登录"菜单项时间监听
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				jf.dispose();	//关闭当前窗口
				//修改登陆状态
				ManageHelper helper = new ManageHelper();
				user.setIsLogin(0);//设置登陆状态为未登录。
				helper.Update_IsLogin(user);
				lesseeSystemLoginFrame frame = new lesseeSystemLoginFrame();	//打开登陆界面
				
			}
		});
		personal_Management.add(logout);	//添加"退出登录"菜单项。
		
		this.setSize(578, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		WindowUtil.setFrameCenter(this);//设置窗体居中。
		ImagePanel imagePanel = new ImagePanel();
		setContentPane(imagePanel);
		
		try {
			Image img = ImageIO.read(this.getClass().getResource("/2.png"));
			this.setIconImage(img);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	     
		this.setVisible(true);//设置窗体可见。
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//修改登陆状态
				ManageHelper helper = new ManageHelper();
				user.setIsLogin(0);//设置登陆状态为未登录。
				helper.Update_IsLogin(user);
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	
}
