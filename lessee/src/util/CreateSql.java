package util;
//生成sql语句的工具类
public class CreateSql {

	//根据查询内容、选项从租户表里返回特定的sql语句
	public static String getlessee_Sql(String str,String option){
		String sql = null;
		if("全部".equals(option)){
			sql = "select * from tb_lessee" ;
		}else if("编号".equals(option)){
			sql = "select * from tb_lessee where lesseeID like '%"+str+"%'";
		}else if("姓名".equals(option)){
			sql = "select * from tb_lessee where lesseeNAME like '%"+str+"%'";
		}else if("性别".equals(option)){
			sql = "select * from tb_lessee where lesseeSEX like '%"+str+"%'";
		}else if("年龄".equals(option)){
			sql = "select * from tb_lessee where lesseeAGE like '%"+str+"%'";
		}else if("时间".equals(option)){
			sql = "select * from tb_lessee where lesseetime  like '%"+str+"%'";
		}else if("租金".equals(option)){
			sql = "select * from tb_lessee where lesseeMoney like '%"+str+"%'";
		}
		return sql;
	}
	
	//多条件查询的sql语句创建
	public static String getConditions_Sql(String id,String name,String sex,String age,String rent,String time){
		StringBuilder sql = new StringBuilder("select * from tb_lessee where 1=1");
		if(!id.equals("")){
			sql.append(" and lesseeID like '%" + id + "%'  ");
		}
		if(!name.equals("")){
			sql.append(" and lesseeNAME like '%" + name + "%'  ");
		}
		if(!sex.equals("")){
			sql.append(" and lesseeSEX like '%" + sex + "%'  ");
		}
		if(!age.equals("")){
			sql.append(" and lesseeAGE like '%" + age + "%'  ");
		}
		if(!rent.equals("")){
			sql.append(" and lesseeMoney like '%" + rent + "%'  ");
		}
		if(!time.equals("")){
			sql.append(" and lesseetime like '%" + time + "%'  ");
		}
		return sql.toString();
	}
	
	//根据查询内容、选项从租户表里返回特定的sql语句
		public static String getlessee_Sql(String age,String time,String str,String option){
			String sql = null;
			if("全部".equals(option)){
				sql = "select * from tb_lessee where lesseeAGE='"+age+"' and lesseetime='"+time+"'" ;
			}else if("编号".equals(option)){
				sql = "select * from tb_lessee where lesseeID like '%"+str+"%' and lesseeAGE='"+age+"' and lesseetime='"+time+"'" ;
			}else if("姓名".equals(option)){
				sql = "select * from tb_lessee where lesseeNAME like '%"+str+"%' and lesseeAGE='"+age+"' and lesseetime='"+time+"'" ;
			}else if("性别".equals(option)){
				sql = "select * from tb_lessee where lesseeSEX like '%"+str+"%' and lesseeAGE='"+age+"' and lesseetime='"+time+"'" ;
			}else if("年龄".equals(option)){
				sql = "select * from tb_lessee where lesseeAGE like '%"+str+"%' and lesseeAGE='"+age+"' and lesseetime='"+time+"'" ;
			}
			return sql;
		}
	
	
	
	
}
