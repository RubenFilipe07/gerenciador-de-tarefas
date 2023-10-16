package com.rubenfilipe07.gerenciadortarefas.services;

import com.rubenfilipe07.gerenciadortarefas.models.Usuario;
import com.rubenfilipe07.gerenciadortarefas.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        usuarioService = new UsuarioService();
        usuarioService.setUsuarioRepository(usuarioRepository);
    }


    @Test
    public void testGetOneUsuario() {
        long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(id);
        Optional<Usuario> optionalUsuario = Optional.of(usuario);
        when(usuarioRepository.findById(id)).thenReturn(optionalUsuario);

        ResponseEntity<Object> response = usuarioService.getOneUsuario(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(optionalUsuario, response.getBody());
    }

    @Test
    public void testGetOneUsuarioNaoEncontrado() {
        long id = 1L;
        Optional<Usuario> optionalUsuario = Optional.empty();
        when(usuarioRepository.findById(id)).thenReturn(optionalUsuario);

        ResponseEntity<Object> response = usuarioService.getOneUsuario(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("{\"message\":\"Usuario nao encontrado\"}", response.getBody());
    }

    @Test
    public void testGetAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario());
        usuarios.add(new Usuario());
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        ResponseEntity<List<Usuario>> response = usuarioService.getAllUsuarios();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuarios, response.getBody());
    }

    @Test
    public void testSaveUsuario() {
        Usuario usuario = new Usuario();
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        ResponseEntity<Usuario> response = usuarioService.saveUsuario(usuario);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(usuario, response.getBody());
    }

    @Test
    public void testUpdateUsuario() {
        long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(id);
        Optional<Usuario> optionalUsuario = Optional.of(usuario);
        when(usuarioRepository.findById(id)).thenReturn(optionalUsuario);
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        ResponseEntity<Object> response = usuarioService.updateUsuario(id, usuario);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(usuario, response.getBody());
    }

    @Test
    public void testUpdateUsuarioNaoEncontrado() {
        long id = 1L;
        Usuario usuario = new Usuario();
        Optional<Usuario> optionalUsuario = Optional.empty();
        when(usuarioRepository.findById(id)).thenReturn(optionalUsuario);

        ResponseEntity<Object> response = usuarioService.updateUsuario(id, usuario);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("{\"message\":\"Usuario nao encontrado\"}", response.getBody());
    }

    @Test
    public void testDeleteOneUsuario() {
        long id = 1L;
        Optional<Usuario> optionalUsuario = Optional.of(new Usuario());
        when(usuarioRepository.findById(id)).thenReturn(optionalUsuario);

        ResponseEntity<Object> response = usuarioService.deleteOneUsuario(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("{\"message\":\"Usuario deletado com sucesso\"}", response.getBody());
        verify(usuarioRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteOneUsuarioNaoEncontrado() {
        long id = 1L;
        Optional<Usuario> optionalUsuario = Optional.empty();
        when(usuarioRepository.findById(id)).thenReturn(optionalUsuario);

        ResponseEntity<Object> response = usuarioService.deleteOneUsuario(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("{\"message\":\"Usuario nao encontrado\"}", response.getBody());
        verify(usuarioRepository, never()).deleteById(id);
    }
}