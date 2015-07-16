package com.springapp.mvc.DAO;

import com.springapp.mvc.model.Pizza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by roman on 07.07.15.
 */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class PizzaDAOImpl implements PizzaDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void add(Pizza pizza) {
        sessionFactory.getCurrentSession().save(pizza);
    }

    @Transactional
    public void edit(Pizza pizza) {
        sessionFactory.getCurrentSession().update(pizza);
    }

    @Transactional
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(getPizza(id));
    }

    @Transactional
    public Pizza getPizza(int id) {
        return (Pizza) sessionFactory.getCurrentSession().get(Pizza.class, id);

    }

    @Transactional
    public List<Pizza> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List pizzas = session.createCriteria(Pizza.class).list();
        return pizzas;
    }


}
