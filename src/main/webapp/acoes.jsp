<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="partials/header.jspf" %>

<main class="container">
    <h1 class="title-page">Ações de Extensão</h1>

    <c:if test="${not empty sessionScope.admin}">
        <a href="${pageContext.request.contextPath}/admin/cadastrar-acao" class="btn-primary">
            Cadastrar nova ação
        </a>
    </c:if>

    <c:choose>
        <c:when test="${empty acoes}">
            <p>Nenhuma ação cadastrada ainda.</p>
        </c:when>

        <c:otherwise>
            <div class="card-grid">
                <c:forEach var="acao" items="${acoes}">
                    <div class="card">
                        <h3>${acao.titulo}</h3>

                        <p><strong>Responsável:</strong> ${acao.responsavel.nome}</p>
                        <p><strong>Local:</strong> ${acao.local}</p>
                        <p><strong>Período:</strong> ${acao.inicio}</p>

                        <p class="descricao-curta">${acao.descricao}</p>

                        <a href="${pageContext.request.contextPath}/acao?id=${acao.id}" 
                           class="btn-secondary">Ver detalhes</a>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
</main>

<%@ include file="partials/footer.jspf" %>
