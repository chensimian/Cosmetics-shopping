<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/2
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--    引入初始化样式文件-->
    <link rel="stylesheet" href="css/base.css">
    <!--    引入公共样式文件-->
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/list.css">
    <link rel="stylesheet" href="layui/css/layui.css">
    <!--    引入favicon图标-->
    <link rel="shortcut icon" href="favicon.ico" >
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $.ajax({
                url:"${pageContext.request.contextPath}/goodsTypeAjax",
                method:"get",
                success:function(data){
                    var list = JSON.parse(data);
                    for(var t in list){
                        var a = $("<a href='${pageContext.request.contextPath}/getGoodsListByTypeId?typeid="+list[t].id+"'>"+list[t].name+"</a>");
                        $("#goodsType").append(a);
                    }
                },
                error:function(){
                    alert("失败");
                }
            })
        })
    </script>
</head>
<body>
<!--快捷导航模块-->
<section class="shortcut">
    <div class="w">
        <div class="fl">

            <ul>
                <c:if test="${empty loginUser}">
                    <a href="login.jsp" id="a_top">登录</a>

                    <a href="register.jsp" id="a_top">注册</a>
                </c:if>
                <c:if test="${not empty loginUser}">
                    <a href="userAddress?flag=show" id="a_top">${loginUser.username}</a>

                    <a href="userLogout" id="a_top">注销</a>

                    <a href="getOrderList" id="a_top">我的订单</a>
                </c:if>

                <a href="" id="a_top">消息通知</a>
            </ul>
        </div>
        <div class="fr">
            <ul>
                <li>我的订单</li>
                <li></li>
                <li class="arrow_icon">生涯经历</li>
                <li></li>
                <li>会员</li>
                <li></li>
                <li>企业采购</li>
                <li></li>
                <li class="arrow_icon">关注列表</li>
                <li></li>
                <li class="arrow_icon">客户服务</li>
                <li></li>
                <li class="arrow_icon">网站导航</li>
            </ul>
        </div>
    </div>
</section>
<!--头部模块制作-->
<header class="w header">
    <div class="logo">
        <h1>
            <a href="#" title="购物商场">购物商场</a>
        </h1>
    </div>
    <div class="search">
        <input type="search" name="" id="" placeholder="化妆品"><button>&nbsp;搜索</button>
    </div>
    <div class="hotword">
        <ul id="goodsType">
            <%--      <li><a href="#" class="style_red">求偶</a></li>--%>
            <%--      <li><a href="#">护肤</a></li>--%>
            <%--      <li><a href="#">彩妆</a></li>--%>
            <%--      <li><a href="#">男士专区</a></li>--%>
            <%--      <li><a href="#">母婴专区</a></li>--%>

        </ul>
    </div>
    <!--    购物车模块-->
    <%--  <a href="${pageContext.request.contextPath}/getCart" id="shorpcar">购物车</a>--%>

    <div class="shopcar"><a href="${pageContext.request.contextPath}/getCart" >购物车</a></div>
</header>
<!--商品列表部分-->
<div class="list">
    <div class="w">
        <div class="adv"></div>
        <div class="ll">
            <ul class="clearfix">
                <c:forEach items="${glist}" var="g" varStatus="i">
                    <li>
                        <a href="${pageContext.request.contextPath}/getGoodsById?id=${g.id}">
                            <img src="${pageContext.request.contextPath}/image/${g.picture}">
                            <div class="price clearfix">
                                <div class="current">￥${g.price}</div>
                            </div>
                            <h4>商品名称:<a href="#">${g.name}</a></h4>
                            <span class="anan">购物商城</span>
                            <span class="fire">热销产品</span>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<!--回到顶部-->
<button id="test" class="totop">回到顶部</button>
<!--底部模块-->
<footer class="footer">
    <div class="w">
        <div class="mod_service">
            <ul>
                <li>
                    <h5></h5>
                    <div class="service_txt">
                        <h4>正品保障</h4>
                        <p>正品保障，提供发票</p>
                    </div>
                </li>
                <li>
                    <h5></h5>
                    <div class="service_txt">
                        <h4>正品保障</h4>
                        <p>正品保障，提供发票</p>
                    </div>
                </li>
                <li>
                    <h5></h5>
                    <div class="service_txt">
                        <h4>正品保障</h4>
                        <p>正品保障，提供发票</p>
                    </div>
                </li>
                <li>
                    <h5></h5>
                    <div class="service_txt">
                        <h4>正品保障</h4>
                        <p>正品保障，提供发票</p>
                    </div>
                </li>
            </ul>
        </div>
        <div class="mod_help">
            <dl>
                <dt><a href="#" name="top" id="top">服务指南</a></dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt><a href="#">服务指南</a></dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt><a href="#">服务指南</a></dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt><a href="#">服务指南</a></dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt><a href="#">服务指南</a></dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt><a href="#">帮助中心</a></dt>
                <dd>
                    <img src="image/wx_cz.jpg">
                    品优购客户端
                </dd>
            </dl>
        </div>
        c
    </div>
</footer>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
    test.onclick = function(){
        document.body.scrollTop = document.documentElement.scrollTop = 0;
    }
</script>
<script>
    layui.use(['rate'], function(){
        var rate = layui.rate;
        //基础效果
        rate.render({
            elem: '#test1'
        })
        //自定义文本
        rate.render({
            elem: '#test5'
            ,value: 3
            ,text: true
            ,setText: function(value){ //自定义文本的回调
                var arrs = {
                    '1': '极差'
                    ,'2': '差'
                    ,'3': '中等'
                    ,'4': '好'
                    ,'5': '极好'
                };
                this.span.text(arrs[value] || ( value + "星"));
            }
        })
        rate.render({
            elem: '#test6'
            ,value: 1.5
            ,half: true
            ,text: true
            ,setText: function(value){
                this.span.text(value);
            }
        })
    });
</script>
</body>
</html>

