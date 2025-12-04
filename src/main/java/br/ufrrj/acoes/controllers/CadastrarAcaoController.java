package br.ufrrj.acoes.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cadastrar-acao")
public class CadastrarAcaoController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        HttpSession session = request.getSession();

        if (session.getAttribute("admin") == null) {
            response.sendRedirect( request.getContextPath() + "/login");
            return;
        }

        request.getRequestDispatcher("admin_cadastrar_acao.jsp").forward(request, response);
    }
}
