package com.ralphmarondev.pisync_one.user.controller

import com.ralphmarondev.pisync_one.user.dto.LoginRequest
import com.ralphmarondev.pisync_one.user.dto.RegisterRequest
import com.ralphmarondev.pisync_one.user.dto.TokenPair
import com.ralphmarondev.pisync_one.user.entity.User
import com.ralphmarondev.pisync_one.user.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        try {
            val token = authService.login(
                email = request.email,
                password = request.password
            )
            return ResponseEntity.ok(TokenPair(token.accessToken, token.refreshToken))
        } catch (e: Exception) {
            return ResponseEntity.status(401).body(e.message)
        }
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<Any> {
        try {
            val token = authService.register(
                user = User(
                    email = request.email,
                    password = request.password,
                    fullName = request.fullName
                )
            )
            return ResponseEntity.ok(TokenPair(token.accessToken, token.refreshToken))
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body(e.message)
        }
    }
}