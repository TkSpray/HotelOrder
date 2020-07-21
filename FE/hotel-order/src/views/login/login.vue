<template>
  <div class="login-bg">
    <div class="login-wrap">
      <header class="lg-header">
        <img src="../../assets/login/logo.svg" class="login-logo" />
        <h1>
          STAR酒店前台管理系统
        </h1>
      </header>
      <nav class="lg-nav">
        <b-form inline>
          <label class="sr-only" for="inline-form-input-name">Name</label>
          <b-input
            id="inline-form-input-name"
            class="mb-2 mr-sm-2 mb-sm-0"
            placeholder="请输入员工号"
          ></b-input>

          <label class="sr-only" for="inline-form-input-username"
            >Username</label
          >
          <b-input-group class="mb-2 mr-sm-2 mb-sm-0">
            <!-- <b-icon icon="person"></b-icon> -->
            <b-input
              id="inline-form-input-password"
              placeholder="请输入登录密码"
              type="password"
            ></b-input>
          </b-input-group>

          <!-- <b-form-checkbox class="mb-2 mr-sm-2 mb-sm-0"
            >Remember me</b-form-checkbox
          > -->

          <b-button variant="primary">登录</b-button>
        </b-form>
      </nav>
    </div>
  </div>
</template>

<script>
export default {}
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
.lg-header {
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  margin: 30px auto;
}
.lg-header h1 {
  margin: 0;
  margin-left: 30px;
  font-size: 3rem;
}
.lg-nav {
  display: flex;
  justify-content: center;
}
</style>
