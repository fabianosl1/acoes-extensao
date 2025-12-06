<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="partials/header.jspf" %>

<main class="container">
    <section class="hero">
        <h1>Portal de Ações de Extensão - UFRRJ</h1>
        <p>Conheça os projetos, cursos, eventos e programas de extensão desenvolvidos pela universidade.</p>

        <a href="${pageContext.request.contextPath}/acoes" class="btn-primary">Ver todas as ações</a>
    </section>

    <section class="cards">
        <h2>Destaques recentes</h2>

        <c:choose>
            <c:when test="${empty acoes}">
                <p>Nenhuma ação cadastrada ainda.</p>
            </c:when>

            <c:otherwise>
                <div class="card-grid">
                    <c:forEach var="a" items="${acoes}">
                        <div class="card">
                            <h3>${a.titulo}</h3>
                            <p>${a.descricao}</p>
                            <a href="${pageContext.request.contextPath}/acao?id=${a.id}"
                               class="btn-secondary">Ver detalhes</a>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
    </section>
</main>

<%@ include file="partials/footer.jspf" %>

