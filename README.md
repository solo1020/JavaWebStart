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

ServletConfig 对象：
===
作用：  
1. getInitParameter(鍵名):获取servlet初始化的时候附带的参数(在web.xml中)   
2. getServletName(): 获取当前servlet的servlet-name   
3. getServletContext(): 获取当前servlet的上下文对象ServletContext  

如何获取web.xml里的全局参数context-param：    
---
通过ServletContext对象去获取：  
getServletContext().getInitParameter("driver"));   



```
// content of QuickStartServlet
@Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet name: " + servletConfig.getServletName());

        String initParam = servletConfig.getInitParameter("url");
        System.out.println("servlet config : " + initParam);

        ServletContext servletContext = servletConfig.getServletContext();

        System.out.println("init running...");
    }


// content of web.xml

<!--    配置全局初始化参数-->
    <context-param>
        <param-name>driver</param-name>
        <param-value>com.mysql.jdbc.Driver</param-value>
    </context-param>


<!--    servlet类的配置-->
    <servlet>
        <servlet-name>webApp</servlet-name>
        <servlet-class>servlet.QuickStartServlet</servlet-class>
        <init-param>
            <param-name>url</param-name>
            <param-value>jdbc:mysql:///mydb</param-value>
        </init-param>



```

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

为什么重定向获取不到name属性：
===




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
> // 防止中文参数乱码 设置request 编码     
> request.setCharacterEncoding("UTF-8");  ---- 只适合post方式的请求     

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

#### 会话技术 Cookie & session
会话技术是帮助服务端区分客户端   
会话技术从打开浏览器开始到关闭浏览器结束，为一次会话   

1. cookie  
> 数据存储在客户端本地，安全性不好，客户端可以清除
2. session  
> 数据存储在服务器端，安全性好，增加服务器压力   

cookie
===
1. 服务器如何将cookie写给客户端
2. 服务器如何获取客户端携带的cookie  

创建Cookie
---
Cookie cookie = new Cookie(String cookieName, String cookieValue);  
接着该cookie会以响应头的形式发送给客户端：   
Set-cookie:"name=zhangsan"   

向客户端发送cookie: 
----
response.addCookie(Cookie cookie);   
#### cookie不能存储中文
默认cookie是会话级别,即浏览器关闭后cookie信息不存在       
常用API：
---
1. 设置cookie在客户端的持久化时间
> cookie.setMaxAge(int seconds);  
> 设置了持久化时间后 cookie则会别存储到磁盘文件里   

2. 设置cookie的携带路径  
> cookie.setPath(String path);  
> 如果不设置路径，那么默认cookie信息会在访问 产生 该cookie的 web 资源所在的路径下都携带cookie信息， 即如果访问地址是 localhost:8080/demo/cookie 那么在 所有的/demo 路径都会携带该cookie

3. 删除cookie   
> 设置同名cookie，设置一致的携带路径，将持久化时间设置为0   

4. 获取所有cookie
> Cookie[] cookies = request.getCookies()
5. 获取cookie的键名
> cookies.getName()
6. 获取cookie键值 
> cookie.getValue()  
```
// 获取客户端携带的cookie数据
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies){
                String cookieName = cookie.getName();
                if (cookieName.equals("name")){
                    String cookieValue = cookie.getValue();
                    System.out.println("cookie value: " + cookieValue);
                }
            }
        }
```

### 案例demo 记录用户上次访问时间
```
Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = format.format(date);
        // 创建cookie 存储最新访问时间
        Cookie cookie = new Cookie("lastAccessTime", currentTime);
        cookie.setMaxAge(60 * 10 * 500);
        response.addCookie(cookie);

        // 获取客户端携带的cookie
        String lastAccessTime = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie coo : cookies){
                if("lastAccessTime".equals(coo.getName())){
                    lastAccessTime = coo.getValue();
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        if (lastAccessTime == null){
            response.getWriter().write("您是第一次访问本站");
        }else {
            response.getWriter().write("您上次访问时间是： " + lastAccessTime);
        }
```

#### session 技术
session基于cookie， 需要客户端存储JSESSIONID       

1. 如何创建专属每个客户端的session存储区域
> HttpSession session = request.getSession()   

2. 如何向session中存储数据
> session.setAttribute("name", "jerry");
> String name = (String) session.getAttribute("name");
> session.removeAttribute(String name);  
3. session生命周期  
> 关闭浏览器，只会是浏览器端内存里的session cookie消失，但不会使保存在服务器端的session对象消失，同样也不会使已经保存到硬盘上的持久化cookie消失。  
> 在服务器的tomcat web.xml 或项目的web.xml配置中 session-config : session-timeout设置服务器的session过期时间   
> 服务器session过期时间是指 没有最新请求后 过30min  
> session不建议存储一次性信息    


#### 关于session和cookie失效：

+ Cookie保存在客户端浏览器，Session保存在服务器。  
+ Cookie可以设置过期时间。    
> 如果Cookie不包含到期日期，则可视为会话Cookie（Session Cookie）。会话Cookie存储在客户端的内存（浏览器占用的内存）中，决不会写入磁盘。当浏览器关闭时，Cookie将从此永久丢失。   
> 如果Cookie包含到期日期，则可视为持久性Cookie，存储在客户端的磁盘中。在指定的到期日期，Cookie将从磁盘中删除。    
+ 客户端请求服务端时，如果客户端的Cookie中没有当前会话的Session Id，则服务端会新分配一个Session，并将与该Session对应的Session Id存到Cookie中发回给客户端浏览器。      
+ 由于大部分的网站在发回Session Id时使用了会话Cookie（即没有设置过期时间），导致该Cookie存在客户端内存中，所以关闭浏览器即丢失了Session Id信息，再次访问服务端时才找不到对应的Session，于是才有了“关闭浏览器则Session过期”的说法！     
+ 服务端在保存Session时也可以设置该Session的过期时间，服务端的Web服务容器通常也有一个默认的过期时间(tomcat 30min)。若访问服务器后，保持不关闭浏览器一段时间，超过Session过期时间后再次访问，会发现依然Session过期找不到了（比如表现为跳转到登录页面），则是“没有关浏览器但Session过期了”！    
+ 当（存放着Session Id的）Cookie和Session中两者有任一过期，即宣告会话过期

#### 实现 关闭浏览器时 cookie中存储的sessionid不被删除
```
// 手动存储JSESSIONID到cookie并设置cookie持久化时间
        // 此时第一次访问/session后关闭浏览器再打开，访问/getsession 可以看到之前session设置的属性
        Cookie cookie = new Cookie("JSESSIONID",id);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 10);
        response.addCookie(cookie);
```

### 案例Demo 验证码校验功能
成语验证码中文乱码：
---
String word = new String(words.get(index).getBytes(),"UTF-8");    

### 问题
1. 用户登录信息回显 为什么是用request.setAttribute 不是response
因为 登录失败后需要自动跳转(不使用重定向)登录页面,且要通过jsp设置页面显示登录错误信息，而且该信息必须在页面加载的时候就显示出来，所以通过设置 转发前的request中添加属性,而跳转后的登录页面的 jsp 中的 request也能拿到该属性    

2. 重定向为什么无法获取设置的header属性   
因为 重定向后 客户端会重新发送请求给重定向后的地址，此时的request对象已经不是原来设置属性时的request对象    


### cookie & session 总结:
+ cookie
1. 发送cookie
> Cookie cookie = new Cookie(name,value)
> 只能存储 非中文 字符串
> cookie.setMaxAge(int second)
> cookie.setPath()
> respons.addCookie(cookie)
2. 获取cookie
> Cookie[] cookies = request.getCookies();
> cookie.getName();
> cookie.getValue();

##### cookie可以创建多个，每个cookie都是一对自定义的键值对：
获取时遍历request.getCookies里的cookie.getName() 和键比较来判断是不是想要的cookie    
```

Cookie cookie = new Cookie("myname","myage");
cookie.setMaxAge(-1);//关闭浏览器失效

Cookie cookie1 = new Cookie("myname1","myage1");
cookie1.setMaxAge(0);//立刻失效 

Cookie cookie2 = new Cookie("myname2","myage2");
cookie2.setMaxAge(3600);//1小时候生效
```


+ session
1. HttpSession sessin = request.getSession()
2. setAttribute(name,value)
3. getAttribute(name)
4. session 生命周期
> 创建：第一次指定request.getSession();
> 销毁：服务器关闭或 session失效/过期/客户端清理cookie丢失JSESSIONID
> 作用范围：默认一次会话中


### web 应用全局错误页面配置
```
<!--  web应用 全局错误页面 配置 -->
    <error-page>
        <error-code>404</error-code>
        <location>/error.jsp</location>
    </error-page>
```




#### JSP 
用servlet生成动态html代码太繁琐   

jsp脚本及注释：
===
1. <%Java代码%>  被转换成service方法内部
2. <%=Java变量或表达式%> 会被转换成service方法内out.print()
3. <%!Java代码%> 代码会被转换到生成的file_jsp.java的成员变量的位置  
4. 注释：不同注释的可见范围不一致
```
<!-- html注释-->   // 可见范围：jsp源码、jsp转换后的servet源码、html均存在

// 单行注释  // Java注释可见范围：jsp源码、jsp转换后的servet源码

/*
多行注释
*/

<%-- jsp注释 --%>    // jsp注释可见范围：只在jsp源码内可见

```
jsp运行原理：
---
jsp首次访问或更新的时候会被翻译为servlet放到tomcat的work目录下   

jsp指令：
===
1. page指令---属性最多
> language: jsp脚本可以嵌入的语言  
> contentType: response.setContentType("text/html; charset=UTF-8")
> pageEncoding: 当前jsp文件的编码
> session="True" 默认为True 可以在jsp脚本中使用session  
> import： 导入包 如 import="java.util.*"
> errorPage: 当前页面执行出错跳转的页面
如 在jsp页面Java代码内写int y = 1/0;  则会跳到errorPage 
> isErrorPage: 当前页面是一个处理错误的页面   
errorPage 只能作为 服务端错误500开头的错误导致而显示的页面  
如果是404这种找不到资源的错误 需要 在web.xml中配置全局错误页面  

```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
```
2. include 指令 页面包含   
将一个jsp页面包含到另一个jsp页面：  
```
格式： <%@include file="被包含文件的地址"%>
```
<%--引用其他页面--%>  
<%@include file="/includedDemo.jsp" %>    

应用：  
可以将页面一些重复使用的部分写到单独的jsp，如header.jsp footer.jsp 等然后在不同的页面直接引用即可  

3. taglib 指令 引入标签库
在jsp 引入jstl, struts2标签库   
格式：
```
<%@ taglib uri="标签库地址" prefix="前缀" %>
如： 
<!-- 引入-->
<%@ taglib uri="http://..." prefix="c" %>

<!-- 使用引用的库中的if 标签， prefix 用来标识哪个库 -->
<c:if></c:if>   
```

### web 应用全局错误页面配置
```
<!--  web应用 全局错误页面 配置 -->
    <error-page>
        <error-code>404</error-code>
        <location>/error.jsp</location>
    </error-page>
```

jsp内置/隐式对象
===
1. javax.servlet.jsp.JspWriter out : 用于页面输出
2. javax.servlet.http.HttpServletRequest request: 得到用户请求  
3. javax.servlet.http.HttpServletResponse response: 服务器向客户端响应信息   
4. javax.servlet.ServletConfig config : 服务器配置，可以获取初始化参数  
5. javax.servlet.http.HttpSession session: 保存用户信息
6. javax.servlet.ServletContext application ： 所有用户共享应用环境上下文
7. java.lang.Object page: 指当前页面转换后的Servlet类的实例
8. javax.servlet.jsp.PageObject pageContext : JSP页面容器   

9. java.lang.Throwable exception 表示JSP页面发生的异常，在errorPage才起作用  
exception.getMessage()   

out对象
---
类型：JspWriter  
作用：向客户端输出内容--- out.write()   
out.write()的内容写到out缓冲区  
response.getWriter().write() 写到response的缓冲区   
##### tomcat会将out 缓冲 追加到 response 缓冲区
out缓冲区默认就是jsp页面page中配置的buffer="8kb" 默认8kb   
如果将 buffer设置为0kb/none, 则 out 无法写到out缓冲区，直接写到response缓冲区  

pageContext对象
---
pageContext是域对象  
作用：   
1. 向request域存数据
pageContext.setAttribute("name","wangwu", PageContext.SESSION_SCOPE)   
pageContext.setAttribute("name","tianqi", PageContext.APPLICATION_SCOPE)  
pageContext.findAttribute("name")    
```
<%
//        使用pageContext向request域存数据
        request.setAttribute("name","zhangsan");
        pageContext.setAttribute("name","sunba");       // pageContext域
//        参数设置作用范围为 request域
        pageContext.setAttribute("name","lisi", PageContext.REQUEST_SCOPE);
//        参数作用范围为session域
        pageContext.setAttribute("name","wangwu", PageContext.SESSION_SCOPE);
//        参数作用范围为 application域 整个应用域范围
        pageContext.setAttribute("name","tianqi", PageContext.APPLICATION_SCOPE);
    %>

        <%=request.getAttribute("name")%>
    <%=pageContext.getAttribute("name",PageContext.REQUEST_SCOPE)%>

    <%--findAttribute 从域的范围从小到大依次查找该属性--%>
    <%--pageContext域 < request域 < session域 < application域--%>
    <%=pageContext.findAttribute("name")%>
```

四大作用域总结：
---
page域：当前jsp页面范围  
request域：一次请求  
session域: 一次会话   
application域：整个web应用   


2. 获取其他8 大 隐式对象
pageContext.getRequest()  
pageContext.getSession()  

jsp标签(动作)
---
1. 页面包含(动态包含): 
<jsp:include page="被包含的页面"/>   
2. 请求转发：  
<jsp:forward page="要转发的资源"/>  

动态包含和静态包含区别：  
---
1. 静态包含
静态包含是将两个页面合并在一起，再转成servlet   
2. 动态包含
动态包含是分别将两个页面都转成servlet   

### 案例demo 商品列表展示
获取数据库中商品数据：ProductServlet   
获取到商品的数据List<Product>  
servlet将该数据集合存到request域中  就可以通过jsp页面进行访问      
jsp页面进行显示该商品集合数据  

数据库基本操作：
---
```
QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product_jsp";
        List<Product> productList = null;
        try {
             productList = qr.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
```
ProductListServlet: 获取数据库中的商品信息并存储到request 域：
---
```
QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product_jsp";
        List<Product> productList = null;
        try {
             productList = qr.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //将数据存储到request域
        request.setAttribute("productList", productList);
        // 将request 域数据转发到 /product_list.jsp
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
```

jsp页面:
---
1. getAttribute获取所有的商品数据  
2. 遍历商品列表，将每个商品都按照页面的格式，使用out.write()输出
3. 访问对应的servlet 就能获取到转发后的页面数据

```
<%
			List<Product> productList = (List<Product>)request.getAttribute("productList");
			if (productList != null){
				for (Product p : productList){
					out.write("<div class='col-md-2' style='height:250px '>");
					out.write("<a href='product_info.htm'> ");

					//	out.write("<img src='products/1/cs10001.jpg' width='170' height='170' style='display: inline-block;'>");

					out.write("<img src='" + p.getPimage() +  "' width='170' height='170' style='display: inline-block;'>");
					out.write("</a>");
					out.write("<p>");

					//	out.write("<a href='product_info.html' style='color: green'>冬瓜</a>");

					out.write("<a href='product_info.html' style='color: green'>" + p.getPname() + "</a>");

					//	out.write("<p><font color='#FF0000'>商城价：&yen;299.00</font></p>");

					out.write("<p><font color='#FF0000'>商城价：&yen;" + p.getShop_price() + "</font></p>");
					out.write("</div>");

				}
			}

		%>

        <%--		<div class="col-md-2">--%>
<%--			<a href="product_info.htm">--%>
<%--				<img src="products/1/cs10001.jpg" width="170" height="170" style="display: inline-block;">--%>
<%--			</a>--%>
<%--			<p>--%>
<%--				<a href="product_info.html" style='color: green'>冬瓜</a>--%>
<%--			</p>--%>
<%--			<p><font color="#FF0000">商城价：&yen;299.00</font></p>--%>
<%--		</div>--%>
```

#### EL表达式
Express Language表达式：
---
可以嵌入jsp页面内部，减少jsp脚本的编写  
可以放在jsp的字符串内部"${request....}"
从域中取出数据： ${EL表达式}
===
jsp脚本：request.getAttribute(name);   
el表达式:   
* ${key}: 按域从小到大查找pageContext --> request session application 和pageContext.findAttribute("name") 一样       
* ${requestScope.name}      
* ${requestScope.company}   
* ${sessionScope.user.name}   
* ${applicationScope.list[1].name}   
* ${pageContextScope.key}   


jsp中创建集合new ArrayList需要指定类型，Java代码中不需要：   
List<User> list = new ArrayList<User>();  

el 内置对象：
---
* pageContextScope 
* requestScope 
* sessionScope 
* applicationScope   
* param: 相当于requset.getParameter()
* paramValues: 相当于request.getParameterValues() 获取有多个值的同一name参数如checkbox  
* header: request.getHeader(name)
* headerValues: 获取请求头信息
* initParam: 相当于全局初始化参数 this.getServletContext().getInitParameter(name)  
* cookie: request.getCookies 遍历后获取cookie.getName() cookie.getValue()  
> 使用时 如果cookie的key不为"name" 则需要使用${cookie["key"].value} 获取cookie中存储的值   
* pageContext: 获取其他八大对象    

页面加载：
---
```
<link href="${pageContext.request.contextPath}/xxx.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/yyy.js"></script>
<img src="${pageContext.request.contextPath}/1.jpg">
<img src="${pageContext.request.contextPath}/2.jpg">
<img src="${pageContext.request.contextPath}/1.jpg">
```
页面加载时先加载jsp,再请求link,script等资源，然后是图片等资源最好使用${pageContext.request.contextPath} 获取web应用的路径   

el执行表达式：
---
${1+1}   
${1==1?true:false}   
${empty user} empty关键字 判断对象是否为null,为null返回true   

JSTL jsp标准标签库：
===

* 导入jar包：  
* 使用jsp的taglib指令导入(<%@ page/include/taglib %> ):
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

jstl核心库常用标签：
---
1. test/if
test关键字代表检查引号内部的boolean表达式的真假，为真则进入，否不进入   
<c:if test=" "> 标签
```

<c:if test="${count == 10}">
        count == 10
    </c:if>
```

2. forEach
使用方式：两种组合形式    
```
<!-- 类似 for(int i = 0; i<=5; i++)  -->
<c:forEach begin="0" end="5" var="i"   >
        ${i}<br/>
    </c:forEach>

<!--
    模拟增强for循环 for(Product p: productList)
    items: 相当于productList
    var: 元素
    -->
    <c:forEach items="${productList}" var="product"  >
        ${product.pname}
    </c:forEach>

    <%
        List<String> strList = new ArrayList<String>();
        strList.add("jstl_forEach_1");
        strList.add("jstl_forEach_2");
        strList.add("jstl_forEach_3");
        strList.add("jstl_forEach_4");
        request.setAttribute("strList", strList);

        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        user.setPassword("123");
        User user1 = new User();
        user1.setId(2);
        user1.setName("lisi");
        user1.setPassword("123");
        User user2 = new User();
        user2.setId(3);
        user2.setName("wangwu");
        user2.setPassword("123");
        userList.add(user1);
        userList.add(user2);
        application.setAttribute("userList", userList);

        Map<String,String> strMap = new HashMap<String, String>();
        strMap.put("name", "lucy");
        strMap.put("age", "30");
        strMap.put("addr", "xisanqi");
        strMap.put("email", "lucy@java.com");
        session.setAttribute("strMap", strMap);

    %>

    <h1>取出strList</h1>
    <c:forEach items="${strList}" var="str" >
        ${str}<br/>
    </c:forEach>

    <h1>取出userList的数据</h1>
    <c:forEach items="${userList}" var="user" >
        user-name:${user.name}-----${user.password}<br/>
    </c:forEach>

    <h1>取出map数据</h1>
    <c:forEach items="${strMap}" var="entry" >
        ${entry.key}:${entry.value}<br/>
    </c:forEach>
```


应用：
---
网站登录后显示用户名：   
```
<!-- 用户未登录 -->
<c:if test="${empty user}">
    <li><a href="login.jsp">登录</a></li>
    <li><a href="register.jsp">注册</a></li>
</c:if>

<!-- 用户已登录 -->
<c:if test="${!empty user}">
    <li>${user.name}</li>
    <li><a href="#">退出</a></li>
</c:if>
```

#### javaEE开发模式
MVC:  web开发设计模式   
M:Model--javaBean   
V:View --视图   
C:Controller--servlet页面逻辑 封装数据 传递数据 指派显示的jsp页面   

JavaEE三层架构：  
* web层：与客户端交互  
* service 层：复杂业务处理    
* dao 层： 与数据库交互   


### 数据库JDBC事务
事务：  
一件事有n个组成单元，这n个组成单元要么同时成功，要么同时失败  

开启事务：  
start transaction;  

执行事务：  
insert into account values(null,'lucy',3000);  

提交事务：  
commit;  

回滚事务：  
rollback;  

回滚后之前的事务不会提交  

JDBC事务：
===

开启事务：  
connection.setAutoCommit(false);  

提交事务：  
connection.commit();  

回滚事务：  
connection.rollback();   

执行sql的connection和开启事务的connection必须是同一个才能对事务进行控制   


```
Connection conn = null;
try{
    class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql:///web06_1", root, password);

    // 手动开启事务
    conn.setAutoCommit(false);

    // 获取执行平台
    Statement stmt = conn.createStatement();

    // 操作sql
    // 可以将executeUpdate的返回值进行校验判断sql是否成功
    stme.executeUpdate("insert into account values(null, 'lisi', 3000);")

    // 提交事务
    conn.commit();

    stmt.close();
    conn.close();

}catch (Exception e) {
    conn.rollback();
    e.printStackTrace();
}
```

DBUtils事务操作：
====

```
Connection conn = null;
try{
    QueryRunner runner = new QueryRunner();

    conn = DataSourceUtils.getConnection();
    
    // 手动开启事务
    conn.setAutoCommit(false);

    runner.update(conn, "update account set money=15000 where name='tom');

    // 提交或回滚事务
    conn.commit();
    
}catch (Exception e) {
    conn.rollback();
    e.printStackTrace();
}
```

ThreadLocal:
===
使用ThreadLocal存储connection   

```
public class MyDataSourceUtils{
    
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    //创建ThreadLocal
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    // 开启事务
    public static void startTransaction(){
        Connection con = getCurrentConnection();
        conn.setAutoCommit(false);
    }

    //回滚事务
    public static void rollback(){
        getCurrentConnection().rollback();
    }

    //提交事务
    public static void commit(){
        Connection conn = getCurrentConnection(); 
        conn.commit();
        // 将connection从ThreadLocal中移除
        tl.remove();
        conn.close();
    }

    // 获取当前线程上绑定的conntion
    public static Connection getCurrentConnection() throws SQLException{

        // 从ThreadLocal寻找当前线程是否有对应的Connection
        Connection conn = tl.get();
        if(conn == null){
            conn = getConnection();
            // 将新创建的connection资源绑定到ThradLocal(map)上
            tl.set(conn);
        }
        return conn;
    }

    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
}
```

并发访问隔离性引起的问题：
---
1. 脏读：  
B 事务读取到了A事务尚未提交的数据
2. 不可重复读：  
一个事务中两次读取的数据不一致  
即 A 事务执行过程中 即使B事务进行了修改, A事务也不能/应该查询到更新数据   
3. 幻读/虚读:  
一个事务中两次读取的数据数量不一致  

事务的隔离级别
---
* read uncommitted 读取尚未提交的数据：不能解决以上问题  
* read committed 读取已经提交的数据，可以解决脏读--oracle默认  
* repeatable read 重读读取 可以解决 脏读 和 不可重复读--mysql默认   
* serializable 串行化 可以解决以上所有问题  

查询数据库隔离级别：
---
select @@tx_isolation  

设置mysql隔离级别:
---
set session transaction isolation level read uncommitted   

问题：
---
使用repeatable read 级别时，后修改的commit是否会覆盖前面的事务修改????  


### 后台页面增删改查：
```
d = new dTree('d');

//01代表本级节点的编号  -1代表根节点
d.add('01',-1,'系统菜单树'); 

//0102代表本级节点编号，01 代表父级节点
d.add('0102','01','分类管理','','','mainFrame');  

// 点击本级时 将list.jsp显示到 mainFrame 类似a 标签的 href 和 target
d.add('010201','0102','分类管理','${pageContext.requestcontextPath}/admin/category/list.jsp','','mainFrame'); 

d.add('0104','01','商品管理');
d.add('010401','0104','商品管理','${pageContext.requestcontextPath}/admin/product/list.jsp','','mainFrame');
document.write(d);
```
一般：  
有事务控制在service层try catch   
没有 在web层进行catch 并显示

```
jstl循环状态
<c:forEach items="${productList}" var="pro" varStatus="vs">
```

新增商品页面中的商品类别需要进行动态加载，因为可能类别信息已经经过修改，所以需要在新增按钮的事件设置成servlet，并在servlet中查询数据库，存储到request域中再转发给页面中显示， 而不是静态jsp  
或者 通过Ajax 在jsp中加载   

文件上传：  
```
enctype="multipart/form-data"
```

一般 没有request 域数据的传递都使用重定向进行跳转   
如果有 使用转发  

##### 后台页面新增商品功能：
1. 首先需要根据数据库动态的更新页面的商品类别字段
2. 通过在点击添加按钮的时候跳转到servlet而不是jsp(后期可以用Ajax在jsp中解决数据动态更新问题)  
3. 在servlet中一层层调用到dao层查询商品类别的数据库并返回，然后存储到request域中
4. 跳转到新增商品的jsp时，使用jstl表达式foreach遍历商品的类别，完成页面的更新  
5. 点击确定提交按钮的绑定事件，form表单的action路径到servlet
6. servlet中获取表单提交的新增商品数据，在servlet中调用service，service中调用dao更新数据库插入
7. 插入完成后再跳转至商品列表，需要进行一次查询操作并显示
```
// 步骤1，2，3

// AdminAddProductUIServlet.java
// 获取所有的商品的类别数据
    AdminProductService service = new AdminProductService();
    List<Category> categoryList = null;
    try {
        categoryList = service.findAllCategory();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    request.setAttribute("categoryList", categoryList);
    request.getRequestDispatcher("/admin/product/add.jsp").forward(request,response);

// AdminProductDao.java
public List<Category> findAllCategory() throws SQLException {
    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select * from category_admin";
    List<Category> list = runner.query(sql, new BeanListHandler<Category>(Category.class));
    return list;
}

//步骤4
// add.jsp
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<select name="cid">

	<c:forEach items="${categoryList}" var="category">
		<option value="${category.cid}">${category.cname}</option>
	</c:forEach>

<%--	<option value="">大型电器</option>--%>
<%--	<option value="">手机数码</option>--%>
<%--	<option value="">衣帽箱包</option>--%>
</select>

//步骤5
// add.jsp
<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/adminAddProduct" method="post"

//步骤6
//AdminAddProductServlet.java
// 获取表单提交的数据
    Map<String, String[]> parameterMap = request.getParameterMap();
    // 封装数据 使用beanutils
    // beanutils 使用必须保证表单中的name 和对象的属性名一致
    Product product = new Product();
    try {
        BeanUtils.populate(product, parameterMap);
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    }
    // 此时Product对象已经封装完毕
    // 手动设置product其他属性 和中文乱码问题解决
    // pid
    product.setPid(UUID.randomUUID().toString());
    // pimage
    product.setPimage("products/1/c_0033.jpg");
    // pdate 上架日期
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String pdate = format.format(new Date());
    product.setPdate(pdate);
    // pflag 是否下架 0代表未下架
    product.setPflag(0);
    // 传递数据给service 层
    AdminProductService service = new AdminProductService();
    try {
        service.addProduct(product);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    

//步骤7
//AdminAddProductServlet.java
//此时不能跳转到jsp,因为jsp需要从数据库查询数据，跳转到 AdminProductListServlet
    response.sendRedirect(request.getContextPath() + "/adminProductList");

```

##### 后台页面删除商品功能
1. 首先实现页面的确认删除按钮
2. 在确认删除按钮点击时，获取商品的id信息
3. 在对应servlet中传递请求到dao层删除数据
4. 返回页面后查询最新数据

注意事项：  

1. 因为删除按钮是a标签,默认会在执行完onclick()后继续跳转href链接, 即使改成"#" 也会跳转本页,体验不好
2. 需要将href跳转这个操作屏蔽掉，使用：href="javascript:void(0);"  
2. 在弹窗完毕后如何判断是否进行了跳转本页的操作：  
3. 点击页面下半部分，如果进行了跳转本页，会自动跳转到页面起始位置，如果没有跳转，则保持当前页面的进度

```
<td align="center" style="HEIGHT: 22px">
	<a
			href="javascript:void(0);"
			onclick="delProduct()"
	>
		<img src="${pageContext.request.contextPath}/images/i_del.gif"
		width="16" height="16" border="0" style="CURSOR: hand">
	</a>
</td>
```
如何在点击事件获取商品的id信息：   
通过在jstl表达式的foreach循环中拿到每个product的id,传递给onlick(product.pid)方法即可   
代码：  
```
onclick="delProduct('${pro.pid}')"
```

servlet代码：  
```
package adminpage.web;

import adminpage.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @ClassName ${NAME}
 * @description:
 * @author: QZ
 * @time: 2020/11/6 0:12
 */
@WebServlet(name = "AdminDelProductServlet")
public class AdminDelProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取传递的参数pid
        String pid = request.getParameter("pid");

        // 传递pid到service层
        AdminProductService service = new AdminProductService();
        try {
            service.deleteProductByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 刷新页面
        response.sendRedirect(request.getContextPath() + "/adminProductList");
    }
}

```

#### jsp中引入jquery失败：

点击更新按钮时，如何从数据库的商品信息中拿到商品分类并在页面显示正确选中的分类：  
```
<script type="text/javascript">

    //页面加载完成后 确定商品类别的哪个select 被选中
    window.onload = function () {
        // 获取当前回显商品数据的cid
        var cid = "${product.cid}";
        // 获取所有select 元素的option
        var options = document.getElementById("cid").getElementsByTagName("option");
        // alert(cid);
        // 比较每个option 的value 与cid
        for(var i=0;i<options.length;i++){
            if(cid==options[i].value){
                options[i].selected = true;
            }
        }
        var is_hot = ${product.is_hot};
        var is_hot_option = document.getElementById("is_hot").getElementsByTagName("option");
        for(var n = 0; n<is_hot_option.length; n++){
            if(is_hot == is_hot_option[n].value){
                is_hot_option[n].selected = true;
            }
        }
    }

</script>


<td class="ta_01" bgColor="#ffffff">
	
	<select  id="is_hot" name="is_hot">
		<option value="1">是</option>
		<option value="0">否</option>
	</select>
</td>

```

##### 商品搜索和分页功能：
```
<form id="Form1" name="Form1"
action="${pageContext.request.contextPath}/user/list.jsp"
method="post">
    商品名称：<input type="text" name="pname" autocomplete="off">&nbsp;&nbsp;
    是否热门：<select name="is_hot">
                <option value="0">否</option>
                <option value="1">是</option>
            </select>&nbsp;&nbsp;
    商品类别：<select name="cid">
                <option value="">手机数码</option>
                <option value="">电脑办公</option>
            </select>&nbsp;&nbsp;
    <input type="submit" value="搜索按钮">
        <table style="margin-top: 10px" cellSpacing="1" cellPadding="0" width="100%" align="center"
            bgColor="#f5fafe" border="0">
            <TBODY>
```

将request参数封装到实体：   
BeanUtils.populate(condition,parameterMap);   

### Ajax
同步异步：  
同步：客户端发送请求到服务端，当服务器返回响应之前，客户端都处于等待卡死状态  
异步：客户端发送请求，无论服务器是否返回响应，客户端都可以随意进行其他事件不会被卡死   

体现在页面中就是：  
同步按钮点击后其他的按钮点击没反应  
异步按钮点击后其他的按钮点击立即执行


Ajax原理:  
页面发起请求，会将请求发送给浏览器内核的Ajax引擎，该引擎会提交请求到服务端，在这段时间内，客户端可以进行任意操作，知道服务器将数据返回Ajax引擎后，会触发设置的事件，从而执行自定义的js逻辑代码完成功能   

onreadystatechange事件：  
每当readystate改变时，触发onreadystatechange事件   
readystate: 存有XMLHTTPRequest的状态，从0到4变化  
0：请求未初始化  
1：服务器连接已建立  
2：请求已接收  
3：请求处理中  
4：请求已完成，且响应已就绪   

```
function fun1(){
    // 创建ajax引擎对象---所有操作都是通过引擎对象
    var xmlHttp = new XMLHttpRequest();
    // 绑定监听---监听服务器是否已经返回相应数据
    xmlHttp.onreadystatechange = function(){

        if(xmlHttp.readystate == 4 && xmlHttp.status == 200){
            // 接收相应数据
            var res = xmlHttp.responseText;
            alert(res)
        }
        
        alert(res);
    }
    xmlHttp.open("GET","/webproject/ajaxServlet",true);
    xmlHttp.send();
}
```
##### AJax优势：  
可以直接更新一部分网页内容，而不需要重新刷新整个网页  
可以异步访问  

##### Ajax传递参数
GET请求：  
直接在ajax引擎对象的open方法传递的url路径中给出  
POST请求：  
先使用setRequestHeader() 添加http头,再在ajax引擎对象的send方法中传递  
xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");  

##### Json
json是js的原生内容，js可以直接取出json对象中的数据   
js中使用json:  
```
<script language="JavaScript">
  	/**
	 * 案例二
	 *  [{key:value,key:value},{key:value,key:value}]
	 *  
	 */

  	var persons = [
      {
        "firstname":"张",
        "lastname":"三丰",
        "age":100
      },
      {
        "firstname":"李",
        "lastname":"四",
        "age":80
      }
    ];

  	// 数组取值
    alert(persons[1].firstname);


    var json = {
	   "baobao":[
         {
           "name":"小双",
           "age":28,
           "addr":"扬州"
         },{
           "name":"建宁",
           "age":18,
           "addr":"紫禁城"
         },{
           "name":"阿珂",
           "age":10,
           "addr":"山西",
           "father":"李自成"
         }
       ]
	 };

	 // 取建宁
	 alert(json.baobao[1].name);
	 // 取addr 山西
	 alert(json.baobao[2].addr)
	 
  </script>
```

#### jquery的Ajax
* jQuery.get(url,[data],[callback],[type])  
url: 请求页面的地址  
data: 待发送的key/value参数数据  
callback: 请求成功时的回调函数  
type: 返回内容的格式 xml html script json text   

jQuery ajax请求 get 和post的区别：  
除了传统的区别，jquery ajax 的post方法解决了get方法的中文乱码问题   
传统的get 请求和post请求如果出现中文乱码，添加request.setCharacterEncoding("UTF-8") 可以解决，但是jquery ajax中该方法无效  

```
// jquery_ajax.html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">

        // $(function () {
        //    alert("check jQuery");
        // });

        function f1() {
            //get 异步访问
            $.get(
                "/jqueryAjaxServlet", // url
                {"name":"张三","age":25}, // 请求参数
                function (data) { // 执行成功后的回调
                    // {"name":"tom","age":21}
                    alert(data.name);
                },
                // "text" //返回数据的类型
                "json"
            );
        }
        function f2() {
            //post异步访问
            $.post(
                "/jqueryAjaxServlet", // url
                {"name":"李四","age":25}, // 请求参数
                function (data) { // 执行成功后的回调
                    // {"name":"tom","age":21}
                    alert(data.name);
                },
                // "text" //返回数据的类型
                "json"
            );

        }

        function f3() {
            //jquery.ajax()方法发送请求
            $.ajax(
                {
                    url:"/jqueryAjaxServlet",
                    async:true,
                    type:"POST",
                    data:{"name":"鲁西", "age":18},
                    success:function (data) {
                        alert(data.name);
                    },
                    error:function () {
                        alert("请求失败");
                    },
                    dataType:"json"

                }
            );

        }
    </script>
</head>
<body>
    <input type="button" value="get访问服务器端" onclick="f1()"><span id="span1"></span>
    <br>
    <input type="button" value="post访问服务器端" onclick="f2()"><span id="span22"></span>
    <br>

    <input type="button" value="Ajax方法访问服务器端" onclick="f3()"><span id="span33"></span>
    <br>
</body>
</html>



// JqueryAjaxServlet.java
package ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ${NAME}
 * @description: jquery 的ajax 请求响应servlet
 * @author: isquz
 * @time: 2020/12/20 13:58
 */
@WebServlet(name = "jqueryAjaxServlet")
public class JqueryAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name + " " + age);

        int i = 1 / 0;  // 演示ajax 方法请求失败的error回调

        // jquery ajax 解析返回数据时指定为json会报错，实际返回的是字符串
        // java代码只能返回一个json 格式的字符串

//        response.getWriter().write("success...");
        response.setContentType("text/html;charset=UTF-8");// 解决响应数据中文乱码
        response.getWriter().write("{\"name\":\"汤姆\",\"age\":21}");
    }
}

```

关注点：  
点击事件的经典jQuery写法 $.post()方法，参数按照api文档定义的url,请求参数,回调函数,返回数据类型传递即可
回调方法中的形参名可以任意，一般写成data，data中即为 response 封装的数据  

* jquery.ajax({option1:value1, option2:value2...});  
常用选项参数：  
async:是否异步 默认true 即异步  
