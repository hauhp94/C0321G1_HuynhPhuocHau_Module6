package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/statistic")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StatisticController {
}
