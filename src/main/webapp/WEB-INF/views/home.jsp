<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
  </head>

  <body>

    <form:form modelAttribute="questionModel" method="post" action="next.go">

    <table>
      <tr><td>Page number:</td><td><c:out value="${questionModel.pageNumber}"/></td></tr>
      <tr><td>Questions per page:</td><td><c:out value="${questionModel.questionsPerPage}"/></td></tr>
      <tr><td>Question count:</td><td><c:out value="${questionModel.questionCount}"/></td></tr>
    </table>

    <br/><br/>

    <c:set var="startQ" value="${(questionModel.pageNumber - 1) * questionModel.questionsPerPage}" />
    <c:set var="endQ" value="${questionModel.pageNumber * questionModel.questionsPerPage}" />

    <c:out value="StartQ = ${startQ}" /><br/>
    <c:out value="EndQ = ${endQ}" /><br/><br/>

    <table>
      <c:forEach items="${questionModel.questionMap}" begin="0" end="${questionModel.questionCount}" var="currQue" varStatus="queIndex">

          <tr>
              <td collspan="2">
                  <form:hidden path="questionMap[${queIndex.count}].question"/>
                  <c:if test="${queIndex.count > startQ && queIndex.count <= endQ}">
                    <c:out value="${currQue.value.question}"/>
                  </c:if>
              </td>
          </tr>

              <c:forEach items="${currQue.value.answerMap}" var="opt" varStatus="optionIndex">
                <tr>
                    <td>
                        <form:hidden path="questionMap[${queIndex.count}].answerMap[${optionIndex.count}].answerText"/>
                        <form:hidden path="questionMap[${queIndex.count}].answerMap[${optionIndex.count}].answerKey"/>
        
                        <c:if test="${queIndex.count > startQ && queIndex.count <= endQ}">
                          <form:radiobutton path="questionMap[${queIndex.count}].selectedAnswer" value="${opt.value.answerKey}" label="${opt.value.answerText}"/>                   
                        </c:if>
                    </td>
                </tr>
              </c:forEach>
          <tr><td collspan="2">&nbsp;</td></tr>
      </c:forEach>
    </table>

<!--     <table> -->
<%--       <c:forEach items="${questionModel.questionMap}" var="currQue" varStatus="queIndex"> --%>
<!--           <tr> -->
<!--               <td collspan="2"> -->
<%--                   <form:hidden path="questionMap[${queIndex.count}].question"/> --%>
<%--                   <label></label><c:out value="${currQue.value.question}"/><br/> --%>
<!--               </td> -->
<!--           </tr> -->
<%--               <c:forEach items="${currQue.value.answerMap}" var="opt" varStatus="optionIndex"> --%>
<!--           <tr> -->
<!--               <td> -->
<%--                   <form:hidden path="questionMap[${queIndex.count}].answerMap[${optionIndex.count}].answerText"/> --%>
<%--                   <form:hidden path="questionMap[${queIndex.count}].answerMap[${optionIndex.count}].answerKey"/> --%>
  
<%--                   <form:radiobutton path="questionMap[${queIndex.count}].selectedAnswer" --%>
<%--                        value="${opt.value.answerKey}" label="${opt.value.answerText}"/>  --%>
<!--               </td> -->
<!--           </tr> -->
<%--               </c:forEach> --%>
<!--           <tr><td collspan="2">&nbsp;</td></tr> -->
<%--       </c:forEach> --%>
<!--     </table> -->

<br/><br/>

      <input type="submit" id="submitId" value="Next >>" />

    </form:form>

  </body>

</html>