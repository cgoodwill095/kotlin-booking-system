package com.example.SportsBookingSystem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FootballBookingSystemApplication

fun main(args: Array<String>) {
	println("Hello, World!")
	runApplication<FootballBookingSystemApplication>(*args)
}
