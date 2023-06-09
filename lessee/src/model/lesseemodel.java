package model;

import bean.lessee;
import dao.ManageHelper;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
//rowData用来存放行数据
//columnNames存放列名
public class lesseemodel extends AbstractTableModel {
    private ManageHelper helper;
    private Vector<lessee> lessees;
    private  Vector<String> columnNames = null;	//列名
    private Vector<Vector<String>> rowData = null;	//行数据

    public lesseemodel(String sql,JDialog jd) {
        helper = new ManageHelper();
        lessees = helper.getlessee(sql);

        columnNames = new Vector<String>();
        rowData = new Vector<Vector<String>>();
        columnNames.add("编号");
        columnNames.add("性别");
        columnNames.add("姓名");
        columnNames.add("年龄");
        columnNames.add("租金");
        columnNames.add("租房时间");
        for(lessee _lessee : lessees){
            Vector<String> hang = new Vector<String>();
            hang.add(_lessee.getLesseeID());
            hang.add(_lessee.getLesseeSEX());
            hang.add(_lessee.getLesseeNAME());
            hang.add(_lessee.getLesseeAGE());
            hang.add(_lessee.getlesseeMoney());
            hang.add(_lessee.getlesseetime());
            rowData.add(hang);
        }
        if(getRowCount()!=0){
            JOptionPane.showMessageDialog(jd, "一共有"+getRowCount()+"条记录！");
            return ;
        }else{
            JOptionPane.showMessageDialog(jd, "没有任何记录！");
            return ;
        }
    }

    //得到共有多少行
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return this.rowData.size();
    }
    //得到共有多少列
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return this.columnNames.size();
    }
    //得到某行某列的数据
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
    }

    //重写方法 getColumnName
    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return (String)this.columnNames.get(column);
    }

}
