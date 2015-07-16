package com.springapp.mvc;

import com.springapp.mvc.DAO.PizzaDAO;
import com.springapp.mvc.model.Pizza;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Controller

public class HelloController {


    @Autowired
    private PizzaDAO pizzaDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView printWelcome1() {
        return new ModelAndView("login", "user", new User());
    }


    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public String printWelcome2(ModelMap model) {
        List<Pizza> pizzas = pizzaDAO.findAll();
        model.addAttribute("pizzas", pizzas);
        return "hello";
    }


    @RequestMapping(value = "/pizza.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Pizza pizza, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        Pizza pizzaResult = new Pizza();
        switch (action.toLowerCase()) {
            case "add":
                pizzaDAO.add(pizza);
                pizzaResult = pizza;
                break;
            case "edit":
                pizzaDAO.edit(pizza);
                pizzaResult = pizza;
                break;
            case "delete":
                pizzaDAO.delete((int) pizza.getId());
                pizzaResult = new Pizza();
                break;
            case "search":
                Pizza searchedStudent = pizzaDAO.getPizza((int) pizza.getId());
                pizzaResult = searchedStudent != null ? searchedStudent : new Pizza();
                break;
        }
        map.put("pizza", pizzaResult);
        map.put("pizzaList", pizzaDAO.findAll());
        return "home";
    }
}