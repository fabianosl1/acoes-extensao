<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="partials/header.jspf" %>

<main class="container">
    <section class="hero">
        <h1>Portal de Ações de Extensão - UFRRJ</h1>
        <p>Conheça os projetos, cursos, eventos e programas de extensão desenvolvidos pela universidade.</p>

        <a href="${pageContext.request.contextPath}/acoes" class="btn-primary">Ver todas as ações</a>

        <c:if test="${not empty sessionScope.admin}">
            <a class="btn-secondary" href="${pageContext.request.contextPath}/admin/cadastrar-acao">
                Gerenciar ações
            </a>
        </c:if>
    </section>

<<<<<<< HEAD
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
=======
    <section class="cards">
        <h2>Destaques recentes</h2>

        <c:choose>
            <c:when test="${empty acoesRecentes}">
                <p>Nenhuma ação cadastrada ainda.</p>
            </c:when>

            <c:otherwise>
                <div class="card-grid">
                    <c:forEach var="a" items="${acoesRecentes}">
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
>>>>>>> 0e3a47c (Aletração css e cadastro)
</main>

<%@ include file="partials/footer.jspf" %>

