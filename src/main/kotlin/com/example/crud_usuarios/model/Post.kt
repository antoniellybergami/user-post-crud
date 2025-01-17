package com.example.crud_usuarios.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty

@Entity
data class Post (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @field:NotEmpty(message = "title cannot be empty")
    @Column(nullable = false)
    var title : String,

    @field:NotEmpty(message = "description cannot be empty")
    @Column(columnDefinition = "text")
    var description : String,

    @ManyToOne(fetch = FetchType.EAGER) //quando um post é carregado, o usuario associado a ele é carregado junt
    @JoinColumn(name = "userId")
    var user : Usuario,
)

