package com.productapp.dao;



import java.util.List;

import org.hibernate.*;

import com.productapp.model.Product;
import com.productapp.util.HibernateUtil;


public class ProductDAO {

    public List<com.productapp.model.Product> findAll() {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product", Product.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Product findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Product> findByName(String keyword) {
    	  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
              String hql = "FROM Product WHERE name LIKE :name";
              return session.createQuery(hql, Product.class)
                      .setParameter("name", "%" + keyword + "%")
                      .list();
          } catch (Exception e) {
              e.printStackTrace();
              return null;
          }
    }

    @SuppressWarnings("deprecation")
	public void insert(Product p) {
    	Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("deprecation")
	public void deleteById(int id) {
    	Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Product p = session.get(Product.class, id);
            if (p != null) session.delete(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    
    public void update(Product p) {
    	Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    
    public boolean existsById(int id) {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product p = session.get(Product.class, id);
            return p != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
