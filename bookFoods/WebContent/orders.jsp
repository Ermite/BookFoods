<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="com.fifth.bean.CustomerBean"%>
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
<script src="js/simpleCart.min.js">
	
</script>
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
						<li class="active"><a href="index.jsp">首页</a></li>
						<li><a href=" resturants.jsp">餐厅</a></li>
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
					<div class="cart box_1">
						<a href="./findAllShoppingCartItem">
							<h3>
								<span class="simpleCart_total"> $0.00 </span> (<span
									id="simpleCart_quantity" class="simpleCart_quantity"> 0
								</span> 项)<img src="images/bag.png" alt="">
							</h3>
						</a>
						<p>
							<a href="javascript:;" class="simpleCart_empty">空空如也</a>
						</p>
						<div class="clearfix"></div>
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
			<div class="order-top">
				<li class="data"><h4>Pizzas</h4>
					<p>Exotic Combo of Cheese & Basil</p>
					<P>Capsicum, Tomatoes, Onion</P>
					<P>Chicken Tikka & Cheese</P>
					<P>Chicken Stripse</P></li>
				<li class="data">
					<div class="special-info grid_1 simpleCart_shelfItem">
						<h4>价格</h4>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</li>
				<div class="clearfix"></div>
			</div>
			<div class="order-top">
				<li class="data"><h4>Burgers</h4>
					<p>Vegetable Patty With Coleslaw</p>
					<p>Fajita Paneer & Vegetable</p>
					<p>Chicken Patty With Vegetable</p>
					<p>Chicken Cut in Mexican Style</p></li>
				<li class="data">
					<div class="special-info grid_1 simpleCart_shelfItem">
						<h4>Price</h4>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</li>
				<div class="clearfix"></div>
			</div>
			<div class="order-top">
				<li class="data"><h4>Hot Dogs</h4>
					<p>Mixed Vegetable With Cheese</p>
					<p>Grilled Paneer & Vegetable</p>
					<p>Chicken Sausage With Mustard</p></li>
				<li class="data">
					<div class="special-info grid_1 simpleCart_shelfItem">
						<h4>Price</h4>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>

					</div>
				</li>
				<div class="clearfix"></div>
			</div>
			<div class="order-top">
				<li class="data"><h4>Desserts</h4>
					<p>(Black Forest/Truffle/Noughat)</p>
					<p>Apple Pie With Ice Cream</p></li>
				<li class="data">
					<div class="special-info grid_1 simpleCart_shelfItem">
						<h4>Price</h4>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>

					</div>
				</li>
				<div class="clearfix"></div>
			</div>
			<div class="order-top">
				<li class="data"><h4>Cold Beverages</h4>
					<p>Strawberry Milk Shake</p>
					<p>Chocolate Milk Shake</p></li>
				<li class="data">
					<div class="special-info grid_1 simpleCart_shelfItem">
						<h4>Price</h4>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>

					</div>
				</li>
				<div class="clearfix"></div>
			</div>
			<div class="order-top">
				<li class="data"><h4>Sandwiches</h4>
					<p>(Mint With Cheese Tomato)</p>
					<p>(Fresh Tomatoes, Cucumber)</p></li>
				<li class="data">
					<div class="special-info grid_1 simpleCart_shelfItem">
						<h4>Price</h4>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>

					</div>
				</li>

				<div class="clearfix"></div>
			</div>
			<div class="order-top">
				<li class="data"><h4>Exotic Cakes</h4>
					<p>Pineapple Flavoured Cream)</p>
					<p>A Chocolate Sponge Base</p></li>
				<li class="data">
					<div class="special-info grid_1 simpleCart_shelfItem">
						<h4>Price</h4>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</li>

				<div class="clearfix"></div>
			</div>
			<br />
			<div class="order-top">
				<li class="data"><h4>Ice Creams</h4>
					<p>Butter Scotch</p>
					<p>Pineapple</p>
					<p>Black Forest</p>
					<p>Chocolate with Orange</p></li>
				<li class="data">
					<div class="special-info grid_1 simpleCart_shelfItem">
						<h4>Price</h4>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="pre-top">
							<div class="pr-left">
								<div class="item_add">
									<span class="item_price"><h6>$30.00</h6></span>
								</div>
							</div>
							<div class="pr-right">
								<div class="item_add">
									<span class="item_price"><a href="#">不要啦</a></span>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</li>

				<div class="clearfix"></div>
			</div>
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
</html>