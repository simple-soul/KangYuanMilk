<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>欢迎登录</title>
    <meta name="description" content="这是一个 login 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="../../assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed"
          href="../../assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="../../assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="../../assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="../../assets/css/app.css">
    <script src="../../assets/js/jquery.min.js"></script>
    <script src="../../js/lib/md5.js"></script>
    <script src="../../js/lib/jquery.cookie.js"></script>
    <script src="../../js/lib/serialize.js"></script>
    <style type="text/css">
        #content_forget {
            margin-top: 5px;
            margin-bottom: 15px;
        }
    </style>
</head>

<body data-type="login" class="theme-white">
<script src="../../assets/js/theme.js"></script>

<div class="am-g tpl-g">
    <!-- 风格切换 -->
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
        <div class="tpl-skiner-content">
            <div class="tpl-skiner-content-title">
                选择主题
            </div>
            <div class="tpl-skiner-content-bar">
                <span class="skiner-color skiner-white"
                      data-color="theme-white"></span>
                <span class="skiner-color skiner-black"
                      data-color="theme-black"></span>
            </div>
        </div>
    </div>
    <div class="tpl-login">
        <div class="tpl-login-content" id="content_login">
            <div class="tpl-login-logo">

            </div>

            <%--登录表单--%>
            <form class="am-form tpl-form-line-form" id="login">
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" id="user-name"
                           name="username" placeholder="请输入账号">
                </div>
                <div class="am-alert am-alert-danger" data-am-alert
                     hidden="hidden" id="alert_username">
                    <button type="button" class="am-close">&times;</button>
                    <p></p>
                </div>

                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="user-pass"
                           name="password" placeholder="请输入密码">
                </div>
                <div class="am-alert am-alert-danger" data-am-alert
                     hidden="hidden" id="alert_password">
                    <button type="button" class="am-close">&times;</button>
                    <p></p>
                </div>

                <div class="am-form-inline">

                    <div class="am-form-group">
                        <input type="text" id="doc-ipt-error"
                               class="am-form-field" name="code"
                               placeholder="验证码">

                    </div>
                    <div class="am-form-group">

                        <img src="${pageContext.request.contextPath}/getCode"
                             id="image" class="am-img-responsive">

                    </div>

                </div>

                <div class="am-alert am-alert-danger" data-am-alert
                     hidden="hidden" id="alert_code">
                    <button type="button" class="am-close">&times;</button>
                    <p></p>
                </div>

                <div class="am-form-group tpl-login-remember-me">
                    <input id="remember-me" type="checkbox" name="remember"
                           value="true">
                    <label for="remember-me">
                        记住一周
                    </label>
                </div>

                <div class="am-alert am-alert-danger" data-am-alert
                     hidden="hidden" id="alert_all">
                    <button type="button" class="am-close">&times;</button>
                    <p></p>
                </div>

                <div class="am-form-group">

                    <button type="button" id="submitFrom"
                            class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">
                        提交
                    </button>

                </div>

            </form>
            <%--忘记密码--%>
            <div class="am-text-sm">
                <a data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}">忘记密码</a>
            </div>
        </div>
    </div>
    <%--忘记密码表单--%>
    <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1"
         hidden="hidden">

        <div class="am-modal-dialog">
            <div class="am-modal-hd">忘记密码
                <a href="javascript: void(0)" class="am-close am-close-spin"
                   data-am-modal-close>&times;</a>
            </div>

            <hr data-am-widget="divider" style=""
                class="am-divider am-divider-default"/>

            <div class="am-modal-bd">
                <div class="tpl-login-content" id="content_forget">
                    <form class="am-form tpl-form-line-form" id="forget">

                        <div class="am-form-group">
                            <input type="text" class="tpl-form-input"
                                   id="forget_name" name="staff_name"
                                   placeholder="请输入姓名">
                        </div>
                        <div class="am-alert am-alert-danger" data-am-alert
                             hidden="hidden" id="alert_name">
                            <button type="button" class="am-close">&times;
                            </button>
                            <p></p>
                        </div>

                        <div class="am-form-group">
                            <input type="text" class="tpl-form-input"
                                   id="forget_idcard"
                                   name="staff_idcard"
                                   placeholder="请输入身份证号码">
                        </div>
                        <div class="am-alert am-alert-danger" data-am-alert
                             hidden="hidden" id="alert_idcard">
                            <button type="button" class="am-close">&times;
                            </button>
                            <p></p>
                        </div>

                        <div class="am-form-group">
                            <input type="text" class="tpl-form-input"
                                   id="forget_tel" name="staff_tel"
                                   placeholder="请输入电话号码">
                        </div>
                        <div class="am-alert am-alert-danger" data-am-alert
                             hidden="hidden" id="alert_tel">
                            <button type="button" class="am-close">&times;
                            </button>
                            <p></p>
                        </div>

                        <div class="am-form-group">
                            <input type="password" class="tpl-form-input"
                                   name="staff_pwd" id="forget_pass"
                                   placeholder="请输入密码">
                        </div>

                        <div class="am-form-group">
                            <input type="password" class="tpl-form-input"
                                   name="double_password" id="forget_dou_pass"
                                   placeholder="请重复密码">
                        </div>
                        <div class="am-alert am-alert-danger" data-am-alert
                             hidden="hidden" id="alert_pass">
                            <button type="button" class="am-close">&times;
                            </button>
                            <p></p>
                        </div>

                        <div class="am-form-group">
                            <button type="button" id="submitForget"
                                    class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success data-am-modal-close">
                                提交
                            </button>
                        </div>
                        <div class="am-alert am-alert-danger" data-am-alert
                             hidden="hidden" id="alert_forget">
                            <button type="button" class="am-close">&times;
                            </button>
                            <p></p>
                        </div>

                    </form>

                </div>
            </div>
        </div>

    </div>
</div>

<script src="../../js/login.js"></script>
<script src="../../assets/js/amazeui.min.js"></script>
<script src="../../assets/js/app.js"></script>
</body>

</html>