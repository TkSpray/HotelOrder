import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import qs from "qs";
import axios from "axios";

import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";

Vue.use(ElementUI);

Vue.config.productionTip = false;
Vue.prototype.$axios = axios.create({
  baseURL: "",
  //请求前处理数据
  transformRequest: [
    function(data) {
      data = qs.stringify(data);
      return data;
    }
  ],
  //请求等待超时时间则中断
  timeout: 1500,
  //请求后的data处理
  transformResponse: [
    function(data) {
      return data;
    }
  ]
});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
