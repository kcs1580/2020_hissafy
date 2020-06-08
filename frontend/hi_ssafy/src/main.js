import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import InfiniteScroll from 'v-infinite-scroll'
import 'v-infinite-scroll/dist/v-infinite-scroll.css'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import vueMoment from 'vue-moment';
import VueSimpleAlert from "vue-simple-alert";

Vue.use(vueMoment)
Vue.use(InfiniteScroll)
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(VueSimpleAlert);

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount("#app");
