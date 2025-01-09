package com.example.crud_usuarios.repository

import com.example.crud_usuarios.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository


interface UsuarioRepository : JpaRepository<Usuario, Long>