package com.prokhorenko.meallist.dao;

import com.prokhorenko.meallist.config.HibernateUtil;
import com.prokhorenko.meallist.model.Meal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MealDao {

    public Meal findMealById(int id){
        return (Meal) HibernateUtil.getSession().createQuery("from Meal where id = :id").setParameter("id", id).getSingleResult();
    }

    public List<Meal> findAllMeals(){
        return HibernateUtil.getSession().createQuery("from Meal").list();
    }

    public void saveMeal(Meal meal) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(meal);
        tx.commit();
    }

    public void updateMeal(Meal meal) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.update(meal);
        tx.commit();
    }

    public void deleteMeal(Meal meal){
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(meal);
        tx.commit();
    }

}
