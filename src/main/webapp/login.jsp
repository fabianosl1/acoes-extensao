<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="partials/header.jspf" %>

<main class="container">
    <h1>Login do Administrador</h1>

    <form action="login" method="post" class="form-card">
        <label>Usuário:</label>
        <input type="text" name="usuario" required>

        <label>Senha:</label>
        <input type="password" name="senha" required>

        <button type="submit" class="btn-primary">Entrar</button>

        <c:if test="${not empty param.erro}">
            <p class="erro">Usuário ou senha inválidos.</p>
        </c:if>
    </form>
</main>

<%@ include file="partials/footer.jspf" %>
