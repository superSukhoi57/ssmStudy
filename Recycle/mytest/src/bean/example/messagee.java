package bean.example;

public class messagee {
    private String username="zhangsan";
    private long password=12456;
    private char sex='男';

    /*messagee(){
        username="zgangsan";
        password=1234566;
        sex='女';
    }*/

   public String getUsername(){
        return username;
    }
   public long getPassword(){
        return password;
    }
   public char getSex(){
        return sex;
    }
    public void setPassword(long str){
        password=str;
    }
   public void setSex(char str){
        sex=str;
    }
    public void setUsername(String str){
        username=str;
    }
}
