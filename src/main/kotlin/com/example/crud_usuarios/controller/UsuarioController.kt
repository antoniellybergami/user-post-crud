package com.example.crud_usuarios.controller

import com.example.crud_usuarios.model.Usuario
import com.example.crud_usuarios.service.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UsuarioController (private val usuarioService: UsuarioService) {

    @PostMapping
    fun create(@RequestBody usuario: Usuario): Usuario {
        return usuarioService.create(usuario)
    }

    @GetMapping
    fun findAll(): List<Usuario> {
        return usuarioService.findAll()
    }

   @GetMapping("/{id}")
   fun findById(@PathVariable id: Long): Usuario? {
       return usuarioService.findById(id)
   }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody usuario: Usuario): Usuario {
        return usuarioService.update(id, usuario)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<String> {
        return try {
            usuarioService.delete(id)
            ResponseEntity.ok("User with id $id deleted")
        } catch ( e:IllegalArgumentException) {
            ResponseEntity.badRequest().body(e.message)
        }

    }
}