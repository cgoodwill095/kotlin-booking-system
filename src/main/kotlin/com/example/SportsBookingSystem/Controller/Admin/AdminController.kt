package com.example.SportsBookingSystem.Controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
@PreAuthorize("hasRole('ADMIN')")
class AdminController
{

    @GetMapping("/admin")
    fun admin(): String {
        return "admin"
    }
}