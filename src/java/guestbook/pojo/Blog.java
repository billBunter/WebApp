package guestbook.pojo;
// Generated 25.04.2018 15:15:23 by Hibernate Tools 4.3.1



/**
 * Blog generated by hbm2java
 */
public class Blog  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String email;
     private String comment;

    public Blog() {
    }

    public Blog(String name, String email, String comment) {
       this.name = name;
       this.email = email;
       this.comment = comment;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }




}

