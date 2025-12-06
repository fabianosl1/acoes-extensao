package br.ufrrj.acoes.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import br.ufrrj.acoes.models.Atividade;
import br.ufrrj.acoes.repositories.AtividadeRepository;
import br.ufrrj.acoes.repositories.jpa.AtividadeRepositoryJpa;

@WebServlet("/inicio")
public class InicioController extends HttpServlet {

    private AtividadeRepository atividadeRepository = new AtividadeRepositoryJpa();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Atividade> atividades = atividadeRepository.listLasts(4);
        
        request.setAttribute("acoes", atividades);

        request.getRequestDispatcher(request.getContextPath() + "/index.jsp").forward(request, response);
    }
}
