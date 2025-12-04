package br.ufrrj.acoes.controllers;

import java.io.IOException;
import java.time.LocalDate;

import br.ufrrj.acoes.models.Atividade;
import br.ufrrj.acoes.repositories.AtividadeRepository;
import br.ufrrj.acoes.repositories.jpa.AtividadeRepositoryJpa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cadastrar-acao")
public class CadastrarAcaoController extends HttpServlet {
    private AtividadeRepository atividadeRepository = new AtividadeRepositoryJpa();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("admin") == null) {
            response.sendRedirect( request.getContextPath() + "/login");
            return;
        }

        request.getRequestDispatcher("admin_cadastrar_acao.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("admin") == null) {
            response.sendRedirect( request.getContextPath() + "/login");
            return;
        }

        Atividade atividade = new Atividade();

        atividade.setTitulo(request.getParameter("titulo"));
        atividade.setDescricao(request.getParameter("descricao"));
        atividade.setLocal(request.getParameter("local"));

        LocalDate data = LocalDate.parse(request.getParameter("inicio"));
        
        atividade.setInicio(data);
        
        atividadeRepository.save(atividade, request.getParameter("responsavel"));

        System.out.println(atividade.getId());
        
        response.sendRedirect(request.getContextPath() + "/acoes");
    }
    

}
