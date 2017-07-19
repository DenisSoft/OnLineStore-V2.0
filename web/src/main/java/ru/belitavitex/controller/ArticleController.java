package ru.belitavitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.belitavitex.entity.Article;
import ru.belitavitex.service.ArticleService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Dzianis on 18.07.2017.
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ServletContext servletContext;


    @GetMapping(path = "/Article/{id}")
    public String showArticle(Model model, @PathVariable("id") long id) {
        model.addAttribute("article", articleService.findOne(id));
        return "article";
    }

    @GetMapping(path = "/Articles")
    public String showArticles(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "articles";
    }

    @GetMapping(path = "/Admin/NewArticle")
    public String newArticle(Model model) {
        model.addAttribute("article", new Article());
        return "new-article";
    }

    @PostMapping(path = "/Admin/SaveArticle")
    public String saveArticles(@RequestParam("file") MultipartFile file,
                              Article article, Model model, HttpSession session) {
        try {
            if (file.getSize() != 0){
                String rootPath = servletContext.getRealPath("/");
                articleService.save(article);
                Long imageName = article.getId();
                String relativePath =
                        "resources" + File.separator + "images" + File.separator + "articles" + File.separator;
                String fileName = String.valueOf(imageName) + "."
                        + file.getOriginalFilename().split("\\.")[1];
                String resultPath = rootPath + relativePath + fileName;
                byte[] bytes = file.getBytes();
                Path path = Paths.get(resultPath);
                Files.write(path, bytes);
                article.setImage(fileName);
            }
            article.setDateCreated(LocalDate.now());
            articleService.save(article);
            model.addAttribute("success", "Вы успешно сохранили статью!");

        } catch (IOException e) {
            model.addAttribute("error", "Что-то пошло не так! Попробуйте позже!");
        }
        return "redirect:/Admin/Articles";
    }

    @GetMapping(path = "/Admin/UpgradeArticle/{id}")
    public String upgradeArticles(Model model, @PathVariable("id") long id) {
        model.addAttribute("article", articleService.findOne(id));
        return "new-article";
    }

    @GetMapping(path = "/Admin/DeleteArticle/{id}")
    public String deleteArticle(Model model, @PathVariable("id") long id) {
        articleService.delete(id);
        return "redirect:/Admin/Articles";
    }

    @GetMapping(path = "/Admin/Articles")
    public String showAllArticles(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "all-articles";
    }
}
