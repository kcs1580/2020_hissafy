import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    frontState: 0,
    times: {
      attendance_start_h: 21,
      attendance_start_m: 58,
      attendance_end_h: 22,
      attendance_end_m: 5,
      leaving_start_h: 22,
      leaving_start_m: 10,
      leaving_end_h: 22,
      leaving_end_m: 15 
    }
  },
  mutations: {
    changeFrontState(state,params) {
      state.frontState = params;
    },
  },
  actions: {
    changeFrontState({commit }, params) {
      // window.console.log(params.cs)
      commit("changeFrontState",params.cs);
      // localStorage.setItem("modalText", '회원가입이 완료되었습니다.');
      // state.modalText = localStorage.getItem("modalText");
      // document.getElementById('modalBtn').click();
    },
  },
  modules: {}
});
