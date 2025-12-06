package br.ufrrj.acoes.repositories.jpa;

import java.util.List;

import br.ufrrj.acoes.database.DatabaseManager;
import br.ufrrj.acoes.models.Atividade;
import br.ufrrj.acoes.models.Responsavel;
import br.ufrrj.acoes.repositories.AtividadeRepository;
import jakarta.persistence.EntityManager;

public class AtividadeRepositoryJpa implements AtividadeRepository {

    @Override
    public void save(Atividade atividade) {
        try (EntityManager em = DatabaseManager.getEntityManager()) {
            em.getTransaction().begin();

            if (atividade.getId() == null) {
                em.persist(atividade);
            } else {
                em.merge(atividade);
            }

            em.getTransaction().commit();
        } catch (Exception ex) {

        }
    }

    @Override
    public void save(Atividade atividade, String nomeResponsavel) {
        EntityManager em = DatabaseManager.getEntityManager();

        try {
            em.getTransaction().begin();
            Responsavel responsavel = this.getResponsavel(nomeResponsavel, em);

            atividade.setResponsavel(responsavel);

            em.persist(atividade);

            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            em.close();
        }
    }

    // Procura o responsavel pelo nome se não encontrar cria um
    private Responsavel getResponsavel(String nome, EntityManager em) {
        try {
            return em.createQuery(
                "SELECT r FROM Responsavel r WHERE r.nome = :nome", 
                Responsavel.class
            ).setParameter("nome", nome)
            .getSingleResult(); 
        } catch (Exception ex) {
            Responsavel responsavel = new Responsavel();

            responsavel.setNome(nome);
            em.persist(responsavel);

            return responsavel;
        }
    }

    @Override
    public List<Atividade> list() {
        EntityManager em = DatabaseManager.getEntityManager();
    
        try {
            return em.createQuery("SELECT a FROM Atividade a", Atividade.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Atividade findById(Integer id) {
        EntityManager em = DatabaseManager.getEntityManager();

        try {
            return em.createQuery(
                "SELECT a FROM Atividade a LEFT JOIN FETCH a.redesSociais WHERE a.id = :id",
                 Atividade.class
            )
            .setParameter("id", id)
            .getSingleResult();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Atividade> listLasts(Integer n) {
        EntityManager em = DatabaseManager.getEntityManager();

        try {
            return em.createQuery(
                "SELECT a FROM Atividade a ORDER BY id DESC", 
                Atividade.class
            )
            .setMaxResults(n)
            .getResultList();
        } finally {
            em.close();
        }
    }
}
