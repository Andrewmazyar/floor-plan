<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<script>
    var xValue;
    var yValue;
    var dps = [];
    <c:forEach items="${loading}" var="load">
    xValue = parseInt("${load.coordinateX}");
    yValue = parseInt("${load.coordinateX}");
    dps.push([xValue, yValue]);
    </c:forEach>
    var canvas = document.getElementById("myCanvas");
    var ctx = canvas.getContext("2d");
    ctx.moveTo(dps[0][0] * 100,dps[0][1] * 100);
    ctx.lineTo(dps[1][0] * 100,dps[1][1] * 100);
    ctx.stroke();
</script>

</body>
</html>
