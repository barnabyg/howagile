<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>How Agile Are You?</title>
    <link rel="stylesheet" href="style/main.css" />
  </head>

  <body>
    <div class="homeIntroduction">
      <p>This is a questionnaire for organisations using Scrum.</p>
      <p>You will be asked a series of questions about your engineering practices, product approach, teams and communications. Each question will have several potential answers. Pick the answer that is closest to how your organisation works.</p>
      <p>At the end of the questionnaire you will be given results showing how agile your organisation is.</p>
    </div>

    <br/><br/>

    <form:form modelAttribute="questionModel" method="post" action="next.go">

      <input type="submit" id="submitNextId" name="Next" value="Next >>" />

    </form:form>

  </body>

</html>