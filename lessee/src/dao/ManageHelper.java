package dao;

import bean.lessee;
import bean.user;

import java.util.Vector;


//数据库业务处理类
public class ManageHelper {
	private JdbcHelper helper;	//与数据库通信的对象
	
	
	
	/**
	 * 登陆业务处理
	 * @param user	用户对象
	 * @return 返回是否成功登陆
	 */
	public boolean Login(user user){
		boolean b = true;
		helper = new JdbcHelper();	//创建与数据库通信的对象
		user newUser = helper.getUser(user);	//获得用户数据
		if(!user.getPassword().equals(newUser.getPassword())){	//比对密码与数据库中的对应密码是否一致
			b = false;
		}
		helper.close();//关闭资源
		return b;
	}
	
	
	
	/**
	 * 注册业务处理
	 * @param user 用户对象
	 * @return	返回是否注册成功
	 */
	public boolean Register(user user){
		helper = new JdbcHelper();//创建与数据库通信的对象
		boolean b = helper.register(user);
		helper.close();//关闭资源
		return b;
	}
	
	
	
	/**
	 * 检查是否重复登陆的方法
	 * @param user 用户对象
	 * @return 是否重复登陆,登陆过的返回true,否则返回false
	 */
	public boolean Check_IsLogin(user user){
		boolean b = true;
		int isLogin;
		helper = new JdbcHelper();//创建与数据库通信的对象
		user newUser = helper.getUser(user);
		if(newUser.getIsLogin()==0){
			b = false;
		}
		helper.close();//关闭资源
		return b;
	}
	
	
	
	/**
	 * 返回成功修改登陆情况
	 * @param user 用户对象
	 */
	public boolean  Update_IsLogin(user user){
		helper = new JdbcHelper();//创建与数据库通信的对象
		boolean b = helper.update_IsLogin(user);
		helper.close();//关闭资源
		return b;
	}
	
	
	
	/**
	 * 修改密码业务处理
	 * @param user	用户对象
	 * @param new_Password	新密码
	 * @return 返回是否修改成功
	 */
	public boolean update_Password(user user,String new_Password){
		boolean b;
		helper = new JdbcHelper();//创建与数据库通信的对象
		b = helper.update_Password(user, new_Password);
		helper.close();//关闭资源
		return b;
	}
	
	/**
	 * 添加租户业务
	 * @param _lessee 租户对象
	 * @return 返回是否添加成功
	 */
	public boolean addlessee(lessee _lessee){
		boolean b = true;
		helper = new JdbcHelper();
		b = helper.addLessee(_lessee);
		helper.close();//关闭资源
		return b;
	}
	
	
	/**
	 * 修改租户业务
	 * @param newLessee	新租户对象
	 * @param oldLesseeID	旧租户信息
	 * @return	返回是否添加成功
	 */
	public boolean updateSlessee(lessee newLessee,String oldLesseeID){
		boolean b = true;
		helper = new JdbcHelper();
		b = helper.updateLessee(newLessee, oldLesseeID);
		helper.close();//关闭资源
		return b;
	}
	
	
	/**
	 * 删除租户业务
	 * @param lesseeID	租户学号
	 * @return	返回是否删除成功
	 */
	public boolean deleteLessee(String lesseeID){
		boolean b = true;
		helper = new JdbcHelper();
		b = helper.deleteLessee(lesseeID);
		helper.close();
		return b;
	}
	
	
	/**
	 * 根据sql语句返回特定的租户对象集合
	 * @param sql	sql语句
	 * @return	返回租户集合
	 */
	public Vector<lessee> getlessee(String sql){
		Vector<lessee> lessees;
		helper = new JdbcHelper();
		lessees = helper.getlessee(sql);
		helper.close();
		return lessees;
	}
}
