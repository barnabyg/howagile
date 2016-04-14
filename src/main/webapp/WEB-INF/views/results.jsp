<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>How Agile Are You? - Results</title>
    <link rel="stylesheet" href="style/main.css" />
  </head>

  <body>
    <p>Score: <c:out value="${questionModel.totalScore}" /> out of <c:out value="${questionModel.maxPossibleScore}" /></p>

    <iframe id="myframe" src="" width="810" height="610" scrolling="no" frameborder="0">
     <p>Your browser does not support iframes</p>
    </iframe>

<script>
if (addEventListener in document) { // use W3C standard method
    document.addEventListener('load', loadChart, false);
} else { // fall back to traditional method
    window.onload = loadChart;
}

function loadChart() {
    var chartType = document.getElementById("chartType");

    var uri = "chart.go?chartType=" + "total";

    document.getElementById("myframe").src=uri;
  }
</script>

  </body>

</html>
