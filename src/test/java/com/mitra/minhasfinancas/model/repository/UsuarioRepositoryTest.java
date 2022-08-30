package com.mitra.minhasfinancas.model.repository;

import com.mitra.minhasfinancas.model.entity.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;

    @Test
    public void deveVerificarAExistenciaDeUmEmail() {
        // Cenário
        Usuario usuario = Usuario.builder().nome("Usuário Teste").email("usuarioteste@email.com").build();
        repository.save(usuario);

        // Ação/Execução
        boolean result = repository.existsByEmail("usuarioteste@email.com");

        // Verificação
        Assertions.assertThat(result).isTrue();
    }
}
