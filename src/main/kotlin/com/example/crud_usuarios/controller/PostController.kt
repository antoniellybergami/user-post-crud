package com.example.crud_usuarios.controller

import com.example.crud_usuarios.model.Post
import com.example.crud_usuarios.service.PostService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/posts")
class PostController (private val service: PostService) {

   @PostMapping
   fun create(@Valid @RequestBody post: Post): Post {
       return service.create(post)
   }

    @GetMapping
    fun findAll(): List<Post> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : Post? {
        return service.findById(id)
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @Valid @RequestBody post: Post): Post {
        return service.update(id, post)
    }

    @DeleteMapping
    fun deletePost(@PathVariable id: Long) {
        return service.delete(id)
    }

    @GetMapping("/user/{userId}")
    fun getPostByUserId(@PathVariable userId: Long) : List<Post> {
        return service.getPostsByUserId(userId)
    }


}