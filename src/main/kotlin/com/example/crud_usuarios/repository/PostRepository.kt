package com.example.crud_usuarios.repository

import com.example.crud_usuarios.model.Post
import com.example.crud_usuarios.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository


interface PostRepository : JpaRepository<Post, Long> {
    fun findByUser(user: Usuario): List<Post>
}