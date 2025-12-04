package br.ufrrj.acoes.listeners;

import br.ufrrj.acoes.database.DatabaseManager;
import br.ufrrj.acoes.models.Usuario;
import br.ufrrj.acoes.repositories.UsuarioRepository;
import br.ufrrj.acoes.repositories.jpa.UsuarioRepositoryJpa;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class Startup implements ServletContextListener {
    private UsuarioRepository usuarioRepository = new UsuarioRepositoryJpa();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        
        // Garante que as tabelas vão ser criadas ao iniciar
        DatabaseManager.getEntityManager().close();

        this.ensureAdmin();
    }

    private void ensureAdmin() {
        Usuario usuario = this.usuarioRepository.findByLogin("admin");

        if (usuario == null) {
            Usuario admin = new Usuario();
            
            admin.setLogin("admin");
            admin.setSenha("admin");

            this.usuarioRepository.save(admin);
        }
    }
}
