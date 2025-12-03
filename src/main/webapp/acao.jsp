<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="partials/header.jspf" %>

<main class="container">
    <a href="acoes" class="voltar">← Voltar</a>

    <h1 class="title-page">${acao.titulo}</h1>

    <section class="detalhes-acao">
        <p><strong>Descrição:</strong></p>
        <p>${acao.descricao}</p>

        <p><strong>Responsável:</strong> ${acao.responsavel}</p>
        <p><strong>Local:</strong> ${acao.local}</p>
        <p><strong>Público-alvo:</strong> ${acao.publicoAlvo}</p>
        <p><strong>Contato:</strong> ${acao.contato}</p>

        <p><strong>Período:</strong>
            ${acao.dataInicio} → ${acao.dataFim}</p>

        <p><strong>Status:</strong> ${acao.status}</p>

        <c:if test="${acao.linkExterno != null}">
            <p><a href="${acao.linkExterno}" target="_blank" class="btn-primary">Acessar página da ação</a></p>
        </c:if>

        <c:if test="${acao.taxaInscricao}">
            <p><em>Esta ação possui taxa de inscrição.</em></p>
        </c:if>
    </section>
</main>

<%@ include file="partials/footer.jspf" %>
