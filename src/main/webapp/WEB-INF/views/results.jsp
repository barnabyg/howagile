<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>How Agile Are You? - Results</title>
    <link rel="stylesheet" href="style/main.css" />
  </head>

  <body>
    <p>Score: <c:out value="${questionModel.totalScore}" /> out of <c:out value="${questionModel.maxPossibleScore}" /></p>
  </body>

</html>
