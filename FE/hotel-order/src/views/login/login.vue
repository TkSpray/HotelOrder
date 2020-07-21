<template>
  <div class="login-bg">
    <div class="login-wrap">
      <header class="login-header">
        <img src="../../assets/login/logo.svg" class="login-logo" />
        <h1>
          STAR酒店前台管理系统
        </h1>
      </header>
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item>
          <el-input
            v-model="formInline.user"
            placeholder="请输入员工号"
            prefix-icon="el-icon-s-custom"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            v-model="formInline.password"
            placeholder="请输入登录密码"
            type="password"
            prefix-icon="el-icon-lock"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <img src="../../assets/login/login.svg" class="login-img" />
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      formInline: {
        user: '',
        password: '',
      },
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!')
    },
  },
}
</script>

<style>
.login-bg {
  background: url('../../assets/login/login-bg.jpg') no-repeat;
  background-size: cover;
  height: 100vh;
  width: 100vw;
  margin: 0;
  overflow: hidden;
}
.login-wrap {
  margin-top: 30vh;
  background-color: rgba(0, 0, 0, 0.498039215686275);
  color: #ffffff;
  height: 40vh;
  overflow: hidden;
}
.login-header {
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  margin: 30px auto;
  margin-bottom: 45px;
}
.login-header h1 {
  margin: 0;
  margin-left: 30px;
  font-size: 3rem;
}
.login-img {
  height: 40px;
}
</style>
