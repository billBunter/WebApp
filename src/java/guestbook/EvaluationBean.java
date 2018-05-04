/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Billy
 */
@ManagedBean(name = "evaluationBean", eager = true)
@RequestScoped
public class EvaluationBean {
    
    private String beibehalten;
    private String platform;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
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
    
    
}
