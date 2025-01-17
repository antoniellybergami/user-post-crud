package com.example.crud_usuarios.model

import jakarta.persistence.*
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
    var nome: String? = null,

    @field:NotEmpty(message = "Email cannot be empty")
    @field:Email(message = "Email cannot be empty")
    var email: String? = null,

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER) //Quand um user é carregado, os posts associados a ele são carregados junto
    val posts: List<Post> = mutableListOf()

)
