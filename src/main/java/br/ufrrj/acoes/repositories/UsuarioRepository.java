package br.ufrrj.acoes.repositories;

import br.ufrrj.acoes.models.Usuario;

public interface UsuarioRepository {
    Usuario findByLogin(String login);
    void save(Usuario usuario);
}
