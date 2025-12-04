package br.ufrrj.acoes.repositories.jpa;


import br.ufrrj.acoes.database.DatabaseManager;
import br.ufrrj.acoes.models.Usuario;
import br.ufrrj.acoes.repositories.UsuarioRepository;
import jakarta.persistence.EntityManager;

public class UsuarioRepositoryJpa implements UsuarioRepository {

    @Override
    public Usuario findByLogin(String login) {
        EntityManager em = DatabaseManager.getEntityManager();
        
        try {
            return em.createQuery(
                "SELECT u FROM Usuario u WHERE u.login = :login", 
                Usuario.class
            )
            .setParameter("login", login)
            .getSingleResult();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void save(Usuario usuario) {
        EntityManager em = DatabaseManager.getEntityManager();
        
        try {
            em.getTransaction().begin();

            if (usuario.getId() == null) {
                em.persist(usuario);
            } else {
                em.merge(usuario);
            }
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
}
