<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <script src="../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<form id="test-form" action="test">
  <legend>请选择想要学习的编程语言：</legend>
  <fieldset>
    <p><label class="selectAll"><input type="checkbox"> <span class="selectAll">全选</span><span
      class="deselectAll">全不选</span></label> <a href="#0" class="invertSelect">反选</a></p>
    <p><label><input type="checkbox" name="lang" value="javascript"> JavaScript</label></p>
    <p><label><input type="checkbox" name="lang" value="python"> Python</label></p>
    <p><label><input type="checkbox" name="lang" value="ruby"> Ruby</label></p>
    <p><label><input type="checkbox" name="lang" value="haskell"> Haskell</label></p>
    <p><label><input type="checkbox" name="lang" value="scheme"> Scheme</label></p>
    <p>
    <h1>${address.address_id}</h1>
    <h1>${address.address_content}</h1>

    </p>
  </fieldset>
</form>
<script>
  'use strict';

  var
    form = $('#test-form'),
    langs = form.find('[name=lang]'),
    selectAll = form.find('label.selectAll :checkbox'),
    selectAllLabel = form.find('label.selectAll span.selectAll'),
    deselectAllLabel = form.find('label.selectAll span.deselectAll'),
    invertSelect = form.find('a.invertSelect');


</script>
</body>
</html>
