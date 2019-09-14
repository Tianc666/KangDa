<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="../../lib/html5shiv.js"></script>
<script type="text/javascript" src="../../lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="../../lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>进货管理</title><link rel="stylesheet" href="${pageContext.request.contextPath}/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<style>
		.updata{
			width: 500px;
			height: auto;
			z-index: 10;
			position: fixed;
			left: 50%;
			top: 50%;
			transform: translate(-50%, -50%);
			background: #999999;
			display:none;
		}
		.basic-grey {
			margin-left:auto;
			margin-right:auto;
			max-width: 500px;
			background: #F7F7F7;
			padding: 25px 15px 25px 10px;
			font: 12px Georgia, "Times New Roman", Times, serif;
			color: #888;
			text-shadow: 1px 1px 1px #FFF;
			border:1px solid #E4E4E4;
		}
		.basic-grey h1 {
			font-size: 25px;
			padding: 0px 0px 10px 40px;
			display: block;
			border-bottom:1px solid #E4E4E4;
			margin: -10px -15px 30px -10px;;
			color: #888;
		}
		.basic-grey h1>span {
			display: block;
			font-size: 11px;
		}
		.basic-grey label {
			display: block;
			margin: 0px;
		}
		.basic-grey label>span {
			float: left;
			width: 20%;
			text-align: right;
			padding-right: 10px;
			margin-top: 10px;
			color: #888;
		}
		.basic-grey input[type="text"], .basic-grey input[type="email"], .basic-grey textarea, .basic-grey select {
			border: 1px solid #DADADA;
			color: #888;
			height: 30px;
			margin-bottom: 16px;
			margin-right: 6px;
			margin-top: 2px;
			outline: 0 none;
			padding: 3px 3px 3px 5px;
			width: 70%;
			font-size: 12px;
			line-height:15px;
			box-shadow: inset 0px 1px 4px #ECECEC;
			-moz-box-shadow: inset 0px 1px 4px #ECECEC;
			-webkit-box-shadow: inset 0px 1px 4px #ECECEC;
		}
		.basic-grey textarea{
			padding: 5px 3px 3px 5px;
		}

		.basic-grey .button {
			background: #E27575;
			border: none;
			padding: 10px 25px 10px 25px;
			color: #FFF;
			box-shadow: 1px 1px 5px #B6B6B6;
			border-radius: 3px;
			text-shadow: 1px 1px 1px #9E3F3F;
			cursor: pointer;

		}

	</style>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 进货管理 <span class="c-gray en">&gt;</span> 进货记录管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" class="input-text Wdate" style="width:120px;">
		<button name="" id="" class="btn btn-success" type="submit" onclick="ac()"><i class="Hui-iconfont">&#xe665;</i> 搜记录</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a class="btn btn-primary radius" onclick="opon()" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 进货</a></span> <span class="r">共有数据：<strong>${num}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
			<tr class="text-c">
				<th width="60">进货ID</th>
				<th width="100">药品编号</th>
				<th width="60">进货数量</th>
				<th width="60">进货时间</th>
				<th width="100">操作</th>
			</tr>
			</thead>

			<tbody>
			<c:forEach items="${list}" var="list">
			<tr class="text-c va-m">
				<td>${list.sId}</td>
				<td>${list.sMedicineid}</td>
				<td>${list.sCount}</td>
				<th><fmt:formatDate value="${list.sData}" pattern="yyyy-MM-dd"/></th>
				<td class="td-manage">
					<input class="iis" style="display: none" value="${list.sId}"/>
					<a  style="text-decoration:none" class="ml-5" onClick="acc(this)" href="javascript:;"  title="删除">
						<i class="Hui-iconfont">&#xe6e2;</i>
					</a>
				</td>
			</tr>
			</c:forEach>
			</tbody>

		</table>
	</div>
</div>

<div class="updata" id="hla">
	<form method="get" action="insert" class="basic-grey">
		<label>
			<span>药品编号：</span>
			<input  type="text" name="mMedicineid"  />
		</label>
		<label>
			<span>药品名字：</span>
			<input  type="text" name="mName" />
		</label>
        <label>
            <span>价格：</span>
            <input  type="text" name="mPrice" />
        </label>
		<label>
			<span>进货数量：</span>
			<input  type="text" name="mInventory"  />
		</label>
		<label>
			<span>过期时间：</span>
			<input  type="text" name="mPastdate"  />
		</label>
		<label>
			<span>药品种类：</span>
			<input  type="text" name="mClassify"  />
		</label>

        <label style="text-align: center">
		    <button id="ok" type="submit" value="添加" class="button">进货</button>
		    <button id="no" type="button" value="取消" class="button" onclick="bbc()">取消</button>
        </label>
	</form>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">


	//删除记录
	function acc(obj) {
		var id=obj.previousElementSibling.value;
		flag = window.confirm("确定要删除该信息？");
		if(flag==false){ return false }
		window.location="${pageContext.request.contextPath}/delete?sid="+id;

	}
	//进货
	function bbc() {
		$("#hla").css("display","none");
	}
	function opon() {
		$("#hla").css("display","block");
	}
	//搜记录
	function ac() {
		var logmin=$("#logmin").val();
		var logmax=$("#logmax").val();
		window.location="${pageContext.request.contextPath}/selectStock?logmin="+logmin+"&logmax="+logmax;

	}


	$('.table-sort').dataTable({
		"aaSorting": [[ 3, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
			{"orderable":false,"aTargets":[2,4]}// 制定列不参与排序
		]
	});
	/*/!*产品-添加*!/
	function product_add(title,url){
		var index = layer.open({
			type: 2,
			title: title,
			content: url
		});
		layer.full(index);
	}
	/!*产品-查看*!/
	function product_show(title,url,id){
		var index = layer.open({
			type: 2,
			title: title,
			content: url
		});
		layer.full(index);
	}

	/!*产品-下架*!/
	function product_stop(obj,id){
		layer.confirm('确认要下架吗？',function(index){
			$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
			$(obj).remove();
			layer.msg('已下架!',{icon: 5,time:1000});
		});
	}

	/!*产品-编辑*!/
	function product_edit(title,url,id){
		var index = layer.open({
			type: 2,
			title: title,
			content: url
		});
		layer.full(index);
	}

	/!*产品-删除*!/
	function product_del(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: '',
				dataType: 'json',
				success: function(data){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
				},
				error:function(data) {
					console.log(data.msg);
				},
			});
		});
	}*/
</script> 
</body>
</html>