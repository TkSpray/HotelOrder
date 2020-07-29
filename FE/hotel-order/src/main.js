import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import getList from "./plugin/getdata";

import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";

import "./axios";

Vue.use(ElementUI);
Vue.use(getList);

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
