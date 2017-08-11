<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="../../assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../../assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <script src="../../assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="../../assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="../../assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="../../assets/css/app.css">
    <script src="../../assets/js/jquery.min.js"></script>
    <script src="../../js/lib/md5.js"></script>
    <script src="../../js/lib/jquery.cookie.js"></script>
    <script src="../../js/lib/serialize.js"></script>

</head>

<body data-type="widgets">
<script src="../../assets/js/theme.js"></script>
<div class="am-g tpl-g">

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">文章列表</div>

                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                                <div class="am-form-group">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" class="am-btn am-btn-default am-btn-success" data-am-modal="{target: '#my-insert'}" id="add">
                                                <span class="am-icon-plus"></span> 新增
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                                <div class="am-form-group tpl-table-list-select">
                                    <select data-am-selected="{btnSize: 'sm'}" id="level">
                                        <option value="null">所有员工</option>
                                        <option value="0">配送员</option>
                                        <option value="1">管理员</option>
                                        <option value="2">boss</option>
                                    </select>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" class="am-form-field" id="search_input">
                                    <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
                    type="button" id="search"></button>
          </span>
                                </div>
                            </div>

                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black "
                                       id="example-r">
                                    <thead>
                                    <tr>
                                        <th>员工编码</th>
                                        <th>姓名</th>
                                        <th>用户名</th>
                                        <th>性别</th>
                                        <th>电话号码</th>
                                        <th>职位</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="page">

                                    <!-- more data -->
                                    </tbody>
                                </table>

                                <%--错误提示--%>
                                <div class="am-alert am-alert-danger" data-am-alert hidden="hidden" id="alert_error">
                                    <button type="button" class="am-close">&times;</button>
                                    <p></p>
                                </div>

                            </div>
                            <div class="am-u-lg-12 ">

                                <div class="am-fr am-u-lg-3">

                                    <ul data-am-widget="pagination"
                                        class="am-pagination am-pagination-select am-text-middle">

                                        <li class="am-pagination-prev ">
                                            <a href="#" id="previous">上一页</a>
                                        </li>

                                        <li class="am-pagination-select">
                                            <select id="paging">

                                            </select>
                                        </li>

                                        <li class="am-pagination-next">
                                            <a href="#" id="next">下一页</a>
                                        </li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%--删除用户信息--%>
    <div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">你确定要删除这条信息吗?</div>

            <div class="am-modal-bd"></div>
            <%--分割线--%>

            <div class="am-modal-footer">
                <span class="am-modal-btn" id="ok">确定</span>
                <span class="am-modal-btn" id="cancel">取消</span>
            </div>
        </div>
    </div>

    <%--修改用户信息--%>
    <div class="am-modal am-modal-no-btn" tabindex="-1" id="my-model">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">员工信息修改
                <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
            </div>
            <%--分割线--%>
            <hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
            <%--内容--%>
            <div class="am-modal-bd">
                <div class="tpl-login-content">
                    <form id="modify" class="am-form tpl-form-line-form">
                        <div class="am-form-group">
                            <label>员工编号：</label>
                            <input name="staff_id" type="text" id="id" minlength="1" readonly="readonly" required/>
                        </div>

                        <div class="am-form-group">
                            <label>姓名：</label>
                            <input type="text" id="name" name="staff_name" minlength="2" required/>
                        </div>

                        <div class="am-form-group">
                            <label for="username">用户名：</label>
                            <input type="text" id="username" name="staff_username" minlength="2" maxlength="10" required/>
                        </div>

                        <div class="am-form-group">
                            <label for="tel">电话号码：</label>
                            <input type="number" id="tel" name="staff_tel" minlength="11" maxlength="11" required/>
                        </div>

                        <div class="am-form-group">
                            <label>性别：</label>
                            <label class="am-radio-inline">
                                <input type="radio" id="man" value="true" name="staff_sex"> 男
                            </label>
                            <label class="am-radio-inline">
                                <input type="radio" id="female" value="false" name="staff_sex"> 女
                            </label>
                        </div>

                        <div class="am-form-group">
                            <label for="select">职务</label>
                            <select id="select" name="staff_authority" required>
                                <option value="0">配送员</option>
                                <option value="1">管理员</option>
                                <option value="2">boss</option>
                            </select>
                            <span class="am-form-caret"></span>
                        </div>

                        <button class="am-btn am-btn-secondary" id="submit" type="button" data-am-modal-close>确定
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%--添加用户--%>
    <div class="am-modal am-modal-no-btn" tabindex="-1" id="my-insert">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">添加员工
                <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
            </div>
            <%--分割线--%>
            <hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
            <%--内容--%>
            <div class="am-modal-bd">
                <div class="tpl-login-content">
                    <form id="insert" class="am-form tpl-form-line-form">

                        <div class="am-form-group">
                            <label>姓名：</label>
                            <input type="text" id="insert_name" name="staff_name" minlength="2" required/>
                        </div>

                        <div class="am-form-group">
                            <label for="username">用户名：</label>
                            <input type="text" id="insert_username" name="staff_username" minlength="2" maxlength="10" required/>
                        </div>

                        <div class="am-form-group">
                            <label for="tel">身份证号码：</label>
                            <input type="text" id="insert_idcard" name="staff_idcard" minlength="18" maxlength="18" required/>
                        </div>

                        <div class="am-form-group">
                            <label for="tel">电话号码：</label>
                            <input type="number" id="insert_tel" name="staff_tel" minlength="11" maxlength="11" required/>
                        </div>

                        <div class="am-form-group">
                            <label>性别：</label>
                            <label class="am-radio-inline">
                                <input type="radio" id="insert_man" value="true" name="staff_sex"> 男
                            </label>
                            <label class="am-radio-inline">
                                <input type="radio" id="insert_female" value="false" name="staff_sex"> 女
                            </label>
                        </div>

                        <div class="am-form-group">
                            <label for="select">职务</label>
                            <select id="insert_select" name="staff_authority" required>
                                <option value="0">配送员</option>
                                <option value="1">管理员</option>
                                <option value="2">boss</option>
                            </select>
                            <span class="am-form-caret"></span>
                        </div>

                        <button class="am-btn am-btn-secondary" id="insert_submit" type="button" data-am-modal-close>确定
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../assets/js/amazeui.min.js"></script>
<script src="../../assets/js/amazeui.datatables.min.js"></script>
<script src="../../assets/js/dataTables.responsive.min.js"></script>
<script src="../../assets/js/app.js"></script>
<script src="../../js/staff.js"></script>

</body>

</html>