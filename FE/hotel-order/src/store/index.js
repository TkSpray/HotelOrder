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
  actions: {},
  modules: {}
});
