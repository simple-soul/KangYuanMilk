<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>主页</title>
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

<body data-type="index">
<script src="../../assets/js/theme.js"></script>
<div class="am-g tpl-g">

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">

        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 首页
                        <small>康源乳业</small>
                    </div>
                    <p class="page-header-description">扬州市扬大康源乳业有限公司是2009年11月由扬州大学实验农牧场（建立于1952年）在原扬大乳业的基础上申请注册成立的国有全资公司，注册资金5000万元。公司主要从事饲料种植、奶牛饲养、乳品加工及销售服务，年销售产值过亿元，现已成为苏中地区规模最大、设备最新、环境最优的乳制品生产企业。</p>
                </div>
                <div class="am-u-lg-3 tpl-index-settings-button">
                    <button type="button" class="page-header-button"><span class="am-icon-paint-brush"></span> 设置
                    </button>
                </div>
            </div>

        </div>

        <div class="row-content am-cf">
            <div class="row  am-cf">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">月度财务收支计划</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body am-fr">
                            <div class="am-fl">
                                <div class="widget-fluctuation-period-text">
                                    ￥61746.45
                                    <button class="widget-fluctuation-tpl-btn">
                                        <i class="am-icon-calendar"></i>
                                        更多月份
                                    </button>
                                </div>
                            </div>
                            <div class="am-fr am-cf">
                                <div class="widget-fluctuation-description-amount text-success" am-cf>
                                    +￥30420.56

                                </div>
                                <div class="widget-fluctuation-description-text am-text-right">
                                    8月份收入
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                    <div class="widget widget-primary am-cf">
                        <div class="widget-statistic-header">
                            本季度利润
                        </div>
                        <div class="widget-statistic-body">
                            <div class="widget-statistic-value">
                                ￥27,294
                            </div>
                            <div class="widget-statistic-description">
                                本季度比去年多收入 <strong>2593元</strong> 人民币
                            </div>
                            <span class="widget-statistic-icon am-icon-credit-card-alt"></span>
                        </div>
                    </div>
                </div>
                <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                    <div class="widget widget-purple am-cf">
                        <div class="widget-statistic-header">
                            本季度利润
                        </div>
                        <div class="widget-statistic-body">
                            <div class="widget-statistic-value">
                                ￥27,294
                            </div>
                            <div class="widget-statistic-description">
                                本季度比去年多收入 <strong>2593元</strong> 人民币
                            </div>
                            <span class="widget-statistic-icon am-icon-support"></span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row am-cf">
                <div class="am-u-sm-12 am-u-md-8">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">月度财务收支计划</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body-md widget-body tpl-amendment-echarts am-fr" id="tpl-echarts">

                        </div>
                    </div>
                </div>

                <div class="am-u-sm-12 am-u-md-4">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">专用服务器负载</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body widget-body-md am-fr">

                            <div class="am-progress-title">CPU Load <span class="am-fr am-progress-title-more">28% / 100%</span>
                            </div>
                            <div class="am-progress">
                                <div class="am-progress-bar" style="width: 15%"></div>
                            </div>
                            <div class="am-progress-title">CPU Load <span class="am-fr am-progress-title-more">28% / 100%</span>
                            </div>
                            <div class="am-progress">
                                <div class="am-progress-bar  am-progress-bar-warning" style="width: 75%"></div>
                            </div>
                            <div class="am-progress-title">CPU Load <span class="am-fr am-progress-title-more">28% / 100%</span>
                            </div>
                            <div class="am-progress">
                                <div class="am-progress-bar am-progress-bar-danger" style="width: 35%"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row am-cf">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-4 widget-margin-bottom-lg ">
                    <div class="tpl-user-card am-text-center widget-body-lg">
                        <div class="tpl-user-card-title">
                            张华
                        </div>
                        <div class="achievement-subheading">
                            月度最佳员工
                        </div>
                        <img class="achievement-image" src="../../assets/img/user07.png" alt="">
                        <div class="achievement-description">
                            张华在一个月内配送了3万单牛奶
                        </div>
                    </div>
                </div>

                <div class="am-u-sm-12 am-u-md-12 am-u-lg-8 widget-margin-bottom-lg">

                    <div class="widget am-cf widget-body-lg">

                        <div class="widget-body  am-fr">
                            <div class="am-scrollable-horizontal ">
                                <table width="100%" class="am-table am-table-compact am-text-nowrap tpl-table-black "
                                       id="example-r">
                                    <thead>
                                    <tr>
                                        <th>文章标题</th>
                                        <th>作者</th>
                                        <th>时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr class="gradeX">
                                        <td>扬大康源乳业燕麦草招标公告</td>
                                        <td>张鹏飞</td>
                                        <td>2017-06-28</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>生态智慧牧场清刮粪处理系统购置招标公告</td>
                                        <td>天纵之人</td>
                                        <td>2017-06-23</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="gradeX">
                                        <td>扬大康源乳业乳品运输服务(二次)招标公告</td>
                                        <td>王宽师</td>
                                        <td>2017-04-17</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>扬大康源乳业喜获中国乳制品工业协会科技进步三等奖</td>
                                        <td>着迷</td>
                                        <td>2017-08-29</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>扬大康源乳业切割焊接操作间等改造工程采购信息</td>
                                        <td>醉里挑灯看键</td>
                                        <td>2017-03-08</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>

                                    <!-- more data -->
                                    </tbody>
                                </table>
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
<script src="../../js/index.js"></script>

</body>

</html>