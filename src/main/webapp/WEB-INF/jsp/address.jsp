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
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="../../assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../../assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="../../assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../assets/css/amazeui.datatables.min.css" />
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
                                <div class="widget-title  am-cf">地址列表</div>

                            </div>
                            <div class="widget-body  am-fr">

                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                                    <div class="am-form-group">

                                    </div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                                    <div class="am-form-group tpl-table-list-select">
                                    </div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
                                    <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                        <input type="text" class="am-form-field ">
                                        <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>
          </span>
                                    </div>
                                </div>

                                <div class="am-u-sm-12">
                                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                        <thead>
                                            <tr>
                                                <th>地址id</th>
                                                <th>详细地址</th>
                                                <th>配送员姓名</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody id="page">

                                            <!-- more data -->
                                        </tbody>
                                    </table>
                                </div>
                                <div class="am-u-lg-12 am-cf">

                                    <div class="am-fr am-u-lg-3">

                                        <ul data-am-widget="pagination"
                                            class="am-pagination am-pagination-select am-text-middle">

                                            <li class="am-pagination-prev ">
                                                <a href="javascript: void(0)" id="previous">上一页</a>
                                            </li>

                                            <li class="am-pagination-select">
                                                <select id="paging">

                                                </select>
                                            </li>

                                            <li class="am-pagination-next">
                                                <a href="javascript: void(0)" id="next">下一页</a>
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

    </div>
    <script src="../../assets/js/amazeui.min.js"></script>
    <script src="../../assets/js/amazeui.datatables.min.js"></script>
    <script src="../../assets/js/dataTables.responsive.min.js"></script>
    <script src="../../assets/js/app.js"></script>
    <script src="../../js/address.js"></script>

</body>

</html>