package bean;

public class lessee
{
    private String lesseeID;             //租户编号
    private String lesseeSEX;           //租户性别
    private String lesseeNAME;             //租户姓名
    private String lesseeAGE;             //租户年龄
    private String lesseeMoney;             //租户租金
    private String lesseetime;              //租户租房时间

    public String getLesseeID(){return lesseeID;}
    public void setLesseeID(String _lesseeID){lesseeID = _lesseeID;}

    public String getLesseeSEX(){return lesseeSEX;}
    public void setLesseeSEX(String _lesseeSEX){lesseeSEX = _lesseeSEX;}

    public String getLesseeNAME(){return lesseeNAME;}
    public void setLesseeNAME(String _lesseeNAME){lesseeNAME = _lesseeNAME;}

    public String getLesseeAGE(){return lesseeAGE;}
    public void setLesseeAGE(String _lesseeAGE){lesseeAGE = _lesseeAGE;}

    public String getlesseeMoney(){return lesseeMoney;}
    public void setlesseeMoney(String _lesseeMoney){lesseeMoney = _lesseeMoney;}

    public String getlesseetime(){return lesseetime;}
    public void setlesseetime(String _lesseetime){lesseetime = _lesseetime;}
}
