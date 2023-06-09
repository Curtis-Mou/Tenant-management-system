package dao;

import bean.lessee;
import bean.user;


import java.util.Vector;

import java.sql.*;


public class JdbcHelper implements JdbcConfig{
	//定义连接数据库所需要的对象
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection ct = null;
	

	//获得数据库的连接
	private  void init(){
		try {
			Class.forName(DRIVER);
			ct = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 获得数据库连接
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//无参构造函数
	public JdbcHelper(){
		this.init();
	}
	

	/**
	 * 获取用户对象
	 * 根据传入的用户名，获取对应的用户，并返回用户对象
	 * @return 用户对象
	 */
	public user getUser(user user){
		user newUser = new user();
		try {
			ps = ct.prepareStatement("select * from tb_user where User_name=?");
			ps.setString(1, user.getUsername());
			rs = ps.executeQuery();
			if(rs.next()){
				newUser.setUsername(rs.getString(1));	//设置用户名
				newUser.setPassword(rs.getString(2));	//设置密码
				newUser.setIsLogin(rs.getInt(3));	//设置是否登陆
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return newUser;
	}
	
	/**
	 * 注册处理
	 * @param user	用户对象
	 * @return	返回是否注册成功
	 */
	public boolean register(user user){
		boolean b = true;
		try {
			ps = ct.prepareStatement("insert into tb_user(User_name,Password_) values(?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			if(ps.executeUpdate()!=1){	//执行sql语句
				b = false;
			}
		} catch (SQLException e) {
			b = false;
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * 修改用户"是否"登陆状态
	 * @param user
	 * @return
	 */
	public boolean update_IsLogin(user user){
		boolean b = true;
		try {
			ps = ct.prepareStatement("update tb_User set IsLogin=? where User_name=?");
			ps.setInt(1, user.getIsLogin());
			ps.setString(2, user.getUsername());
			if(ps.executeUpdate()!=1){
				b = false;
			}
		} catch (SQLException e) {
			b = false;
			e.printStackTrace();
		}
		return b;
	}
	
	
	
	
	
		/**
		 * 修改密码
		 * @param user  用户对象
		 * @param new_Password 新密码
		 * @return	返回是否修改成功
		 */
		public boolean update_Password(user user,String new_Password){
			boolean b = true;
			try {
				ps = ct.prepareStatement("update tb_User set Password_=? where User_name=?");
				ps.setString(1, new_Password);
				ps.setString(2, user.getUsername());
				if(ps.executeUpdate()!=1){	//执行sql语句
					b = false;
				}
			} catch (SQLException e) {
				b = false;
				e.printStackTrace();
			}
			return b;
		}

		/**
		 * 添加租户
		 * @param _lessee	租户对象
		 * @return	返回是否添加成功
		 */
		public boolean addLessee(lessee _lessee){
			boolean b = true;
			try {
				ps = ct.prepareStatement("insert into tb_lessee(lesseeID,lesseeSEX,lesseeNAME,lesseeAGE,lesseeMoney,lesseeTime) values(?,?,?,?,?,?)");
				ps.setString(1, _lessee.getLesseeID() );
				ps.setString(2, _lessee.getLesseeSEX());
				ps.setString(3, _lessee.getLesseeNAME());
				ps.setString(4, _lessee.getLesseeAGE());
				ps.setString(5, _lessee.getlesseeMoney());
				ps.setString(6, _lessee.getlesseetime());
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		
		
		/**
		 * 修改租户信息
		 * @param newLessee	新租户对象
		 * @param oldLesseeID	旧租户信息
		 * @return	是否修改成功
		 */
		public boolean updateLessee(lessee newLessee,String oldLesseeID){
			boolean b = true;
			try {
				//update
				ps = ct.prepareStatement("update tb_lessee set lesseeID=?, lesseeSEX=?, lesseeNAME=? ,lesseeAGE=? ,lesseeMoney=?,lesseeTime=? where lesseeID=?");
				ps.setString(1, newLessee.getLesseeID() );
				ps.setString(2, newLessee.getLesseeSEX());
				ps.setString(3, newLessee.getLesseeNAME());
				ps.setString(4, newLessee.getLesseeAGE());
				ps.setString(5, newLessee.getlesseeMoney());
				ps.setString(6, newLessee.getlesseetime());
				ps.setString(7, oldLesseeID);
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		
		/**
		 * 根据租户学号从数据库移除该租户
		 * @param _lesseeID	租户学号
		 * @return	返回是否删除成功
		 */
		public boolean deleteLessee(String _lesseeID){
			boolean b = true;
			try {
				ps = ct.prepareStatement("delete from tb_lessee where lesseeID=?");
				ps.setString(1, _lesseeID);
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		

		/**
		 * 根据sql语句返回特定的租户集合
		 * @param sql	sql语句
		 * @return	返回Vector<lessee>对象
		 */
		public Vector<lessee> getlessee(String sql){
			Vector<lessee> lessees = new Vector<lessee>();
			try {
				ps = ct.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					lessee _lessee = new lessee();
					_lessee.setLesseeID(rs.getString(1));
					_lessee.setLesseeSEX(rs.getString(2));
					_lessee.setLesseeNAME(rs.getString(3));
					_lessee.setLesseeAGE(rs.getString(4));
					_lessee.setlesseeMoney(rs.getString(5));
					_lessee.setlesseetime(rs.getString(6));
					lessees.add(_lessee);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			return lessees;
		}

		//关闭数据库资源
		public void close()	{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
}
