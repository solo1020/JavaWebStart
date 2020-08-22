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
事件操作的元素需要确保在操作前已经完成加载  
事件绑定：点击显示或隐藏  
```
$("#panel h5.head").bind("click", function() {
					var $content = $(this).next();
					if($content.is(":visible")) {
						$content.hide();
					} else {
						$content.show();
					}
				})


<body>
		<div id="panel">
			<h5 class="head">什么是jQuery?</h5>
			<div class="content">
				jQuery是继Prototype之后又一个优秀的JavaScript库，它是一个由 John Resig 创建于2006年1月的开源项目。jQuery凭借简洁的语法和跨平台的兼容性，极大地简化了JavaScript开发人员遍历HTML文档、操作DOM、处理事件、执行动画和开发Ajax。它独特而又优雅的代码风格改变了JavaScript程序员的设计思路和编写程序的方式。
			</div>
		</div>
	</body>
```
#panel 选中id panel  
h5.head 选中class 为head的 h5标签  
#panel h5.head 选中 id为panel 的子元素中 class 为head的h5标签
bind() 绑定到指定的事件  
$(this).next this是当前的h5标签 next是同级的下一个元素  
$content.is(":visible") 判断元素是否可见  
</br>
鼠标滑过显示或隐藏：  
```
                $(".head").mouseover(function() {
					$(this).next().show();
				}).mouseout(function() {
					$(this).next().hide();
				})

<body>
		<div id="panel">
			<h5 class="head">什么是jQuery?</h5>
			<div class="content">
				jQuery是继Prototype之后又一个优秀的JavaScript库，它是一个由 John Resig 创建于2006年1月的开源项目。jQuery凭借简洁的语法和跨平台的兼容性，极大地简化了JavaScript开发人员遍历HTML文档、操作DOM、处理事件、执行动画和开发Ajax。它独特而又优雅的代码风格改变了JavaScript程序员的设计思路和编写程序的方式。
			</div>
		</div>
	</body>
```
</br>
toggle事件：  
```
                $(".head").toggle(function() {
					$(this).next().hide();
				}, function() {
					$(this).next().show();
				})
```

表单校验 validate插件
---
语法：
```
$(#id).validate({
    rules:{
        字段名：校验器,
        字段名：校验器
    },
    messages:{}
});
```
实例：
```
<style>
            label.success{
				background:url(img/checked.gif) no-repeat 10px 3px;
				padding-left: 30px;
			}

            label.error{
				background:url(img/unchecked.gif) no-repeat 10px 3px;
				padding-left: 30px;
				font-family:georgia;
				font-size: 15px;
				font-style: normal;
				color: red;
			}
        </style>
        <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
        <script src="../js/jquery.validate.min.js"></script>
        <script src="../js/messages_zh.js"></script>
        <script>
            $(function(){
                // alert("hello jquery")
                $("#checkForm").validate({
                    rules:{
                        username:{
                            required:true,
                            minlength:10
                        },
                        password:{
                            required:true,
                            digits:true,
                            minlength:6
                        },
                        repassword:{
                            required:true,
                            equalTo:"[name='password']"
                        },
                        email:{
                            required:true,
                            email:true
                        },
                        sex:{
                            required:true
                        }
                    },
                    message:{
                        username:{
                            required:"用户名不能为空",
                            minlength:"用户名不得少于10位"
                        },
                        password:{
                            required:"密码不能为空",
                            digits:"密码必须是整数",
                            minlength:"密码不得少于6位"
                        },
                    },
                    errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
					success: function(label) { //验证成功后的执行的回调函数
						//label指向上面那个错误提示信息标签label
						label.text(" ") //清空错误提示消息
							.addClass("success"); //加上自定义的success类
					}
                });
            });
        </script>


        <form action="#" id="checkForm">
            用户名：<input type="text" name="username"><br/>
            密码：<input type="password" name="password"><br/>
            确认密码：<input type="password" name="repassword"><br/>
            邮箱：<input type="text" name="email" size="35px" id="email"/><br/>
            性别<input type="radio" name="sex" value="男"/>男
			<input type="radio" name="sex" value="女"/>女<label for="sex" class="error" style="display: none;"></label><br/>
            <input type="submit">
        </form>
```
equalTo用法：equalTo:"[name='password']"  


MYSQL
====
数据库操作： 
----
net stop mysql  net start mysql  

开启事务：<br/>
start transaction;  
delete from tbl_user;  
roll back;  


创建数据库：create database 库名;  
create database 库名 character set 编码;  
show create database 库名;  

show databases;  
drop database 库名;  

使用库 use 库名;  
查看正在使用的库 select database();  

表操作：
---
show tables; 

创建table:  
```
create table 表名(
    字段名 类型(长度) [可选约束],
    字段名 类型(长度) [可选约束]
)
```
单表约束：  
主键约束 primary key 要求被修饰的字段 唯一 且 非空  
唯一约束 unique 要求被修饰的字段 唯一  
非空约束  not null 非空  
auto_increment 自增  
```
create table user(
    uid int(32) primary key auto_increment,
    uname varchar(32),
    upassword varchar(32)
);
```
查看表结构：desc 表名;  
```
mysql> desc VIEWS;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| uid       | int(32)     | NO   | PRI | NULL    | auto_increment |
| uname     | varchar(32) | YES  |     | NULL    |                |
| upassword | varchar(32) | YES  |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
```
drop 表名;  
修改表：  
添加一列 alter table 表名 字段名 类型(长度) [约束]  
```
mysql> alter table user add uinfo varchar(32) not null;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc user;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| uid       | int(32)     | NO   | PRI | NULL    | auto_increment |
| uname     | varchar(32) | YES  |     | NULL    |                |
| upassword | varchar(32) | YES  |     | NULL    |                |
| uinfo     | varchar(32) | NO   |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
```
修改列的属性长度、约束  
alter table 表名 modify 字段名 类型(长度) [约束]  
```
mysql>alter table user modify uinfo varchar(100) null;
Query OK, 0 rows affected (0.00 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc user;
+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| uid       | int(32)      | NO   | PRI | NULL    | auto_increment |
| uname     | varchar(32)  | YES  |     | NULL    |                |
| upassword | varchar(32)  | YES  |     | NULL    |                |
| uinfo     | varchar(100) | YES  |     | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+
```
修改列名：  
alter table 表名 change 旧列名 新列名 类型(长度) [约束]  
```
mysql> alter table user change uinfo info varchar(32) not null;
Query OK, 0 rows affected (0.00 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc user;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| uid       | int(32)     | NO   | PRI | NULL    | auto_increment |
| uname     | varchar(32) | YES  |     | NULL    |                |
| upassword | varchar(32) | YES  |     | NULL    |                |
| info      | varchar(32) | NO   |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
```
删除列:  
alter 表名 table drop 列名  
```
mysql> alter table user drop info;
Query OK, 0 rows affected (0.00 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc user;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| uid       | int(32)     | NO   | PRI | NULL    | auto_increment |
| uname     | varchar(32) | YES  |     | NULL    |                |
| upassword | varchar(32) | YES  |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)
```
修改表名：  
rename table 表名 to 新表名  
修改表的字符集：  
alter table 表名 character set 编码  
查看表编码 show create table tbl_user;  

DML 数据操作
---
insert into 表名 (列名1, 列名2, 列名3...) values (值1, 值2, 值3...);  只插入某些列 即必填字段  
insert into 表名 values (值1, 值2, 值3...); 插入所有字段  
值为字符串或日期 需要加 单引号  
<br/>

```
insert into tbl_user(uid,uname,upassword) values(null, 'zhangsan', '123');
```
##### 插入数据中文乱码问题：  
1. 直接修改数据库安装目录里的my.ini文件  default-character-set=utf-8    
2. 方法2： set names gbk;    
更新 update 表名 set 字段=value where 字段=value2     
删除 delete from 表名 where 字段=value;     

*********

面试题
===
delete 和 truncat 区别：  
delete 是一条一条删除 配合事务，可以找回删除的数据  
truncat 删除 是将整个表删除，再创建一个一模一样的空表 删除后无法找回  且自增主键会重置  

*****


查询操作：  
---
select [distinct] * 列名, 列名 from 表名 [where 条件]  
使用别名：  
select pname as p from product  
去重：  
select distinct(price) from product  
将所有商品的价格+10 进行显示：  
select pname, price+10 from product;  
select * from tbl where price >= 60;
select * from tbl where pname like '%新%';  
select * from tbl where pid in (2,4,6);  


排序：  order by 字段 desc 反序  
聚合: 聚合函数不统计null值  
sum() avg() max() min()  count()计数  
select sum(price) from tbl;  
select count(*) from tbl;  

*****

分组：    
alter table product add cid varchar(32);    
初始化数据： update product set cid='1';    
update product set cid='2' where pid in (5,6,7);    
根据cid 分组：    
select cid , count(*) from tbl group by cid;    
select avg(price) from product group by cid having avg(price) > 2000;     


group by 后不能再用 where 使用 having
---
order by 必须放在最后面  
---



limit关键字查询：  
limit(1,2)  1 表示从1开始  2表示每页显示条数  
select * from tbl limit 6,3;  

******

JDBC
====
一般不使用硬编码创建驱动  一般使用Class.forName() 加载指定类,在类的静态代码块中 注册驱动  

获取连接：  
DriverManager.getConnection(url, username, password)  
Statement st = con.createStatement();  

jdbc:mysql://localhost:3306/mydatabase1     
jdbc:mysql://localhost:3306/mydatabase1?useUnicode=true&characterEncoding=UTF8    
mysql中utf-8编码 为 UTF8    
方法：  
int executeUpdate(String sql);  //DML    
ResultSet executeQuery(String sql);    
关闭资源：    
resultSet.close();    
statement.close();    
connection.close();    

*****

```
public void login(String username, String password) throws ClassNotFoundException, SQLException {
		// 1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "root");
		// 3.创建执行sql语句的对象
		Statement stmt = conn.createStatement();
		// 4.书写一个sql语句
		String sql = "select * from tbl_user where " + "uname='" + username + "' and upassword='" + password + "'";
		// 5.执行sql语句
		ResultSet rs = stmt.executeQuery(sql);
		// 6.对结果集进行处理
		if (rs.next()) {
			System.out.println("恭喜您，" + username + ",登录成功!");
			System.out.println(sql);
		} else {
			System.out.println("账号或密码错误!");
		}
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}

    @Test
	public void testLogin() {
		try {
			login1("zs' or 'zs", "zs");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
```


*****

SQL攻击：  
---
过滤用户输入是否包含非法字符  
分步验证  先使用用户名来查询用户，如果查到，再比较密码  
使用 PreparedStatement  

```
public void login1(String username, String password) throws ClassNotFoundException, SQLException {
		// 1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "root");
		// 3.编写sql语句
		String sql = "select * from tbl_user where uname=? and upassword=?";
		// 4.创建预处理对象
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 5.设置参数(给占位符)
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		// 6.执行查询操作
		ResultSet rs = pstmt.executeQuery();
		// 7.对结果集进行处理
		if (rs.next()) {
			System.out.println("恭喜您，" + username + ",登录成功!");
			System.out.println(sql);
		} else {
			System.out.println("账号或密码错误!");
		}
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}
```
外键
----
主表的主键 被从表 引用，主表和从表是一对多的关系  
alter table 从表 add [constraint] [外键名称] foreign key 从表外键字段名 references 主表 主表的主键;  
外键名称用来删除外键约束使用， 一般建议 _fk 结尾  
删除外键：   
alter table 从表 drop foreign key 外键名称    

*****

表与表的关系：  
一对多  多对多 一对一  

查询：
---- 
交叉连接查询：select * from A,B;  
内连接查询：inner join  
隐式内连接：select * from A,B where 条件;  
显式内连接：select * from A inner join B on 条件;  

select * from category inner join product on cid=category_id;  
反过来  select * ... cid=category_id; 也可以  
把 category 表 添加到 product表,所以 category表在左边  

select * from category c, product p where c.cid=p.category_id;  
相当于使用表别名    


*****

外连接：  
左外连接 left outer join  
    select * from A left outer join B on 条件;  
select * from category left join product on cid=category_id;  

*****

外连接 内连接区别：  
内连接 : 查询两个表交集(公共部分)  
左外连接：左表全部及两个表的交集  
右外连接：右表全部及两个表的交集  

insert into category values('c004',null);  
insert into product values('p010', '海飞丝', '0.5', null);    
   
select * from category left join product on cid=category_id;   
select * from category right join product on cid=category_id;   

*****

子查询：将一条select语句的结果作为另一条select 语法(查询条件,查询结果,表等)的一部分    

选中化妆品产品：  

select * from product where category_id=(select cid from category where cname='化妆品');

JDBC工具类抽取：  
获取连接和释放资源 代码重复    
```
Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web06_1", "root", "qzqzqz");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
```
*****

JDBC查询： 
---- 

*****
```
con = JDBCUtils_V1.getConnection();
            // 2.编写sql
            String sql = "select * from tbl_user where uid=?";
            // 3.获取执行sql语句对象
            ps = con.prepareStatement(sql);
            ps.setInt(1, 2);

            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(2) + "----" + rs.getString("upassword"));
            }
```
properties配置文件写数据库连接信息：不能有空格  
driver=com.mysql.jdbc.Driver    
url=jdbc:mysql://localhost:3306/web06_1?useUnicode=true&    characterEncoding=utf8    
username=root    
password=******    
  
1. 使用ResourceBundel对象 加载配置文件：   
```
private static String driver;
    private static String url;
    private static String username;
    private static String password;

static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        username = bundle.getString("username");
        password = bundle.getString("password");
    }
```

2. 类加载器获取配置文件输入流：  
```
private static String driver;
    private static String url;
    private static String username;
    private static String password;

// 通过当前类获取类加载器
            ClassLoader cl = JDBCUtils_V3.class.getClassLoader();

            // 通过类加载器获取 输入流
            InputStream is = cl.getResourceAsStream("db.properties");

            // 创建properties 对象
            Properties props = new Properties();

            // 加载输入流
            props.load(is);

            // 获取相关参数的值
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");
```

JDBC插入数据：  
----

```
public void testAdd(){
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = JDBCUtils_V2.getConnection();
            String sql = "insert into tbl_user values(null, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, "lisi");
            ps.setString(2,"hehe");

            int row = ps.executeUpdate();
            if(row > 0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils_V2.release(con, ps, null);
        }
    }
```

JDBC删除数据：  
-----

```
public void testDeleteById(){
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = JDBCUtils_V3.getConnection();
            String sql = "delete from tbl_user where uid=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 4);

            int row = ps.executeUpdate();
            if(row > 0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils_V3.release(con, ps, null);
        }
    }
```

JDBC更新数据：  
-------

```
public void testUpdateById(){
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = JDBCUtils_V3.getConnection();
            String sql = "update tbl_user set upassword=? where uid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "999");
            ps.setInt(2,3);

            int row = ps.executeUpdate();
            if(row > 0){
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils_V3.release(con, ps, null);
        }
    }
```

JDBC查询数据：  
---------


```
public void testFindUserById() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取连接
            con = JDBCUtils_V1.getConnection();
            // 2.编写sql
            String sql = "select * from tbl_user where uid=?";
            // 3.获取执行sql语句对象
            ps = con.prepareStatement(sql);
            ps.setInt(1, 2);

            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(2) + "----" + rs.getString("upassword"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils_V1.release(con, ps, rs);
        }
    }
```

数据库连接池：  
------

实现接口：javax.sql.DataSource    
手动创建linkedList容器存储数据库连接对象    
实现：    
调用连接对象connection.close()方法也能将其归还到连接池中：    
方法： 
      
继承    
      
装饰者设计模式：  
      
专门用于增强方法，必须有接口，需要将接口的方法全部实现  

动态代理：在运行时动态创建代理类，前提时有接口，使用反射技术  

字节码增强：运行时创建目标类子类  

装饰者固定结构：  
接口A, 已知实现类C, 需要装饰者创建代理类B  

```

/**
 * @ClassName MyConnection
 * @Description 使用装饰者模式 代理 实现 Connection接口
 *              接口A(本例中为Connection接口)
 *              已知实现类C(本例中为DriverManager.getConnection()方法返回的)
 *              需要装饰者创建代理类B
 *              步骤：
 *              1.创建类B (MyConnection)
 *              2.提供B 的构造方法,参数类型为A,用于接收A接口实现类C
 *              3.给类 B 添加类型为 A 的成员变量, 用于存放 A 接口的其他实现类 C
 *              4.增强需要的方法
 * @Author QZ
 * @Date 2020/7/21 23:52
 * @Version 1.0
 **/
public class MyConnection implements Connection {

    private Connection con;
    private LinkedList<Connection> pool;

    // Connection 接口做参数 是 接口和接口实现类的多态实现
    public MyConnection(Connection con, LinkedList<Connection> pool){
        this.con = con;
        this.pool = pool;
    }

    // 增强方法：
    @Override
    public void close() throws SQLException {
        pool.add(con);

        // 为什么不是 pool.add(this);

    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        /**
         * description:
         * 这里的con 因为从构造器参数传递进来的 其实是 JDBCUtils_V3.getConnection()
         * 所以 直接调用 con.prepareStatement即可
         * 如果不重新，则MyConnection对象调用此方法会返回空指针
         */
        return con.prepareStatement(sql);
    }
    
    ...
}

```
此时的连接池类：
----------  
```
package JDBC;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @ClassName MyDataSource_1
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/22 0:10
 * @Version 1.0
 **/
public class MyDataSource_1 implements DataSource {
    private static LinkedList<Connection> pool = new LinkedList<>();

    static{
        for (int i = 0; i < 5; i++) {
            Connection con = JDBCUtils_V3.getConnection();

            // 放入连接池的Connection对象是 封装过的MyConnection
            MyConnection myConnection = new MyConnection(con, pool);
            pool.add(myConnection);
        }
    }


    @Override
    public Connection getConnection() throws SQLException {
        Connection con = null;
        if(pool.size() == 0){
            for (int i = 0; i < 5; i++) {
                con = JDBCUtils_V3.getConnection();
                // 放入连接池的Connection对象是 封装过的MyConnection
                MyConnection myConnection = new MyConnection(con, pool);
                pool.add(myConnection);
            }
        }
        // 从连接池中获取一个链接对象Connection

        // 连接池还是这个连接池，只不过池中每个Connection对象穿了一件外套
        // 一件已经改造过close() 方法的外套
        // 此时 这个连接池中实际上全是MyConnection的对象
        // 每个MyConnection 对象包含有原来的Connection
        // remove获取到的 可以多态 赋值给Connection接口的引用
        con = pool.remove(0);
        return con;
    }



    /**
     * 已经不需要这个归还Connection对象的方法了
     * 因为直接con.close()就可以
     * 而这个con对象 实际上在连接池中就是MyConnection对象
     * 所以调用close()方法，走的是已经改造过的close()方法
     */

    /**
     * description: 将连接对象返回到连接池
     * @param
     * @return: void
     * @date: 2020/7/20 23:38
     * @author: qz
     */
//    public void backConnection(Connection con){
//        pool.add(con);
//    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}

```

测试类：  
-----

```
/**
 * @ClassName TestMyDataSource
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/21 22:54
 * @Version 1.0
 **/
public class TestMyDataSource {

    /**
     * description: 使用改造过close()方法的 MyConnection
     * @param
     * @return: void
     * @date: 2020/7/22 0:25
     * @author: qz
     */
    @Test
    public void testMyConnectionAddUser(){
        Connection con = null;
        PreparedStatement ps = null;
        MyDataSource_1 dataSource = new MyDataSource_1();
        try {
            con = dataSource.getConnection();
            String sql = "insert into tbl_user values(null,?,?)";

            /**
             * description:
             * 因为这个 con 实际上已经是MyConnection对象
             * 所以直接调用 走的是 MyConnection类里面的 prepareStatemen()方法
             * 需要对该方法也进行改造重写
             */
            ps = con.prepareStatement(sql);


            ps.setString(1,"吕布1");
            ps.setString(2,"貂蝉1");
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            if (con != null){
//                try {
//                    con.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }

            /**
             * description:
             *
             */
            JDBCUtils_V3.release(con,ps,null);
        }
    }

    ...

}
```

JDBCUtils工具类：
----------


```
package JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @ClassName JDBCUtils_V3
 * @Description TODO
 * @Author QA
 * @Date 2020/7/19 20:42
 * @Version 1.0
 **/
public class JDBCUtils_V3 {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    /**
     * description: 通过类加载器获取配置文件输入流
     * @date: 2020/7/19 20:48
     * @author: qz
     */
    static {
        try {
            // 通过当前类获取类加载器
            ClassLoader cl = JDBCUtils_V3.class.getClassLoader();

            // 通过类加载器获取 输入流
            InputStream is = cl.getResourceAsStream("db.properties");

            // 创建properties 对象
            Properties props = new Properties();

            // 加载输入流
            props.load(is);

            // 获取相关参数的值
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection con, PreparedStatement ps, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}

```
连接池：C3P0 DBCP
=====

注意配置文件要放在src目录下   
----

```
public class DBCPUtils {
    private static DataSource dataSource;
    static {

        try {
            InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties props = new Properties();
            props.load(is);

            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
```
DBUtils 连接池和 JavaBean
====
JavaBean的类放在 domain下面 
    
特点：
---
QueryRunner 提供对sql语句操作的API 
QueryRunner(DataSource ds)  提供数据源连接池，DBUtils底层自动维护连接Connection  
update(String sql, Object... params) 执行更新数据  
query(String sql, ResultSetHandle<T> rsh, Object...params) 执行查询  
      
ResultSetHandle 接口 用于定义select操作后 怎样封装结果集  
BeanHandle 将结果集中第一条记录封装到一直指定的javaBean中  

```
QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

String sql = "select * from tbl_user where uid=?";

Object[] params = {8};

User user = qr.query(sql, new BeanHandler<User>(User.class), params);

System.out.println(user.getUname() + ": " + user.getUpassword());
```


BeanListHandle 将结果集中每一条记录封装到指定的javaBean中，再将这些JavaBean封装到的List集合中  
```
QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

String sql = "select * from tbl_user";

List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
for (User user : users){
    System.out.println(user.getUname() + ": " + user.getUpassword());
}
```


MapListHandle 
----------
            
将结果集中每一条结果封装到Map<String, Object> 集合中，key是字段名称(列名),value是字段值,再将这些map封装到List集合中    
```
QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

String sql = "select * from tbl_user";

List<Map<String,Object>> list = qr.query(sql, new MapListHandler());
for (Map<String, Object> map : list){
    System.out.println(map);
}
```

ScalarHandle
------
用于单数据，如 select count(*) from tbl_user 等操作     

```
QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

String sql = "select count(*) from tbl_user";

Long count = (Long) qr.query(sql, new ScalarHandler());

System.out.println("There are " + count + " uesrs");
```

ColumnListHandle(String columnName)
-----------
将结果集中指定列的字段值封装到一个List集合中    
按列查询 不指定列的情况默认返回uid    
```
QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

String sql = "select * from tbl_user";

List<Object> list = qr.query(sql, new ColumnListHandler("uname"));
for (Object obj : list){
    System.out.println(obj);
}

输出：
老王
zs
张三
lisi
吕布3
余淮
```
* JavaBean封装到List集合中  
* ScalarHandle 用于单数据，例如 select count(*) from 表操作  
* DbUtils类 定义关闭资源和事务处理的方法  

XML:
======
区分大小写：  
xml属性值必须加 引号  
特殊字符：  
```
< 字符放在xml元素中会发生错误 需要进行替换：  
小于： < ：&lt;  
大于： > ：&gt;  
&amp;  :  &  和  
&apos; :  '  单引号  
&quot; :  "  双引号  
```

******

```
<note date="08/08/2008">
<to>George</to>
<from>John</from>
<heading>Reminder</heading>
<body>Don't forget the meeting</body>
</note>
```
文档声明：  
---
必须从文档的最起始 0行0列开始  
```
<?xml version="1.0" encoding="UTF-8"?>
```
元素：
----
区分大小写 不能使用空格冒号 不以xml开头 必须只有一个根元素  
属性：
----
必须出现在元素的开始标签中  
属性值必须使用单引号或双引号  
一个元素可以使用多个属性  
属性名不能使用空格 冒号等特殊字符，且必须以字母开头  

CDATA转义代码块：
----
```
<![CDATA[ code here ]]>  
```
其中内容不能包含"]]>" 即结束定界符  

DTD文档类型定义：
---------
规定xml文档中的元素名称，子元素的名称和顺序，元素的属性  
元素
---
```
<!ELEMENT web-app (servlet*, servlet-mapping*, welcome-file-list?)>
```
servlet 子标签个数任意0~多次    
servlet-mapping 子标签个数任意0~多次    
welcome-file-list 子标签最多出现一次 或0 次    
子标签名+  即该子标签最少出现一次    
子标签1, 子标签2, 子标签3 即子标签必须按指定 1,2,3的顺序    
子标签1 | 子标签2 即子标签只能为1 或者 2    

属性：
---
根据约束写xml文档： 
约束：  
```
<?xml version="1.0" encoding="UTF-8"?>
<!--
	模拟servlet2.3规范，如果开发人员需要在xml使用当前DTD约束，必须包括DOCTYPE。
	格式如下：
	<!DOCTYPE web-app SYSTEM "web-app_2_3.dtd">
-->
<!ELEMENT web-app (servlet*,servlet-mapping* , welcome-file-list?) >
<!ELEMENT servlet (servlet-name,description?,(servlet-class|jsp-file))>
<!ELEMENT servlet-mapping (servlet-name,url-pattern+) >
<!ELEMENT servlet-name (#PCDATA)>
<!ELEMENT servlet-class (#PCDATA)>
<!ELEMENT url-pattern (#PCDATA)>
<!ELEMENT description (#PCDATA)>
<!ELEMENT jsp-file (#PCDATA)>

<!ELEMENT welcome-file-list (welcome-file+)>
<!ELEMENT welcome-file (#PCDATA)>

<!ATTLIST web-app version CDATA #IMPLIED>
```

文档： 

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE web-app SYSTEM "web-app_2_3.dtd">
<web-app version="1.0">
    <servlet>
        <servlet-name>
            aaaaa
<!--            <a></a>-->
        </servlet-name>
        <description></description>
        <servlet-class></servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name></servlet-name>
        <url-pattern></url-pattern>
    </servlet-mapping>
    <welcome-file-list>
        <welcome-file></welcome-file>
    </welcome-file-list>
</web-app>
```
Schema约束：
====

xml解析：
====
dom4j:  
---
常用API：  
---
SaxReader:  read()方法加载执行xml文档  
Document: getRootElement() 获取根元素  
Element对象： elements() 获取指定名称的所有子元素  
element() 获取指定名称的第一个子元素  
getName() 获取当前元素的元素名  
attributeValue() 获取指定属性名的属性值  
elementText() 获得指定名称子元素的文本值  
getText() 获取当前元素的文本内容  
```
package XML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName TestDom4j
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/27 0:26
 * @Version 1.0
 **/
public class TestDom4j {

    @Test
    public void testReadWebXML(){

        try {
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read("src/XML/web02.xml");

            Element rootElement = doc.getRootElement();
            // 获取根元素的名称
            System.out.println("root element name: " + rootElement.getName());

            // 获取根元素的属性值
            System.out.println("root element attribute value: " + rootElement.attributeValue("version"));

            List<Element> childElements = rootElement.elements();

            for (Element element : childElements){
                if ("servlet".equals(element.getName())){
                    Element servletName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");
                    System.out.println(servletName.getText());
                    System.out.println(servletClass.getText());
                }
            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}

```
反射：
===
可以在运行时对类class 构造方法Constructor 普通方法method 字段Field(域)进行操作  
获取Class对象的方式：
---
1. 通过对象的 getClass()方法  
Person p = new Person();  
Class cls = p.getClass();  
2. 通过类的class属性：  
Class cls = Person.class;  
3. 通过Class类的静态方法forName():  
Class cls = Class.forName("com.android.bean.Person");  

常用方法：
---
1. 创建对象  
Class cls = Class.forName(className);  
Object obj = cls.newInstance();  
2. 获取字节码文件中的实例域 field  
Field field = cls.getDeclaredField("age"); // 私有实例域  
私有实例域须取消对其的访问控制检查：  
field.setAccessible(true); // 暴力访问  
公有实例域 getField(fieldName) 包括从父类继承的,不包括非公开方法    
3. 实例域操作：  
field.set(obj, 789);  
4. 获取实例域的值：  
Object fieldValue = field.get(obj);  
5. 获取指定类的公共成员方法, 方法参数为方法名和当前方法的参数  
Method method = cls.getMethod("staticShow", null);  
6. 调用该方法：  
method.invoke(obj,paramsList);  
7. 还能获取构造器  

读取xml配置文件 创建对象并调用方法：
---
```
// Test 
SAXReader saxReader = new SAXReader();
            Document document = saxReader.read("src/XML/servlet/web.xml");

            Element rootEle = document.getRootElement();
            Element servletEle = rootEle.element("servlet");

            String servletClass = servletEle.element("servlet-class").getText();
            System.out.println(servletClass);
            Class cls = Class.forName(servletClass);

            MyServlet1 my1 = (MyServlet1) cls.newInstance();

            my1.init();
            my1.service();
            my1.destory();
```
```
// web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://www.example.org/web-app_2_5"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://www.example.org/web-app_2_5 ../web-app_2_5.xsd"
         version="2.5">
    <servlet>
        <servlet-name>myServlet1</servlet-name>
        <servlet-class>XML.servlet.MyServlet1</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>myServlet1</servlet-name>
        <url-pattern>/myServlet1</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>myServlet2</servlet-name>
        <servlet-class>XML.servlet.MyServlet2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>myServlet2</servlet-name>
        <url-pattern>/myServlet2</url-pattern>
    </servlet-mapping>
</web-app>
```

```
package XML.servlet;

import XML.MyServlet;
public class MyServlet1 implements MyServlet {

    @Override
    public void init() {
        System.out.println("MyServlet1 诞生了");
    }

    @Override
    public void service() {
        System.out.println("MyServlet1 开始服务");
    }

    @Override
    public void destory() {
        System.out.println("MyServlet1 销毁了");
    }
}

```

## Http  &&  Tomcat
http协议：
---
分为请求和响应两部分：  
请求：
---
```
POST /web12/form.html HTTP/1.1    # 请求行：请求方式 资源地址 协议版本

# 如下段落为请求头 
Accept: text/html, application/xhtml+xml, */*       # 浏览器能接收的类型
Referer: http://localhost:8080/web12/form.html      # 请求的来源
Accept-Language: zh-CN                              # 语言
User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)      # 内核
Content-Type: application/x-ww-form-urlencoded      # 文本类型
Accept-Encoding: gzip, deflate                      # 客户端能接受的压缩格式
Host: localhost:8080                                # 主机
If-Modified-since: Wed, 03 Aug 2016 01:54:00 GMT    # 本地缓存的资源的最新一次修改时间
Content-Length: 28                                  # 请求内容长度
Connection: Keep-Alive                              # 长连接
Cache-Control: no-cache

username=lisi&password=12345     # 请求体 post请求提交的参数
```
响应：
---
```
# 状态码 常见：200 
# 302(重定向跳转)
# 304 拿本地缓存
# 404 没有该资源
# 500 服务器端报错
HTTP/1.1 200 OK    

# 响应头              
Server: Apache-Coyote/1.1
Accept-Range: bytes
ETag: W/"305-1470186605044"
Last-Modified: Wed, 03 Aug 2016 01:10:05 GMT        # 资源的最后修改时间
Content-Type: text/html
Content-Length: 305
Date: Wed, 03 Aug 2016 01:11:07 GMT

# 响应体
<html>
  <head>
<%--    <title>$Title$</title>--%>
    <title>第一个JavaWeb项目</title>
  </head>
  <body>
<%--  $END$--%>
第一个JavaWeb项目1
  </body>
</html>


```
Tomcat
===
常见问题：
---
端口被占用：  
目录结构：  
---

项目根目录   
-----
```
|  
|----html,jsp, css,js文件  
|  
|----WEB-INF目录  
        |  
        |---classes 目录 Java类     
        |---lib目录 Java依赖jar包  
        |---web.xml 文件 web应用配置文件  

```
注意事项：
---
WEB-INF目录受保护，外界不能直接访问  
手动删除tomcat 下的项目目录，导致无法启动，需要先去server.xml中删除仍残留的context上下文  

IDEA中Run --> Edit configurations -->选中tomcat --> Deloyment(发布)  -->  
设置发布配置 --> 下方Application context 即是 默认的浏览器url路径  

#### tomcat 生成的url路径末尾带 / 问题没找到解决方法：

Servlet
====
servlet filter listener  

servlet 重写方法：  
* init():servlet对象创建的时候执行  
* service(ServletRequest servletRequest, ServletResponse servletResponse)：每次请求都会执行   
* destroy()  servlet对象销毁的时候执行

Tomcat容器会解析请求地址，自动创建servlet对象  
并创建代表请求的request对象和代表响应的response对象  
每次浏览器请求都会创建一组 request和response  

url-pattern配置方式：
---
1) 完全匹配：访问的资源域配置的资源完全相同  
2) 目录匹配：/虚拟目录../*  
3) 扩展名匹配：*.扩展名  
不能同时使用： /aaa/bbb/*.abcd  

在服务器启动时创建servlet对象-->  
3 代表优先级 数字越小 优先级越高
```
<load-on-startup>3</load-on-startup>-->  
```

默认servlet:   
------

在url-pattern中配置 / 代表当前servlet为默认的servlet  
当浏览器地址栏所有的资源的都无法找到匹配的servlet的时候，默认的负责处理  
如果不配置自己的 默认servlet， 那么tomcat在项目的web.xml中查找完毕还没找到匹配的资源，则会去 conf中对tomcat的 web.xml进行查找，一般其中有配置一个默认的servlet,该servlet会查找项目目录中的静态资源，如果有则显示，没有则 报404  
如果配置了自己默认的servlet 但是又没有找到资源，就会报404  

### 案例demo 登录：
页面：
---
```
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>
    <!-- Bootstrap css 放在body前的head中-->
    <link href="bootstrap/bootstrap.css" rel="stylesheet">
    <style>

        <!-- col-center-block是网上找到将登录框 垂直居中的方法： -->
        .col-center-block {
            position: absolute;
            top: 50%;
            -webkit-transform: translateY(-50%);
            -moz-transform:  translateY(-50%);
            -ms-transform:  translateY(-50%);
            -o-transform:  translateY(-50%);
            transform:  translateY(-50%);
        }
    </style>
</head>

<!-- 设置背景图片 无重复充满屏幕 并设置透明度 -->
<body style="background: url(imgs/34.jpg) no-repeat center 0;background-size: cover; margin: 0px;">
    <h1>Welcome!</h1>

        <!-- 表单路径需要与 web.xml中一致 -->
        <form action="/login" method="post" >

            <!-- col-md col-lg 还有col-lg-offset设置登录框的位置和宽度 -->
            <!-- border-radius 设置登录框的圆角 -->
            <div class="col-md-4 col-lg-4 col-lg-offset-4 col-md-offset-4 col-center-block" style="background-color: white; opacity: 0.7; padding: 50px; border-radius: 10px">

                <!-- bootstrap自带的登录表单组件： -->
                <div class="form-group input-group input-group-lg" >

                <!-- 每一行的组件group由span的文字和 后面的输入框组成 -->
                <!-- span的文字元素 class input-group-addon 表示这是附加在当前input-group组里面的 -->
                    <span class="input-group-addon" id="sizing-addon1" >Username</span>
                    <input type="text" name="username" class="form-control" placeholder="Username" aria-describedby="sizing-addon1">
                </div>

                <div class="form-group input-group input-group-lg">
                    <span class="input-group-addon" id="sizing-addon2" >Password&nbsp;</span>
                    <input type="password" name="password" class="form-control" placeholder="Password" aria-describedby="sizing-addon2">

                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
                <!--        <div class="form-group">-->
                <!--            <label for="" class="control-label">Paycheck</label>-->
                <!--            <div class="input-group input-group-lg">-->
                <!--                <span class="input-group-addon">$</span>-->
                <!--                <input type="text" class="form-control" id="">-->
                <!--            </div>-->
                <!--        </div>-->
            </div>
        </form>



    <!-- jquery和js要在body最后面引入 -->
    <!-- 引入jQuery核心js文件 -->
    <script src="bootstrap/jquery-1.11.3.min.js"></script>

    <!-- 引入BootStrap核心js文件 -->
    <script src="bootstrap/bootstrap.min.js"></script>
</body>

</html>

```
#### 注意事项：
1. idea 项目默认url路径设置：run-edit-configuration 设置 deployment 里面的Application context 为空或者 /  
2. 资源文件放在项目的web根目录下面，不能放在WEB-INFO里  
3. idea自带的tomcat运行机制导致在webapps下找不到发布的工程文件夹，跟eclipse不一样  
4. form表单 需要加 name 且 密码框的type必须为 password  
5. servlet中不能随意重写service方法  
我开始只是为了查看打印信息来debug一下，结果后面页面死活不显示，但是f12看返回的是200,请求的参数也都传递过去了，只可能是响应 部分出问题了，所以看 servlet

ServletContext对象：
===
代表web应用对象，封装了该web应用的信息  
获取方式：
---
1. ServletContext servletContext = config.getServletContext();  
2. this.getServletContext();  

作用：
---
1. 获取全局参数：  
web.xml:  
```
<!--    配置全局初始化参数-->
    <context-param>
        <param-name>driver</param-name>
        <param-value>com.mysql.jdbc.Driver</param-value>
    </context-param>

//通过context对象获取参数：
ServletContext servletContext = getServletContext();
        String initParamter = servletContext.getInitParameter("driver");
        System.out.println(initParamter);

```
2. 获取web应用中任何资源的 绝对路径：  
```
String pathA = servletContext.getRealPath("a.txt");
        System.out.println(pathA);

        String pathB = servletContext.getRealPath("/WEB-INF/b.txt");
        System.out.println(pathB);

        String pathC = servletContext.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println(pathC);

        // class下面的 c.txt可以通过类加载器方式获取
        String pathC2 = ContextServlet.class.getClassLoader().getResource("c.txt").getPath();
        System.out.println(pathC2);

        // 获取不到工程根目录下的 d.txt
```

3. ServletContext是一个域对象   
可以理解为对于所有Servlet的一个公共的存取区域、静态变量     
所有web动态资源都可以随意对servletContext 域中存取对象，数据可以共享  
ServletContext.setAttribute(name,valueObject)  
ServletContext.getAttribute(name)   
ServletContext.removeAttribute(name)  


###  案例demo 统计访问次数：
使用 ServletContext.setAttribute(name,valueObject)  
和 setAttribute 方法  
先在init()方法中 初始化count变量并存储到ServletContext域  
再在 doPost()方法中读取并 +1 然后再存储回去 ServletContext  

```
@Override
    public void init() throws ServletException {
        super.init();
        int count = 0;
        getServletContext().setAttribute("count", count);
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post ...");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username + "password: " + password);
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        System.out.println(sql);
        User user = null;
        try {
            user = runner.query(sql, new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
            System.out.println("query sql error!");
            e.printStackTrace();
        }

        if(user != null){
            System.out.println("query ok!");

            ServletContext context = getServletContext();
            Integer count = (Integer) context.getAttribute("count");
            count++;
            context.setAttribute("count", count);

            response.getWriter().write(user.toString() + "--- you are the " + count + " visitor");
        }else {
            response.getWriter().write("sorry your username or password is wrong");
        }

    }

```


web.xml示例:
---
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  <display-name>WEB13</display-name>
  <context-param>
    <param-name>driver</param-name>
    <param-value>com.mysql.jdbc.Driver</param-value>
  </context-param>
  <servlet>
    <servlet-name>abc</servlet-name>
    <servlet-class>com.itheima.servlet.QuickStratServlet</servlet-class>
    <init-param>
      <param-name>url</param-name>
      <param-value>jdbc:mysql:///mydb</param-value>
    </init-param>
    <load-on-startup>3</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>abc</servlet-name>
    <url-pattern>/quickStratServlet</url-pattern>
  </servlet-mapping>
  <welcome-file-list>
    <welcome-file>1.html</welcome-file>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <servlet-name>QuickStartServlet2</servlet-name>
    <servlet-class>com.itheima.servlet.QuickStartServlet2</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>QuickStartServlet2</servlet-name>
    <url-pattern>/quickStartServlet2</url-pattern>
  </servlet-mapping>
  <servlet>
    <description></description>
    <display-name>LoginServlet</display-name>
    <servlet-name>LoginServlet</servlet-name>
    <servlet-class>com.itheima.login.LoginServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/login</url-pattern>
  </servlet-mapping>
  <servlet>
    <description></description>
    <display-name>ContextServlet</display-name>
    <servlet-name>ContextServlet</servlet-name>
    <servlet-class>com.itheima.context.ContextServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ContextServlet</servlet-name>
    <url-pattern>/context</url-pattern>
  </servlet-mapping>
  <servlet>
    <description></description>
    <display-name>ContextServlet2</display-name>
    <servlet-name>ContextServlet2</servlet-name>
    <servlet-class>com.itheima.context.ContextServlet2</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ContextServlet2</servlet-name>
    <url-pattern>/context2</url-pattern>
  </servlet-mapping>
</web-app>
```

###  HttpServletResponse  
默认放在doGet()方法里：
===
设置response 响应行：
---
设置状态码：response.setStatus(302);   

设置response 响应头：
----
addHeader(String name, String value)   
addIntHeader(String name, int value)    
addDateHeader(String name, long date)     
setHeader(String name, String value)    
setDateHeader(String name, long date)    
setIntHeader(String name, int value)   

多次addHeader()添加相同参数，会生成到列表
---
多次setHeader()设置相同参数，以最新的设置为准
---
```
response.addHeader("name", "zhangsan");
        response.addIntHeader("age", 288);
        response.addDateHeader("birthday", date.getTime());
        response.addHeader("name", "lisi");
        response.setHeader("age", "28");

响应：
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
name: zhangsan
age: 28
birthday: Wed, 12 Aug 2020 01:08:11 GMT
name: lisi
Content-Length: 0
Date: Wed, 12 Aug 2020 01:08:11 GMT
```

重定向：
===
特点：  
1. 访问服务器两次
2. 地址栏的地址发生变化
状态码302   
响应头：location 重定向的地址   
```
response.setStatus(302);
        response.setHeader("Location", "/directDst");
```
使用定时跳转：
===
```
// 5s 后进行跳转
        response.setHeader("refresh","5;url=localhost:8080/directDst");
```
response的write方法：
---
顺序也很关键：  
##### 设置编码和解码表需要在获取 PrintWrite之前
实际只需要setHeader()/setContentType即可，setCharacterEncoding()方法没必要   
response.setContentType("text/html;charset=UTF-8");   
```
// 中文会显示？，需设置response查询的编码表
        response.setCharacterEncoding("UTF-8");

        // 此时还需要告诉客户端使用哪个表进行解码
        //response.setHeader("Content-Type", "text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("中国");
```

### IDEA 配置tomcat自动更新
compile independent modules in parallel     
build project automaticlly    
都要勾上 尤其是第一个 必须勾 不然经常出现web-content目录下的资源找不到的情况   

### git 回滚操作
git log 获取旧的commitid   
git reset --hard   
然后 再将本地回退后的版本 push到远程：  
git push --force   

response write 图片字节流：
====
```
//        response.setContentType("image/jpg");
        // 使用response获取字节输出流
        ServletOutputStream stream = response.getOutputStream();
        //获取服务器上的图片 先获取绝对路径
//        String picPath = this.getServletContext().getRealPath("imgs/a.jpg");
        String picPath = this.getServletContext().getRealPath("b.jpg");
        System.out.println(picPath);
        System.out.println(this.getServletContext().getRealPath("/"));
        InputStream in = new FileInputStream(picPath);

//        InputStream in = this.getServletContext().getResourceAsStream("/a.jpg");

        int len = 0;
        byte[] buffer = new byte[1024];
        while ( (len = in.read(buffer)) > 0){
            stream.write(buffer,0,len);
        }
        in.close();
        stream.close();
```
图片路径放在web-content根目录或其他非WEB-INF目录都可以  
但是要确保每次run tomcat之后 out目录下有同步更新图片资源   
#### WEB-INF里面的资源没有更新时，查看-Project Structure-Artifacts右边的Include in project build 是不是没勾上 下面的show content of elements也勾上  


### 案例Demo 文件下载
浏览器默认不能解析的文件默认就需要下载(除图片文本等)
---
所以, 浏览器可以解析的文件需要编写下载代码，不能解析的浏览器默认会下载，不需要编写   

页面编写：
===
在页面中写访问后台servlet的链接：  
对应的地址是web.xml中的servlet name 不是 servlet-class   

```
<h1>使用服务端编码的方式实现文件下载</h1>
    <!--链接的地址和web.xml中配置的servlet名一致，不是和servlet的类名一致-->
    <a href="/downloadServlet?filename=a.flv">a.flv</a><br/>
    <a href="/downloadServlet?filename=a.jpg">a.jpg</a><br/>
    <a href="/downloadServlet?filename=a.mp3">a.mp3</a><br/>
```
下载代码：
===
通过页面href中写的url链接传递的参数 filename 获取服务器本地目录的资源，并进行文件读写操作    

#### 设置文件以附件形式下载：
response.setHeader("Content-Disposition", "attachment;filename="+fileName);    

#### 获取文件的MIME类型
response.setContentType(this.getServletContext().getMimeType(fileName));   
但是这个好像只是根据后缀名判断？ 因为fileName传递进来的只是字符串   


```
 // 获取待下载文件名称
        String fileName = request.getParameter("filename");


        // 客户端通过文件的MIME类型去区分类型
        response.setContentType(this.getServletContext().getMimeType(fileName));

        // 告诉客户端浏览器 不要直接解析，以附件形式下载
        response.setHeader("Content-Disposition", "attachment;filename="+fileName);

        // 获取文件的绝对路径
        String path = this.getServletContext().getRealPath("download/"+fileName);
        System.out.println("local file path: " + path);
        // 获取该文件的输入流
        InputStream in = new FileInputStream(path);
        // 获取输出流--通过response的输出流用于向客户端写数据
        ServletOutputStream out = response.getOutputStream();

        int len = 0;
        byte[] buffer = new byte[1024];
        while ( (len = in.read(buffer)) > 0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
```
中文文件名下载：
====
// 中文的文件名需要进行编码转换  
fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");    

此时文件可以下载但是文件名是空白：  
---
解决办法： 通过设置不同的浏览器解码方式对应的编码：  
其中 BASE64Encoder 可能无法自动导入 手动import sun.misc.BASE64Encoder;   
```
// 获得请求头中的User-Agent
        String agent = request.getHeader("User-Agent");

        // 根据不同的浏览器进行编码
        String fileNameEncoded = "";
        if(agent.contains("MSIE")){
            fileNameEncoded = URLEncoder.encode(fileName, "utf-8");
            fileNameEncoded = fileNameEncoded.replace("+", " ");
        }else if(agent.contains("Firefox")){
            BASE64Encoder base64Encoder = new BASE64Encoder();
            fileNameEncoded = "=?utf-8?B?" + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
        }else {
            fileNameEncoded = URLEncoder.encode(fileName, "utf-8");
        }

```

完整代码：
---
```
package servlet;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取待下载文件名称
        String fileName = request.getParameter("filename");

        // 中文的文件名需要进行编码转换
        fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");

        // 获得请求头中的User-Agent
        String agent = request.getHeader("User-Agent");

        // 根据不同的浏览器进行编码
        String fileNameEncoded = "";
        if(agent.contains("MSIE")){
            fileNameEncoded = URLEncoder.encode(fileName, "utf-8");
            fileNameEncoded = fileNameEncoded.replace("+", " ");
        }else if(agent.contains("Firefox")){
            BASE64Encoder base64Encoder = new BASE64Encoder();
            fileNameEncoded = "=?utf-8?B?" + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
        }else {
            fileNameEncoded = URLEncoder.encode(fileName, "utf-8");
        }


        // 客户端通过文件的MIME类型去区分类型
        response.setContentType(this.getServletContext().getMimeType(fileName));

        // 告诉客户端浏览器 不要直接解析，以附件形式下载
        // 客户端默认对fileName进行解码，是中文的时候 需要根据不同的客户端解码格式 进行编码
        response.setHeader("Content-Disposition", "attachment;filename="+fileNameEncoded);

        // 获取文件的绝对路径
        String path = this.getServletContext().getRealPath("download/"+fileName);
        System.out.println("local file path: " + path);
        // 获取该文件的输入流
        InputStream in = new FileInputStream(path);
        // 获取输出流--通过response的输出流用于向客户端写数据
        ServletOutputStream out = response.getOutputStream();

        int len = 0;
        byte[] buffer = new byte[1024];
        while ( (len = in.read(buffer)) > 0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();

    }
}

```

#### response细节点：
1. response获得的流outputStream 不需要手动关，web容器tomcat会关
2. getWriter() 和 getOutputStream()不能同时调用  
> HTTP Status 500 - getWriter() has already been called for this response   
3. 获取response缓冲区大小 getBufferSize()   
4. servlet中进行重定向之后最好不要再写代码  



### 设置gitignore global
git config --global core.excludesfile ~/.gitignore_global   

### 案例demo 实现验证码
登录页面代码：
---
```
<form action="/login" method="post" >
    <div class="col-md-4 col-lg-4 col-lg-offset-4 col-md-offset-4 col-center-block" style="background-color: white; opacity: 0.7; padding: 50px; border-radius: 10px">
        <div class="form-group input-group input-group-lg" >
            <span class="input-group-addon" id="sizing-addon1" >Username</span>
            <input type="text" name="username" class="form-control" placeholder="Username" aria-describedby="sizing-addon1">
        </div>

        <div class="form-group input-group input-group-lg">
            <span class="input-group-addon" id="sizing-addon2" >Password&nbsp;</span>
            <input type="password" name="password" class="form-control" placeholder="Password" aria-describedby="sizing-addon2">

        </div>

        <div class="form-group input-group input-group-lg">
            <span class="input-group-addon" id="checkImg" >&nbsp;&nbsp;&nbsp;验证码&nbsp;&nbsp;&nbsp;</span>
            <input type="text" name="checkcode" class="form-control" placeholder="验证码" aria-describedby="checkImg">
            <div class="input-group-addon" style="width: 100px;">
                <img  src="/checkImg" style="height: 100%;">
            </div>
            
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-default">登录/注册</button>
        </div>

    </div>
</form>
```

验证码图片点击更新：
----
```
<div class="input-group-addon" style="width: 100px;">
                <img  src="/checkImg" onclick="refreshImg(this)" style="height: 100%;">
            </div>
            
<script type="text/javascript">
        function refreshImg(obj) {
            // 因为与原来图片地址一样，浏览器默认走缓存，所以需要将地址改一下
            obj.src = "/checkImg?time="+new Date().getTime();
        }
    </script>
```

### HttpServletRequest

根据request获取请求行：
===
getRemoteAddr() 获得客户端的ip    


String getRequestURI() 请求资源   
StringBuffer getRequestURL()   
String getContextPath()  获取web应用的名称    
String getQueryString()  获取get提交的url后携带的参数   

```
// 获取请求方式
        String method = request.getMethod();
        System.out.println("request method: " + method);

        // 2.获取请求资源的相关内容
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("request URI: " + requestURI);
        System.out.println("request URL: " + requestURL);

        //获取web应用名称
        String contextPath = request.getContextPath();
        System.out.println("web 应用: " + contextPath);

        // 获取请求参数
        String queryString = request.getQueryString();
        System.out.println("request params: " + queryString);
```


输出：   
其中web应用的路径 和idea中设置的Application context是一样的   
getQueryString 因为post请求参数不是携带在请求行里面而是在请求体里面   
```
request method: POST
request URI: /requestline
request URL: http://localhost:8080/requestline
web 应用: 
request params: null
```

#### 修改后未生效：  
1. 设置Setting-compiler-build project automaticlly
2. ctrl+alt+shift+/ Registry 勾选 compiler.automake.allow.when.app.running   
3. 查看out的目录下是否文件更新，如已经更新，清空浏览器缓存，且在f12中disable cache  

根据request获取请求头：
====
long getDateHeader(String name)    
String getHeader(String name)   
Enumeration getHeaderNames()   
Enumeration getHeaders(String name)    
int getIntHeader(String name)    

header示例：
referer: 代表当前请求的来源页面 可以做 防盗链     

方法：
---
```
//获取所有头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + " : " + headerValue);
        }
```

```
agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36
host : localhost:8080
connection : keep-alive
upgrade-insecure-requests : 1
user-agent : Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36
accept : text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
sec-fetch-site : same-origin
sec-fetch-mode : navigate
sec-fetch-user : ?1
sec-fetch-dest : document
referer : http://localhost:8080/form.html
accept-encoding : gzip, deflate, br
accept-language : zh-CN,zh;q=0.9
cookie : Idea-6a75e9c1=61b4759b-ca18-4f3d-bd88-53997540f963; JSESSIONID=A0768F66022A989C4C9BBBB64866B80C

```

防盗链示例：
===
正常访问的页面：
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>request 表单</title>
</head>
<body>
    <!--<a href="/requestheader">访问requestheader资源</a>-->
    <a href="/referer">访问requestheader资源</a>
    <form action="/requestline" method="get">
        <input type="text" name="username"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="提交"><br>
    </form>
</body>
</html>
```
即正常从该页面点击 a 链接访问的就是refer资源    
referer 中运行从该页面获取展示的内容    
```
// 对新闻来源进行判断
        String header = request.getHeader("referer");
        // 因为是本地测试 多加了一条判断  endWith()
        if(header != null && header.startsWith("http://localhost") && header.endsWith("form.html")){
            // startWith用来判断referer是否是本网站打开的链接
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("中国已经100块金牌");
        }else {
            response.getWriter().write("盗链可耻。。。");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 跳转来源页
            response.setStatus(302);
            response.setHeader("Location", "/form.html");
        }
```

而盗链的页面也copy了这个链接a 准备访问：   
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>盗链跳转</title>
</head>
<body>
    <a href="/referer">访问referer资源</a>
    <form action="/requestline" method="get">
        <input type="text" name="username"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="提交"><br>
    </form>
</body>
</html>
```
则此时 页面的 header里 referer的值是盗链页面news_referer.html 而不是 正常的页面form.html   可以通过判断不让其进行访问    

request 获取请求体
===
请求体的内容是 post提交的请求参数：   
username=zhangsan&password=123&hobby=football&hobbybasketball    

获取参数方法：
getParameter("username") 获取单个值表单：  
getParameterValues("hobby") 获取多个值的表单   
getParameterNames() 获取所有参数名   
getParameterMap() 获取所有的参数存储到map里   
 Map<String,String[]> paramterMap = request.getParameterMap();   
        for(Map.Entry<String,String[]> entry:paramterMap.entrySet()){    
            System.out.println("parameter key: " + entry.getKey());   
            for(String s : entry.getValue()){    

```
// 获得单个表单值
        String username = request.getParameter("username");
        System.out.println("username: " + username);
        String password = request.getParameter("password");
        System.out.println("password: " + password);

        // 获取多个表单的值
        String[] hobbys = request.getParameterValues("hobby");
        for(String hobby: hobbys){
            System.out.println("hobby: " + hobby);
        }
        // 获取所有请求参数的名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }

        // 获取所有参数 到 一个Map<String,String[]>
        Map<String,String[]> paramterMap = request.getParameterMap();
        for(Map.Entry<String,String[]> entry:paramterMap.entrySet()){
            System.out.println("parameter key: " + entry.getKey());
            for(String s : entry.getValue()){
                System.out.println("parameter " + entry.getKey() + " value: " + s);
            }
            System.out.println("------------------------");
        }

```
输出：  
---
```
username: 545
password: ghgryty
hobby: soccer
hobby: paiqiu
username
password
hobby
parameter key: username
parameter username value: 545
------------------------
parameter key: password
parameter password value: ghgryty
------------------------
parameter key: hobby
parameter hobby value: soccer
parameter hobby value: paiqiu
------------------------
```

#### request 其他功能
1. request是一个域对象 作用域是 一次请求中   
setAttribute(String name, Object o)    
getAttribute(String name)    
removeAttribute(String name)    
2. request 完成请求转发
获取请求转发器：  
RequestDispatcher getRequestDispatcher(String path 转发地址)    
通过转发器对象转发：    
requestDispatcher.forword(ServletRequest request, ServletResponse response)    

转发与重定向：
===
重定向：
---
重定向是 客户端浏览器 向 服务端发送某个资源的请求，服务端返回给客户端一个location的header和重定向后的真实资源地址，客户端再去获取该资源      

请求转发：
---
请求转发是客户端请求服务端之后，服务端自动将该请求发送给 含有用户请求资源的服务servlet,而目标servlet进行响应    

#### 区别：
1. 重定向需要两次请求，请求转发只需要一次    
2. 重定向的浏览器地址栏会发生改变，而请求转发浏览器地址不变  
3. 重定向可以访问外部网站   
4. 转发的性能优于重定向   


request域对象的作用范围仅限一次完整请求中：  

如下代码中的ForwardSrc 如果设置的name属性后，不是使用请求转发而是使用重定向，则 目标ForwardDst 无法获取到该name属性    
---


代码：    
源servlet:   
```
// ForwardSrcServlet.java

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // request域对象存储数据
        request.setAttribute("name","tom");

        // 当前servlet 将请求转发给 目标servlet ForwardDstServlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("/forwarddst");
        dispatcher.forward(request,response);
    }
```
目标servlet:     
```
// ForwardDstServlet.java

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object name =  request.getAttribute("name");
        response.getWriter().write("hello ForwardSrcServlet " + name );
    }


// web.xml
<!--request 请求转发-->
    <servlet>
        <servlet-name>dispatcherServlet</servlet-name>
        <servlet-class>request.ForwardSrcServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <url-pattern>/forwardsrc</url-pattern>
    </servlet-mapping>

    <!--request 请求转发接收-->
    <servlet>
        <servlet-name>dispatcherReceiveServlet</servlet-name>
        <servlet-class>request.ForwardDstServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcherReceiveServlet</servlet-name>
        <url-pattern>/forwarddst</url-pattern>
    </servlet-mapping>
```
总结：
===
get方法的表单参数通过 getQueryString() 方法获取请求行  
post方法的表单参数通过     
getParameter("username")   
getParameterValues("hobby")    
getParameterNames()    
getParameterMap()   等方法获取请求体中的参数

### 案例demo 实现注册功能
1. 表单中文乱码问题
2. 参数过多： 使用BeanUtils 将map中的数据与实体类Javabean进行映射  
> 创建表：BeanUtils.populate()    
```
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 防止中文参数乱码 设置request 编码 --只限于post请求
        request.setCharacterEncoding("UTF-8");

        // get请求
//        String username = request.getParameter("username");
//        // 先用ISO8859-1编码
//        username = new String(username.getBytes("iso8859-1"),"UTF-8");

        // 获取数据
        // 多个参数时下面的方式太繁琐，使用BeanUtils解决
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");

        // 将原始数据封装到JavaBean中
        // 多个参数时下面的方式太繁琐，使用BeanUtils解决
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);

        // 使用BeanUtils自动进行映射封装
        // 工作原理：将map中数据 根据key 与实体类的属性对应关系进行封装
        // 只要key的名字和尸体属性名一样，就自动封装
        Map<String,String[]> properties = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 此时 user对象已经封装完毕
        // 手动封装uid--使用uuid--32位随机不重复字符串 加 四位的短划线 生成的Java代码是36位
        user.setUid(UUID.randomUUID().toString());

        // 将参数传递给业务操作方法
        try {
            regist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 注册成功跳转登录页面,不推荐用请求转发，需要让用户看到跳转的地址变化，使用重定向
//        response.sendRedirect("/login.jsp");
        response.sendRedirect(request.getContextPath() + "/login.jsp");



    }
```

uid因为使用UUID生成 所有需要大于36位   

修改表字段长度： alter table user_tbl modify column uid varchar(50);   
---

```
CREATE TABLE `user_tbl` (
  `uid` varchar(50) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uid`)
)
```

#####  中文乱码：  
// 防止中文参数乱码 设置request 编码     
request.setCharacterEncoding("UTF-8");  ---- 只适合post方式的请求      
get方式的乱码原理：   
---
页面中文字符 --使用UTF-8编码 ---服务端使用ISO8859-1解码    
解决乱码：   
使用ISO8859-1编码--UTF-8解码 --- 逆向获取   
编码使用： String.getBytes("iso8859-1")    
解码使用：  new String(byte[] bytes, "UTF-8")   

##### 一般情况请求都是post 所以使用 setCharacterEncoding即可  

注册代码：  
```
// 注册方法
    public void regist(User user) throws SQLException {
        // 操作数据库
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user_tbl values(?,?,?,?,?,?,?,?,?,?)";
        runner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
                user.getName(), user.getEmail(),null,user.getBirthday(),
                user.getSex(),null,null);
    }
```

登录后跳转首页
---
注册成功跳转登录页面,不推荐用请求转发，需要让用户看到跳转的地址变化，使用重定向    
response.sendRedirect(request.getContextPath() + "/login.jsp");    
不直接写路径，防止后期web项目名称修改后找不到资源   

登录失败信息回显：
----
借助servlet转发请求时设置的attribute 动态改变jsp内容   



### request 总结:
1. request 获取请求行的内容 
> request.getMethod()     
> request.getRequestURI()   
> request.getRequestURL()   
> request.getContextPath()   
> request.getRemoteAddr()  

2. request 获取请求头的内容
> request.getHeader(name)

3. request 获取请求体的内容
> String request.getParameter(name)
> Map<String, String[]> request.getParameterMap()
> String[] request.getParameterValues(name)    
> Notes: 客户端发送的参数到服务器端都是字符串
********
中文乱码解决：  
> post请求： request.setCharacterEncoding("UTF-8);   
> get 请求： parameter = new String(parameter.getBytes("iso8859-1"), "UTF-8")    

4. request 转发和域
> request.getRequestDispatcher(转发的地址).forward(request,response)   
> request.setAttribute(String name,Object value);








