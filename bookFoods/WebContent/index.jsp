<%@page import="java.util.ArrayList"%>
<%@page import="com.fifth.bean.RestaurantsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/util.js"></script>

</head>
<%
      CustomerBean customerBean0=(CustomerBean)session.getAttribute("customerBean0");
              
  %>
<body>

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
						<li ><a href=" ./ResturantsServlet">餐厅</a></li>
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
					List<ShoppingCartItemBean> shoppingCartItemList=null;
					ShoppingCartItemBean shoppingCartItemBean0=null;
					if(customerBean0!=null){
						int current_id=customerBean0.getCustomer_id();
						ShoppingCartBiz shoppingCartBiz=new ShoppingCartBizImpl();
						shoppingCartBean=shoppingCartBiz.fetchshoppingCartByCustomer_id(current_id);
						if(shoppingCartBean==null){
							shoppingCartBiz.addShoppingCartByCustomer_id(current_id);
							shoppingCartBean=shoppingCartBiz.fetchshoppingCartByCustomer_id(current_id);
						}else{
						shoppingCartItemList=shoppingCartBiz.fetchshoppingCartItemByCustomer_id(current_id);
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
	<!-- banner -->
	<div class="banner">
		<div class="container">
			<div class="b_room">
				<div class="booking_room">
					<br />
					<div class="reservation">
						<div class="book-top">
							<div class="b-search">
								<div class="boo-lef">
									<i class="sear"></i>
									<p>查找</p>
								</div>
							</div>
							<div class="pick">
								<div class="boo-lef">
									<i class="sele"></i>
									<p>预订列表</p>
								</div>
							</div>
							<div class="delv">
								<div class="boo-lef">
									<i class="ca-r"></i>
									<p>购物车</p>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<form action="./SearchRestaurant">
					<ul>
							<li class="span1_of_1">
								<!----------start section_room----------->
																																									
									<input type="text" class="textbox" value="Resturant Name" name="rsname"
										onfocus="this.value = '';"
										onblur="if (this.value == '') {this.value = 'Resturant Name';}">
								
							</li>
							<li class="span1_of_1">
								<!----------start section_room----------->
								<div class="section_room">
									<select id="country" onchange="change_country(this.value)" name="restaurant_location"
										class="frm-field required">
										<option value="null">城市</option>
										<option value="null">热门地区</option>
										<option value="北京">北京</option>
										<option value="太原">太原</option>
									</select>
								</div>
							</li>
							<li class="span1_of_3">
								<div class="date_btn">
									
										<input type="submit" value="查找餐厅">
									
								</div>
							</li>
							<div class="clearfix"></div>
						</ul>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- banner -->
	<!-- latis -->
	<div class="latis">
		<div class="container">
			<%
			ArrayList<FoodsBean> foodlist =(ArrayList<FoodsBean>)request.getAttribute("foodlist");
			if(foodlist!=null){
			for(FoodsBean foodsBean : foodlist){
				%>
				
			<div class="col-md-4 latis-left">
				<h3><%=foodsBean.getFood_name() %></h3>
				<img src="images/<%=foodsBean.getFood_img() %>" style="height:170px;width:260px" class="img-responsive" alt="" >
				<div class="special-info grid_1 simpleCart_shelfItem">
					<p>现在可以支持预订</p>
					<div class="cur">
						<div class="cur-left">
							<div class="item_add">
							<input type="hidden" value="<%=foodsBean.getFood_id()%>"
								    name="food_id" fid="<%=foodsBean.getFood_id()%>" class="foodid"/>
							<input type="hidden" value="<%=foodsBean.getFood_price() %>"
								    name="food_price" fprice="<%=foodsBean.getFood_price() %>" class="fprice"/>
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
								<span class="add">
								<a class="morebtn hvr-rectangle-in" href="#">添加到购物车</a></span>
							</div>
						</div>
						<div class="cur-right">
							<div class="item_add">
								<span class="item_price"><h6 id="price"><%=foodsBean.getFood_price() %></h6></span>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			

	<%
			}
			}
			%>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- latis -->
	<!-- feature -->

	<div class="feature">
		<div class="container">
			<div class="fle-xsel">
				<ul id="flexiselDemo3">

					<%
						@SuppressWarnings("unchecked")
					List<RestaurantsBean> restaurantsBeanList = (List<RestaurantsBean>)request.getAttribute("restaurantsBeanList");
					if(restaurantsBeanList!=null){
						
					for(RestaurantsBean bean:restaurantsBeanList){
					%>

					<li><img src="images/<%=bean.getRestaurant_img()%>"
						class="img-responsive" width="120px" alt=""></li>
					<%
						}
					}else{
					%>
					<h3 class="animate-onscroll no-margin-top">无结果</h3>
					<%
						}
					%>


				</ul>

				<script type="text/javascript">
					$(window).load(function() {

						$("#flexiselDemo3").flexisel({
							visibleItems : 8,
							animationSpeed : 1000,
							autoPlay : true,
							autoPlaySpeed : 3000,
							pauseOnHover : true,
							enableResponsiveBreakpoints : true,
							responsiveBreakpoints : {
								portrait : {
									changePoint : 480,
									visibleItems : 1
								},
								landscape : {
									changePoint : 640,
									visibleItems : 2
								},
								tablet : {
									changePoint : 768,
									visibleItems : 3
								}
							}
						});

					});
				</script>
				<script type="text/javascript" src="js/jquery.flexisel.js"></script>
				<div class="clearfix"></div>

			</div>
		</div>
	</div>

	<!-- feature -->
	<!-- magnust -->
	<div class="magnust">
		<div class="container">
			<h3>店主推荐</h3>
			<div class="col-md-4 magnust-top">

				<div class="magnust-left">
					<img src="images/9b.jpg" class="img-responsive" alt="">
				</div>
				<div class="magnust-right">
					<h4>
						<a href="#">黑胡椒鸡柳套餐</a>
					</h4>
					<p>仅售13.9元，价值20元温迪店鸡柳套餐！极入味的香气与外皮，扑鼻而来满是胡椒香气，肉质柔暖而不干涩，咬下去尽享外酥内嫩的满足！</p>
					<a class="see" href="#">更多</a>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="col-md-4 magnust-top">
				<div class="magnust-left">
					<img src="images/8b.jpg" class="img-responsive" alt="">
				</div>
				<div class="magnust-right">
					<h4>
						<a href="#">猕猴桃汁</a>
					</h4>
					<p>猕猴桃汁，食疗作用是 清热生津，健脾止泻，止渴利尿</p>
					<a class="see" href="#">更多</a>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="col-md-4 magnust-top">
				<div class="magnust-left">
					<img src="images/10b.jpg" class="img-responsive" alt="">
				</div>
				<div class="magnust-right">
					<h4>
						<a href="#">加利福尼亚式比萨</a>
					</h4>
					<p>加利福尼亚式比萨的定义特色之一是饼顶馅料。松脆的口感、饼底较轻、多孔并且松软，是批萨不可多得的精品。</p>
					<a class="see" href="#">更多</a>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- magnust -->
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
	<script type="text/javascript">
	$(".add").click(
			function() {
				singleprice = $(this).parent().find(".fprice").attr("fprice");
				singleprice = parseFloat(singleprice);
				fid=$(this).parent().find(".foodid").attr("fid");
				<%
				if(customerBean0==null){
				%>
					alert("请先登录！");
					window.location.href("login.jsp");
				<%
				}else{}
				%>
				cid=$(this).parent().find(".customerid").attr("cid");
				sid=$(this).parent().find(".shoppingCartid").attr("sid");
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
</body>
</html>