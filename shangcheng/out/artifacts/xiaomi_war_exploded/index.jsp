<%--
  Created by IntelliJ IDEA.
  User: 86158
  Date: 2021/7/2
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>

  <!--    网站说明-->
  <meta name="description"
        content="品优购-专业的综合网上购物商城,销售家电、数码通讯、电脑、家居百货、服装服饰、母婴、图书、食品等数万个品牌优质商品.便捷、诚信的服务，为您提供愉悦的网上购物体验!"/>
  <meta name="Keywords" content="网上购物,网上商城,手机,笔记本,电脑,MP3,CD,VCD,DV,相机,数码,配件,手表,存储卡,品优购"/>
  <!--    引入初始化样式文件-->
  <link rel="stylesheet" type="text/css" href="css/login2.css">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/base.css">
  <!--    引入公共样式文件-->
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="layui/css/layui.css">
  <link rel="stylesheet" href="css/index.css">
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
  <span style="float:right">
           		<c:if test="${empty loginUser}">
                  <a href="login.jsp" id="a_top">登录</a>
                  <li>|</li>
                  <a href="register.jsp" id="a_top">注册</a>
                </c:if>
       			<c:if test="${not empty loginUser}">
                  <a href="userAddress?flag=show" id="a_top">${loginUser.username}</a>
                  <li>|</li>
                  <a href="userLogout" id="a_top">注销</a>
                  <li>|</li>
                  <a href="getOrderList" id="a_top">我的订单</a>
                </c:if>
                <li>|</li>
                <a href="" id="a_top">消息通知</a>

            </span>
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
    <input type="search" name="" id="" placeholder="护肤"><button>&nbsp;搜索</button>
  </div>
  <div class="hotword">
    <ul id="goodsType">
<%--      <li><a href="#" class="style_red">求偶</a></li>--%>
<%--      <li><a href="#">求偶</a></li>--%>
<%--      <li><a href="#">求偶</a></li>--%>
<%--      <li><a href="#">求偶</a></li>--%>
<%--      <li><a href="#">求偶</a></li>--%>
<%--      <li><a href="#">求偶</a></li>--%>
<%--      <li><a href="#">求偶</a></li>--%>
<%--      <li><a href="#">求偶</a></li>--%>
<%--      <li><a href="#">求偶</a></li>--%>
<%--      <li><a href="#">求偶</a></li>--%>
<%--      <li><a href="#">求偶</a></li>--%>
<%--      <li><a href="#">求偶</a></li>--%>

    </ul>
  </div>
  <!--    购物车模块-->
<%--  <a href="${pageContext.request.contextPath}/getCart" id="shorpcar">购物车</a>--%>

  <div class="shopcar"><a href="${pageContext.request.contextPath}/getCart" >购物车</a></div>
</header>
<!--首页模块-->
<div class="nav">
  <div class="w" >
    <div class="drowdown">
      <div class="dt">商品分类</div>
      <div class="dd">
        <ul>
          <li><a href="#">护肤</a></li>
          <li><a href="#">彩妆</a></li>
          <li><a href="#">男士专区</a></li>
          <li><a href="#">母婴专区</a></li>

        </ul>
      </div>
    </div>
    <div class="pic">
      <div class="layui-carousel" id="test10">
        <div carousel-item="">
          <div><img src="image/20130331_1_1.jpg"></div>
          <div><img src="image/20130331_1_2.jpg"></div>
          <div><img src="image/20130331_1_3.jpg"></div>
          <div><img src="image/20130331_1_4.jpg"></div>
          <div><img src="image/20130331_1_5.jpg"></div>
          <div><img src="image/20130331_1_6.jpg"></div>
          <div><img src="image/20130331_1_7.jpg"></div>
        </div>
      </div>
    </div>
    <div class="news">
      <div class="new_sup">
        <div class="new_hd">
          <h5>购物商场速报</h5>
          <a href="#" class="more">更多</a>
        </div>
        <div class="new_bd">
          <ul>
            <li><a href="#"><strong>【重磅】</strong>口红降价了！！</a></li>
            <li><a href="#"><strong>【重磅】</strong>口红降价了！！</a></li>
            <li><a href="#"><strong>【重磅】</strong>口红降价了！！</a></li>
            <li><a href="#"><strong>【重磅】</strong>口红降价了！！</a></li>
            <li><a href="#"><strong>【重磅】</strong>口红降价了！！</a></li>
          </ul>
        </div>
        <div class="new_click">
          <ul>
            <li><img src="image/7.jpg"><p>口红</p></li>
            <li><img src="image/7.jpg"><p>口红</p></li>
            <li><img src="image/7.jpg"><p>口红</p></li>
            <li><img src="image/7.jpg"><p>口红</p></li>
            <li><img src="image/7.jpg"><p>口红</p></li>
            <li><img src="image/7.jpg"><p>口红</p></li>
            <li><img src="image/7.jpg"><p>口红</p></li>
            <li><img src="image/7.jpg"><p>口红</p></li>
            <li><img src="image/7.jpg"><p>口红</p></li>
            <li><img src="image/7.jpg"><p>口红</p></li>
            <li><img src="image/7.jpg"><p>口红</p></li>
            <li><img src="image/7.jpg"><p>口红</p></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
<!--楼层模块-->
<div class="floor">
  <div class="w jiadian">
    <div class="box_hd">
      <h3>购物商城</h3>
      <div class="tab_list"><ul>
        <li><a href="#"class="style_red">热门</a>|</li>
        <li><a href="#">毛刷</a>|</li>
        <li><a href="#">化妆套装</a>|</li>
        <li><a href="#">洗面奶</a>|</li>
        <li><a href="#">素颜霜</a>|</li>
        <li><a href="#">爽肤水</a>|</li>
      </ul></div>
    </div>
    <div class="box_bd">
      <div class="tab_content">
        <div class="tab_list_item sign">
          <div class="col_210 ">
            <ul>
              <li><a href="">护肤</a></li>
              <li><a href="">彩妆</a></li>
              <li><a href="">男士专区</a></li>
              <li><a href="">母婴专区</a></li>
            </ul>
            <a href="#"><img src="image/03_pic.png" alt=""></a>
          </div>
         <div class="col_220">
            <a href="#">
              <img src="image/dian.jpg">
            </a>
         </div>
          <div class="col_220">
            <a href="#">
              <img src="image/dian.jpg">
            </a>
          </div>
          <div class="col_220">
            <a href="#">
              <img src="image/dian.jpg">
            </a>
          </div>
        </div>
      </div>
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
          <h5 class="p1"></h5>
          <div class="service_txt">
            <h4>正品保障</h4>
            <p>正品保障，提供发票</p>
          </div>
        </li>
        <li>
          <h5 class="p2"></h5>
          <div class="service_txt">
            <h4>极速物流</h4>
            <p>急速物流，急速送达</p>
          </div>
        </li>
        <li>
          <h5 class="p3"></h5>
          <div class="service_txt">
            <h4>无忧售后</h4>
            <p>7天无理由退换货</p>
          </div>
        </li>
        <li>
          <h5 class="p4"></h5>
          <div class="service_txt">
            <h4>帮助中心</h4>
            <p>您的购物指南</p>
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
        <dd><a href="#">团购</a></dd>
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
          <img src="image/wx_cz.jpg">
          品优购客户端
        </dd>
      </dl>
    </div>
    c
  </div>
</footer>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
  test.onclick = function(){
    document.body.scrollTop = document.documentElement.scrollTop = 0;
  }
  layui.use(['carousel', 'form'], function(){
    var carousel = layui.carousel
            ,form = layui.form;

    //图片轮播
    carousel.render({
      elem: '#test10'
      ,width: '700px'
      ,height: '460px'
      ,interval: 5000
    });

    //事件
    carousel.on('change(test4)', function(res){
      console.log(res)
    });

    var $ = layui.$, active = {
      set: function(othis){
        var THIS = 'layui-bg-normal'
                ,key = othis.data('key')
                ,options = {};

        othis.css('background-color', '#5FB878').siblings().removeAttr('style');
        options[key] = othis.data('value');
        ins3.reload(options);
      }
    };

    //监听开关
    form.on('switch(autoplay)', function(){
      ins3.reload({
        autoplay: this.checked
      });
    });

    $('.demoSet').on('keyup', function(){
      var value = this.value
              ,options = {};
      if(!/^\d+$/.test(value)) return;

      options[this.name] = value;
      ins3.reload(options);
    });

    //其它示例
    $('.demoTest .layui-btn').on('click', function(){
      var othis = $(this), type = othis.data('type');
      active[type] ? active[type].call(this, othis) : '';
    });
  });
</script>
</body>
</html>
