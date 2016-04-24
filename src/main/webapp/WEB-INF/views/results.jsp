<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>How Agile Are You? - Results</title>
    <link rel="stylesheet" href="style/main.css" />
    <script>
    if (addEventListener in document) { // use W3C standard method
        document.addEventListener('load', loadChart, false);
    } else { // fall back to traditional method
        window.onload = loadChart;
    }
    
    function loadChart() {
    
        var uri = "chart.go?chartType=" + "total";
        document.getElementById("totalFrame").src=uri;
    
        uri = "chart.go?chartType=" + "team";
        document.getElementById("teamFrame").src=uri;

        uri = "chart.go?chartType=" + "product";
        document.getElementById("productFrame").src=uri;

        uri = "chart.go?chartType=" + "communication";
        document.getElementById("communicationFrame").src=uri;

        uri = "chart.go?chartType=" + "engineering";
        document.getElementById("engineeringFrame").src=uri;

        uri = "chart.go?chartType=" + "sprints";
        document.getElementById("sprintsFrame").src=uri;

      }
    </script>
  </head>

  <body>

    <iframe id="totalFrame" src="" width="600" height="400" scrolling="no" frameborder="0">
     <p>Your browser does not support iframes</p>
    </iframe>

    <iframe id="teamFrame" src="" width="500" height="300" scrolling="no" frameborder="0">
     <p>Your browser does not support iframes</p>
    </iframe>

    <iframe id="communicationFrame" src="" width="500" height="300" scrolling="no" frameborder="0">
     <p>Your browser does not support iframes</p>
    </iframe>

    <iframe id="productFrame" src="" width="500" height="300" scrolling="no" frameborder="0">
     <p>Your browser does not support iframes</p>
    </iframe>

    <iframe id="engineeringFrame" src="" width="500" height="300" scrolling="no" frameborder="0">
     <p>Your browser does not support iframes</p>
    </iframe>

    <iframe id="sprintsFrame" src="" width="500" height="300" scrolling="no" frameborder="0">
     <p>Your browser does not support iframes</p>
    </iframe>

    <p>Score: <c:out value="${questionModel.totalScore}" /> out of <c:out value="${questionModel.maxPossibleScore}" /></p>

  </body>

</html>
