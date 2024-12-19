package com.example.SportsBookingSystem.Controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {
    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}