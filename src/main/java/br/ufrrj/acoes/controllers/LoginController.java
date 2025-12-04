package br.ufrrj.acoes.controllers;

import java.io.IOException;

import br.ufrrj.acoes.models.Usuario;
import br.ufrrj.acoes.repositories.UsuarioRepository;
import br.ufrrj.acoes.repositories.hibernate.UsuarioRepositoryHibernate;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet  {
    
    private UsuarioRepository usuarioRepository = new UsuarioRepositoryHibernate();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        Usuario usuario = usuarioRepository.findByLogin(login);

        if (usuario == null || !usuario.getSenha().equals(senha)) {
            doGet(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/acoes");
    }

}
