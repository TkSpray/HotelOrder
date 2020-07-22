<template>
  <div>
    <el-container class="maincon">
      <el-header style="background-color:rgba(255, 197, 0, 0.823529411764706)">
        <el-row :gutter="20" class="mainhead">
          <el-col :span="12" class="head1">
            <div class="logowrapper">
              <img src="../../assets/home/logo.svg" class="logo" />
              <span class="tohome">
                <router-link to="/adminindex">STAR酒店前台管理系统</router-link>
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
        <el-aside width="220px">
          <el-menu
            :default-active="this.$route.path"
            router
            background-color="#f2f2f2"
          >
            <el-menu-item>
              <i class="el-icon-s-home"></i>
              <span style="font-weight:600;">系统首页</span>
            </el-menu-item>
          </el-menu>
          <el-menu
            :default-active="this.$route.path"
            router
            active-text-color="#c49800"
          >
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-s-order"></i>
                <span> 房间预订</span>
              </template>
              <el-menu-item index="/adminindex/examining">
                办理预订
              </el-menu-item>
              <el-menu-item index="/adminindex/examined">
                预订列表
              </el-menu-item>
            </el-submenu>
            <el-menu-item>
              <i class="el-icon-message-solid"></i>
              <span>来客入住</span>
            </el-menu-item>
            <el-menu-item>
              <i class="el-icon-s-release"></i>
              <span>办理退房</span>
            </el-menu-item>
            <el-menu-item>
              <i class="el-icon-s-claim"></i>
              <span>订单列表</span>
            </el-menu-item>
            <el-menu-item>
              <i class="el-icon-s-grid"></i>
              <span>房间列表</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>
          <div class="maintheme">
            <h2>{{ title }}</h2>
          </div>
          <router-view :key="key"></router-view>
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
      admin: '817号工作人员小花',
      title: '',
      key: 1,
    }
  },
  methods: {
    // async logout() {
    //   document.cookie = ''
    //   this.$store.commit('change_state', {
    //     logined: false,
    //     type: 0,
    //   })
    //   try {
    //     await api.user.logout()
    //   } catch (e) {}
    //   this.$router.push('/login')
    // },
  },
}
</script>

<style>
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
</style>
