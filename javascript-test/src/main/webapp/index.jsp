<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>dlkjfsdkl</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js" ></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#button").click(function() {
                $("#spantest").html("123");
                $(".123").hide();
                $(".123").show();

//                $("#spantest").text("");
            });

            $("#username").focusout(function() {
                $("#username").val("abcde");
            });

            $.ajax({
                url:'',
                dataType:'',

            });
        });
    </script>
</head>
<body onload="loading()">
<h2>Hello World!</h2>
<div style="position:absolute; left: 500px; right: 500px;height: 400px">
    <input align="middle" style="text-align: center;" id="username" type="text"/>
    <input id="button" type="button" onclick="test()" />
    <span id="spantest"></span>
</div>

<li>
    <ul class="123">abc</ul>
    <ul class="123">def</ul>
    <ul class="123">fkd</ul>
</li>
<div style="position:absolute;left:20px;"></div>
</body>
</html>
