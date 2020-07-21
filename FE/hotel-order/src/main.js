import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import qs from 'qs'
import axios from 'axios'
import { BootstrapVue, BootstrapVueIcons } from 'bootstrap-vue'

Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'bootstrap-vue/dist/bootstrap-vue-icons.min.css'

Vue.config.productionTip = false
Vue.prototype.$axios = axios.create({
  baseURL: '',
  //请求前处理数据
  transformRequest: [
    function(data) {
      console.log(data)
      data = qs.stringify(data)
      return data
    },
  ],
  //请求等待超时时间则中断
  timeout: 1500,
  //请求后的data处理
  transformResponse: [
    function(data) {
      console.log(data)
      return data
    },
  ],
})

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app')
