<template>
  <div class="home">
    <el-container class="main-container" style="height:100%">
      <el-header style="background-color:rgba(255, 197, 0, 0.823529411764706)">
        <el-row :gutter="20" class="mainhead">
          <el-col :span="12" class="head1">
            <div class="logowrapper">
              <img src="../../assets/home/logo.svg" class="logo" />
              <span class="tohome" @click="changeTitle('/home')">
                <router-link to="/home">
                  STAR酒店前台管理系统
                </router-link>
              </span>
            </div>
          </el-col>
          <el-col :span="12" class="user">
            <img src="../../assets/home/userlogo.svg" class="userlogo" />
            <span class="username">{{ admin }}</span>
            <span class="logout">
              退出登录
            </span>
          </el-col>
        </el-row>
      </el-header>
      <el-container>
        <el-aside width="220px" style="position:relative;text-align:center">
          <el-menu
            :default-active="this.$route.path"
            router
            background-color="#f2f2f2"
            @select="changeTitle"
          >
            <el-menu-item index="/home">
              <i class="el-icon-s-home"></i>
              <span style="font-weight:600;">系统首页</span>
            </el-menu-item>
          </el-menu>
          <el-menu
            :default-active="this.$route.path"
            router
            active-text-color="#c49800"
            @select="changeTitle"
            class="leftnav"
          >
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-s-order"></i>
                <span> 房间预订</span>
              </template>
              <el-menu-item index="/home/book">
                办理预订
              </el-menu-item>
              <el-menu-item index="/home/booklist">
                预订列表
              </el-menu-item>
            </el-submenu>
            <el-menu-item index="/home/checkin">
              <i class="el-icon-message-solid"></i>
              <span>来客入住</span>
            </el-menu-item>
            <el-menu-item index="/home/checkout">
              <i class="el-icon-s-release"></i>
              <span>办理退房</span>
            </el-menu-item>
            <el-menu-item index="/home/orderlist">
              <i class="el-icon-s-claim"></i>
              <span>订单列表</span>
            </el-menu-item>
            <el-menu-item index="/home/roomlist">
              <i class="el-icon-s-grid"></i>
              <span>房间列表</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>
          <header class="main-header">
            <span class="header-font"> {{ title }}</span>
          </header>
          <router-view @getTitle="changeTitle"></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pid: 0,
      admin: "817号工作人员小花",
      title: "系统首页",
      map: {
        book: "办理预订",
        booklist: "预订列表",
        checkin: "来客入住",
        checkout: "办理退房",
        orderlist: "订单列表",
        roomlist: "房间列表"
      }
    };
  },
  mounted() {
    // this.getRoom();
    // this.getOrder();
    this.$store.dispatch("getOrderlist");
    this.$store.dispatch("getRoomlist");
  },
  methods: {
    changeTitle(title) {
      let str = title.substring(6);
      this.title = str ? this.map[str] : "系统首页";
    }
    // getRoom() {
    //   this.$axios({
    //     url: "/page/room_list"
    //   }).then(res => {
    //     this.$store.commit("getRoomlist", JSON.parse(res.data).data);
    //     let list = this.$store.state.roomlist;
    //     console.log("获取到的roomlist: ", list);
    //   });
    // },
    // getOrder() {
    //   this.$axios({
    //     url: "/page/order_list"
    //   }).then(res => {
    //     this.$store.commit("getOrderlist", JSON.parse(res.data).data);
    //     let list = this.$store.state.orderlist;
    //     console.log("获取到的orderlist: ", list);
    //   });
    // }
  }
};
</script>

<style>
.home {
  height: 100%;
}
.tohome a {
  color: #000000;
  text-decoration: none;
  font-size: 1.4rem;
}
.tohome {
  margin-left: 10px;
}

.head1 {
  height: 60px;
}
.head1 span {
  text-align: center;
  line-height: 60px;
}
.user {
  text-align: right;
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: flex-end;
}
.user span {
  line-height: 60px;
}

.userlogo {
  height: 40px;
}
.maincon h2 {
  text-align: center;
  margin-top: -20px;
  margin-bottom: 10px;
}
.maintheme h2 {
  font-weight: 400;
}
.logout {
  color: #004686;
  text-decoration: underline;
}
.logout:hover {
  cursor: pointer;
}
.logo {
  width: 40px;
  height: 40px;
}
.logowrapper {
  display: flex;
  align-items: center;
}
.username {
  font-weight: 600;
  margin: 0 25px 0 15px;
}
.main-header {
  height: 56px;
  line-height: 56px;
  background-color: rgb(242, 242, 242);
  text-align: left;
  width: 100%;
  font-weight: 700;
}
.el-main {
  padding: 0;
}

.header-font {
  padding-left: 30px;
  border-left: solid 5px rgba(26, 101, 188, 1);
}

.leftnav {
  height: calc(100vh - 116px);
}
</style>
