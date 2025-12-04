<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../partials/header.jspf" %>

<main class="container">
    <h1>Cadastrar Nova Ação de Extensão</h1>

    <form action="cadastrar-acao" method="post" class="form-card">

        <label>Título:</label>
        <input type="text" name="titulo" required>

        <label>Descrição:</label>
        <textarea name="descricao" rows="5" required></textarea>

        <label>Data de Início:</label>
        <input type="date" name="inicio" required>

        <label>Responsável:</label>
        <input type="text" name="responsavel" required>

        <label>Local:</label>
        <input type="text" name="local" required>

        <button type="submit" class="btn-primary">Salvar Ação</button>

    </form>
</main>

<%@ include file="../partials/footer.jspf" %>
