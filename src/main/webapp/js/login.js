//登录提交表单
$('#submitFrom').click(function ()
{
    if (checkLogin())
    {
        var alert_username = $('#alert_username');
        var alert_password = $('#alert_password');
        var alert_code = $('#alert_code');
        var alert_all = $('#alert_all');
        var pass = $('[name=password]');
        var password = $.trim(pass.val());
        pass.val(md5(password));
        var v = $('#login').serializeObject();

        alert_username.hide();
        alert_password.hide();
        alert_code.hide();
        alert_all.hide();

        $.ajax({
            url: "/web/login2",
            dataType: 'text',
            data: JSON.stringify(v),
            type: "post",
            contentType: 'application/json',
            success: function (data)
            {
                var json = JSON.parse(data);
                console.log("json:" + json);
                if (json.status === 200)
                {
                    if (json.response.result === true)
                    {
                        location.href = '/web/index';
                    }
                    else
                    {
                        alert_all.find('p').text("用户名或密码错误!");
                        alert_all.show();
                    }
                }
                else if (json.status === 500)
                {
                    alert_all.find('p').text("服务器错误!");
                    alert_all.show();
                }
                else
                {
                    alert_all.find('p').text("未知错误!");
                    alert_all.show();
                }
            },
            error: function (e)
            {
                console.log("错误" + e);
            }
        })
    }
});

//检查用户名密码
function checkLogin()
{
    var username = $.trim($('[name=username]').val());
    var password = $.trim($('[name=password]').val());
    var code = $.trim($('[name=code]').val());
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

//换验证码
$('#image').click(function ()
{
    var date = new Date();
    $('#image').attr('src', "/web/getCode?date=" + date.getMilliseconds());
});

//检查忘记密码表单
function checkForget()
{
    var forget_name = $.trim($('#forget_name').val());
    var forget_idcard = $.trim($('#forget_idcard').val());
    var forget_tel = $.trim($('#forget_tel').val());
    var forget_pass = $.trim($('#forget_pass').val());
    var forget_dou_pass = $.trim($('#forget_dou_pass').val());

    var alert_name = $('#alert_name');
    var alert_idcard = $('#alert_idcard');
    var alert_tel = $('#alert_tel');
    var alert_pass = $('#alert_pass');

    if (forget_name === null || forget_name.length === 0)
    {
        alert_name.find('p').text("姓名不能为空哦");
        alert_name.show();
        return false;
    }
    if (forget_idcard === null || forget_idcard.length !== 18)
    {
        alert_idcard.find('p').text("亲，你的身份证号码位数不对吧？");
        alert_idcard.show();
        return false;
    }
    if (forget_tel === null || forget_tel.length !== 11)
    {
        alert_tel.find('p').text("亲，你的电话号码位数不对哎！");
        alert_tel.show();
    }
    if(forget_pass === null || forget_dou_pass === null)
    {
        if(forget_pass !== forget_dou_pass)
        {
            alert_pass.find('p').text("两次密码不一样哎！");
            alert_pass.show();
        }
    }
    else
    {
        alert_pass.find('p').text("密码不能为空哦!");
        alert_pass.show();
    }
    return true;
}


//提交忘记密码表单
$('#submitForget').click(function ()
{
    console.log("dianjile");
    var pass = $('#forget_pass');
    var forget_pass = $.trim(pass.val());
    pass.val(md5(forget_pass));
    if (checkForget())
    {
        var alert_name = $('#alert_name');
        var alert_idcard = $('#alert_idcard');
        var alert_tel = $('#alert_tel');
        var alert_forget = $('#alert_forget');
        var alert_pass = $('#alert_pass');

        var v = $('#forget').serializeObject();
        console.log(v);

        alert_name.hide();
        alert_idcard.hide();
        alert_tel.hide();
        alert_forget.hide();
        alert_pass.hide();

        $.ajax({
            url: "/web/forget",
            dataType: 'text',
            data: JSON.stringify(v),
            type: "post",
            contentType: 'application/json',
            success: function (data)
            {
                var json = JSON.parse(data);
                console.log("json:" + json);
                if (json.status === 200)
                {
                    if (json.response.result === true)
                    {
                        location.href = '/web/login';
                    }
                    else
                    {
                        alert_forget.find('p').text("请检查下信息有没有错哦!");
                        alert_forget.show();
                    }
                }
                else if (json.status === 500)
                {
                    alert_forget.find('p').text("服务器错误!");
                    alert_forget.show();
                }
                else
                {
                    alert_forget.find('p').text("未知错误!");
                    alert_forget.show();
                }
            },
            error: function (e)
            {
                console.log(e);
            }
        })
    }
});

