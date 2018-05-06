/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.FacesValidator;

/**
 *
 * @author Billy
 */
@ManagedBean(name = "evaluationBean")
@SessionScoped
public class EvaluationBean implements Serializable {

    private String beibehalten;
    private String[] platform;
    private String lohntSich;
    private String kurs;

    /**
     * Creates a new instance of EvaluationBean
     */
    public EvaluationBean() {
    }

    public String getBeibehalten() {
        return beibehalten;
    }

    public void setBeibehalten(String beibehalten) {
        this.beibehalten = beibehalten;
    }

    public String[] getPlatform() {
        return platform;
    }

    public void setPlatform(String[] platform) {
        this.platform = platform;
    }

    public String getLohntSich() {
        return lohntSich;
    }

    public void setLohntSich(String lohntSich) {
        this.lohntSich = lohntSich;
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    public void validate(){
        System.out.println(kurs);
        System.out.println(lohntSich);
        System.out.println(platform);
        System.out.println(beibehalten);
        
    }
}
