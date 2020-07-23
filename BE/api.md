# 接口文档-慧


## 数据接口

### 订单查询

@request

```json
{
    URL: "/page/order_list",
    method: "POST"
}
```

@return

```json
{
  	status_code: Number,//200表示正常 操作成功 其他均表示出现异常 
    msg: String,
  	data: [
        {
      		orderstatus: String,  //订单状态
      		name: String, 		   //客户姓名
					phone: String,		   //电话
					roomId:String,		   //房间号
					roomtype:String,	   //房间类型
					ordertime:datetime,	  //预定时间
					preintime:datetime,   //预计入住时间
					intime:datetime,   	  //实际入住时间
					preouttime:datetime,  //预计退房时间
					outtime:datetime,	    //实际退房时间
          total:String,         //总计时间
          price:Number		      //总价
					overtime:String,      //是否超时
        }
        ...
    ]
}
```

## 房间查询

### 房间列表

@request

```json
{
    URL: "/page/room_list",
    method: "POST",
}
```

@return

```json
{
  	status_code: Number,
    msg: String,
  	data: [
        {
      		roomID: String, 	  //房间号
      		roomtype: Number,	  //房间类型
					price: Number,		  //价格
					numofpeople:Number,	//适合人数
					floor:Number,	      //楼层
					area:String,	  	  //面积
					includebrk:String,  //是否含早
					status:String,   	  //状态
        }
        ...
    ]
}
```


### 房间操作

@request

```json
{
    URL: "/page/room_list/option",
    method: "POST",
  	param: {
      roomID: String, //房间号 这个地方默认只有关闭或者开放两种可能 会直接把状态切换成另一个状态
    }
}
```

@return

```json
{
  	status_code: Number,
    msg: String		//操作成功或者出现异常			
}
```

# 接口文档-森

## 入住接口

### 客人信息与房间号录入

@request

```json
{
    URL: "/page/check_in",
    method: "POST",
    param：{
            		gId: String,         //身份证号NOT NULL
            		gName: String,       //姓名NOT NULL
            		phone: String,       //电话
    						tId: String,  		 //房间类型编号
  							ordertime:datetime,	  //预定时间
								preintime:datetime,   //预计入住时间
								intime:datetime,   	  //实际入住时间
								preouttime:datetime,  //预计退房时间
								outtime:datetime,	    //实际退房时间
        				total:String,         //总计时间
        				price:Number		      //总价
    }
}
```

@return

```json
{
  	status_code: Number,//200表示正常 操作成功 其他均表示出现异常
    msg: String
}
```

## 退房接口

输入个人信息和房间号

@request

```json
{
    URL: "/page/check_out",
    method: "POST",
    param: {
        tId: String  		//房间类型编号
    }
}
```

@return

```json
{
  	status_code: Number,
    msg: String				//操作成功或者出现异常  	
}
```

# 接口文档-凯

## 员工接口

### 使用员工ID和密码登录

登录成功进入主页面，失败给出提示
再login页面提供action为“/login”的提交按钮

@request

```json
{
    URL: "/page/login"
    param: {
        sId : String, //员工ID
        password : String  //密码
    }
}
```

@return

```json
{
    status_code: Number,
    msg: String				//操作成功或者出现异常  	
}
```

### 员工账号注册

填写员工基本信息和密码，将信息封装成Staff对象并传给后端。
register ： 提交按钮

@request
提供action为“/register”的提交按钮

```json
{
    URL:  "/page/register"
    param:{
            sId: String,         //id NOT NULL
            sName: String ,      //NOT NULL
            sGender: String,     //性别 //性别 IN ('男','女')
            phone: String,
            address: String,
            eMail: String,
            password: String ,   //NOT NULL
            remarks: String     //备注，可以为null
    }
}
```

@return
注册成功：

```json
{
    status_code: Number,
    msg: String				//操作成功或者出现异常  	
}
```

## 酒店预定接口

###客人信息登录

填写客人基本信息。点击提交按钮后，传给后端数据。
并跳转到房间筛选界面。
submit : 提交按钮，转到筛选界面

@request

```json
{
    URL: "/page/advance_Book/submit"
    param:{
        gId: String,        //身份证号NOT NULL
        gName: String,       //姓名NOT NULL
        phone: String,       //电话
  			tid: String
  			ordertime:datetime,	  //预定时间
				preintime:datetime,   //预计入住时间
				intime:datetime,   	  //实际入住时间
				preouttime:datetime,  //预计退房时间
				outtime:datetime,	    //实际退房时间
        total:String,         //总计时间
        price:Number		      //总价
    }
}
```

@return

```json
{
    URL:"page/selectRoom"   //进入房间筛选界面 ！！！
}
```

