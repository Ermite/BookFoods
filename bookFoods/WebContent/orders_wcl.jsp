<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="com.fifth.bean.ShoppingCartBean"%>
<%@page import="com.fifth.wcl.biz.FoodsBizImpl"%>
<%@page import="com.fifth.wcl.biz.FoodsBiz"%>
<%@page import="com.fifth.bean.ShoppingCartItemBean"%>
<%@page import="com.fifth.wcl.biz.ShoppingCartBizImpl"%>
<%@page import="com.fifth.wcl.biz.ShoppingCartBiz"%>
<%@page import="com.fifth.bean.CustomerBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.fifth.bean.MenusBean"%>
<%@page import="com.fifth.bean.FoodsBean"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<html>
<head>


<title>外卖</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Spicemystery Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Libre+Baskerville:400,700'
	rel='stylesheet' type='text/css'>
<script src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />

<!-- <script src="js/simpleCart.min.js"></script> -->
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>

</head>
<%
      CustomerBean customerBean0=(CustomerBean)session.getAttribute("customerBean0");
              
  %>
<body>

<%
List<Map<FoodsBean,Integer>> foodslist=(List<Map<FoodsBean,Integer>>)request.getAttribute("foodslist");
List<MenusBean> menusBeanList=(List<MenusBean>)request.getAttribute("menusBeanList");
%>
	<!-- header -->
	<div class="head-top"></div>
	<div class="header">

		<div class="container">
			<div class="logo">
				<a href="index.jsp"><img src="images/logo.png"
					class="img-responsive" alt=""></a>
			</div>
			<div class="header-left">
				<div class="head-nav">
					<span class="menu"> </span>
					<ul>
						<li class="active"><a href="./IndexServlet">首页</a></li>
						<li><a href="./ResturantsServlet">餐厅</a></li>
						<li><a href="login.jsp">登录</a></li>
						<li><a href=" contact.jsp">联系我们</a></li>
						<div class="clearfix"></div>
					</ul>
					<!-- script-for-nav -->
					<script>
						$("span.menu").click(function() {
							$(".head-nav ul").slideToggle(300, function() {
								// Animation complete.
							});
						});
					</script>
					<!-- script-for-nav -->
				</div>
				<div class="header-right1">
					<%
						if(customerBean0==null){
					%>
					<a href="register.jsp">注册</a> <a href="login.jsp">登录</a>
					<%
						}else{
					%>
					<a href="#"><%=customerBean0.getCustomer_name()%></a>
					<%
						}
					%>
					
					
					
					<%
					ShoppingCartBean shoppingCartBean=null;
					if(customerBean0!=null){
						int current_id=customerBean0.getCustomer_id();
						ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
						ShoppingCartItemBean shoppingCartItemBean0=null;
						shoppingCartBean=shoppingCartBiz.fetchshoppingCartByCustomer_id(current_id);
						if(shoppingCartBean==null){
							shoppingCartBiz.addShoppingCartByCustomer_id(current_id);
							shoppingCartBean=shoppingCartBiz.fetchshoppingCartByCustomer_id(current_id);
						}else{
						List<ShoppingCartItemBean> shoppingCartItemList=shoppingCartBiz.fetchshoppingCartItemByCustomer_id(current_id);
				      if(shoppingCartItemList==null){
					%>
					购物车为空<a href="./ResturantsServlet">请先预定食物</a>
					<%
					}else{
						
					%>
					
					<% 
					//shoppingCartItemList 当前用户的购物车信息
					FoodsBiz foodsBiz=new FoodsBizImpl();
					FoodsBean foodsBean2=null;
					float total=0;
					int count=0;
					for(ShoppingCartItemBean cartItemBean:shoppingCartItemList){
						int shoppingCart_id=cartItemBean.getShoppingCart_id();
						foodsBean2=foodsBiz.fetchFoodById(cartItemBean.getFood_id());
						shoppingCartItemBean0=cartItemBean;
						float price=(float)foodsBean2.getFood_price();
						int num=cartItemBean.getFood_count();
						total+=price*num;
						count+=num;
						
					}
					%>
					
					
					<div class="cart box_1">
						<a href="checkout_wcl.jsp">
							<h3>
								<span class="simpleCart_total" id="simpleCart_total"><%=total %> </span> (<span
									id="simpleCart_quantity" class="simpleCart_quantity"> <%=count %>
								</span> 项)<img src="images/bag.png" alt="">
								
							</h3>
						</a>
						<p>
							<a href="#" class="simpleCart_empty">清空购物车</a>
							<input type="hidden"  value="<%=customerBean0.getCustomer_id()%>"
						    name="customer_id" cid="<%=customerBean0.getCustomer_id()%>" class="customerid"/>
						</p>
						<div class="clearfix"></div>
						
							<%
					 }
					}
					
				} 
				%>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- header -->
	<!-- about -->
	<div class="orders">
		<div class="container">
		<%
		if(menusBeanList!=null&&foodslist!=null){
			for(MenusBean menusBean:menusBeanList){
		%>
		<div class="order-top">
				<li class="data">
				<h4><%=menusBean.getMenu_name() %></h4>
				<%
				for(Map<FoodsBean,Integer> map:foodslist){
					 Set<Map.Entry<FoodsBean,Integer>> allSet = null ;
					 allSet = map.entrySet() ; 
				     Iterator<Map.Entry<FoodsBean,Integer>> iter = null ; 
				        iter = allSet.iterator() ; 
					if(map.containsValue(menusBean.getMenu_id())){
						 while(iter.hasNext()){ 
					            Map.Entry<FoodsBean,Integer> me = iter.next() ; 
					            FoodsBean foodsBean=new FoodsBean();
					            foodsBean=me.getKey();
				%>
				
				
                <img src="images/<%=foodsBean.getFood_img() %>" height="90dp" width="125dp"/>
                <p><%=foodsBean.getFood_name() %></p>
				
				<%
					} 
			      }
			    }
				%>
				</li>
				
				<li class="data">
					<div class="special-info grid_1 simpleCart_shelfItem">
						<h4>价格</h4>
						
				<%
				for(Map<FoodsBean,Integer> map:foodslist){
					 Set<Map.Entry<FoodsBean,Integer>> allSet = null ;
					 allSet = map.entrySet() ; 
				     Iterator<Map.Entry<FoodsBean,Integer>> iter = null ; 
				        iter = allSet.iterator() ; 
					if(map.containsValue(menusBean.getMenu_id())){
						 while(iter.hasNext()){ 
					            Map.Entry<FoodsBean,Integer> me = iter.next() ; 
					            FoodsBean foodsBean=new FoodsBean();
					            foodsBean=me.getKey();
				%>
				
				<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6 id="price"><%=foodsBean.getFood_price() %></h6>元/份</br></br><br></span>
									
									<input type="hidden" value="<%=foodsBean.getFood_id()%>"
								    name="food_id" fid="<%=foodsBean.getFood_id()%>" class="foodid"/>
								    <%
								    if(customerBean0!=null){
								    %>
								    <input type="hidden"  value="<%=customerBean0.getCustomer_id()%>"
								    name="customer_id" cid="<%=customerBean0.getCustomer_id()%>" class="customerid"/>
								    <input type="hidden" value="<%=shoppingCartBean.getShoppingCart_id()%>"
								    name="shoppingCart_id" sid="<%=shoppingCartBean.getShoppingCart_id()%>" class="shoppingCartid"/>
								    <%
								    }
								    %>
								   
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="add"><a href="#">添加到购物车</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
				</div>
				
				<%
					} 
			      }
			    }
				%>
				
				
					</div>
				</li>
				<div class="clearfix"></div>
			</div>
		
		<%
			}
		}else{
			out.print("空");
		}
		%>
			
			
			<br />
		</div>
	</div>
	<!-- about -->
	<!-- footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-left">
				<p>
					Copyrights © 2015 SpiceMystery All rights reserved | Design by <a
						href="http://w3layouts.com/">Android一班第五组</a>
				</p>
			</div>

			<div class="clearfix"></div>
		</div>
	</div>
	<!-- footer-->
</body>

<script type="text/javascript">
	$(".add").click(
			function() {
				singleprice = $(this).parent().parent().parent().find("#price").html();
				singleprice = parseFloat(singleprice);
				fid=$(this).parent().parent().parent().find(".foodid").attr("fid");
				<%
				if(customerBean0==null){
				%>
					alert("请先登录！");
					window.location.href("login.jsp");
				<%
				}else{
					
				}
				%>
				cid=$(this).parent().parent().parent().find(".customerid").attr("cid");
				sid=$(this).parent().parent().parent().find(".shoppingCartid").attr("sid");
				total = $("#simpleCart_total").html();
				count = $("#simpleCart_quantity").html();
				total = parseFloat(total) + singleprice;
				count = parseInt(count) + 1;
				$("#simpleCart_total").html("" + total);
				$("#simpleCart_quantity").html("" + count);
				$.post('./UpdateShoppingCard',{food_id:fid,customer_id:cid,shoppingCart_id:sid},function(data){
					if(data=='1'){
					}
				});
			});
	$(".simpleCart_empty").click(
			function() {
				cid=$(this).parent().find(".customerid").attr("cid");
				total = $("#simpleCart_total").html();
				count = $("#simpleCart_quantity").html();
				total = 0.0;
				count = 0;
				$("#simpleCart_total").html("" + total);
				$("#simpleCart_quantity").html("" + count);
				$.post('./ClearShoppingCartServlet',{customer_id:cid},function(data){
					if(data=='1'){
					}
				});
			});
	
</script>	
</html>