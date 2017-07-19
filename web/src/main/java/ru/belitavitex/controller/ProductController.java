package ru.belitavitex.controller;

import ru.belitavitex.entity.*;
import ru.belitavitex.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Dzianis on 03.07.2017.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ServletContext servletContext;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @ModelAttribute("product")
    public Product product() {
        return new Product();
    }

    @GetMapping(path = "/Admin/AllProducts/{id}")
    public String showProduct(Model model, @PathVariable("id") long id) {
        model.addAttribute("products", productService.findByCategory(id));
        return "all-products";

    }

    @GetMapping(path = "/Admin/DeleteProduct/{id}/{categoryId}")
    public String deletePerson(Model model,
                               @PathVariable("id") long id,
                               @PathVariable("categoryId") long categoryId) {
        productService.delete(id);
        return "redirect:/Admin/AllProducts/"+categoryId;
    }

    @GetMapping(path = "/ProductsInCategory/{id}/{firstResult}/{maxResults}")
    public String showProductsInCategory
            (Model model,
             @PathVariable("id") long id,
             @PathVariable("maxResults") int maxResults,
             @PathVariable("firstResult") int firstResult) {
        List<Product> page = productService.getPage(id, maxResults, firstResult);
        if (page.size() == 0){
            model.addAttribute("empty", true);
        }else{
            model.addAttribute("catalogOfPages", productService.createCatalogOfPages(id, maxResults));
            model.addAttribute("maxResults", maxResults);
            model.addAttribute("firstResult", firstResult + maxResults);
            model.addAttribute("category", page.get(0).getCategory());
            model.addAttribute("count", productService.getCountInCategory(id));
            model.addAttribute("products", page);
        }
        return "products-in-category";
    }

    @GetMapping(path = "/ProductDetails/{id}")
    public String showProductsInCategory
            (Model model, @PathVariable("id") long id) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(productService.findOne(id));
        model.addAttribute("orderItem", orderItem);
        return "product-details";
    }


    @GetMapping(path = "/Admin/NewProduct")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-product";
    }

    @PostMapping(path = "/Admin/SaveProduct")
    public String saveProduct(@RequestParam("file") MultipartFile file, Product product, Model model, HttpSession session) {
        try {
            if (file.getSize() != 0){
                String rootPath = servletContext.getRealPath("/");
                String relativePath = "resources" + File.separator + "images" + File.separator + "products" + File.separator;
                String fileName = String.valueOf(productService.getNextImageNumber()) + "."
                        + file.getOriginalFilename().split("\\.")[1];
                String resultPath = rootPath + relativePath + fileName;
                byte[] bytes = file.getBytes();
                Path path = Paths.get(resultPath);
                Files.write(path, bytes);
                product.setImage(fileName);
            }

            productService.save(product);
            model.addAttribute("success", "Вы успешно сохранили продукт!");

        } catch (IOException e) {
            model.addAttribute("error", "Что-то пошло не так! Попробуйте позже!");
        }
        model.addAttribute("products", productService.findByCategory(product.getCategory()));
        return "all-products";
    }

    @GetMapping(path = "/Admin/UpgradeProduct/{id}")
    public String upgradeProduct(Model model, @PathVariable("id") long id) {
        model.addAttribute("product", productService.findOne(id));
        return "new-product";
    }
}
