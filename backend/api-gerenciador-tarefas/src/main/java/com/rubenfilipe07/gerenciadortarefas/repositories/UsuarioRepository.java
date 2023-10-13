package com.rubenfilipe07.gerenciadortarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rubenfilipe07.gerenciadortarefas.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
