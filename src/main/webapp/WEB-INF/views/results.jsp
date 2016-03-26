<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
Here<br/>
   <c:forEach var="questionMap" items="${questionModel.questionMap}">
     <c:out value="$questionMap[${queIndex.count}].question}" />
    <br/>
   </c:forEach>
</body>
</html>
