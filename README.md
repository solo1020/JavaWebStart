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
新标签：  
<thead> <tbody> <tfoot>
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
箭头函数 对指定变量 进行一系列操作 即 没有名字的function  
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
getElementsByName 返回带有指定名称的对象集合
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
案例：  
---
隔行换色表格：  
确定点击事件 body 里的 onload  
获取元素 document.getElementById()  
最终获取tbody里的行数 rows.length  
js变例for循环  
获取奇数行和偶数行  
设置背景颜色 .style.backgroundColor  
```
<script>
        window.onload = function(){
            var table = document.getElementById("tbl");
            // 获取tbody里面行数
            var len = table.tBodies[0].rows.length;
            for(var i = 0; i < len; i++){
                if (i % 2 == 0){
                    // 对偶数行设置背景色
                    table.tBodies[0].rows[i].style.backgroundColor="pink";
                }else{
                    table.tBodies[0].rows[i].style.backgroundColor="gray";
                }
            }
        }
    </script>
```

表格高亮显示：
---
确定点击事件 onmouseover onmouseout 并绑定函数  
```
function changeColor(id,flag){
            if(flag == "over"){
                document.getElementById(id).style.backgroundColor = "red";
            }else if (flag == 'out'){
                document.getElementById(id).style.backgroundColor = "white";
            }
            // document.getElementById(id).style.backgroundColor = "red";
        }
```

事件总结：
---
onsubmit onclick onload onfocus onblur onmouseover onmouseout  
onfocus onblur 聚焦离焦事件 用于输入框  
onclick ondbclick 鼠标单击双击事件  
onkeydown onkeypress  某个键盘键被按下 用于搜索引擎回车等  
onchange 用户改变内容时 一般用于二级联动  

全选按钮  
---
事件onclik 绑定编号前的复选框里面  
获取复选框：var checkAll = document.getElementById("id")  
获取复选框状态：checkAll.checked?  
getElementsByName 返回带有指定名称的对象集合  
```
<script>
            function checkAll(id){
                var selectAll = document.getElementById(id);
                if(selectAll.checked == true){
                    var checkItems = document.getElementsByName("checkOne");
                    for(var i = 0; i < checkItems.length; i++){
                        checkItems[i].checked = true;
                    }
                }else{
                    var checkItems = document.getElementsByName("checkOne");
                    for(var i = 0; i < checkItems.length; i++){
                        checkItems[i].checked = false;
                    }
                }

            }
</script>

<table border="1" width="500" height="50" align="center">
            <thead>
                <tr>
                    <td colspan="4">
                        <input type="button" value="添加" name="" id="">
                        <input type="button" value="删除" name="" id="">
                    </td>
                </tr>

                <tr>
                    <th><input type="checkbox" name="" 
                        id="checkAll" onclick="checkAll('checkAll')"></th>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>年龄</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="checkbox" name="checkOne"></td>
                    <td>1</td>
                    <td>张三</td>
                    <td>22</td>
                </tr>
            </tbody>
        </table>
```
DOM:
---
包含 document element attribute text 都是一种节点node  
document对象方法：  
getElementById()  
getElementsByName()  返回带有指定名称对象的集合  
getElementByTagName()   返回带有指定标签名的对象集合  
document.createTextNode() 创建文本节点  
document.createElement() 创建元素节点  

</br>
element对象：
所有html标签都是element  
element.appendChild() 向元素添加新的子节点，作为最后一个子节点  
element.firstChild() 返回元素的首个子节点  
element.getAttribute() 返回元素节点的指定属性值  
element.innerHTML 设置或返回元素的内容  
.insertChild() 在指定位置插入子节点  
.lastChild() 返回元素最后一个子节点  
.setAttribute() 设置指定属性值  
</br>


attribute 对象：
---
常用方法：attr.value 设置或返回属性的值  
```
window.onload = function(){
                document.getElementById('btn').onclick = function(){
                    // 获取 ul 元素节点
                    var list = document.getElementById("list");
                    // 创建城市文本节点
                    var textCity = document.createTextNode("深圳");
                    // 创建li元素节点
                    var li = document.createElement("li");
                    // 将城市文本节点添加到li元素节点中去
                    li.appendChild(textCity);
                    // 将li 元素添加到ul中去
                    list.appendChild(li);
                }
            }
</script>
<input type="button" value="添加城市" id="btn">
        <ul id="list">
            <li>北京</li>
            <li>上海</li>
            <li>广州</li>
        </ul>

```
遇到页面响应不是预期 可以打开浏览器f12控制台
---

</br>
省市二级联动选择案例
---
事件onchange  
使用二维数组存储省份和城市  
获取用户选择的省份  传参 this.value  
遍历数组 获取省份与用户选择的省份比较，如果相同继续遍历该省份下的所有城市  
创建文本节点和元素节点进行添加操作  
每次操作前清空第二个下拉选择  
</br>

select.options 获取下面的选项  

```
<script>
            var cities = new Array(3);
            cities[0] = new Array("武汉","黄冈","襄阳","荆州");
            cities[1] = new Array("张家界","长沙","郴州","岳阳");
            cities[2] = new Array("石家庄","邯郸","廊坊","保定");
            cities[3] = new Array("郑州","洛阳","开封","安阳");
            function changeCity(val){
                // alert(value);

                // 获取第二个下拉列表
                var cityEle = document.getElementById("city");
                // var optionElement = [];

                // 清空第二个下拉列表中的option内容
                
                // 这里是 cityEle.options 是自带属性，不应该是下面设置的optionElement
                cityEle.options.length= 0;
                 
                           

                // 遍历二维数组中的省份
                for(var i = 0; i < cities.length; i++){
                    // 比较下标
                    if(val == i){

                        //遍历用户选择省份下的城市
                        for(var j = 0; j <cities[i].length; j++){
                            // alert(cities[i][j]);

                            // 创建城市文本节点
                            var city = document.createTextNode(cities[i][j]);

                            // // 创建option元素节点
                            var optionElement = document.createElement("option");

                            // // 将城市文本节点添加到option元素节点
                            optionElement.appendChild(city);

                            // // 将option元素节点添加到第二个下拉列表
                            cityEle.appendChild(optionElement);
                        }
                    }
                }
            }
        </script>

        <select name="" id="province" onchange="changeCity(this.value)" >
                <option >--请选择--</option>
                <option value="0">湖北</option>
                <option value="1">湖南</option>
                <option value="2">河南</option>
                <option value="3">河北</option>
                
            </select>

            <select name="" id="city">
```
Js全局函数:
---

jQuery:
=====
```
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
        <script>
            window.onload = function(){
                alert("zhangsan");
            }

            // 传统的js加载页面会存在覆盖问题 加载比jquery慢
            // 在整个页面加载完毕才会加载
            window.onload = function(){
                alert("wangwu");
            }

            // jquery 加载比js快，当整个dom树结构绘制完毕就会加载
            jQuery(document).ready(function(){
                alert("李四");
            });

            // jquery 加载不存在覆盖问题，且是顺序加载
            $(document).ready(function(){
                alert("laowang");
            });

            // 简写方式
            $(function(){
                alert("hello jquery");
            });
        </script>
```

开始jQuery
---
```
$(document).ready(function(){
 
   // 开始写 jQuery 代码...
 
});

简洁写法（与以上写法效果相同）:
$(function(){
 
   // 开始写 jQuery 代码...
 
});


```

jQuery通过id获取元素:
---
$("#id")  
```
$(function(){
    $("#btn2").click(function(){
        $("#span1").html("呵呵哒")
    });
});
```

jQuery对象和DOM对象转换：
---
```
// jQuery对象和DOM对象转换 方式1
$("#span1").get(0).innerHTML = "jQuery转成DOM对象";
//方式2
$("span1")[0].innerHTML = "jQuery转DOM 使用数组方式";
```
get(index) 获取指定类型的元素中第几个  

DOM对象转jQuery对象：
---
```
//将DOM对象转换成jQuery对象
$(spanEle).html("simiada");
```
jQuery定时广告：
---
```
            $(function(){
                // alert("hello jquery");
                time = setInterval("showAd()",3000);
            });

            function showAd(){
                // 获取广告图片并让其显示
                // $("#img2").show(1000);  
                // show() 和show(1000)的区别
                // show(1000) 为将内容1s内显示出来
                // show()是瞬间显示
                // 下滑显示
                // $("#img2").slideDown(5000);

                $("#img2").fadeIn(1000);

                // 清除显示图片定时操作
                clearInterval(time);
                // 设置隐藏图片定时操作
                time2 = setInterval("hiddenAd()", 3000);
            }

            function hiddenAd(){
                // 获取广告图片 并让其隐藏
                // $("#img2").hide();

                // $("#img2").slideUp(4000);
                
                $("#img2").fadeOut(1000);

                // 清除
                setInterval(time2);
            }
```
toggle显示或隐藏：
---
```
<script>
            $(function(){
                // alert("hello jquery")
                $("#btn").click(function(){
                    $("#img1").toggle();
                });
            });
        </script>
```

jQuery 选择器：(与 css 中一致)
---
id 选择器：$("#id")  
class 选择器：$(".class")  

层级选择器：
---
$("body div").css 选择前一元素的所有 子 孙 元素  
$("body>div") 选择前一元素的下一级元素即 子 不包含孙 元素  
$("#two+div").css 选择前一id 元素的下一个元素  
$("#one~div") 选择前一id 元素的所有 兄弟 div  


```
$(function(){
				$("#btn1").click(function(){
					// 选择body 中所有的div
					$("body div").css("background-color", "gold");
				});

				$("#btn2").click(function(){
					// 选择body 中下一级的 div 下下一级的不选择
					$("body>div").css("background-color", "gold");
				});

				$("#btn3").click(function(){
					// 选择id 为two的元素的下一个元素
					$("#two+div").css("background-color", "gold");
				});

				$("#btn4").click(function(){
					// 选择id为one的所有兄弟div元素
					$("#one~div").css("background-color", "gold");
				});
			})
```

过滤选择器：
---
查找表格的偶数行：$("tr:odd") 奇数行$("tr:even")  

$("div:contains('John')") 查找包含John的div元素  
```
$("#btn1").click(function(){
					$("body div:first").css("background-color", "red");
					// 与直接调用first()方法等价
					// $("body div").first().css("background-color", "red")
				});

				$("#btn2").click(function(){
					// 选择最后一个元素
					$("body div:last").css("background-color","red");
				});

				$("#btn3").click(function(){
					// 选择奇数行
					$("body div:odd").css("background-color","red");
				});

				$("#btn3").click(function(){
					// 选择偶数行
					$("body div:even").css("background-color","red");
				});
```
属性选择器：
---
查找所有包含给定属性的元素：  
$("div[id]")  

查找所有name属性 不是 newsletter的input元素：  
$("input[name!='newsletter']").attr("checked",true);  

设置属性：  
.attr("checked",true)  
.attr({src:"test.jpg", alt:"Test Image"}); 同时设置多个属性  

匹配第一个子元素：  
$("ul li:first-child")  

匹配所有input元素  
:input  
:text 匹配所有单行文本  
:radio 匹配所有单选按钮  
:checked 匹配所有被选择的复选框元素  
$("input:checked")  
:selected 匹配所有选择的 选项元素  
$("select option:selected")  
<br />

为匹配的元素添加指定类名  
$("p").addClass("selected")  

css属性：
---
```
// 获取tbody下面的偶数行并设置背景颜色
                // $("tbody>tr:even").css("background-color","yellow");
                // 获取tbody下面的奇数行并设置背景颜色
                // $("tbody>tr:odd").css("background-color","green");

                //因为style.css里添加了奇数行class偶数行class的样式颜色
                //可以直接给 奇数行添加奇数行的class 即可应用该样式表
                $("tbody tr:even").addClass("even");

                // $("tbody tr:even").removeClass("even");

                $("tbody tr:odd").addClass("odd");
```

jQuery遍历数组：
---
$("input[name='hobby']").each(function(){});  

$.each([0,1,2], function(i,n){ alert("Item #" + i + ": " + n)});  

```
$("#checkallbox").click(function(){
    var isChecked = this.checked;
    $("input[name='hobby']").each(function(){
        this.checked = isChecked;
    });
});
```
jQuery 向每个匹配的元素里追加内容：  
$("p").append("<b>Hello</b>");  

jQuery 把所有指定的元素/内容 添加到..  
appendTo 实际效果是 剪切到...
---
<hr>
$("p").appendTo("div") 将所有段落添加到div中  

jQuery删除：
---
$("p").empty();  删除匹配元素集合中所有子节点  
$("p").remove(); 从DOM中删除所有匹配的元素p  




使用jQuery 为标签添加属性或样式  
---

为指定标签添加子标签或兄弟标签  
---

给标签绑定事件  
---

jQuery实现省市联动：
---
```
<script>
            $(function(){
                // alert("hello jquery")
                $(function(){
                    var cities = new Array(3);
                    cities[0] = new Array("武汉市","黄冈市","襄阳市","荆州市");
                    cities[1] = new Array("长沙市","郴州市","株洲市","岳阳市");
                    cities[2] = new Array("石家庄市","邯郸市","廊坊市","保定市");
                    cities[3] = new Array("郑州市","洛阳市","开封市","安阳市");
                    $("#province").change(function(){

                        // 每次的点击事件触发时 应当清除第二个下拉列表
                        $("#city").empty();

                        var val = this.value;
                        $.each(cities,function(i,n){
                            // alert(i + ":" + n);
                            if(i == val){
                                $.each(cities[i],function(h,m){
                                    // alert(m);
                                    // 创建城市节点
                                    var textNode = document.createTextNode(m);
                                    //创建option 元素节点
                                    var opEle = document.createElement("option");
                                    // 将城市文本系欸DNA添加到option 元素节点中去
                                    // opEle是DOM 元素 append却是jQuery方法
                                    // 须使用$(opEle)
                                    $(opEle).append(textNode);
                                    // 将option元素节点追加到第二个下拉列表中
                                    $(opEle).appendTo($("#city"));
                                })
                            }
                        });
                    });
                });
            });
</script>

<select onchange="changeCity(this.value)" id="province">
            <option>--请选择--</option>
            <option value="0">湖北</option>
            <option value="1">湖南</option>
            <option value="2">河北</option>
            <option value="3">河南</option>
        </select>
        <select id="city">
            
        </select>
```
jQuery属性操作：
---
val() 获取value属性的值  
val(...) 设置value属性的值  
html() 获取html代码，如果有标签一并获得  
html(..) 设置html代码  
text() 获得文本，如果有标签，忽略  
text(...) 设置文本，如果含有标签不进行解析，原样输出 
```
$("#province").change(function(){

                        // 每次的点击事件触发时 应当清除第二个下拉列表
                        $("#city").empty();

                        var val = this.value;   
                        // var val = $(this).val()
```
this.value 等价 $(this).val()  

下拉左右箭头选择案例：  
```
<script>
            $(function(){
                // alert("hello jquery")
                //确定点击事件onclick

                // 获取左侧下拉列表被选中的option

                //将获取到的option添加到右侧的下拉列表 append

                $("#selectOneToRight").click(function(){
                    $("#left option:selected").appendTo($("#right"));
                });

                $("#leftAllToRight").click(function(){
                    $("#left option").appendTo($("#right"));
                });

                $("#left option").dblclick(function(){
                    $("#left option:selected").appendTo($("#right"));
                });
                
            });
        </script>

        <select multiple="multiple" style="width: 100px;height: 200px;" id="left">
							<option>IPhone6s</option>
							<option>小米4</option>
							<option>锤子T2</option>
                        </select>
                        
						<p><a href="#" style="padding-left: 20px;" id="selectOneToRight">&gt;&gt;</a></p>
						<p><a href="#" style="padding-left: 20px;" id="selectAllToRight">&gt;&gt;&gt;</a></p>

        <select multiple="multiple" style="width: 100px;height: 200px;" id="right">
							<option>三星Note3</option>
							<option>华为6s</option>
						</select>
						<p><a href="#" >&lt;&lt;</a></p>
						<p><a href="#" >&lt;&lt;&lt;</a></p>
```
jQuery事件总结：
---

