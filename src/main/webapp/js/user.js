var alert_error = $('#alert_error');
alert_error.hide();

var query = {
    key: null,
    level: null,
    num: 0
};

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
//员工信息
var users;

//初始加载
load(true);

function load(isPaging)
{
    $.ajax({
        url: "/web/user/find",
        type: "post",
        data: JSON.stringify(query),
        contentType: 'application/json',
        success: function (data)
        {
            if (data.status === 200)
            {
                var response = data.response;
                var domain = response.domain;
                if (response.result === false)
                {
                    alert_error.find('p').text("数据出错");
                    alert_error.show();
                }
                else
                {
                    page.find('tr').remove();
                    users = response.users;
                    var count = response.count;
                    //加载数据
                    for (var i = 0; i < users.length; i++)
                    {
                        var url = "../../assets/img/user04.png";
                        if(users[i].user_head !== null)
                        {
                            url = domain+users[i].user_head;
                        }
                        console.log("i--->"+url);
                        page.append("<tr class=\"gradeX\">\n" +
                            "            <td>\n" +
                            "                <img src=\""+url+"\" class=\"tpl-table-line-img\" width=\"48\" height=\"48\">\n" +
                            "            </td>\n" +
                            "            <td class='am-text-middle'>" + users[i].user_id + "</td>\n" +
                            "            <td class='am-text-middle'>" + users[i].user_name + "</td>\n" +
                            "            <td class='am-text-middle'>" + sex(users[i].user_sex) + "</td>\n" +
                            "            <td class='am-text-middle'>" + users[i].user_tel + "</td>\n" +
                            "            <td class='am-text-middle'>" + users[i].user_idcard + "</td>\n" +
                            "            <td class='am-text-middle'>" + users[i].address_content + "</td>\n" +
                            "            <td class='am-text-middle'>" + getMyDate(users[i].user_registerdate) + "</td>\n" +
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

function sex(bool)
{
    if (bool)
        return "男";
    else
        return "女";
}

paging.change(function ()
{
    var select = paging.find("option:selected").attr('name');
    query.num = (select - 1) * 20;
    load(false);
});

previous.click(function ()
{
    var select = paging.find("option:selected").attr('name');
    if (select - 1 > 0)
    {
        query.num = (select - 1) * 20;
        load(false);
    }
});

next.click(function ()
{
    var select = paging.find("option:selected").attr('name');
    if (select + 1 <= pages)
    {
        query.num = (select + 1) * 20;
        load(false);
    }
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