<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <body>
    <p>Score: <c:out value="${questionModel.totalScore}" /> out of <c:out value="${questionModel.maxPossibleScore}" /></p>
  </body>
</html>
