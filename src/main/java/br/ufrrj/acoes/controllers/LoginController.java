package br.ufrrj.acoes.controllers;

import java.io.IOException;

import br.ufrrj.acoes.models.Usuario;
import br.ufrrj.acoes.repositories.UsuarioRepository;
import br.ufrrj.acoes.repositories.jpa.UsuarioRepositoryJpa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet  {
    
    private UsuarioRepository usuarioRepository = new UsuarioRepositoryJpa();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("admin"));

        if (session.getAttribute("admin") != null) {
            response.sendRedirect(request.getContextPath() + "/inicio");
            return;
        }

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

        
        HttpSession session = request.getSession();

        session.setAttribute("admin", usuario);

        response.sendRedirect(request.getContextPath() + "/inicio");
    }

}
