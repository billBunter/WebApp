/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook.helper;

import guestbook.HibernateUtil;
import guestbook.pojo.Evaluierung;
import org.hibernate.Session;

/**
 *
 * @author Billy
 */
public class EvaluationHelper {
    
    Session session = null;

    public EvaluationHelper(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void insertEvaluation(Evaluierung e){
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
    }
    
}
