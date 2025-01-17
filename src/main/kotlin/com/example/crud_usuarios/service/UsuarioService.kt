package com.example.crud_usuarios.service

import com.example.crud_usuarios.model.Usuario
import com.example.crud_usuarios.repository.UsuarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
class UsuarioService(private val usuarioRepository: UsuarioRepository) {


    fun create(usuario: Usuario): Usuario {
        return usuarioRepository.save(usuario)
    }
    fun findAll(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    fun findById(id: Long): Usuario? {
        return usuarioRepository.findById(id).orElse(null)
    }

    fun update(id: Long, usuario: Usuario): Usuario {
        val user: Usuario = usuarioRepository.findById(id).orElseThrow {
            IllegalArgumentException("Usuario ID $id does not exist")
        }

        user.nome = usuario.nome
        user.email = usuario.email

        return usuarioRepository.save(user)
    }

    fun delete(id: Long) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id)
        } else {
            throw IllegalArgumentException("Usuario exists do nothing !")
        }

    }

}