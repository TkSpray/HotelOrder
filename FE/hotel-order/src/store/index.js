import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    roomlist: [],
    orderlist: []
  },
  mutations: {
    getRoomlist(state, list) {
      state.roomlist = list;
    },
    getOrderlist(state, list) {
      state.orderlist = list;
    }
  },
  actions: {
    getRoomlist(context) {
      Vue.prototype
        .$axios({
          url: "/page/room_list"
        })
        .then(res => {
          console.log("获取到的roomlist: ", res.data.data);
          context.commit("getRoomlist", res.data.data);
        });
    },
    getOrderlist(context) {
      Vue.prototype
        .$axios({
          url: "/page/order_list"
        })
        .then(res => {
          console.log("获取到的orderlist: ", res.data.data);
          context.commit("getOrderlist", res.data.data);
        });
    }
  },
  modules: {}
});
