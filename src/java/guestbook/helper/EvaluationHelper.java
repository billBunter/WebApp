/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook.helper;

import guestbook.HibernateUtil;
import guestbook.pojo.Evaluierung;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
    
    public List<Evaluierung> getEvaluations(String kurs){
        List<Evaluierung> eList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Evaluierung where kurs ='"+kurs+"'");
            eList = q.list();
        } catch (HibernateException e){
            e.printStackTrace();
        }
        return eList;
    }
    
}
