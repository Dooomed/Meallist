package com.prokhorenko.meallist.dao.service;

import com.prokhorenko.meallist.dao.MealDao;
import com.prokhorenko.meallist.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MealService {

    @Autowired
    private MealDao mealDao;

    public Meal getById(int id){
        return mealDao.findMealById(id);
    }

    public List<Meal> findAll() {
        return mealDao.findAllMeals();
    }

    public void save(Meal meal) {
        mealDao.saveMeal(meal);
    }

    public void delete(Meal meal) {
        mealDao.deleteMeal(meal);
    }

    public void update(Meal meal) {
        mealDao.updateMeal(meal);
    }
}
