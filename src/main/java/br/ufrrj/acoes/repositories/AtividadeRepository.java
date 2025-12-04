package br.ufrrj.acoes.repositories;

import br.ufrrj.acoes.models.Atividade;

public interface AtividadeRepository {
    void save(Atividade atividade);
    void save(Atividade atividade, String nomeResponsavel);
}
