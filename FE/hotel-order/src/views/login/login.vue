<template>
  <div class="login-bg">
    <div class="login-wrap">
      <header class="login-header">
        <img src="../../assets/login/logo.svg" class="login-logo" />
        <h1>
          STAR酒店前台管理系统
        </h1>
      </header>
      <el-form :inline="true" :model="formInline" class="form-inline">
        <el-form-item>
          <el-input
            v-model="formInline.staffid"
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
            @keyup.enter.native="onSubmit"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <img
            src="../../assets/login/login.svg"
            class="login-img"
            @click="onSubmit"
          />
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
        staffid: "",
        password: ""
      }
    };
  },
  methods: {
    onSubmit() {
      console.log(this.formInline);
      this.$axios({
        url: "/login",
        params: this.formInline
      }).then(res => {
        if (res.data.code == 0) {
          this.$store.commit("getName", res.data.data);
          console.log(this.$store.state.name);
          this.$router.push({ name: "home" });
        } else if (res.data.code == -1) {
          this.$message({
            type: "error",
            message: "用户名或密码错误"
          });
        } else {
          this.$message({
            type: "error",
            message: "网络错误"
          });
        }
      });
    }
  }
};
</script>

<style>
.login-bg {
  background: url("../../assets/login/login-bg.jpg") no-repeat;
  background-size: cover;
  height: 100vh;
  width: 100vw;
  margin: 0;
  overflow: hidden;
  position: relative;
}
.login-wrap {
  position: absolute;
  background-color: rgba(0, 0, 0, 0.498039215686275);
  color: #ffffff;
  overflow: scroll;
  width: 100%;
  top: 50%;
  transform: translateY(-50%);
}
.form-inline {
  width: 460px;
  margin: 0 auto;
}
.login-header {
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  margin: 30px auto;
  margin-bottom: 45px;
  min-width: 700px;
}
.login-header h1 {
  margin: 0;
  margin-left: 30px;
  font-size: 3rem;
}
.login-img {
  height: 40px;
  cursor: pointer;
}
</style>
