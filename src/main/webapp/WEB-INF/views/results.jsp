<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
Here<br/>
   <c:forEach var="questionObj" items="${questionModel.questionMap}" varStatus="queIndex">
<%--      <c:out value="${questions[${queIndex.count}].answerMap[${queIndex.count}].answerText}" /> --%>
     <c:out value="${questionObj.value.answerMap}" />
    <br/>
   </c:forEach>
</body>
</html>
