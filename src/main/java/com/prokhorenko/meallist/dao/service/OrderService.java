package com.prokhorenko.meallist.dao.service;

import com.prokhorenko.meallist.config.HibernateUtil;
import com.prokhorenko.meallist.dao.OrderDao;
import com.prokhorenko.meallist.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public List<Order> findAll(){
        return orderDao.getAll();
    }

    public Order findById(int id) {
        return orderDao.getOrderById(id);
    }

    public void save(Order order) {
        orderDao.save(order);
    }

    public void delete(Order order) {
        orderDao.delete(order);
    }

    public void update(Order order) {
        orderDao.update(order);
    }
}
