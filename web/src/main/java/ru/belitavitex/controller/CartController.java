package ru.belitavitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.belitavitex.entity.*;
import ru.belitavitex.service.CustomerOrderService;
import ru.belitavitex.service.PersonService;
import ru.belitavitex.service.ProductService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Dzianis on 15.07.2017.
 */
@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PersonService personService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping(path = "/Cart")
    public String showCart(Model model) {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if (!personService.validAddress(user.getId())){
            model.addAttribute("message",
                    "Вы не можете совершить покупку. У Вас не заполнен адрес!");
        }
        return "cart";
    }

    @PostMapping(path = "/AddToCart")
    public String addToCart(OrderItem orderItem, Model model, HttpSession session) {
        CustomerOrder cart = (CustomerOrder) session.getAttribute("cart");
        if (cart == null){
            cart = new CustomerOrder();
        }
        cart.addToCart(orderItem);
        session.setAttribute("cart", cart);
        model.addAttribute("message",
                "Вы успешно добавили товар в корзину!");
        return "success";
    }

    @GetMapping(path = "/RemoveFromCart/{id}")
    public String deletePerson(Model model, HttpSession session, @PathVariable("id") long id) {
        CustomerOrder cart = (CustomerOrder) session.getAttribute("cart");
        cart.removeToCart(id);
        productService.delete(id);
        return "redirect:/Cart";
    }

    @GetMapping(path = "/SuccessfulPayment")
    public String successfulPayment(Model model, HttpSession session) {
        CustomerOrder cart = (CustomerOrder) session.getAttribute("cart");
        customerOrderService.save(cart);
        session.removeAttribute("cart");
        model.addAttribute("message",
                "Вы успешно оплатили заказ!");
        return "success";
    }

    @GetMapping(path = "/Admin/AllOrders")
    public String showAllOrders(Model model) {
        model.addAttribute("orders", customerOrderService.findAll());
        return "all-orders";
    }

    @GetMapping(path = "/Admin/DetailsOrder/{id}")
    public String showOrder(Model model, @PathVariable("id") long id) {
        CustomerOrder customerOrder = customerOrderService.findOne(id);
        model.addAttribute("order", customerOrderService.findOne(id));
        return "order-details";
    }

    @GetMapping(path = "/Admin/DeleteOrder/{id}")
    public String deleteOrder(Model model, @PathVariable("id") long id) {
        if(customerOrderService.delete(id)){
            model.addAttribute("success", "Заказ успешно удален!");
        }else{
            model.addAttribute("error",
                    "Удаление невозможно! Этот заказ еще не закрыт!");
        }
        model.addAttribute("orders", customerOrderService.findAll());
        return "all-orders";
    }

    @GetMapping(path = "/Admin/ChangeStatus/{id}")
    public String changeStatusOrder(Model model, @PathVariable("id") long id) {
        CustomerOrder order = customerOrderService.findOne(id);
        order.setOrderStatus(OrderStatus.CLOSED);
        order.setDateClosing(LocalDate.now());
        customerOrderService.update(order);
        model.addAttribute("orders", customerOrderService.findAll());
        return "all-orders";
    }
}
