<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="partials/header.jspf" %>

<main class="container">
    <a href="${pageContext.request.contextPath}/acoes" class="voltar">← Voltar</a>

    <h1 class="title-page">${acao.titulo}</h1>

    <section class="detalhes-acao">

        <p><strong>Descrição:</strong></p>
        <p>${acao.descricao}</p>

        <p><strong>Responsável:</strong> ${acao.responsavel.nome}</p>

        <p><strong>Local:</strong> ${acao.local}</p>

        <p><strong>Período:</strong> ${acao.inicio}</p>

        <c:if test="${not empty acao.redesSociais}">
            <p><strong>Redes Sociais:</strong></p>
            <ul>
                <c:forEach var="rede" items="${acao.redesSociais}">
                    <li><a href="${rede.link}" target="_blank">${rede.nome}</a></li>
                </c:forEach>
            </ul>
        </c:if>

    </section>
</main>

<%@ include file="partials/footer.jspf" %>
