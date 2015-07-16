package com.springapp.mvc.DAO;


import com.springapp.mvc.model.Pizza;

import java.util.List;


public interface PizzaDAO {

    public void add(Pizza pizza);

    public void edit(Pizza pizza);

    public void delete(int id);

    public Pizza getPizza(int id);

    public List<Pizza> findAll();
}