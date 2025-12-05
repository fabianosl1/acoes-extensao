package br.ufrrj.acoes.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import br.ufrrj.acoes.repositories.AtividadeRepository;
import br.ufrrj.acoes.repositories.jpa.AtividadeRepositoryJpa;

@WebServlet("/acoes")
public class AtividadesController extends HttpServlet {

    private AtividadeRepository atividadeRepository = new AtividadeRepositoryJpa();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("acoes", atividadeRepository.list());
        
        request.getRequestDispatcher("acoes.jsp").forward(request, response);
    }
}
