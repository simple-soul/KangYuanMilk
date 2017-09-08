var alert_error = $('#alert_error');
alert_error.hide();

var query = {
    key: null,
    level: null,
    num: 20,
    page:1
};

var lev = ['广告', '最新活动'];
//页面显示列表
var page = $('#page');
//分页
var paging = $('#paging');
//下一页
var next = $('#next');
//上一页
var previous = $('#previous');
//总共页数
var pages = 0;
//按等级筛选
var level = $('#level');
//搜索输入框
var search_input = $('#search_input');
//搜索按钮
var search_btn = $('#search');
//活动列表
var milks;
var domain;
var classify;

$.ajax("/android/other/getQiniu", {
    success: function (data)
    {
        domain = data.response.message;
        console.log("domain----->"+domain);
        //初始加载
        load(true);
    }
});

$.ajax("/shop/getClassify", {
    success: function (data) {
        classify = data.response.classify;
    }
});

function load(isPaging)
{
    $.ajax({
        url: "/shop/findMilk",
        type: "post",
        data: JSON.stringify(query),
        contentType: 'application/json',
        success: function (data)
        {
            if (data.status === 200)
            {
                var response = data.response;
                if (response.result === false)
                {
                    alert_error.find('p').text("数据出错");
                    alert_error.show();
                }
                else
                {
                    page.find('tr').remove();
                    milks = response.dataList;
                    var count = response.count;
                    console.log("dongxi====>"+milks[0].title);
                    //加载数据
                    for (var i = 0; i < milks.length; i++)
                    {
                        var url = "../../assets/img/user04.png";
                        console.log(milks[i].imageview);
                        if(milks[i].imageview !== null)
                        {
                            url = domain+milks[i].imageview;
                        }
                        console.log("i--->"+url);
                        page.append("<tr class=\"gradeX\">\n" +
                            "            <td>\n" +
                            "                <img src=\""+url+"\" class=\"tpl-table-line-img\" width=\"48\" height=\"48\">\n" +
                            "            </td>\n" +
                            "            <td class='am-text-middle'>" + milks[i].id + "</td>\n" +
                            "            <td class='am-text-middle'>" + milks[i].title + "</td>\n" +
                            "            <td class='am-text-middle'>" + milks[i].price + "</td>\n" +
                            "            <td class='am-text-middle'>" + milks[i].spec + "</td>\n" +
                            "            <td>\n" +
                            "                <div class=\"tpl-table-black-operation\">\n" +
                            "                    <a data-am-modal=\"{target: '#my-model'}\" id=\"bar-"+i+"\" name=\""+i+"\">\n" +
                            "                           <i class=\"am-icon-pencil\"></i> 编辑\n" +
                            "                    </a>\n" +
                            "                    <a data-am-modal=\"\" id='mod-"+i+"' name=\""+i+"\" \n" +
                            "                        <i class=\"am-icon-archive\"></i> 修改简介\n" +
                            "                    </a>\n" +
                            "                    <a data-am-modal=\"{target: '#my-alert'}\" id='del-"+i+"' name=\""+i+"\" class=\"tpl-table-black-operation-del\">\n" +
                            "                        <i class=\"am-icon-trash\"></i> 删除\n" +
                            "                    </a>\n" +
                            "                </div>\n" +
                            "            </td>\n" +
                            "        </tr>");
                    }
                    if (isPaging)
                    {
                        //加载分页标签
                        paging.find('option').remove();
                        var p = parseInt(count / 20);
                        var y = count % 20;
                        console.log("p=" + p + ", t=" + y);
                        if (y > 0) pages = p + 1;
                        else pages = p;

                        for (i = 1; i <= p + 1; i++)
                        {
                            paging.append("<option value=\"#\" name=\"" + i + "\">" + i + '/' + pages + "</option>");
                        }
                    }
                }
            }
            else if (data.status === 500)
            {
                alert_error.find('p').text("服务器错误!");
                alert_error.show();
            }
            else
            {
                alert_error.find('p').text("未知错误!");
                alert_error.show();
            }
        },
        error: function (e)
        {
            console.log(e);
        }
    });
}

paging.change(function ()
{
    var select = paging.find("option:selected").attr('name');
    query.page = select;
    load(false);
});

previous.click(function ()
{
    var select = paging.find("option:selected").attr('name');
    if (select - 1 > 0)
    {
        query.page = select - 1;
        load(false);
    }
});

next.click(function ()
{
    var select = paging.find("option:selected").attr('name');
    if (select + 1 <= pages)
    {
        query.page = select + 1;
        load(false);
    }
});

search_btn.click(function ()
{
    var key = search_input.val();
    query.key = key;
    query.page = 1;
    load(true);
});

//编辑员工信息
page.delegate('a[id^=bar-]', 'click', function(){

    var num = $(this).attr('name');
    console.log("num="+num);
    var milk = milks[num];
    $('#id').val(milk.id);
    $('#name').val(milk.title);
    $('#price').val(milk.price);
    $('#spec').val(milk.spec);
});

//编辑简介html
page.delegate('a[id^=mod-]', 'click', function(){

    var num = $(this).attr('name');

});

//修改提交按钮点击事件
$('#submit').click(function ()
{
    $.ajax({
        url: "/staff/update",
        type: "post",
        dataType: 'text',
        data: JSON.stringify($('#modify').serializeObject()),
        contentType: 'application/json',
        success: function (data)
        {
            load(false);
        },
        error: function (e)
        {
            console.log(e);
        }
    })
});

//删除按钮的监听事件
var sel = undefined;
page.delegate('a[id^=del-]', 'click', function(){
    sel = $(this).attr('name');
});

//确定删除
$('#ok').click(function ()
{
    $.ajax({
        url: "/shop/delete",
        type: "post",
        data: JSON.stringify(milks[sel]),
        contentType: 'application/json',
        success: function (data)
        {
            load(true);
        },
        error: function (e)
        {
            console.log(e);
        }
    })
});

//添加商品提交按钮
$('#insert_submit').click(function ()
{
    $.ajax({
        url: "/milk/insert",
        type: "post",
        dataType: 'text',
        data: JSON.stringify($('#insert').serializeObject()),
        contentType: 'application/json',
        success: function (data)
        {
            load(true);
        },
        error: function (e)
        {
            console.log(e);
        }
    })
});