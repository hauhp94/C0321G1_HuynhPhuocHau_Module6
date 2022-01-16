package com.controller;

import com.model.entity.BusRoute;
import com.model.entity.CategoryCard;
import com.model.service.BusRouteService;
import com.model.service.CategoryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
    @Autowired
    private CategoryCardService categoryCardService;

    @GetMapping
    public ResponseEntity<List<CategoryCard>> findAll() {
        List<CategoryCard> categoryCards = categoryCardService.findAll();
        if (categoryCards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryCards, HttpStatus.OK);
    }
}
