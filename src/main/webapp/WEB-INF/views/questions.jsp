<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Agile Questions</title>
<!--     <link rel="stylesheet" href="style/main.css" /> -->

  </head>

  <body>

    <form:form modelAttribute="questionModel" method="post" action="next.go">

    <c:set var="startQ" value="${1 + ((questionModel.pageNumber - 1) * questionModel.questionsPerPage)}" />
    <c:set var="endQ" value="${(questionModel.pageNumber * questionModel.questionsPerPage)}" />

    <table>
      <c:forEach items="${questionModel.questionMap}" begin="0" end="${questionModel.questionCount}" var="currQue" varStatus="queIndex">

          <c:if test="${queIndex.count >= startQ && queIndex.count <= endQ}">
          <tr>
              <td collspan="2">
                  <c:out value="${queIndex.count}"/>.&nbsp;<c:out value="${currQue.value.question}"/>
              </td>
          </tr>

              <c:forEach items="${currQue.value.answerMap}" var="opt" varStatus="optionIndex">
                <tr>
                  <td>
                    <form:radiobutton path="questionMap[${queIndex.count}].selectedAnswer" value="${opt.value.answerKey}" label="${opt.value.answerText}"/>&nbsp;(scores&nbsp;<c:out value="${opt.value.points}" />&nbsp;points)                   
                  </td>
                </tr>
              </c:forEach>
          <tr><td collspan="2">&nbsp;</td></tr>
          </c:if>
      </c:forEach>
    </table>

    <br/><br/>

    <c:choose>
      <c:when test="${questionModel.pageNumber == questionModel.totalPages}">
        <input type="submit" id="submitResultsId" name="Results" value="Results >>" />
      </c:when>
      <c:when test="${questionModel.pageNumber == 1}">
        <input type="submit" id="submitNextId" name="Next" value="Next >>" />
      </c:when>
      <c:when test="${questionModel.pageNumber < questionModel.totalPages}">
        <input type="submit" id="submitPreviousId" name="Previous" value="<< Previous" />
        <input type="submit" id="submitNextId" name="Next" value="Next >>" />
      </c:when>
    </c:choose>

    <br/><br/>

    <p>Page <c:out value="${questionModel.pageNumber}"/> of <c:out value="${questionModel.totalPages}"/></p>

    </form:form>

  </body>

</html>