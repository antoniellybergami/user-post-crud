package com.example.crud_usuarios.service

import com.example.crud_usuarios.model.Post
import com.example.crud_usuarios.repository.PostRepository
import com.example.crud_usuarios.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository,
    val usuarioRepository: UsuarioRepository,
) {
    fun create(post: Post): Post {
        val user = usuarioRepository.findById(post.user.id!!).orElseThrow {
            IllegalArgumentException("User not found")
        }

        post.user = user
        return postRepository.save(post)
    }


    fun list(): List<Post> {
        return postRepository.findAll()
    }

    fun findById(id: Long): Post? {
        return postRepository.findById(id).orElse(null)
    }

    fun update(id: Long, post: Post): Post {
        if (findById(id) == null) {
            throw IllegalArgumentException("Post not found")
        }
       return postRepository.save(post)
    }

    fun delete(id: Long) {
        postRepository.deleteById(id)
    }

    fun getPostsByUserId(userId: Long): List<Post> {
        val user = usuarioRepository.findById(userId).orElse(null)
        return postRepository.findByUser(user)
    }


}