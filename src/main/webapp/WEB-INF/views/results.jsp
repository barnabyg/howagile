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

    <div class="largeChart" >
      <iframe id="totalFrame"src="" class="largeChartFrame">
       <p>Your browser does not support iframes</p>
      </iframe>
    </div>

    <div class="smallChart">
      <iframe id="teamFrame" src="" class="smallChartFrame">
       <p>Your browser does not support iframes</p>
      </iframe>
  
      <iframe id="communicationFrame" src="" class="smallChartFrame">
       <p>Your browser does not support iframes</p>
      </iframe>
  
      <iframe id="productFrame" src="" class="smallChartFrame">
       <p>Your browser does not support iframes</p>
      </iframe>
  
      <iframe id="engineeringFrame" src="" class="smallChartFrame">
       <p>Your browser does not support iframes</p>
      </iframe>
  
      <iframe id="sprintsFrame" src="" class="smallChartFrame">
       <p>Your browser does not support iframes</p>
      </iframe>
    </div>

  </body>

</html>
