package com.controller;

import com.model.entity.CategoryCard;
import com.model.entity.Object;
import com.model.service.CategoryCardService;
import com.model.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/object")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ObjectController {
    @Autowired
    private ObjectService objectService;

    @GetMapping
    public ResponseEntity<List<Object>> findAll() {
        List<Object> objectList = objectService.findAll();
        if (objectList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(objectList, HttpStatus.OK);
    }
}
