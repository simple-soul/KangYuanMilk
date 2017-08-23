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
var activityList;
var domain;

$.ajax("/android/other/getQiniu", {
    success: function (data)
    {
        domain = data.response.message;
        console.log("domain----->"+domain);
        //初始加载
        load(true);
    }
});

function load(isPaging)
{
    $.ajax({
        url: "/shop/findActivity",
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
                    activityList = response.activityList;
                    var count = response.count;
                    console.log("dongxi====>"+activityList[0].activity_title);
                    //加载数据
                    for (var i = 0; i < activityList.length; i++)
                    {
                        var url = "../../assets/img/user04.png";
                        console.log(activityList[i].activity_image);
                        if(activityList[i].activity_image !== null)
                        {
                            url = domain+activityList[i].activity_image;
                        }
                        console.log("i--->"+url);
                        page.append("<tr class=\"gradeX\">\n" +
                            "            <td>\n" +
                            "                <img src=\""+url+"\" class=\"tpl-table-line-img\" width=\"48\" height=\"48\">\n" +
                            "            </td>\n" +
                            "            <td class='am-text-middle'>" + activityList[i].activity_id + "</td>\n" +
                            "            <td class='am-text-middle'>" + activityList[i].activity_title + "</td>\n" +
                            "            <td class='am-text-middle'>" + lev[activityList[i].classify-1] + "</td>\n" +
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
