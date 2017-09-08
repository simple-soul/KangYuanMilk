var alert_error = $('#alert_error');
alert_error.hide();

var query = {
    key: null,
    level: null,
    num: 0
};

var lev = ['配送员', '管理员', 'boss'];
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
var milks;

//初始加载
load(true);

function load(isPaging)
{
    $.ajax({
        url: "/staff/findStaff",
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
                    milks = response.staffs;
                    var count = response.count;
                    //加载数据
                    for (var i = 0; i < milks.length; i++)
                    {
                        page.append("<tr class=\"gradeX\">\n" +
                            "            <td>" + milks[i].staff_id + "</td>\n" +
                            "            <td>" + milks[i].staff_name + "</td>\n" +
                            "            <td>" + milks[i].staff_username + "</td>\n" +
                            "            <td>" + sex(milks[i].staff_sex) + "</td>\n" +
                            "            <td>" + milks[i].staff_idcard + "</td>\n" +
                            "            <td>" + milks[i].staff_tel + "</td>\n" +
                            "            <td>" + lev[milks[i].staff_authority] + "</td>\n" +
                            "            <td>\n" +
                            "                <div class=\"tpl-table-black-operation\">\n" +
                            "                    <a data-am-modal=\"{target: '#my-model'}\" id=\"bar-"+i+"\" name=\""+i+"\">\n" +
                            "                           <i class=\"am-icon-pencil\"></i> 编辑\n" +
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

//编辑员工信息
page.delegate('a[id^=bar-]', 'click', function(){

    var num = $(this).attr('name');
    console.log("num="+num);
    var staff = milks[num];
    console.log("staff.staff_name"+staff.staff_name);
    $('#id').val(staff.staff_id);
    $('#name').val(staff.staff_name);
    $('#username').val(staff.staff_username);
    $('#tel').val(staff.staff_tel);
    if(staff.staff_sex)
        $('#man').attr("checked",true);
    else
        $('#female').attr("checked",true);
    $('#select').val(staff.staff_authority);
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
        url: "/staff/delete",
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

//添加员工提交按钮
$('#insert_submit').click(function ()
{
    $.ajax({
        url: "/staff/insert",
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