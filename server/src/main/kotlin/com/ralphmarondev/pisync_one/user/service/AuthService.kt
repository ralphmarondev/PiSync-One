package com.ralphmarondev.pisync_one.user.service

import com.ralphmarondev.pisync_one.security.JwtService
import com.ralphmarondev.pisync_one.user.dto.TokenPair
import com.ralphmarondev.pisync_one.user.entity.User
import com.ralphmarondev.pisync_one.user.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val jwtService: JwtService,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder
) {
    fun login(email: String, password: String): TokenPair {
        val user = userRepository.findByEmail(email)
            ?: throw IllegalArgumentException("Email already in use.")

        if (!bCryptPasswordEncoder.matches(password, user.password)) {
            throw IllegalArgumentException("Invalid email or password.")
        }

        val accessToken = jwtService.generateAccessToken(email)
        val refreshToken = jwtService.generateRefreshToken(email)

        return TokenPair(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }

    fun register(user: User): TokenPair {
        if (userRepository.findByEmail(email = user.email) != null) {
            throw IllegalArgumentException("Email already in use.")
        }
        val newUser = user.copy(
            password = bCryptPasswordEncoder.encode(user.password)
        )
        userRepository.save(newUser)

        val accessToken = jwtService.generateAccessToken(newUser.email)
        val refreshToken = jwtService.generateRefreshToken(newUser.email)

        return TokenPair(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }

    fun refreshAccessToken(refreshToken: String): String {
        val email = jwtService.extractEmailFromRefresh(refreshToken)
            ?: throw IllegalArgumentException("Invalid refresh token.")

        if (!jwtService.isRefreshTokenValid(refreshToken, email)) {
            throw RuntimeException("Invalid or expired refresh token.")
        }
        return jwtService.generateAccessToken(email)
    }
}