/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook.beans;

import guestbook.AccountController;
import guestbook.helper.EvaluationHelper;
import guestbook.pojo.Evaluierung;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Billy
 */
@ManagedBean(name = "kursOverviewDataBean")
@ViewScoped
public class KursOverviewDataBean {

    private List<Evaluierung> evaluirungen;
    private String avg;
    
    /**
     * Creates a new instance of KursOverviewDataBean
     */
    public KursOverviewDataBean() {
        AccountController accController = AccountController.getInstanz();
        EvaluationHelper eHelper = new EvaluationHelper();
        String kurs = accController.getWhatOverview();
        evaluirungen = eHelper.getEvaluations(kurs);
        int durchschnitt = 0;
        for (Evaluierung e : evaluirungen){
            switch (e.getLohntSich()){
                case "one":
                    durchschnitt = durchschnitt + 1;
                    break;
                case "two":
                    durchschnitt = durchschnitt + 2;
                    break;
                case "three":
                    durchschnitt = durchschnitt + 3;
                    break;
                case "four":
                    durchschnitt = durchschnitt + 4;
                    break;
                case "five":
                    durchschnitt = durchschnitt + 5;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid data in the Database");
            }
        }
        durchschnitt = durchschnitt / evaluirungen.size();
        avg = ""+durchschnitt;
    }

    public List<Evaluierung> getEvaluirungen() {
        return evaluirungen;
    }

    public void setEvaluirungen(List<Evaluierung> evaluirungen) {
        this.evaluirungen = evaluirungen;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }
    
    
    
}
