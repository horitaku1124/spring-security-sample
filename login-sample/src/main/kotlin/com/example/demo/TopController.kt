package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TopController {

    @GetMapping("/")
    fun top() : String {
        return "top"
    }

    @GetMapping("/login")
    fun login() : String {
        return "login"
    }

    @GetMapping("/mypage")
    fun mypage() : String {
        return "mypage"
    }
}