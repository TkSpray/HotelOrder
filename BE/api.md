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

- 1、用户登录
- 2、用户注册
- 3、酒店预订
- 4、预订订单变为入住订单
- 5、预订订单的取消
- 5、退房订单的完成


## 用户登录

@request

```json
{
    contentType:"application/json",

    param:{
        staffid:String,  //用户ID
        password:String  //密码
    }
}

```
@return

```json
{
    param:{
        code:int,       //0:登录成功，-1：账号错误，1：密码错误
        message:String  //（登录成功，账号错误，密码错误）
    }
}
```


## 用户注册

@request

```json
{
    URL:"/register",

    contentType:"application/json",

    param:{
            staffid:String, //员工注册ID
            name:Strng,     //姓名
            phone:String,   //电话
            password:String //密码
    }
}
```

@return

```json
{
    param:{
        code:int,       //0-注册成功    -1-注册失败，账号ID已近存在
        message:String  //提示信息
    }
}
```

# 酒店预订模块

- 客人预订

@request

```json
{
    URL:"/book",
    contentType:"application/json",
    param:{
            guestid:String,        //身份证ID
            name:String,           //姓名
            phone:String,          //电话
            roomid:String,         //房间ID
            ordertime:Date,        //预订时间
            preintime:Date,        //预计入住时间
            preouttime:Date,       //预计退房时间
            total: String          //住几晚
    }
}
```

@return

```json
{
    param:{
        code:int,       //0-预订成功    -1-失败
        message:String  //提示信息
    }
}
```

- 预订变为入住订单

@request

```json
{
    URL:"/book_to_order",
    contentType:"application/json",
    param:{
        orderid:int,
        roomid:String,     //对应订单的房间ID
        intime:Date,    //入住时间
        price:int       //应付金额
    }
}
```

@return

```json
{
    param:{
        code:int,       //0-入住成功    -1-失败
        message:String  //提示信息
    }
}
```


- 预订订单取消

@request

```json
{
    URL:"/cancelbook",

    param:{
            orderid:int,    //订单ID
    }
}
```

@return

```json
{
    param:{
        code:int,       //0-入住成功    -1-失败
        message:String  //提示信息
    }
}
```


## 退房操作

@request
```json
{
    URL:"checkout",

    param:{
        orderid:int,        //订单ID
        outtime:Date       //退房时间
    }
}
```

@return

```json
{
    param:{
        code:int,       //0-入住成功    -1-失败
        message:String  //提示信息
    }
}
```