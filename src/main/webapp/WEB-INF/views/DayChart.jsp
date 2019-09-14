<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript"
            src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript"
            src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>
    <title>日销售</title>
</head>
<body>
<%--<form role="form" class="myform" action="${pageContext.request.contextPath}/dbar" method="post">--%>
<select value="切换日期" id="changetime" onchange="haha()">
    <option value="all">选择要查看的日销售量日期：</option>
    <c:forEach items="${SaleTime}" var="SaleTime">
        <option value="${SaleTime}">${SaleTime}</option>
    </c:forEach>
</select>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>
<div id="mainChart" style="width: 100%;height:630px;">

</div>
<script type="text/javascript">
    <%--$(document).ready(function(){--%>
    <%--    $.ajax({--%>
    <%--        method: 'post',--%>
    <%--        url: '${pageContext.request.contextPath}/dbar?changetime='+change,--%>
    <%--        dataType: 'json',--%>
    <%--        success: function (dayls) {//data格式:[{name:三个月前,value:600},...]--%>
    <%--            initChat(dayls);--%>
    <%--        }--%>
    <%--    });--%>
    <%--    //do something--%>
    <%--})--%>

    function haha(){
       var change = $("#changetime").val();
       // alert(change);
       console.log(change);
<%--       $.ajax({--%>
<%--           // method:"post",--%>
<%--           // data:changetime=change,--%>
<%--// method:"get",--%>
<%--//            data:changetime=change,--%>
<%--           url:"${pageContext.request.contextPath}/dbar?changetime="+change,--%>
<%--           type:"POST",--%>
<%--           dataType:"json",--%>
<%--       });--%>

<%--       window.location.href="${pageContext.request.contextPath}/dbar?changetime="+change;--%>

        //使用ajax加载数据
        $.ajax({
            method: 'post',
            url: '${pageContext.request.contextPath}/dbar?changetime='+change,
            <%--url : '${pageContext.request.contextPath}/dbar',--%>
            dataType: 'json',
            success: function (dayls) {//data格式:[{name:三个月前,value:600},...]
                initChat(dayls);
            }
        });

        function initChat(dayls) {
            var dom = document.getElementById("mainChart");
            var myChart = echarts.init(dom);

            // 初始 option
            var option = {
                title: {
                    text: '用户消费预测',
                    textStyle: {
                        color: '#000'
                    }
                },
                backgroundColor: '#ccc',
                textStyle: {
                    color: '#000',
                },
                tooltip: {},
                legend: {
                    data: ['消费额'],
                    textStyle: {
                        color: '#000'
                    }
                },
                xAxis: {
                    data: formatData(dayls).xAxData,
                    axisLabel: {
                        interval: 0,//横轴信息全部显示
                        rotate: -30,//-30度角倾斜显示
                    }

                },
                yAxis: {},
                series: [{
                    name: '消费额',
                    type: 'bar',
                    data: formatData(dayls).serData
                }]
            };

            if (option && typeof option === "object") {
                myChart.setOption(option, true);
            }
        };

        function formatData(data) {
            var xAxData = [];
            var serData = [];

            for (var i = 0; i < data.length; i++) {
                xAxData.push(data[i].name || "");
                serData.push({
                    name: data[i].name,
                    value: data[i].value || 0
                });
            }

            return {
                xAxData: xAxData,
                serData: serData
            };
        };

    }


</script>
</body>
</html>