<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
  </head>

  <body>

    <form:form modelAttribute="questionModel" method="post" action="nextPage">

<table>
    <c:forEach items="${questionModel.questionMap}" var="currQue" varStatus="queIndex">
        <tr>
            <td collspan="2">
                <form:hidden path="questionMap[${queIndex.count}].question"/>
                <label>Question:</label><c:out value="${currQue.value.question}"/><br/>
            </td>
        </tr>
            <c:forEach items="${currQue.value.answerMap}" var="opt" varStatus="optionIndex">
        <tr>
            <td>
                <form:hidden path="questionMap[${queIndex.count}].answerMap[${optionIndex.count}].answerText"/>
                <form:hidden path="questionMap[${queIndex.count}].answerMap[${optionIndex.count}].answerKey"/>

                <form:radiobutton path="questionMap[${queIndex.count}].selectedAnswer"
                    value="${opt.value.answerKey}" label="${opt.value.answerText}"/>
            </td>
        </tr>
            </c:forEach>
        <tr><td collspan="2">&nbsp;</td></tr>
    </c:forEach>
</table>

<%--       <c:forEach items="${questionModel.questionMap}" var="questionObj"> --%>
<!--         <table> -->
<%--         <tr><td collspan="2"><c:out value="${questionObj.question}" /></td></tr> --%>
<%--         <c:forEach items="${questionObj.answers}" var="answerObj"> --%>
<%--           <c:set var="answerTxt" value="${answerObj.answerText}"/> --%>
<%--           <tr><td><c:out value="${answerTxt}"/></td><td><form:radiobutton path="answer" value="${answerTxt}"/></td></tr> --%>
<%--         </c:forEach> --%>
<!--         </table> -->
<!--         <br/><br/> -->
<%--       </c:forEach> --%>

<%--     <c:set var="answerTextList" value="${questionObj.answersText}"/> --%>
<%--     <form:radiobuttons items="${answerTextList}" path="answer" cssClass="questionRadioButtons"/> --%>

<br/><br/>

      <input type="submit" id="submitId" value="Next >>" />

    </form:form>

  </body>

</html>