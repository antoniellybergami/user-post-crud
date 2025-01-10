package com.example.crud_usuarios.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size


@Entity
data class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotEmpty(message = "Name cannot be empty")
    @field:Size(min = 3, message = "Name cannot be empty")
    var nome: String,

    @field:NotEmpty(message = "Email cannot be empty")
    @field:Email(message = "Email cannot be empty")
    var email: String,
)
