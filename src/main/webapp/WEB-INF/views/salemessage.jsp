<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>品牌管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span
        class="c-gray en">&gt;</span> 品牌管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
<%--        <form enctype="multipart/form-data" class="Huiform" method="post" action="/list" target="_self">--%>
<%--            <input name="file" type="file" placeholder="销售表格" value="" class="input-text" style="width:120px">--%>
<%--            <span class="btn-upload form-group">--%>
<%--			&lt;%&ndash;<input class="input-text upload-url" type="text" name="uploadfile-2" id="uploadfile-2" readonly--%>
<%--                   style="width:200px">&ndash;%&gt;--%>
<%--			<input type="submit"  href="javascript:void();" class="btn btn-primary upload-btn"><i--%>
<%--                    class="Hui-iconfont">&#xe642;</i> 上传表格</input>--%>
<%--			<input type="file" multiple name="file-2" class="input-file">--%>
<%--			</span> <!--<span class="select-box" style="width:150px">--%>
<%--			 <select class="select" name="brandclass" size="1">--%>
<%--				<option value="1" selected>国内品牌</option>--%>
<%--				<option value="0">国外品牌</option>--%>
<%--			</select>--%>
<%--			</span><button type="button" class="btn btn-success" id="" name="" onClick="picture_colume_add(this);"><i class="Hui-iconfont">&#xe600;</i> 添加</button> -->--%>
<%--        </form>--%>

        <form enctype="multipart/form-data" action="list" method="post" class="Huiform">
            <input type="file" name="file" class="input-text" style="width:200px">
            <input type="submit" value="上传工作文件" name="导入" class="btn btn-primary upload-btn">
        </form>

    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	
	<select value="切换用户" id="changeuser" onchange="haha()">
  <option value="all">全部</option>
        <c:forEach items="${Saleuname}" var="Saleuname">
  <option id="select" value="${Saleuname.user.uUsername}">${Saleuname.user.uUsername}</option>
        </c:forEach>
    </select>
	<a href="${pageContext.request.contextPath}/shijian"  class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加销售记录</a>
	</span></div> <!-- <span class="r">共有数据：<strong>54</strong> 条</span> -->
    <!-- <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> -->
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-sort">
            <thead>
            <tr class="text-c">
                <!-- <th width="25"><input type="checkbox" name="" value=""></th> -->
                <th width="100">药品名称</th>
                <th width="80">销售件数</th>
                <th width="200">药品价格</th>
<%--                <th width="120">库存</th>--%>
                <th>销售日期</th>
                <th width="100">用户名</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${salesmessages}" var="sale">
            <tr class="text-c">
                <!-- <td><input name="" type="checkbox" value=""></td> -->
                <td>${sale.medicine.mName}</td>
                <td>${sale.smInventory}件</td>
                <td>${sale.medicine.mPrice}元</td>
<%--                <td>${sale.medicine.mInventory}件</td> <!-- class="text-l" -->--%>
                <td>${sale.smData}</td><!-- class="text-l" -->
                <td>${sale.user.uUsername}</td><!-- class="f-14 product-brand-manage" -->
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">

    // $("#changeuser").on("change",function () {
    //     cuname = $("option:selected",this).val();
    //     queryDemandByPid(cuname);
    //
    //
    // });
    // cuname = $("option:selected",this).val();
    // cuname = $("#select option:selected").val();

    // cuname = $("#select").find("option:selected").val();
    // cuname=$("#select option:selected").val();
    // cuname = $("#changeuser").find("option:selected").val();
    function haha(){
        cuname = $("#changeuser").val();
        alert(cuname);
        $.ajax({
            method: 'GET',
            dataType: 'JSON',
            url:"${pageContext.request.contextPath}/salemessage2?cuname="+cuname,
            success:function() {
                window.location.href="${pageContext.request.contextPath}/salemessage2";
            }
        });
    }

    $('.table-sort').dataTable({
        "aaSorting": [[1, "desc"]],//默认第几个排序
        "bStateSave": true,//状态保存
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable": false, "aTargets": [0, 4]}// 制定列不参与排序
        ]
    });
</script>
</body>
</html>