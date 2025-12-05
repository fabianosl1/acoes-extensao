package br.ufrrj.acoes.controllers;

import java.io.IOException;

import br.ufrrj.acoes.models.Atividade;
import br.ufrrj.acoes.repositories.AtividadeRepository;
import br.ufrrj.acoes.repositories.jpa.AtividadeRepositoryJpa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/acao")
public class AtividadeController extends HttpServlet {
    
    private AtividadeRepository atividadeRepository = new AtividadeRepositoryJpa();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        Atividade atividade = atividadeRepository.findById(Integer.parseInt(id));

        if (atividade == null) {
            response.sendRedirect(request.getContextPath() + "/acoes");
            return;
        }

        request.setAttribute("acao", atividade);

        request.getRequestDispatcher("acao.jsp").forward(request, response);
    }
}
