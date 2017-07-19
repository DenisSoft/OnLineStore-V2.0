package ru.belitavitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.belitavitex.entity.Category;
import ru.belitavitex.entity.Groups;
import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.User;
import ru.belitavitex.service.CategoryService;

import javax.servlet.http.HttpSession;

/**
 * Created by Dzianis on 04.07.2017.
 */
@Controller
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/Admin/AllCategories")
    public String showCategory() {
        return "all-categories";
    }

    @GetMapping(path = "/Admin/DeleteCategory/{id}")
    public String deleteCategory(Model model, HttpSession session, @PathVariable("id") long id) {
        if(categoryService.delete(id)){
            model.addAttribute("success", "Категория успешно удалена!");
        }else{
            model.addAttribute("error",
                    "Удаление невозможно! В этой категории присутствуют товары.");
        }
        session.setAttribute("categories", categoryService.findAll());
        return "all-categories";
    }

    @GetMapping(path = "/Admin/NewCategory")
    public String newCategory(Model model) {
        model.addAttribute("category", new Category());
        return "new-category";
    }



    @PostMapping(path = "/Admin/SaveCategory")
    public String savePerson(Category category, Model model, HttpSession session) {
        try {
                categoryService.save(category);
            model.addAttribute("success", "Вы успешно сохранили категорию!");
        }catch (Exception e) {
            model.addAttribute("error",
                    "Вы используете старые данные. Пререгрузите страницу.");
        }
        session.setAttribute("categories", categoryService.findAll());
        return "all-categories";
    }

    @GetMapping(path = "/Admin/UpgradeCategory/{id}")
    public String upgradeCategory(Model model, @PathVariable("id") long id) {
        Category one = categoryService.findOne(id);
        if (one == null){
            return "redirect:/Admin/AllCategories";
        }
        model.addAttribute("category", one);
        return "new-category";
    }
}
