<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../partials/header.jspf" %>

<main class="container">
    <h1>Cadastrar Nova Ação de Extensão</h1>

    <form action="acoes/cadastrar" method="post" class="form-card">

        <label>Título:</label>
        <input type="text" name="titulo" required>

        <label>Descrição:</label>
        <textarea name="descricao" rows="5" required></textarea>

        <label>Data de Início:</label>
        <input type="datetime-local" name="dataInicio" required>

        <label>Data de Fim:</label>
        <input type="datetime-local" name="dataFim" required>

        <label>Responsável:</label>
        <input type="text" name="responsavel" required>

        <label>Local:</label>
        <input type="text" name="local" required>

        <label>Público-Alvo:</label>
        <input type="text" name="publicoAlvo" required>

        <label>Contato:</label>
        <input type="text" name="contato" required>

        <label>Link Externo:</label>
        <input type="url" name="linkExterno">

        <label>Status:</label>
        <select name="status">
            <option value="ativa">Ativa</option>
            <option value="encerrada">Encerrada</option>
        </select>

        <label>
            <input type="checkbox" name="taxaInscricao">
            Possui taxa de inscrição?
        </label>

        <button type="submit" class="btn-primary">Salvar Ação</button>

    </form>
</main>

<%@ include file="../partials/footer.jspf" %>
