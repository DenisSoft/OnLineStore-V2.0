package ru.belitavitex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.Review;
import ru.belitavitex.entity.ValidationMessage;
import ru.belitavitex.service.ReviewService;

import javax.validation.Valid;

/**
 * Created by Dzianis on 11.07.2017.
 */
@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/Admin/ShowAllReviews/{moderation}")
    public String showAllReviewsPublished(Model model, @PathVariable("moderation") Boolean moderation){
        model.addAttribute("publish", moderation);
        model.addAttribute("reviews", reviewService.findAll(moderation));
        return "all-reviews";
    }

    @GetMapping(path = "/Admin/DeleteReview/{id}")
    public String deleteReview(Model model, @PathVariable("id") long id) {
        reviewService.delete(id);
        return "redirect:/Admin/ShowAllReviews/false";
    }

    @GetMapping(path = "/Admin/PublishReview/{id}")
    public String publishReview(Model model, @PathVariable("id") long id) {
        reviewService.publish(id);
        return "redirect:/Admin/ShowAllReviews/false";
    }
}
