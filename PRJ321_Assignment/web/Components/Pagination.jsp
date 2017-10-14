<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="pagination is-centered" role="navigation" aria-label="pagination">
    <c:set var="pag" value="${requestScope.pgn}"/>
    <c:if test="${pag.getPrev() != null}">
        <a class="pagination-previous" href="<c:out value="${pag.getPrev()}"/>">Previous</a>
    </c:if>

    <c:if test="${pag.getNext() != null}">
        <a class="pagination-next" href="<c:out value="${pag.getNext()}"/>">Next page</a>
    </c:if>


    <ul class="pagination-list">
        <c:if test="${pag.getCurrentIndex() > pag.getGapIndex() + 1}">
            <a class="pagination-link" href="<c:out value="${pag.getFirst()}"/>">
            1
            </a>
        </c:if>

        <c:if test="${pag.getCurrentIndex() > pag.getGapIndex() + 2}">
            <li><span class="pagination-ellipsis">&hellip;</span></li>
        </c:if>
            
        <c:if test="${pag.getGaps().size() - 1 >= 0}">
            <c:forEach var="i" begin="0" end="${pag.getGaps().size() - 1}">
                <c:set var="pagurl" value="${pag.getGaps().get(i)}"/>
                <li>
                    <a class="pagination-link 
                       <c:if test="${pagurl.equals(pag.getCurrent())}">
                        <c:out value="is-current"/>
                        </c:if>" 
                        href="<c:out value="${pagurl}"/>">
                        ${pag.gapsIndex[i]}
                    </a>
                </li>
            </c:forEach>
        </c:if>


        <c:if test="${pag.getCurrentIndex() < pag.getTotalIndex() - page.getGapIndex() - 3}">
            <li><span class="pagination-ellipsis">&hellip;</span></li>
        </c:if>

        <c:if test="${pag.getCurrentIndex() < pag.getTotalIndex() - page.getGapIndex() - 2}">
            <a class="pagination-link" href="<c:out value="${pag.getLast()}"/>">
            <c:out value="${requestScope.pageCount}"/>
            </a>
        </c:if>
    </ul>
</nav>