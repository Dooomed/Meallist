package com.prokhorenko.meallist.dao;

import com.prokhorenko.meallist.model.Order;
import com.prokhorenko.meallist.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDao {

    public List<Order> getAll() {
        return HibernateUtil.getSession().createQuery("from Order ").list();
    }

    public void save(Order order) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(order);
        tx.commit();
    }

    public Order getOrderById(int id) {
        return (Order) HibernateUtil.getSession().createQuery("from Order where id = :id").setParameter("id", id).getSingleResult();
    }

    public void delete(Order order) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(order);
        tx.commit();
    }

    public void update(Order order) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.update(order);
        tx.commit();
    }
}
