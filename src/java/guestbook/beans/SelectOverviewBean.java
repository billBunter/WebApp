/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook.beans;

import guestbook.AccountController;
import java.io.IOException;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Billy
 */
@ManagedBean(name = "selectOverviewBean")
@SessionScoped
public class SelectOverviewBean implements Serializable {

    private String kurs;

    /**
     * Creates a new instance of SelectOverviewBean
     */
    public SelectOverviewBean() {
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    public void doTheThing() {
        AccountController accController = AccountController.getInstanz();
        accController.setWhatOverview(kurs);
        
        try {
            FacesContext fContext = FacesContext.getCurrentInstance();
            ExternalContext extContext = fContext.getExternalContext();
            extContext.redirect("kursOverview.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
