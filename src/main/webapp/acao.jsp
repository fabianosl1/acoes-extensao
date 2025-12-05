<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="partials/header.jspf" %>

<main class="container">
    <a href="acoes" class="voltar">← Voltar</a>

    <h1 class="title-page">${acao.titulo}</h1>

    <section class="detalhes-acao">
        <p><strong>Descrição:</strong></p>
        <p>${acao.descricao}</p>

        <p><strong>Responsável:</strong> ${acao.responsavel.nome}</p>
        <p><strong>Local:</strong> ${acao.local}</p>
        <p><strong>Inicio:</strong> ${acao.inicio}</p>
    </section>
</main>

<%@ include file="partials/footer.jspf" %>
