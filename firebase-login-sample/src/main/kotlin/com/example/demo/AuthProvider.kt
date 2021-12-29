package com.example.demo

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class AuthProvider: AuthenticationProvider {
    @PostConstruct
    fun setupFB() {
        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.getApplicationDefault())
            .build()

        FirebaseApp.initializeApp(options)
    }

    override fun authenticate(authentication: Authentication): Authentication? {
        val defaultAuth = FirebaseAuth.getInstance();
        val username = authentication.name
        val credential = authentication.credentials.toString()
        val verifyIdToken = defaultAuth.verifyIdToken(credential)
        return if (verifyIdToken == null) {
            null
        } else {
            UsernamePasswordAuthenticationToken(username, credential, ArrayList())
        }
    }

    override fun supports(authentication: Class<*>): Boolean {
        return authentication == UsernamePasswordAuthenticationToken::class.java
    }
}