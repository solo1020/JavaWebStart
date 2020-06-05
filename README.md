# JavaWebStart
JavaEE helloworld


html
==================================
水平线
 <hr />

字体
---- 
```
<font></font> color size(1~7)
```

图片 
---- 
```
<img src="pic.png"> width height alt="图片无法显示提示"
```

列表
----  
```
<ul> <ol> <li>  
```

表格 
---- 
```
<table>  <th>表头  <tr>行  <td> 单元格 border 
rowspan 一列跨多行  colspan 一行跨多栏
cellspacing 单元格之间的间距 cellpadding 单元格内边距
background=".jpg" 在单元格中设置背景图片,然后再嵌套表格等元素
效果与 float效果差不多
align 居中显示
```

```
<table>
        <caption>表名</caption>
</table>   
```   

超链接 
---- 
```
<a href="www.html#页面的指定位置的id" ></a> 
target="_self" _blank  self 在当前标签页打开 blank 打开新标签页
```

表单：
---- 
```
<form action="#处理请求的servlet路径" method="get">
<input type="text" name="提交到服务器的参数名" 
        maxlength="" readonly="" placeholder="提示输入信息"
        readonly="readonly 只读" size="40px 输入框长度" 
        required="requried 代表必填">
```

密码:
-----
```
<input type="password" name="">
```

单选按钮：
---- 
```
<input type="radio" name="" value="选项值" 
        checked="checked 表示是否默认选中">
```

多选按钮：
---- 
```
<input type="checkbox" name="" value="" checked="">
```

下拉列表：
---- 
```
<select name="用来区分多个select" >
        <option value="选项值" selected="请选择">北京选项显示的名称</option>
</select>
```

文件上传：
---- 
```
<input type="file" name="">
```

文本输入域：
---- 
```
<textarea name=""></textarea>
```

提交按钮：
---- 
```
<input type="submit" value="按钮内容">
```

普通按钮：
---- 
```
<input type="button" value="">
```

重置按钮：
---- 
```
<input type="reset" value="">
```

css
=====

语法：
----

引入css文件：
----
```
<link type="text/css" rel="stylesheet" href="文件名.css" >
```

选择器{
    属性名:属性值;
}
</br>
元素选择器 div {} </br>
类选择器  .class {}  
id选择器 #id {}  
层级选择器 div p {} 选择 div 中的段落元素  
属性选择器：input[type='text'] {} 选择input表单中的type为 text的元素  

css浮动与清除：
---

```
#id {
        float:left // right none inherit
        clear:both // 左右均不允许浮动
        border:1px solid red; // solid 实线
        text-align:center;
        width:300px;
        height:150px;
        padding: 10px 0.25em 2ex 20% // 分别对应 上右下左 边距 顺时针
}
```

盒模型：
---
margin: 与外部元素的边距 </br>
padding: 内边距  
border: 边框厚度  


Javascript
==========

组成部分：
-----
ECMAScript:核心  
DOM：文档对象模型  
BOM：浏览器对象模型  

变量弱类型，可以不声明直接使用变量，默认变成全局变量  
5种原始类型：Undefined Null Boolean Number String
typeof 运算符
```
var sTemp = "test string";
alert(typeof sTemp);  // 输出 "string"
alert(typeof 86);    //输出 "number"
```
引用类型或Null类型调用typeof 返回 object  
null被认为是对象的占位符  
声明的变量未初始化，默认值为 undefined  
</br>

全等号和非全等号
---
```
var sNum = "66";
var iNum = 66;
alert(sNum == iNum );  // true
alert(sNum === iNum);  // false
```

标签语句：
---
label:statement 配合break使用  
start : i = 5;  

获取元素：
---
```
获取元素和元素的值
document.getElementById("id名称");
document.getElementById("id名称").value;
```

表单提交事件:   
onsubmit = return checkForm()  
在form 元素标签中设置 onsubmit属性 "return checkForm()"

js输出：
---
操作html元素：  
```
document.getElementById("demo").innerHTML="My First Javascript";
```

写到文档中： 
--- 
```
document.write("<p>My First Javascript</p>");
```

判断邮箱格式： 
--- 
```
正则：^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
.test() 判断 不匹配则提示
if ( ! ^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(email))
```

绑定点击事件：
---
```
onclick="function()"
```

页面加载事件:
---
在body 中定义onload="init()" 函数

定时操作：
---
setInternal("changeImg()",3000); // 按照指定周期调用函数
```
<script>
        function init(){
           window.setInternal("changeImg()",3000);
        }
        var i = 0;
        function changeImg(){
            i++;
            document.getElementById("img1").src="../index/pics/"+i+".jpg";
            if (i == 3){ // 最后一张图片重置索引
                i = 0;
            } 
        }
</script>
```
定时弹窗：
----
通过css 样式display：none属性实现
```
document.getElementById("img2").style.display = "block";
```

BOM对象：
----
window对象方法：  

alert() setInternal() clearInternal()  
setTimeout() 在指定的毫秒数后调用函数或表达式  
confirm("确定是否清空购物车")显示确认按钮对话框  
prompt("请输入价格") 弹出输入对话框  
</br>
history对象方法：  
back() forward()  

</br>
Location对象：包含当前url信息  
```
<input type="button" value="跳转到history页面" 
onclick="javascript:location.href='02history.html'">
```

navigator 浏览器对象
---
screen 显示屏幕分辨率等信息  
---
</br>

表单校验
----
输入框点击聚焦事件：onfocus 并在输入框后添加span标签  
鼠标离开输入框 离焦事件：onblur  
```
<input type="text" placeholder="用户名" 
width="100%" height="100px" 
size="45px" name="username"
id="user" onfocus="showTips('user','用户名必填')" onblur="checkUser('user', '用户名不能为空')"><span id="userspan"></span>

function showTips(id, info){
        // alert('click user');
        
        // document.getElementById("userspan").innerHTML = "<font color='gray'>用户名必填！格式*****</font>";

        //因为存在多个校验代码重复，考虑用参数：  
        document.getElementById(id+'span').innerHTML = "<font color='gray'>"+info+"*****</font>";
}

function checkUser(id, info){
        var userValue = document.getElementById(id).value;
        if(userValue == ""){
                document.getElementById(id+'span').innerHTML = "<font color='red'>"+info+"</font>";
        }else{
                document.getElementById(id+'span').innerHTML = "";
        }
}
```

```



```







