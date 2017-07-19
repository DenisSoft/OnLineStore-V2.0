package ru.belitavitex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RestController
public class ReviewControllerRest {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/SaveReview")
    @ResponseBody
    public ValidationMessage login(@Valid @RequestBody Review review, Errors errors) {
        if (StringUtils.isEmpty(review.getComment())) {
            return new ValidationMessage("Пустой коментарий");
        }
        reviewService.saveFull(review);
        return new ValidationMessage("Ваш отзыв отправлен на модерацию.");
    }
}
