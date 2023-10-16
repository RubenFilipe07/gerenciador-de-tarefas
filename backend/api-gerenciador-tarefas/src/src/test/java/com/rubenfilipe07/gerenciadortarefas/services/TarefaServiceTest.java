package com.rubenfilipe07.gerenciadortarefas.services;

import com.rubenfilipe07.gerenciadortarefas.enums.SituacaoTarefa;
import com.rubenfilipe07.gerenciadortarefas.models.Tarefa;
import com.rubenfilipe07.gerenciadortarefas.models.Usuario;
import com.rubenfilipe07.gerenciadortarefas.repositories.TarefaRepository;
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

public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    private TarefaService tarefaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        tarefaService = new TarefaService();
        tarefaService.setTarefaRepository(tarefaRepository);
        tarefaService.setTarefaUsuarioRepository(usuarioRepository);
    }

    @Test
    public void testGetOneTarefa() {
        long id = 1L;
        Tarefa tarefa = new Tarefa();
        tarefa.setId(id);
        Optional<Tarefa> optionalTarefa = Optional.of(tarefa);
        when(tarefaRepository.findById(id)).thenReturn(optionalTarefa);

        ResponseEntity<Object> response = tarefaService.getOneTarefa(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(optionalTarefa, response.getBody());
    }

    @Test
    public void testGetOneTarefaNaoEncontrara() {
        long id = 1L;
        Optional<Tarefa> optionalTarefa = Optional.empty();
        when(tarefaRepository.findById(id)).thenReturn(optionalTarefa);

        ResponseEntity<Object> response = tarefaService.getOneTarefa(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("{\"message\":\"Tarefa não encontrada\"}", response.getBody());
    }

    @Test
    public void testGetAllTarefasByUsuario() {
        Long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(id);
        Optional<Usuario> optionalUsuario = Optional.of(usuario);
        List<Tarefa> tarefas = new ArrayList<>();
        tarefas.add(new Tarefa());
        tarefas.add(new Tarefa());
        when(usuarioRepository.findById(id)).thenReturn(optionalUsuario);
        when(tarefaRepository.findByResponsavel(usuario)).thenReturn(tarefas);

        ResponseEntity<Object> response = tarefaService.getAllTarefasByUsuario(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tarefas, response.getBody());
    }

    @Test
    public void testGetAllTarefasByUsuarioNaoEncotrado() {
        Long id = 1L;
        Optional<Usuario> optionalUsuario = Optional.empty();
        when(usuarioRepository.findById(id)).thenReturn(optionalUsuario);

        ResponseEntity<Object> response = tarefaService.getAllTarefasByUsuario(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("{\"message\":\"Usuario nao encontrado\"}", response.getBody());
    }

    @Test
    public void testGetAllTarefasByFiltro() {
        Long id = 1L;
        String titulo = "titulo";
        String descricao = "descricao";
        Usuario responsavel = new Usuario();
        SituacaoTarefa situacao = SituacaoTarefa.CONCLUIDA;
        List<Tarefa> tarefas = new ArrayList<>();
        tarefas.add(new Tarefa());
        tarefas.add(new Tarefa());
        when(tarefaRepository.getAllTarefasByFiltro(id, titulo, descricao, responsavel, situacao)).thenReturn(tarefas);

        List<Tarefa> result = tarefaService.getAllTarefasByFiltro(id, titulo, descricao, responsavel, situacao);

        assertEquals(tarefas, result);
    }

    @Test
    public void testSaveTarefa() {
        Tarefa tarefa = new Tarefa();
        when(tarefaRepository.save(tarefa)).thenReturn(tarefa);

        ResponseEntity<Tarefa> response = tarefaService.saveTarefa(tarefa);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(tarefa, response.getBody());
    }

    @Test
    public void testUpdateTarefa() {
        long id = 1L;
        Tarefa tarefa = new Tarefa();
        tarefa.setId(id);
        Optional<Tarefa> optionalTarefa = Optional.of(tarefa);
        when(tarefaRepository.findById(id)).thenReturn(optionalTarefa);
        when(tarefaRepository.save(tarefa)).thenReturn(tarefa);

        ResponseEntity<Object> response = tarefaService.updateTarefa(id, tarefa);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tarefa, response.getBody());
    }

    @Test
    public void testUpdateTarefaNaoEncontrada() {
        long id = 1L;
        Tarefa tarefa = new Tarefa();
        Optional<Tarefa> optionalTarefa = Optional.empty();
        when(tarefaRepository.findById(id)).thenReturn(optionalTarefa);

        ResponseEntity<Object> response = tarefaService.updateTarefa(id, tarefa);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("{\"message\":\"Tarefa não encontrada\"}", response.getBody());
    }

    @Test
    public void testUpdateTarefaConcluida() {
        long id = 1L;
        Tarefa tarefa = new Tarefa();
        tarefa.setId(id);
        Optional<Tarefa> optionalTarefa = Optional.of(tarefa);
        when(tarefaRepository.findById(id)).thenReturn(optionalTarefa);
        when(tarefaRepository.save(tarefa)).thenReturn(tarefa);

        ResponseEntity<Object> response = tarefaService.updateTarefaConcluida(id);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("{\"message\":\"Tarefa marcada como concluida\"}", response.getBody());
        assertEquals(SituacaoTarefa.CONCLUIDA, tarefa.getSituacao());
    }

    @Test
    public void testUpdateTarefaConcluidaNaoEncotrada() {
        long id = 1L;
        Optional<Tarefa> optionalTarefa = Optional.empty();
        when(tarefaRepository.findById(id)).thenReturn(optionalTarefa);

        ResponseEntity<Object> response = tarefaService.updateTarefaConcluida(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("{\"message\":\"Tarefa não encontrada\"}", response.getBody());
    }

    @Test
    public void testDeleteOneTarefa() {
        long id = 1L;
        Optional<Tarefa> optionalTarefa = Optional.of(new Tarefa());
        when(tarefaRepository.findById(id)).thenReturn(optionalTarefa);

        ResponseEntity<Object> response = tarefaService.deleteOneTarefa(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("{\"message\":\"Tarefa deletada com sucesso\"}", response.getBody());
        verify(tarefaRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteOneTarefaNaoEncontrada() {
        long id = 1L;
        Optional<Tarefa> optionalTarefa = Optional.empty();
        when(tarefaRepository.findById(id)).thenReturn(optionalTarefa);

        ResponseEntity<Object> response = tarefaService.deleteOneTarefa(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("{\"message\":\"Tarefa não encontrada\"}", response.getBody());
        verify(tarefaRepository, never()).deleteById(id);
    }
}