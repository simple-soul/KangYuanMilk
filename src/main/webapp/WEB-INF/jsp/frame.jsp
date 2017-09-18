<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>康源乳业后台管理系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="../../assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed"
          href="../../assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <script src="../../assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="../../assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="../../assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="../../assets/css/app.css">
    <script src="../../assets/js/jquery.min.js"></script>
    <script src="../../js/lib/md5.js"></script>
    <script src="../../js/lib/jquery.cookie.js"></script>
    <script src="../../js/lib/serialize.js"></script>
    <style type="text/css">
        .tpl-login-content {
            margin-top: 5px;
            margin-bottom: 15px;
        }

    </style>
</head>

<body data-type="widgets" class="theme-white">
<script src="../../assets/js/theme.js"></script>
<div class="am-g tpl-g">

    <!-- 头部 -->
    <header>
        <!-- logo -->
        <div class="am-fl tpl-header-logo">
            <a href="javascript:;"><img src="../../assets/logo.png" alt=""></a>
        </div>
        <!-- 右侧内容 -->
        <div class="tpl-header-fluid">
            <!-- 侧边切换 -->
            <%--<div class="am-fl tpl-header-switch-button am-icon-list">--%>
            <%--<span>--%>

            <%--</span>--%>
            <%--</div>--%>
            <!-- 搜索 -->
            <div class="am-fl tpl-header-search" hidden="hidden">
                <form class="tpl-header-search-form" action="javascript:;">
                    <button class="tpl-header-search-btn am-icon-search"></button>
                    <input class="tpl-header-search-box" type="text"
                           placeholder="搜索内容...">
                </form>
            </div>
            <!-- 其它功能-->
            <div class="am-fr tpl-header-navbar">
                <ul>
                    <!-- 欢迎语 -->
                    <li class="am-text-sm tpl-header-navbar-welcome">
                        <a href="javascript:;">欢迎你, <span>Amaze UI</span> </a>
                    </li>

                    <!-- 退出 -->
                    <li class="am-text-sm">
                        <a href="/login">
                            <span class="am-icon-sign-out"></span> 退出
                        </a>
                    </li>
                </ul>
            </div>
        </div>

    </header>
    <!-- 侧边导航栏 -->
    <div class="left-sidebar">
        <!-- 用户信息 -->
        <div class="tpl-sidebar-user-panel">
            <div class="tpl-user-panel-slide-toggleable">
                <div class="tpl-user-panel-profile-picture">
                    <img src="../../assets/head3.jpg" alt="">
                </div>
                <span class="user-panel-logged-in-text">
                  <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
                  <span>Tom</span>
                </span>
                <a data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}"
                   class="tpl-user-panel-action-link"> <span
                        class="am-icon-pencil"></span>
                    <span>修改密码</span>
                </a>

            </div>
        </div>

        <!-- 菜单 -->
        <ul class="sidebar-nav">
            <%--大标题--%>
            <%--<li class="sidebar-nav-heading">Components <span class="sidebar-nav-heading-info"> 附加组件</span></li>--%>
            <%--首页--%>
            <li class="sidebar-nav-link">
                <a id="index" class="active">
                    <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                </a>
            </li>
            <%--员工管理--%>
            <li class="sidebar-nav-link">
                <a id="staff">
                    <i class="am-icon-wpforms sidebar-nav-link-logo"></i> 员工管理
                </a>
            </li>
            <%--用户管理--%>
            <li class="sidebar-nav-link">
                <a id="user">
                    <i class="am-icon-wpforms sidebar-nav-link-logo"></i> 用户管理
                </a>
            </li>
            <%--地址管理--%>
            <li class="sidebar-nav-link">
                <a id="address">
                    <i class="am-icon-wpforms sidebar-nav-link-logo"></i> 地址管理
                </a>
            </li>
            <%--商城管理--%>
            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title" id="map">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 商城管理
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>

                <ul class="sidebar-nav sidebar-nav-sub">
                    <%--活动管理--%>
                    <li class="sidebar-nav-link">
                        <a id="activity">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span>
                            活动管理
                        </a>
                    </li>
                    <%--商品管理--%>
                    <li class="sidebar-nav-link">
                        <a id="goods">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span>
                            商品管理
                        </a>
                    </li>
                </ul>
            </li>
            <%--订单管理--%>
            <li class="sidebar-nav-link">
                <a id="order">
                    <i class="am-icon-wpforms sidebar-nav-link-logo"></i> 订单管理
                </a>
            </li>
            <%--我的配送单--%>
            <li class="sidebar-nav-link">
                <a id="myOrder">
                    <i class="am-icon-wpforms sidebar-nav-link-logo"></i> 我的配送单
                </a>
            </li>

        </ul>
    </div>
    <%--修改密码--%>
    <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">修改密码
                <a href="javascript: void(0)" class="am-close am-close-spin"
                   data-am-modal-close>&times;</a>
            </div>
            <%--分割线--%>
            <hr data-am-widget="divider" style=""
                class="am-divider am-divider-default"/>
            <%--内容--%>
            <div class="am-modal-bd">
                <div class="tpl-login-content">
                    <form class="am-form tpl-form-line-form"
                          id="changePassword">

                        <div class="am-form-group">
                            <input type="password" class="tpl-form-input"
                                   id="password"
                                   placeholder="请输入密码">
                        </div>

                        <div class="am-form-group">
                            <input type="password" class="tpl-form-input"
                                   id="double_password"
                                   placeholder="请重复密码">
                        </div>

                        <div class="am-alert am-alert-danger" data-am-alert
                             hidden="hidden" id="alert_pass">
                            <button type="button" class="am-close">&times;
                            </button>
                            <p></p>
                        </div>

                        <div class="am-form-group">
                            <button type="button" id="submit"
                                    class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">
                                提交
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>

    <iframe id="myFrame" src="/index2" frameBorder="0" width="100%"
            scrolling="yes" height="100%"></iframe>

</div>
<script src="../../assets/js/amazeui.min.js"></script>
<script src="../../assets/js/amazeui.datatables.min.js"></script>
<script src="../../assets/js/dataTables.responsive.min.js"></script>
<script src="../../assets/js/app.js"></script>
<script src="../../js/frame.js"></script>

</body>

</html>