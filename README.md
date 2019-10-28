# My cart 
该项目是基于JavaEE的web项目，实现了基本的购物功能，并保存用户数据和订单到MySQL数据库。功能包括了`用户注册`，`用户登录`，`商品页面`，`购物车页面`，`用户订单中心页面`。

该项目使用了tomcat服务器，servlet技术，jsp技术，同时包括基本的前端技术：html,css,js,Ajax,jQuery。有部分实现了mvc设计模式。

## 功能界面一览
### 1.用户登录
![login](https://github.com/chajiuqqq/cart/blob/master/img/login.png)
#### 它能够：
* 登录
* 注册
#### 路径
http://127.0.0.1:8080/cart/login.jsp

### 2.用户注册
![register](https://github.com/chajiuqqq/cart/blob/master/img/register.png)


#### 它能够：
* 检测用户名是否重复
* 确认两次密码是否一致
![confirm_register](https://github.com/chajiuqqq/cart/blob/master/img/register_confirm.png)

#### 路径
http://127.0.0.1:8080/cart/register.jsp


### 3.商品页面
![products](https://github.com/chajiuqqq/cart/blob/master/img/listProduct.png)
#### 路径
http://127.0.0.1:8080/cart/listProduct

#### 它能够：
* 显示用户是否已登录，登录了就显示用户昵称
![is_login](https://github.com/chajiuqqq/cart/blob/master/img/islogin.png)
* 提供`我的订单`链接
* 可以把指定数量的商品加入购物车，并显示购物车

### 4.购物车页面
![cart](https://github.com/chajiuqqq/cart/blob/master/img/cart.png)

#### 它能够：
* 显示加入的商品名称、单价、数量和小计
* 显示购物车总金额
* 提交您的订单

#### 路径
http://127.0.0.1:8080/cart/listcart.jsp

### 5.用户订单中心页面
![myorder](https://github.com/chajiuqqq/cart/blob/master/img/myOrder.png)

#### 它能够：
* 按订单创建顺序显示订单和商品信息
![show_orders](https://github.com/chajiuqqq/cart/blob/master/img/orders_detail.png)

#### 路径
http://127.0.0.1:8080/cart/myorders
## 需要改进的地方
界面没有美化，开发过程中也没有使用框架，这对后期维护造成了困难。

## 联系我
chajiuqqq@outlook.com

## 参考
[how2j mycart](http://how2j.cn/k/cart/cart-tutorials/595.html)
