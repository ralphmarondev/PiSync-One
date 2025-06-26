package com.ralphmarondev.pisync_one.user.repository

import com.ralphmarondev.pisync_one.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}