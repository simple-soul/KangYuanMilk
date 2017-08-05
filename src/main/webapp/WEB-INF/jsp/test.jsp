<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/js/lib/jquery-3.2.1.min.js"></script>

</head>
<body>
<form id="test-form" action="test">

    <div>

        <h1>地址id：${address.address_id}</h1>
        <h1>详细地址：${address.address_content}</h1>

        <button class="json">发送并请求json数据</button>
    </div>
</form>
<script>

    $("button.json").click(function(){
        $.getJSON('/requestJson',{
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            data: '{"address_id":2,"address_content":"刘庄"}'
        }).done(function (data) {
            alert(data);
        });
    });


    function submit() {

    }
</script>
</body>
</html>
