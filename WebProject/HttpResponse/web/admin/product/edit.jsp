<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">

<%--		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"--%>

		<script type="text/javascript">

			//使用jquery
			<%--$(function(){--%>
			<%--	//测试jqurey是否引入成功--%>
			<%--	alert();--%>

			<%--	// 获取当前回显商品数据的cid--%>
			<%--	$("#cid option[value='${product.cid}']").prop("selected",true);--%>
			<%--	$("#is_hot option[value='${product.is_hot}']").prop("selected",true);--%>

			<%--});--%>


			//页面加载完成后 确定商品类别的哪个select 被选中
			window.onload = function () {
				// 获取当前回显商品数据的cid
				var cid = "${product.cid}";
				// 获取所有select 元素的option
				var options = document.getElementById("cid").getElementsByTagName("option");
				// alert(cid);
				// 比较每个option 的value 与cid
				for(var i=0;i<options.length;i++){
					if(cid==options[i].value){
						options[i].selected = true;
					}
				}

				var is_hot = ${product.is_hot};
				var is_hot_option = document.getElementById("is_hot").getElementsByTagName("option");
				for(var n = 0; n<is_hot_option.length; n++){
					if(is_hot == is_hot_option[n].value){
						is_hot_option[n].selected = true;
					}
				}
			}



		</script>
	</HEAD>
	
	<body>
		<!--  -->
		<form id="userAction_save_do" name="Form1"
			  action="${pageContext.request.contextPath}/adminUpdateProduct"
			  method="post"

<%--			  enctype导致无法获取request数据--%>
<%--			  enctype="multipart/form-data"--%>
		>


			<input type="hidden" name="pid" value="${product.pid}" >
			
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑商品</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="pname" value="${product.pname}" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						
						<select  id="is_hot" name="is_hot">
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						市场价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="market_price" value="${product.market_price}" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商城价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="shop_price" value="${product.shop_price}" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品图片：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="file" name="upload" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属分类：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<select id="cid" name="cid">
							<c:forEach items="${categoryList}" var="category">
								<option value="${category.cid}">${category.cname}</option>
							</c:forEach>


							<option value="">大型电器</option>
							<option value="">手机数码</option>
							<option value="">衣帽箱包</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="pdesc" rows="5" cols="30">${product.pdesc}</textarea>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							确定
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>