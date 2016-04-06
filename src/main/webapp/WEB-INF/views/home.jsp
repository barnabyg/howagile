<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
  </head>

  <body>

    <form:form modelAttribute="questionModel" method="post" action="next.go">

    <c:set var="startQ" value="${(questionModel.pageNumber - 1) * questionModel.questionsPerPage}" />
    <c:set var="endQ" value="${(questionModel.pageNumber * questionModel.questionsPerPage) - 1}" />

    <c:out value="StartQ = ${startQ}" /><br/>
    <c:out value="EndQ = ${endQ}" /><br/><br/>

    <table>
      <c:forEach items="${questionModel.questionMap}" begin="${startQ}" end="${endQ}" var="currQue" varStatus="queIndex">

          <tr>
              <td collspan="2">
                  <c:out value="${currQue.value.question}"/>
              </td>
          </tr>

              <c:forEach items="${currQue.value.answerMap}" var="opt" varStatus="optionIndex">
                <tr>
                  <td>
                    <form:radiobutton path="questionMap[${queIndex.count}].selectedAnswer" value="${opt.value.answerKey}" label="${opt.value.answerText}"/>                   
                  </td>
                </tr>
              </c:forEach>
          <tr><td collspan="2">&nbsp;</td></tr>
      </c:forEach>
    </table>

    <br/><br/>

    <c:choose>
      <c:when test="${questionModel.pageNumber == questionModel.totalPages}"><input type="submit" id="submitId" name="Results >>" value="Results >>" /></c:when>
      <c:when test="${questionModel.pageNumber == 1}"><input type="submit" id="submitId" name="Next >>" value="Next >>" /></c:when>
      <c:when test="${questionModel.pageNumber < questionModel.totalPages}"><input type="submit" id="submitId" name="<< Previous" value="<< Previous" /><input type="submit" id="submitId" name="Next >>" value="Next >>" /></c:when>
    </c:choose>

    <br/><br/>

    <p>Page <c:out value="${questionModel.pageNumber}"/> of <c:out value="${questionModel.totalPages}"/></p>

    </form:form>

  </body>

</html>