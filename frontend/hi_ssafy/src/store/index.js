import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    frontState: 0,
    times: {
      attendance_start_h: 1,
      attendance_start_m: 28,
      attendance_end_h: 1,
      attendance_end_m: 29,
      leaving_start_h: 1,
      leaving_start_m: 30,
      leaving_end_h: 1,
      leaving_end_m: 31 
    }
  },
  mutations: {
    changeFrontState(state,params) {
      state.frontState = params;
    },
  },
  actions: {
    changeFrontState({commit }, params) {
      window.console.log(params.cs)
      commit("changeFrontState",params.cs);
      // localStorage.setItem("modalText", '회원가입이 완료되었습니다.');
      // state.modalText = localStorage.getItem("modalText");
      // document.getElementById('modalBtn').click();
    },
  },
  modules: {}
});
