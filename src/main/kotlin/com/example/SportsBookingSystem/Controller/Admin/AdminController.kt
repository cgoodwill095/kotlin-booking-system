package com.example.SportsBookingSystem.Controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminController
{

    @GetMapping("/")
    fun index(): String {
        return "admin"
    }
}