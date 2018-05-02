/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook.helper;

import guestbook.HibernateUtil;
import guestbook.pojo.Account;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Billy
 */
public class AccountHelper {

    Session session = null;

    public AccountHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Account> getByName(String userName) {
        List<Account> accList = null;
        try {
            //org.hibernate.Transaction tx = session.beginTransaction();
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Account where userid = '" + userName + "'");
            accList = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accList;
    }

    public boolean insertEntry(String userid, String passwd) {
        List<Account> possibleCollision = getByName(userid);
        if (possibleCollision.isEmpty()) {
            session.beginTransaction();
            Account acc = new Account(userid, passwd);
            session.save(acc);
            session.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    }

}
