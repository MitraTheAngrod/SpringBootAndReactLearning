package com.mitra.minhasfinancas.model.repository;

import com.mitra.minhasfinancas.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Spring Data already searches in DB for emails(in "Usuario") without a manual implementation of how to search using the sintax "findby<name>"
    // Since I only want to find whether it's true or not that the given email exists in the DB, I'll use "existsBy<name>"
    // That's called "Query methods"
    boolean existsByEmail(String email);
}
