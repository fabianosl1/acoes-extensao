<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="partials/header.jspf" %>

<main class="container">
    <section class="hero">
        <h1>Portal de Ações de Extensão - UFRRJ</h1>
        <p>Conheça os projetos, cursos, eventos e programas de extensão desenvolvidos pela universidade.</p>
        <a href="acoes" class="btn-primary">Ver todas as ações</a>
    </section>

    <c:if test="${not empty acoes}">
        <section class="cards">
            <h2>Destaques</h2>
            <div class="card-grid">
                <c:forEach var="acao" items="${acoes}">
                    <div class="card">
                        <h3>${acao.titulo}</h3>
                        <p>${acao.descricao}</p>
                        <a href="acao?id=${acao.id}" class="btn-secondary">Ver detalhes</a>
                    </div>
                </c:forEach>
            </div>
        </section>
    </c:if>
</main>

<%@ include file="partials/footer.jspf" %>
