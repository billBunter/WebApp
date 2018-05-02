/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook.helper;

import guestbook.HibernateUtil;
import guestbook.pojo.Blog;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Billy
 */
public class BlogHelper {

    private Session session;

    public BlogHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void insertEntry(String name, String mail, String comment) {
        session.beginTransaction();
        Blog b = new Blog(name, mail, comment);
        session.save(b);
        session.getTransaction().commit();

    }

    public List getEntries() {
        List<Blog> entryList = null;
        try {
            //org.hibernate.Transaction tx = session.beginTransaction();
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Blog");
            entryList = (List<Blog>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entryList;
    }

}
