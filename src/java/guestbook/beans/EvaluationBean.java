/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook.beans;

import guestbook.helper.EvaluationHelper;
import guestbook.pojo.Evaluierung;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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

    public void validate() {
        if (kurs == null || lohntSich == null || beibehalten == null || platform.length == 0) {
            redirectTo("fehlermeldungEvaluierung.html");
        } else {
            String platformStr = "";
            for (int i = 0; i < platform.length; i++) {
                if (i > 0) {
                    platformStr = platformStr + ";";
                }
                platformStr = platformStr + platform[i];
            }
            Evaluierung evaluierung = new Evaluierung(kurs, lohntSich, platformStr, beibehalten);
            EvaluationHelper evaluationHelper = new EvaluationHelper();
            evaluationHelper.insertEvaluation(evaluierung);
            redirectTo("index.html");
        }
    }

    private void redirectTo(String url) {
        try {
            FacesContext fContext = FacesContext.getCurrentInstance();
            ExternalContext extContext = fContext.getExternalContext();
            extContext.redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
