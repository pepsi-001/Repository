<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户增加</title>
</head>
<body>
<div>
    <div>
        取Model中的数据
        <%--${requestScope}--%>
        ${USErNAMEINFO_ITHEIM}
    </div>
</div>


用户增加
<div>
    <form method="post" action="/cat/add">
        <button type="submit">POST提交</button>
    </form>
</div>


<div>

    <div>
        @RequestBody接收前台传递的参数
        <form action="/parameters/request/body" method="post">
            用户名：<input name="name" /><br/>
            年龄:<input name="age" /><br/>
            生日:<input name="birthday" /><br/>
            <button type="submit">提交</button>
        </form>
    </div>

    <div>
        处理Date问题(自定义类型转换器)
        <form action="/parameters/date/add">
            用户名：<input name="name" /><br/>
            年龄:<input name="age" /><br/>
            生日:<input name="birthday" /><br/>
            <button type="submit">提交</button>
        </form>
    </div>



    <div>
        后台接受一个JavaBean
        <form action="/parameters/bean/add">
            用户名：<input name="name" /><br/>
            年龄:<input name="age" /><br/>
            <button type="submit">提交</button>
        </form>
    </div>

    <div>
        后台接受一个一对多映射
        <form action="/parameters/one2more/add" method="post">
            用户名：<input name="name" /><br/>
            年龄:<input name="age" /><br/>
            <div>
                ====================一对多映射============
            </div>

            <div>
                手机1
                <div>
                    手机名字：<input name="mobiles[0].mobileName" /><br/>
                    价格：<input name="mobiles[0].price" /><br/>
                </div>
            </div>
            <div>
                手机2
                <div>
                    手机名字：<input name="mobiles[1].mobileName" /><br/>
                    价格：<input name="mobiles[1].price" /><br/>
                </div>
            </div>
            <div>
                手机3
                <div>
                    手机名字：<input name="mobiles[2].mobileName" /><br/>
                    价格：<input name="mobiles[2].price" /><br/>
                </div>
            </div>


            <button type="submit">提交</button>
        </form>
    </div>

    <div>
        后台接受一个一对一映射
        <form action="/parameters/one2one/add">
            用户名：<input name="name" /><br/>
            年龄:<input name="age" /><br/>
            <div>
                ====================一对一映射============
            </div>
            身份证号码：<input name="idCard.number" /> <br/>
            地址：<input name="idCard.address" /> <br/>
            <button type="submit">提交</button>
        </form>
    </div>

    <div>
        接受一个Map
        <form action="/parameters/map/add">
            用户名：<input name="name" /><br/>
            年龄:<input name="age" /><br/>
            <button type="submit">提交</button>
        </form>
    </div>


    <div>
        接受一个List
        <form action="/parameters/list/add">
           <table>
               <tr>
                   <td>
                       <input type="checkbox" />
                   </td>
                   <td>
                       用户ID
                   </td>
                   <td>
                       用户名
                   </td>
               </tr>
               <tr>
                   <td>
                       <input name="id" value="1" type="checkbox" />
                   </td>
                   <td>
                       1
                   </td>
                   <td>
                       小红
                   </td>
               </tr>
               <tr>
                   <td>
                       <input name="id" value="2" type="checkbox" />
                   </td>
                   <td>
                      2
                   </td>
                   <td>
                       小花
                   </td>
               </tr>
               <tr>
                   <td>
                       <input name="id" value="3" type="checkbox" />
                   </td>
                   <td>
                       3
                   </td>
                   <td>
                       小六
                   </td>
               </tr>
           </table>
            <div>
                <button type="submit">提交</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
