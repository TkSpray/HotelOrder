import Vue from "vue";
import axios from "axios";
import qs from "qs";

axios.defaults.baseURL = "http://127.0.0.1:8080";
axios.defaults.withCredentials = true;
axios.defaults.transformRequest = [
  function(data) {
    // 对 data 进行任意转换处理
    return qs.stringify(data);
  }
];

Vue.prototype.$axios = axios;
