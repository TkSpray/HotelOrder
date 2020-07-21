<template>
  <div class="login-bg">
    <div class="login-wrap">
      <header>
        <img src="../../assets/login/logo.svg" class="login-logo" />
        <h1>
          STAR酒店前台管理系统
        </h1>
      </header>
      <b-form inline>
        <label class="sr-only" for="inline-form-input-name">Name</label>
        <b-input
          id="inline-form-input-name"
          class="mb-2 mr-sm-2 mb-sm-0"
          placeholder="Jane Doe"
        ></b-input>

        <label class="sr-only" for="inline-form-input-username">Username</label>
        <b-input-group class="mb-2 mr-sm-2 mb-sm-0">
          <b-icon icon="person"></b-icon>
          <b-input
            id="inline-form-input-username"
            placeholder="Username"
          ></b-input>
        </b-input-group>

        <b-form-checkbox class="mb-2 mr-sm-2 mb-sm-0"
          >Remember me</b-form-checkbox
        >

        <b-button variant="primary">Save</b-button>
      </b-form>
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
}
</style>
