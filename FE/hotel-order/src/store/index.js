import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    roomlist: [],
  },
  mutations: {
    getRoomlist(state, list) {
      state.roomlist = list
    },
  },
  actions: {},
  modules: {},
})
