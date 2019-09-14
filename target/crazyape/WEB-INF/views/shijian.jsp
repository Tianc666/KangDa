<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<%--lang="en"--%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/login-ui/js/need/laydate.css" />
<%--    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<%--    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/login-ui/js/laydate.js"></script>

<%--    <title>jQuery UI 日期选择器（Datepicker） - 显示按钮栏</title>--%>
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="jqueryui/style.css">
<%--    <script>--%>
<%--        $(function () {--%>
<%--            $("#datepicker").datepicker({--%>
<%--                showButtonPanel: true--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>

<%--    <style type="text/css">--%>
<%--        *{margin:0;padding:0;list-style:none;}--%>
<%--        html{background-color:#E3E3E3; font-size:14px; color:#000; font-family:'微软雅黑'}--%>
<%--        h2{line-height:30px; font-size:20px;}--%>
<%--        a,a:hover{ text-decoration:none;}--%>
<%--        pre{font-family:'微软雅黑'}--%>
<%--        .box{width:970px; padding:10px 20px; background-color:#fff; margin:10px auto;}--%>
<%--        .box a{padding-right:20px;}--%>
<%--        .demo1,.demo2,.demo3,.demo4,.demo5,.demo6{margin:25px 0;}--%>
<%--        h3{margin:10px 0;}--%>
<%--        .layinput{height: 22px;line-height: 22px;width: 150px;margin: 0;}--%>
<%--    </style>--%>
    <script type="text/javascript">
        // !function(){
        //     laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
        //     laydate({elem: '#demo'});//绑定元素
        // }();

        //日期范围限制
        var start = {
            elem: '#start',
            format: 'YYYY-MM-DD',
            min: laydate.now(), //设定最小日期为当前日期
            max: '2099-06-16', //最大日期
            istime: true,
            istoday: false,
            choose: function(datas){
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            elem: '#end',
            format: 'YYYY-MM-DD',
            min: laydate.now(),
            max: '2099-06-16',
            istime: true,
            istoday: false,
            choose: function(datas){
                start.max = datas; //结束日选好后，充值开始日的最大日期
            }
        };
        laydate(start);
        laydate(end);

        //自定义日期格式
        laydate({
            elem: '#test1',
            format: 'YYYY年MM月DD日',
            festival: true, //显示节日
            choose: function(datas){ //选择日期完毕的回调
                alert('得到：'+datas);
            }
        });

        //日期范围限定在昨天到明天
        laydate({
            elem: '#hello3',
            min: laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
            max: laydate.now(+1) //+1代表明天，+2代表后天，以此类推
        });
    </script>
</head>
<body>
<form role="form">
    <%--    <div class="form-group">--%>
    <%--        <label for="name">名称</label>--%>
    <%--        <input type="text" class="form-control" id="name"--%>
    <%--               placeholder="请输入名称">--%>
    <%--     </div>--%>

    <div class="form-group">
        <p>选择用户：
        <select value="切换用户" id="changeuser" class="form-control">
            <option value="all">选择用户</option>
            <c:forEach items="${users}" var="users">
                <option id="select" value="${users.uId}">${users.uUsername}</option>
            </c:forEach>
        </select>
        </p>
        <p>选择药品:
        <select value="切换药品" id="changemedicine" class="form-control">
            <option value="all">选择药品</option>
            <c:forEach items="${medicines}" var="medicines">
                <option id="select" value="${medicines.mMedicineid}">${medicines.mName}</option>
            </c:forEach>
        </select>
        </p>
    </div>

    <%--    <input type="text" id="datepicker" class="form-control">--%>

<%--    <p>日期：<input type="datetime-local" i value="2015-09-24 13:59:59" class="form-control" id="data"/></p>--%>
        <div class="box">
        <div class="demo2">
            <input id="data" placeholder="请输入日期" class="laydate-icon" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
        </div>
        </div>
    <p>购买数量：
        <input type="text" class="form-control" id="count" placeholder="请输入购买数量">
    </p>
    <%--    <input id="dt" type="text" name="birthday">--%>
        <button type="submit" class="btn btn-default" onclick="sub()">提交</button>

</form>

<script type="text/javascript">
    function sub() {
// alert("进来了")
        var changeuser=$("#changeuser option:selected").val();  //获取选中的项
        // var changeuser='hahah';
        var changemedicine=$("#changemedicine option:selected").val();

        var count =$("#count").val();

        var data=$("#data").val();
        // alert(options.val());   //拿到选中项的值
        // function sub(){
            $.ajax({
               method:"GET",
                datatype:"JSON",
                url:"${pageContext.request.contextPath}/tijiao?changeuser="+changeuser+"&changemedicine="+changemedicine+"&count="+count+"&data="+data,
                success:function () {
                      window.location.href="${pageContext.request.contextPath}/salemessage"
                }
            });
        // }


        // function changeuser() {
        //     var changeuser = $("#changeuser").val
        // }
        // function changemedicine() {
        //     var changemedicine = $("#changemedicine").val()
        // }
        <%--window.location.href="${pageContext.request.contextPath}/tijiao?changeuser="+changeuser+",changemedicine="+changemedicine;--%>
    }

</script>

</body>
</html>