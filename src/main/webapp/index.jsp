<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="partials/header.jspf" %>

<main class="container">
    <section class="hero">
        <h1>Portal de Ações de Extensão - UFRRJ</h1>
        <p>Conheça os projetos, cursos, eventos e programas de extensão desenvolvidos pela universidade.</p>
        <a href="${pageContext.request.contextPath}/acoes" class="btn-primary">Ver todas as ações</a>

        <c:if test="${not empty sessionScope.admin}">
            <a class="btn-secondary" href="${pageContext.request.contextPath}/admin/cadastrar-acao">Gerenciar ações</a>
        </c:if>
    </section>

    <section class="cards">
        <h2>Destaques</h2>
        <div class="card-grid">
            <div class="card">
                <h3>Exemplo 1</h3>
                <p>Ações de alcance social e impacto na comunidade.</p>
            </div>

            <div class="card">
                <h3>Exemplo 2</h3>
                <p>Cursos abertos para toda a população.</p>
            </div>

            <div class="card">
                <h3>Exemplo 3</h3>
                <p>Projetos desenvolvidos por discentes e docentes.</p>
            </div>
        </div>
    </section>
</main>

<%@ include file="partials/footer.jspf" %>
