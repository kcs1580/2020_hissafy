import Vue from "vue";
import VueRouter from "vue-router";
import InAndOut from "../views/InAndOut.vue";
import OneMode from "../views/OneMode.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "InAndOut",
    component: InAndOut,
  },
  {
    path: "/OneMode",
    name: "OneMode",
    component: OneMode,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
