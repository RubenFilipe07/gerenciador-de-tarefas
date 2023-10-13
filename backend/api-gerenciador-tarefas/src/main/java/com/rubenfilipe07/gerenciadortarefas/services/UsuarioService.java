package com.rubenfilipe07.gerenciadortarefas.services;

import com.rubenfilipe07.gerenciadortarefas.models.Usuario;
import com.rubenfilipe07.gerenciadortarefas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<Object> getOneUsuario(long id) {
        if (usuarioRepository.findById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Usuario nao encontrado\"}");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findById(id));
        }
    }

    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
    }

    public ResponseEntity<Usuario> saveUsuario(Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    public ResponseEntity<Object> updateUsuario(long id, Usuario usuario) {
        if (usuarioRepository.findById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Usuario nao encontrado\"}");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
        }
    }

    public ResponseEntity<Object> deleteOneUsuario(long id) {
        if (usuarioRepository.findById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Usuario nao encontrado\"}");
        } else {
            usuarioRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"Usuario deletado com sucesso\"}");
        }
    }
}
