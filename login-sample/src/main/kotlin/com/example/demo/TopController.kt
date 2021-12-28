package com.example.demo

import org.springframework.security.core.context.SecurityContextHolder
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
    fun mypage(model: MutableMap<String, Any>) : String {
        val auth = SecurityContextHolder.getContext().authentication
        model["username"] = auth.name
        return "mypage"
    }
}