package ru.belitavitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.Product;
import ru.belitavitex.service.CategoryService;
import ru.belitavitex.service.PersonService;
import ru.belitavitex.service.ProductService;

/**
 * Created by Dzianis on 03.07.2017.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("product")
    public Product product() {
        return new Product();
    }

    @GetMapping(path = "/AllProducts")
    public String showProduct(Model model) {

        model.addAttribute("products", productService.findAll() );
        return "all-products";
    }

    @GetMapping(path = "/Admin/DeleteProduct/{id}")
    public String deletePerson(Model model, @PathVariable("id") long id) {
        productService.delete(id);
        return "redirect:/AllProducts";
    }
}
