<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
	<%@ include file="../../static/head.jsp"%>
	<!-- font-awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
</head>
<style>

</style>
<body>
	<!-- Pre Loader -->
	<div class="loading">
		<div class="spinner">
			<div class="double-bounce1"></div>
			<div class="double-bounce2"></div>
		</div>
	</div>
	<!--/Pre Loader -->
	<div class="wrapper">
		<!-- Page Content -->
		<div id="content">
				<!-- Top Navigation -->
				<%@ include file="../../static/topNav.jsp"%>
				<!-- Menu -->
				<div class="container menu-nav">
					<nav class="navbar navbar-expand-lg lochana-bg text-white">
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
						 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="ti-menu text-white"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<!-- <div class="z-navbar-nav-title">$template2.back.menu.title.text</div> -->
							<ul id="navUl" class="navbar-nav mr-auto">						
							</ul>
						</div>
					</nav>
				</div>
				<!-- /Menu -->
				<!-- Breadcrumb -->
				<!-- Page Title -->
				<div class="container mt-0">
					<div class="row breadcrumb-bar">
						<div class="col-md-6">
							<h3 class="block-title">在线下单管理</h3>
						</div>
						<div class="col-md-6">
							<ol class="breadcrumb">
								<li class="breadcrumb-item">
									<a href="${pageContext.request.contextPath}/index.jsp">
										<span class="ti-home"></span>
									</a>
								</li>
								<li class="breadcrumb-item"><span>在线下单管理</span></li>
								<li class="breadcrumb-item active"><span>在线下单列表</span></li>
							</ol>
						</div>
					</div>
				</div>
			<!-- /Page Title -->

			<!-- /Breadcrumb -->
			<!-- Main Content -->
			<div class="container">

				<div class="row">
					<!-- Widget Item -->
					<div class="col-md-12">
						<div class="widget-area-2 lochana-box-shadow">
							<h3 class="widget-title">在线下单列表</h3>							
							<div class="table-responsive mb-3" id="tableDiv">
								<div class="col-sm-12">
									<label>
										商家名
									</label>
									<input type="text" id="shangjiamingSearch" class="form-control form-control-sm" placeholder="" aria-controls="tableId">
									<label>
										菜名
									</label>
									<input type="text" id="caimingSearch" class="form-control form-control-sm" placeholder="" aria-controls="tableId">
									<button onclick="search()" type="button" class="btn btn-primary">查询</button>
									<button onclick="add()" type="button" class="btn btn-success 新增">添加</button>
									<button onclick="deleteMore()" type="button" class="btn btn-danger 删除">批量删除</button>
								</div>
								<table id="tableId" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th class="no-sort" style="min-width: 35px;">
												<div class="custom-control custom-checkbox">
													<input class="custom-control-input" type="checkbox" id="select-all" onclick="chooseAll()">
													<label class="custom-control-label" for="select-all"></label>
												</div>
											</th>
											<th onclick="sort('shangjiahao')">商家号<i id="shangjiahaoIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('shangjiaming')">商家名<i id="shangjiamingIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('zhanghao')">账号<i id="zhanghaoIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('xingming')">姓名<i id="xingmingIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('shouji')">手机<i id="shoujiIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('dizhi')">地址<i id="dizhiIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('caiming')">菜名<i id="caimingIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('caixi')">菜系<i id="caixiIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('fenliang')">分量<i id="fenliangIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('jiage')">价格<i id="jiageIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('shuliang')">数量<i id="shuliangIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('zongjia')">总价<i id="zongjiaIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('shijian')">时间<i id="shijianIcon" class="fa fa-sort"></i></th>
											<th onclick="sort('sfsh')">是否审核<i id="sfshIcon" class="fa fa-sort"></i></th>

											<th>审核回复</th>
											<th onclick="sort('ispay')">是否支付<i id="ispayIcon" class="fa fa-sort"></i></th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
								<div class="col-md-6 col-sm-3 z-pages" style="flex:none;max-width:inherit;display:flex;">
									<div class="dataTables_length" id="tableId_length">
										
											<select name="tableId_length" aria-controls="tableId" id="selectPageSize" onchange="changePageSize()">
												<option value="10">10</option>
												<option value="25">25</option>
												<option value="50">50</option>
												<option value="100">100</option>
											</select> 
											<span class="text">条每页</span>
										
									</div>
									<nav aria-label="Page navigation example">
										<ul class="pagination justify-content-end">
											<li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
												<a class="page-link" href="#" tabindex="-1">上一页</a>
											</li>
									
											<li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
												<a class="page-link" href="#">下一页</a>
											</li>
										</ul>
									</nav>
								</div>
								
							</div>
						</div>
					</div>
					<!-- /Widget Item -->
				</div>
			</div>
			<!-- /Main Content -->

		</div>
		<!-- /Page Content -->
	</div>
	<!--审核对话框-->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">审核</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="shForm">
						<input type="hidden" id="shId" name="id">
						<div class="row">
							<div class="col-md-6 pr-0">
								<div class="form-group form-group-default">
									<label>是否审核</label>
									<select name="sfsh" class="form-control">
										<option class="shOption" value="是">是</option>
										<option class="shOption" value="否">否</option>
									</select>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group form-group-default">
									<label>审核回复</label>
									<textarea id="shhf-text" class="form-control" name="shhf" rows="10" cols="50"></textarea>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
					<button id="addRowButton" onclick="sh()" type="button" class="btn btn-primary">提交</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Back to Top -->
	<a id="back-to-top" href="#" class="back-to-top">
		<span class="ti-angle-up"></span>
	</a>
	<!-- /Back to Top -->
	<%@ include file="../../static/foot.jsp"%>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>

	<script>
		<%@ include file="../../utils/menu.jsp"%>
		<%@ include file="../../static/setMenu.js"%>
		<%@ include file="../../utils/baseUrl.jsp"%>
		<%@ include file="../../static/getRoleButtons.js"%>
		<%@ include file="../../static/crossBtnControl.js"%>
		var tableName = "zaixianxiadan";
		var pageType = "list";
	  	var searchForm = { key: ""};
		var pageIndex = 1;
		var pageSize = 10;
		var totalPage = 0;
		var dataList = [];
		var sortColumn = '';
		var sortOrder= '';
		var ids = [];
		var checkAll = false;


		function init() {
			// 满足条件渲染提醒接口
		}
		// 改变每页记录条数
		function changePageSize() {
		    var selection = document.getElementById('selectPageSize');
		    var index = selection.selectedIndex;
			pageSize = selection.options[index].value;
			getDataList();
        }		
		//排序
		function sort(columnName){
			var iconId = '#'+columnName+'Icon'
			$('th i').attr('class','fa fa-sort');
			if(sortColumn == '' || sortColumn != columnName){
				sortColumn = columnName;
				sortOrder = 'asc';
				$(iconId).attr('class','fa fa-sort-asc');
			}
			if(sortColumn == columnName){
				if(sortOrder == 'asc'){
					sortOrder = 'desc';
					$(iconId).attr('class','fa fa-sort-desc');
				}else{
					sortOrder = 'asc';
					$(iconId).attr('class','fa fa-sort-asc');
				}
			}
			pageIndex = 1;
			getDataList();
		}		
		
		// 查询
		function search(){
			searchForm = { key: ""};
			if($('#shangjiamingSearch').val() != null && $('#shangjiamingSearch').val() != ''){
				searchForm.shangjiaming ="%" +  $('#shangjiamingSearch').val() + "%";
			}
			
			if($('#caimingSearch').val() != null && $('#caimingSearch').val() != ''){
				searchForm.caiming ="%" +  $('#caimingSearch').val() + "%";
			}
			
			getDataList();
		}		
		// 获取数据列表
        function getDataList() {
			http("zaixianxiadan/page","GET",{
				page: pageIndex,
				limit: pageSize,
				sort: sortColumn,
				order: sortOrder,
				shangjiaming : searchForm.shangjiaming,	
				caiming : searchForm.caiming,	
			},(res)=>{
				if(res.code == 0){
					clear();
					dataList = res.data.list;
					totalPage = res.data.totalPage;
					//var tbody = document.getElementById('tbMain');
					for(var i = 0;i < dataList.length; i++){ //遍历一下表格数据  
						var trow = setDataRow(dataList[i],i); //定义一个方法,返回tr数据 
						$('tbody').append(trow); 
					}
					pagination(); //渲染翻页组件
					getRoleButtons();// 权限按钮控制
				}
			});
        }		
		// 渲染表格数据
		function setDataRow(item,number){
			//创建行 
			var row = document.createElement('tr'); 
			row.setAttribute('class','useOnce');
			//创建勾选框
			var checkbox = document.createElement('td');
			var checkboxDiv = document.createElement('div');
			checkboxDiv.setAttribute("class","custom-control custom-checkbox");
			var checkboxInput = document.createElement('input');
			checkboxInput.setAttribute("class","custom-control-input");
			checkboxInput.setAttribute("type","checkbox");
			checkboxInput.setAttribute('name','chk');
			checkboxInput.setAttribute('value',item.id);
			checkboxInput.setAttribute("id",number);
			checkboxDiv.appendChild(checkboxInput);
			var checkboxLabel = document.createElement('label');
			checkboxLabel.setAttribute("class","custom-control-label");
			checkboxLabel.setAttribute("for",number);
			checkboxDiv.appendChild(checkboxLabel);
			checkbox.appendChild(checkboxDiv);
			row.appendChild(checkbox)

			var shangjiahaoCell  = document.createElement('td');

						 shangjiahaoCell.innerHTML = item.shangjiahao;


			row.appendChild(shangjiahaoCell);
			var shangjiamingCell  = document.createElement('td');

						 shangjiamingCell.innerHTML = item.shangjiaming;


			row.appendChild(shangjiamingCell);
			var zhanghaoCell  = document.createElement('td');

						 zhanghaoCell.innerHTML = item.zhanghao;


			row.appendChild(zhanghaoCell);
			var xingmingCell  = document.createElement('td');

						 xingmingCell.innerHTML = item.xingming;


			row.appendChild(xingmingCell);
			var shoujiCell  = document.createElement('td');

						 shoujiCell.innerHTML = item.shouji;


			row.appendChild(shoujiCell);
			var dizhiCell  = document.createElement('td');

						 dizhiCell.innerHTML = item.dizhi;


			row.appendChild(dizhiCell);
			var caimingCell  = document.createElement('td');

						 caimingCell.innerHTML = item.caiming;


			row.appendChild(caimingCell);
			var caixiCell  = document.createElement('td');

						 caixiCell.innerHTML = item.caixi;


			row.appendChild(caixiCell);
			var fenliangCell  = document.createElement('td');

						 fenliangCell.innerHTML = item.fenliang;


			row.appendChild(fenliangCell);
			var jiageCell  = document.createElement('td');

						 jiageCell.innerHTML = item.jiage;


			row.appendChild(jiageCell);
			var shuliangCell  = document.createElement('td');

						 shuliangCell.innerHTML = item.shuliang;


			row.appendChild(shuliangCell);
			var zongjiaCell  = document.createElement('td');

						 zongjiaCell.innerHTML = item.zongjia;


			row.appendChild(zongjiaCell);
			var shijianCell  = document.createElement('td');

						  shijianCell.innerHTML = item.shijian;


			row.appendChild(shijianCell);
			var sfshCell  = document.createElement('td');

						 sfshCell.innerHTML = item.sfsh;


			row.appendChild(sfshCell);
			var shhfCell  = document.createElement('td');

						  if(item.shhf != null && item.shhf != "" && item.shhf.length >= 11){
			  	shhfCell.innerHTML = item.shhf.substring(0, 10) + "..."; 
			  }else{
			  	shhfCell.innerHTML = item.shhf;
			  }


			row.appendChild(shhfCell);
			var ispayCell  = document.createElement('td');

							var payBtn = document.createElement('button');		
				payBtn.innerHTML = "支付"; 
				payBtn.setAttribute('class','btn btn-success btn-sm 支付')
					      
				if(window.sessionStorage.getItem('role') != '管理员'){
					if(item.ispay.trim() != "已支付"){
						var payAttr = "pay(" + item.id + ")";
						payBtn.setAttribute('onclick',payAttr);
						ispayCell.appendChild(payBtn);
					}else{
						ispayCell.innerHTML = item.ispay;
					}    
				}else{
					ispayCell.innerHTML = item.ispay;
				}


			row.appendChild(ispayCell);

			//每行按钮
			var btnGroup = document.createElement('td');
			//审核按钮
			var shBtn = document.createElement('button');
			shBtn.setAttribute("type","button");
			shBtn.setAttribute("class","btn btn-primary btn-sm 审核");
			var shAttr = "shDialog(" + item.id + ")";
			shBtn.setAttribute('onclick',shAttr);
			shBtn.innerHTML = "审核";
			shBtn.setAttribute("data-toggle","modal");
			shBtn.setAttribute("data-target","#exampleModal");
			btnGroup.appendChild(shBtn);

			//详情按钮
			var detailBtn = document.createElement('button');
			var detailAttr = "detail(" + item.id + ')';
			detailBtn.setAttribute("type","button");
			detailBtn.setAttribute("class","btn btn-info btn-sm 查看");
			detailBtn.setAttribute("onclick",detailAttr);
			detailBtn.innerHTML = "查看"
			btnGroup.appendChild(detailBtn)
			//修改按钮
			var editBtn = document.createElement('button');
			var editAttr = 'edit(' +  item.id + ')';
			editBtn.setAttribute("type","button");
			editBtn.setAttribute("class","btn btn-warning btn-sm 修改");
			editBtn.setAttribute("onclick",editAttr);
			editBtn.innerHTML = "修改"

			btnGroup.appendChild(editBtn)
			//删除按钮
			var deleteBtn = document.createElement('button');
			var deleteAttr = 'remove(' +  item.id + ')';
			deleteBtn.setAttribute("type","button");
			deleteBtn.setAttribute("class","btn btn-danger btn-sm 删除");
			deleteBtn.setAttribute("onclick",deleteAttr);
			deleteBtn.innerHTML = "删除"
			btnGroup.appendChild(deleteBtn)


			row.appendChild(btnGroup)
			return row;
		}		
		//配置审核表单
		function shDialog(id){
			$("#shId").attr("value",id);
			http("zaixianxiadan/info/" + id,"GET",{},(res)=>{
				if(res.code == 0){
					var shOptions = document.getElementsByClassName("shOption");
					for(var i=0;i<shOptions.length;i++){
						if(shOptions[i].value == res.data.sfsh){
							shOptions[i].setAttribute("selected","selected");
						}
					}
					$("#shhf-text").val(res.data.shhf);
				}
			});
		}		
		//审核提交
		function sh(){
			let data = {};
			let value = $('#shForm').serializeArray();
			$.each(value, function (index, item) { 
							data[item.name] = item.value;
					});
			let json = JSON.stringify(data);
			httpJson("zaixianxiadan/update","POST",data,(res)=>{
				if(res.code == 0){
					$('#addRowModal').modal('hide');
					alert("提交成功");
					window.location.href="list.jsp";
				}
			});
		}		

		// 翻页
        function pageNumChange(val) {
            if(val == 'pre') {
                pageIndex--;
            }else if(val == 'next'){
                pageIndex++;
            }else{
                pageIndex = val;
            }
			getDataList();
        }		
		// 下载
		function download(url){
			window.open(url);
		}
		// 打开新窗口播放媒体
		function mediaPlay(url){
			window.open(url);
		}		
		// 渲染翻页组件
		function pagination() {
			var beginIndex = pageIndex;
			var endIndex = pageIndex;
			var point = 4;
			//计算页码
			for(var i=0;i<3;i++){
				if(endIndex==totalPage){ break;}
				endIndex++;
				point--;
			}
			for(var i=0;i<3;i++){
				if(beginIndex==1){break;}
				beginIndex--;
				point--;
			}
			if(point>0){
				while (point>0){
					if(endIndex==totalPage){ break;}
					endIndex++;
					point--;
				}
				while (point>0){
					if(beginIndex==1){ break;}
					beginIndex--;
					point--
				}
			}
			// 是否显示 前一页 按钮
			if(pageIndex>1){
				$('#tableId_previous').show();
			}else{
				$('#tableId_previous').hide();
			}
			// 渲染页码按钮
			for(var i=beginIndex;i<=endIndex;i++){
				var pageNum = document.createElement('li');
				pageNum.setAttribute('onclick',"pageNumChange("+i+")");
				if(pageIndex == i){
					pageNum.setAttribute('class','paginate_button page-item active useOnce');
				}else{
					pageNum.setAttribute('class','paginate_button page-item useOnce');
				}								
				var pageHref = document.createElement('a');
				pageHref.setAttribute('class','page-link');
				pageHref.setAttribute('href','#');
				pageHref.setAttribute('aria-controls','tableId');
				pageHref.setAttribute('data-dt-idx',i);
				pageHref.setAttribute('tabindex',0);
				pageHref.innerHTML = i;
				pageNum.appendChild(pageHref);
				$('#tableId_next').before(pageNum);
			}
			// 是否显示 下一页 按钮
			if(pageIndex < totalPage){
				$('#tableId_next').show();
				$('#tableId_next a').attr('data-dt-idx',endIndex+1);
			}else{
				$('#tableId_next').hide();
			}
			var pageNumInfo = "当前第 "+ pageIndex + " 页，共 "+ totalPage + " 页";
			$('#tableId_info').html(pageNumInfo);
		}		
		// 跳转到指定页
		function toThatPage(){
			//var index = document.getElementById('pageIndexInput').value;
			if(index<0 || index>totalPage){
				alert('请输入正确的页码');
			}else {
				pageNumChange(index);
			}
		}		
		// 全选/全不选
		function chooseAll(){
			checkAll = !checkAll;
			var boxs = document.getElementsByName("chk");
			for(var i=0;i<boxs.length;i++){
				boxs[i].checked= checkAll;
			}
		}		
	
		// 批量删除
		function deleteMore(){
			ids = []
			var boxs = document.getElementsByName("chk");
			for(var i=0;i<boxs.length;i++){
				if(boxs[i].checked){
					ids.push(boxs[i].value)
				}
			}
			if(ids.length == 0){
				alert('请勾选要删除的记录');
			}else{
				remove(ids);
			}
		}	
		// 删除
        function remove(id) { 
            var mymessage = confirm("真的要删除吗？");
            if (mymessage == true) {
				var paramArray = [];
				if (id == ids){
					paramArray = id;
				}else{
					paramArray.push(id);
				}             
				httpJson("zaixianxiadan/delete","POST",paramArray,(res)=>{
					if(res.code == 0){
						getDataList();		
						alert('删除成功');
					}
				});         
            }
            else {
                alert("已取消操作");
            }
        }			
		// 用户登出
        <%@ include file="../../static/logout.jsp"%>

		//修改
        function edit(id) {
            window.sessionStorage.setItem('id', id)
            window.location.href = "add-or-update.jsp"
        }
		//清除会重复渲染的节点
        function clear(){
        	var elements = document.getElementsByClassName('useOnce');
        	for(var i = elements.length - 1; i >= 0; i--) { 
        	  elements[i].parentNode.removeChild(elements[i]); 
        	}
        }
		//添加
		function add(){
			window.location.href = "add-or-update.jsp"
		}
		//单列求和
		function getSum(colName){
			http("zaixianxiadan"+colName,"GET",{
				tableName: "zaixianxiadan",
				columnName: colName
			},(res)=>{
				if(res.code == 0){
					return res.data.sum;
				}
			});
		}		
		// 查看详情
		function detail(id){
			window.sessionStorage.setItem("id", id);
			//window.sessionStorage.setItem("ifView", true);
			window.location.href = "info.jsp";
		}

		//跨表
		function crossTable(id,crossTableName){
			window.sessionStorage.setItem('crossTableId',id);
			window.sessionStorage.setItem('crossTableName',"zaixianxiadan");
			var url = "../"+crossTableName+"/add-or-update.jsp";
			window.location.href = url;
        }
        //跳转到支付页面
        function pay(id){
            window.sessionStorage.setItem('oId',id);
			window.sessionStorage.setItem('tableName',"zaixianxiadan");
            window.location.href = "${pageContext.request.contextPath}/jsp/pay.jsp";
        }




		$(document).ready(function() { 
			//激活翻页按钮
			$('#tableId_previous').attr('class','paginate_button page-item previous')
			$('#tableId_next').attr('class','paginate_button page-item next')
			//隐藏原生搜索框
			$('#tableId_filter').hide()
			//设置右上角用户名
			$('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
			//设置项目名
			$('.sidebar-header h3 a').html(projectName)
			setMenu();			
			init();
			getDataList();
			<%@ include file="../../static/myInfo.js"%>
		});
	</script>
</body>

</html>
