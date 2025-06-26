package com.ralphmarondev.pisync_one.user.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val fullName: String,
    @Column(unique = true, nullable = false)
    val email: String,
    val password: String
)