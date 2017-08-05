$('#submitFrom').click(function ()
{
    if (check())
    {
        var alert_all = $('#alert_all');
        var pass = $('#login').find('[name=password]');
        var password = $.trim(pass.val());
        pass.val(md5(password));
        console.log(md5(password));
        var v = $('#login').serializeObject();

        $.ajax({
            url: "/web/login2",
            dataType: 'text',
            data: JSON.stringify(v),
            type: "post",
            contentType: 'application/json',
            success: function (data)
            {
                console.log(data);
                var json = JSON.parse(data);
                console.log("json:"+json);
                console.log("json.response.result:"+json.response.result);
                if(json.response.result === true)
                {
                    location.href = '/web/index';
                }
                else
                {
                    alert_all.find('p').text("用户名或密码错误!");
                    alert_all.show();
                }
            },
            error: function (e)
            {
                console.log("错误"+e);
            }
        })
    }
});

function check()
{
    var username = $.trim($('#login').find('[name=username]').val());
    var password = $.trim($('#login').find('[name=password]').val());
    var code = $.trim($('#login').find('[name=code]').val());
    var alert_username = $('#alert_username');
    var alert_password = $('#alert_password');
    var alert_code = $('#alert_code');
    if (username !== null && username.length !== 0)
    {
        if (username.length > 20)
        {
            alert_username.find('p').text("你确定你的用户名有这么长?");
            alert_username.show();
            return false;
        }
    }
    else
    {
        alert_username.find('p').text("亲, 你的用户名空空如也哎!?");
        alert_username.show();
        return false;
    }
    if (password !== null && password.length !== 0)
    {
        if (password.length > 20)
        {
            alert_password.find('p').text("你确定你的密码有这么长?");
            alert_password.show();
            return false;
        }
    }
    else
    {
        alert_password.find('p').text("亲, 你的密码空空如也哎!?");
        alert_password.show();
        return false;
    }
    if (code !== null)
    {
        if (code.length !== 4)
        {
            alert_code.find('p').text("亲, 你填的真的是验证码么!?");
            alert_code.show();
            return false;
        }
    }
    else
    {
        alert_code.find('p').text("亲, 你的验证码空空如也哎!?");
        alert_code.show();
        return false;
    }
    return true;
}

$('#image').click(function ()
{
    var date = new Date();
    console.log("${pageContext.request.contextPath}/web/getCode?date=" + date.getMilliseconds());
    $('#image').attr('src', "/web/getCode?date=" + date.getMilliseconds());
});

