import Vue from "vue";
import VueRouter from "vue-router";
import Notice from "../views/Notice.vue";
import OneMode from "../views/OneMode.vue";
import register from "../views/register.vue"

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Notice",
    component: Notice
  },
  {
    path: "/onemode",
    name: "OneMode",
    component: OneMode
  },
  {
    path: "/register",
    name: "register",
    component: register
  }

];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;
