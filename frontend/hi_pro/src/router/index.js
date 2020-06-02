import Vue from "vue";
import VueRouter from "vue-router";
import StudentManagement from "../views/StudentManagement"
import StudentEdit from "../views/StudentEdit"
import AttendanceCheck from "../views/AttendanceCheck"
import NoticeList from "../views/NoticeList"
import AddNotice from "../views/AddNotice"
import TimeConfig from "../views/TimeConfig"

import Home from"../views/Home"
Vue.use(VueRouter);

// const rejectAuthUser =(to,from,next)=>{
//   if(StorageEvent.getters.isAuthenticated ===false){
//     alert("로그인 해야 사용하실 수 있습니다.")
//     next("/")
//   }else{
//     next()
//   }
// }

const routes = [

  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/studentManagement",
    name: "StudentManagement",
    component: StudentManagement
  },
  {
    path:"/attendanceCheck",
    name:"AttendanceCheck",
    component:AttendanceCheck
  },
  {
    path:"/noticeList",
    name:"NoticeList",
    component:NoticeList
  },
  {
    path:"/addNotice",
    name:"AddNotice",
    component:AddNotice
  },
  {
    path:"/timeConfig",
    name : TimeConfig,
    component :TimeConfig
  },
  {
    path:"/updateStudent",
    name :StudentEdit,
    component:StudentEdit
  }
  // {
  //   path: "/about",
  //   name: "About",
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () =>
  //     import(/* webpackChunkName: "about" */ "../views/About.vue")
  // }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;
