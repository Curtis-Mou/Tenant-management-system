package util;

import java.util.Calendar;
import java.util.Vector;

public class Tools {

	//获取年级
		public static Vector<String> Createage(){
			Vector<String> vector = new Vector<String>();
			vector.add("");	//添加一个空选项 
			Calendar c = Calendar.getInstance();
			int Year = c.get(Calendar.YEAR);
			for(int i=0;i<4;i++){
				vector.add(String.valueOf(Year--));
			}
			return vector;
			
		}
}
