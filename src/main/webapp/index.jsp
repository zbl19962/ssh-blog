<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<input id="email" type="email" >

<input id="password" type="password" >

<a href="#"   onclick="test()" >Login in</a>

</body>
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    function test() {
        $.ajax({
            type: "POST",
            url: "/index",
            data: {
                email:$("#email").val(),
                password:$("#password").val(),
            },
            dataType:"json",
            success:function (r) {
                console.log("1111");
                var data=JSON.parse(r);
                alert(data);
            },
            error: function (err) {
                alert(err);
            }
        });
    }
</script>
</html>