package guestbook.pojo;
// Generated 06.05.2018 18:00:33 by Hibernate Tools 4.3.1



/**
 * Account generated by hbm2java
 */
public class Account  implements java.io.Serializable {


     private Integer id;
     private String userid;
     private String passwd;
     private String rechte;

    public Account() {
    }

	
    public Account(String userid) {
        this.userid = userid;
    }
    public Account(String userid, String passwd, String rechte) {
       this.userid = userid;
       this.passwd = passwd;
       this.rechte = rechte;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getPasswd() {
        return this.passwd;
    }
    
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getRechte() {
        return this.rechte;
    }
    
    public void setRechte(String rechte) {
        this.rechte = rechte;
    }




}


