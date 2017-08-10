var alert_error = $('#alert_error');
alert_error.hide();

var query = {
    key: null,
    level: null,
    num: 0
};

var lev = ['配送员', '管理员', 'boss'];
var page = $('#page');
var paging = $('#paging');

$.ajax({
    url: "/web/findStaff",
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
                var staffs = response.staffs;
                var count = response.count;
                //加载数据
                for (var i = 0; i < staffs.length; i++)
                {
                    page.append("<tr class=\"gradeX\">\n" +
                        "                                                <td>" + staffs[i].staff_id + "</td>\n" +
                        "                                                <td>" + staffs[i].staff_name + "</td>\n" +
                        "                                                <td>" + staffs[i].staff_username + "</td>\n" +
                        "                                                <td>" + sex(staffs[i].staff_sex) + "</td>\n" +
                        "                                                <td>" + staffs[i].staff_tel + "</td>\n" +
                        "                                                <td>" + lev[staffs[i].staff_authority] + "</td>\n" +
                        "                                                <td>\n" +
                        "                                                    <div class=\"tpl-table-black-operation\">\n" +
                        "                                                        <a href=\"javascript:;\">\n" +
                        "                                                            <i class=\"am-icon-pencil\"></i> 编辑\n" +
                        "                                                        </a>\n" +
                        "                                                        <a href=\"javascript:;\" class=\"tpl-table-black-operation-del\">\n" +
                        "                                                            <i class=\"am-icon-trash\"></i> 删除\n" +
                        "                                                        </a>\n" +
                        "                                                    </div>\n" +
                        "                                                </td>\n" +
                        "                                            </tr>");
                }
                //加载分页标签
                var p = count / 20;
                var y = count % 20;
                if (p < 5 && p > 0)
                {

                }
                else if (p > 5)
                {

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

function sex(bool)
{
    if (bool)
        return "男";
    else
        return "女";
}