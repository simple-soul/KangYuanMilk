var alert_error = $('#alert_error');
alert_error.hide();

var query = {
    key: null,
    level: null,
    num: 20,
    page: 1
};

var lev = ['购物车','已完成','待付款','配送中','已取消'];
//页面显示列表
var page = $('#page');
//总共页数
var pages = 0;
//按等级筛选
var level = $('#level');
//搜索输入框
var search_input = $('#search_input');
//搜索按钮
var search_btn = $('#search');
//员工信息
var orders;

//初始加载
load(true);

function load(isPaging)
{
    $.ajax({
        url: "/searchOrder",
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
                    orders = response.orders;
                    var count = response.count;
                    //加载数据
                    for (var i = 0; i < orders.length; i++)
                    {
                        page.append("<tr class=\"gradeX\">\n" +
                            "            <td>" + orders[i].order_id + "</td>\n" +
                            "            <td>" + orders[i].order_number + "</td>\n" +
                            "            <td>" + orders[i].user_name + "</td>\n" +
                            "            <td>" + orders[i].milk_name + "</td>\n" +
                            "            <td>" + orders[i].milk_num + "</td>\n" +
                            "            <td>" + getMyDate(orders[i].distribution_startdate) + "</td>\n" +
                            "            <td>" + getMyDate(orders[i].distribution_enddate) + "</td>\n" +
                            "            <td>" + getMyDate(orders[i].order_date) + "</td>\n" +
                            "            <td>" + orders[i].order_money + "</td>\n" +
                            "            <td>" + lev[orders[i].order_currentstate] + "</td>\n" +
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

//分页
var paging = $('#paging');
//下一页
var next = $('#next');
//上一页
var previous = $('#previous');

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

level.change(function ()
{
    var select = level.find("option:selected").val();
    query.level = select;
    load(true);
});

search_btn.click(function ()
{
    var key = search_input.val();
    query.key = key;
    query.num = 0;
    load(true);
});

function getMyDate(str){
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间
    return oTime;
}

//补0操作
function getzf(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}