/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.DO.Account;
import project.DO.Index;
import project.DO.ShareCourse;

/**
 *
 * @author DA CUOI
 */
public class IndexDAO {

    public static int addIndex(Index index) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        int indexID = -1;
        try {
            tx = session.beginTransaction();
            indexID = (Integer) session.save(index);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return indexID;
    }
    
    public static Index getIndexById(int id){
        Index index = null;
        
        return index;
    }
    
    public static List<Index> getIndexByIdShareCourse(ShareCourse shareCourse){
        List<Index> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = null;
        try{
           tx = session.beginTransaction();
           Query query = session.createQuery("FROM Index WHERE id_share_course = :id_share_course ORDER BY level ASC");
           query.setParameter("id_share_course", shareCourse.getIdshareCourse());        
           list = query.list();           
           tx.commit();
        }catch(NullPointerException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
        catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return list;
    }
}
