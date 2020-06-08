import Vue from "vue";
import VueRouter from "vue-router";
import InAndOut from "../views/InAndOut.vue";
import OneMode from "../views/OneMode.vue";
import register from "../views/register.vue"

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "InAndOut",
    component: InAndOut
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
