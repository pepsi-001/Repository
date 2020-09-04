<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC</title>
    <script src="/js/jquery-2.2.3.min.js"></script>
    <script>
        $(function () {
            //数据以JSON格式提交
            $('#btn').click(function () {
                $.ajax({
                    url:'/user/request/body/json',
                    type:'post',
                    data:'{"username":"小虎","telephone":"13670081111","hight":2}',
                    contentType:'application/json;charset=utf-8',    //指定提交数据类型JSON
                    success:function (data) {
                        alert(data);
                    }
                });
            });


            //获取JSON数据
            $('#jsonbtn').click(function () {
                $.ajax({
                    url:'/user/response/body/json',
                    type:'get',
                    dataType:'json',
                    success:function (data) {
                        //控制台输出
                        console.log(data);

                        alert(data.username+"----"+data.telephone);
                    }
                });
            });


        });
    </script>
</head>
<body>
    ${username}欢迎使用SpringMVC!<br/>
    ${msg}
<div>
    获取JSON数据
    <button type="button" id="jsonbtn">获取JSON</button>
</div>
<div>
    <button type="button" id="btn">提交JSON</button>
</div>
<div>
    <form action="/user/request/body/str" method="post">
        用户名字：<input name="username" /><br/>
        用户手机号：<input name="telephone" /><br/>
        用户身高：<input name="hight" /><br/>
        <button>提交</button>
    </form>
</div>


<div>
    <div>传统方式文件上传</div>
    <form action="/upload/servlet/image" method="post" enctype="multipart/form-data">
        请选择文件：<input type="file" name="upload" /><br/>
        <button>上传</button>
    </form>
</div>

<div>
    <div>SpringMVC文件上传</div>
    <form action="/upload/image" method="post" enctype="multipart/form-data">
        请选择文件：<input type="file" name="file" /><br/>
        <button>上传</button>
    </form>
</div>


<div>
    <div>远程文件上传</div>
    <form action="/upload/remote/image" method="post" enctype="multipart/form-data">
        请选择文件：<input type="file" name="file" /><br/>
        <button>上传</button>
    </form>
</div>

</body>
</html>
