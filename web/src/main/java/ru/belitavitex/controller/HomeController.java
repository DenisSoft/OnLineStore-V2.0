package ru.belitavitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.belitavitex.entity.Product;
import ru.belitavitex.service.CategoryService;
import ru.belitavitex.service.ProductService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Dzianis on 29.06.2017.
 */
@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    public HomeController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping(path = "/")
    public String showHomePage(HttpSession session, Model model) {
        session.setAttribute("categories", categoryService.findAll());
        List<Product> bestSellers = productService.getBestSellers();
        session.setAttribute("bestSeller", bestSellers.get(0));
        model.addAttribute("bestSellers", bestSellers);
        return "home";
    }

    @GetMapping(path = "/AboutAs")
    public String showAboutAs() {
        return "about-us";
    }


    @GetMapping(path = "/ContactUs")
    public String showContactUs() {
        return "contact-us";
    }
}

