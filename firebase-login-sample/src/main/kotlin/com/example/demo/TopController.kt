package com.example.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TopController {
    @Value("\${firebase-api-key}")
    private lateinit var apiKey: String
    @Value("\${firebase-project-id}")
    private lateinit var projectId: String

    @GetMapping("/")
    fun top() : String {
        return "top"
    }

    @GetMapping("/login")
    fun login(model: MutableMap<String, Any>) : String {
        model["apiKey"] = apiKey
        model["projectId"] = projectId
        return "login"
    }

    @GetMapping("/mypage")
    fun mypage(model: MutableMap<String, Any>) : String {
        val auth = SecurityContextHolder.getContext().authentication
        model["username"] = auth.name
        return "mypage"
    }
}