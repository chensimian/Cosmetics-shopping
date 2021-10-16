<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/2
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--    引入初始化样式文件-->
    <link rel="stylesheet" href="css/base.css">
    <!--    引入公共样式文件-->
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/goods.css">
    <link rel="stylesheet" href="layui/css/layui.css">
    <!--    引入favicon图标-->
    <link rel="shortcut icon" href="favicon.ico" >
    <script type="text/javascript" src="js/jquery.min.js"></script>
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
        <input type="search" name="" id="" placeholder="语言开发"><button>&nbsp;搜索</button>
    </div>
    <div class="hotword">
        <ul id="goodsType">


        </ul>
    </div>
    <!--    购物车模块-->
    <%--  <a href="${pageContext.request.contextPath}/getCart" id="shorpcar">购物车</a>--%>

    <div class="shopcar"><a href="${pageContext.request.contextPath}/getCart" >购物车</a></div>
</header>
<!--回到顶部-->
<button id="test" class="totop">回到顶部</button>
<div class="td"></div>
<div class="w clearfix" >
    <div class="dp">
        <a href="#"><img src="${pageContext.request.contextPath}/image/${goods.picture}"></a>
    </div>
    <div class="df">
        <h3>${goods.name}</h3>
        <div class="price">
            <span>促销价：</span>
            <em>￥</em>
            <em>${goods.price}</em>
        </div>
        <div class="send clearfix" >
            <span>配送</span>
            <div class="address">
                <span>浙江温州</span>
                <span>至</span>
                <span>广东揭阳</span>
            </div>
            <div class="layui-input-block">
                <select name="interest" lay-filter="aihao">
                    <option value="0">快递包邮</option>
                    <option value="1" selected="">顺丰到付</option>
                </select>
            </div>
            <div>
                <h4>付款后七天后发货</h4>
            </div>
        </div>
        <div class="star">
            <span>评价：</span>
            <div id="test5"></div>

        </div>
        <div class="xianxi">
            <span>详细介绍：</span>

            <br>
            <p>上市时间:&nbsp;&nbsp;&nbsp;${goods.pubdate}</p> <br>
            <p>${goods.intro }</p>

        </div>
        <div class="buy">
            <a href="#" class="buy_1">购买</a>
            <a href="${pageContext.request.contextPath}/addCart?goodsId=${goods.id}&price=${goods.price}" class="shoppcar">加入购物车</a>
        </div>
    </div>
</div>
<div class="recom_t w">
    <span>商品搭配推荐</span>
</div>
<div class="recom w">
    <div class="recomm">
        <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title">
                <li class="layui-this">推荐1</li>
                <li>推荐2</li>
                <li>推荐3</li>
                <li>推荐4</li>
                <li>推荐5</li>
            </ul>
            <div class="layui-tab-content" style="height: 260px">
                <div class="layui-tab-item layui-show">
                    <div class="recom_m">
                        <div class="recom_pic" >
                            <%--                            <a href="goods_2.html"><img src="image/04_pic.png"></a>--%>
                            <a href="${pageContext.request.contextPath}/getGoodsById?id=${goods1.id}">
                                <img src="${pageContext.request.contextPath}/image/${goods1.picture}">
                            </a>
                        </div>
                        <div class="recom_show">
                            <div class="title" id="megs1">
                                <h3>${goods1.name}</h3>
                            </div>
                            <div class="starr">
                                <span>适搭程度：</span><div id="test6"></div>
                            </div>
                            <div class="introduce">
                                <p>${goods1.intro}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-tab-item">
                    <div class="recom_m">
                        <div class="recom_pic">
                            <a href="${pageContext.request.contextPath}/getGoodsById?id=${goods2.id}">
                                <img src="${pageContext.request.contextPath}/image/${goods2.picture}">
                            </a>
                        </div>
                        <div class="recom_show">
                            <div class="title">
                                <h3>${goods2.name}</h3>                            </div>
                            <div class="starr">
                                <span>适搭程度：</span><div id="test7"></div>
                            </div>
                            <div class="introduce">
                                <p>
                                <p>${goods2.intro}</p>

                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-tab-item"><div class="recom_m">
                    <div class="recom_pic">
                        <a href="${pageContext.request.contextPath}/getGoodsById?id=${goods3.id}">
                            <img src="${pageContext.request.contextPath}/image/${goods3.picture}">
                        </a>
                    </div>
                    <div class="recom_show">
                        <div class="title">
                            <h3>${goods3.name}</h3>
                        </div>
                        <div class="starr">
                            <span>适搭程度：</span><div id="test8"></div>
                        </div>
                        <div class="introduce">
                            <p>${goods1.intro}</p>

                        </div>
                    </div>
                </div></div>
                <div class="layui-tab-item"><div class="recom_m">
                    <div class="recom_pic">
                        <a href="${pageContext.request.contextPath}/getGoodsById?id=${goods4.id}">
                            <img src="${pageContext.request.contextPath}/image/${goods4.picture}">
                        </a>                    </div>
                    <div class="recom_show">
                        <div class="title">
                            <h3>${goods4.name}</h3>
                        </div>
                        <div class="starr">
                            <span>适搭程度：</span><div id="test9"></div>
                        </div>
                        <div class="introduce">
                            <p>${goods4.intro}</p>

                        </div>
                    </div>
                </div></div>
                <div class="layui-tab-item"><div class="recom_m">
                    <div class="recom_pic">
                        <a href="${pageContext.request.contextPath}/getGoodsById?id=${goods5.id}">
                            <img src="${pageContext.request.contextPath}/image/${goods5.picture}">
                        </a>                    </div>
                    <div class="recom_show">
                        <div class="title">
                            <h3>${goods5.name}</h3>
                        </div>
                        <div class="starr">
                            <span>适搭程度：</span><div id="test10"></div>
                        </div>
                        <div class="introduce">
                            <p>${goods5.intro}</p>

                        </div>
                    </div>
                </div></div>
            </div>
        </div>
    </div>
</div>
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
                <dd><a href="#">生活旅游/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt><a href="#">服务指南</a></dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅游/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt><a href="#">服务指南</a></dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅游/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt><a href="#">服务指南</a></dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅游/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt><a href="#">服务指南</a></dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅游/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt><a href="#">帮助中心</a></dt>
                <dd>
                    <img src="images/wx_cz.jpg">
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
            ,value: ${goods.star}
            ,text: true
            ,setText: function(value){
                //自定义文本的回调
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
            ,value: ${goods1.star}
            ,text: true
            ,setText: function(value){
                //自定义文本的回调
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
            elem: '#test7'
            ,value: ${goods2.star}
            ,text: true
            ,setText: function(value){
                //自定义文本的回调
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
            elem: '#test8'
            ,value: ${goods3.star}
            ,text: true
            ,setText: function(value){
                //自定义文本的回调
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
            elem: '#test9'
            ,value: ${goods4.star}
            ,text: true
            ,setText: function(value){
                //自定义文本的回调
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
            elem: '#test10'
            ,value: ${goods5.star}
            ,text: true
            ,setText: function(value){
                //自定义文本的回调
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
        // rate.render({
        //     elem: '#test6,#test7,#test8,#test9,#test10'
        //     ,value: 4.5
        //     ,half: true
        //     ,text: true
        //     ,setText: function(value){
        //         this.span.text(value);
        //     }
        // })
    });
</script>
</body>
</html>
