import Vue from "vue";
import VueRouter from "vue-router";
import StudentManagement from "../views/StudentManagement"
import StudentEdit from "../views/StudentEdit"
import AttendanceCheck from "../views/AttendanceCheck"
import EarlyLeaveCheck from "../views/EarlyLeaveCheck"
import NoticeList from "../views/NoticeList"
import NoticeInfo from "../views/NoticeInfo"
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
    path:"/earlyLeaveCheck",
    name:" EarlyLeaveCheck",
    component: EarlyLeaveCheck
  },
  {
    path:"/noticeList",
    name:"NoticeList",
    component:NoticeList
  },
  {
    path:"/noticeInfo/:notice_id",
    name:"NoticeInfo",
    component:NoticeInfo
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
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;
