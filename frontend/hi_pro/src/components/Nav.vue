<template>
  <div class="nav">
    <div class="header">
      <div class="content">
        <router-link to="/">
          <ul class="home">
            <img src="../assets/header-logo.jpg" />
          </ul>
        </router-link>

        <ul class="menu" @mouseover="active=true" @mouseout="active=false">
          <li>
            <a>교육생관리</a>
          </li>
          <!-- //교육생관리 -->
          <li>
            <a href="#">출결관리</a>
          </li>
          <!--//출결관리 -->
          <li>
            <a href="#">설정</a>
          </li>
          <!-- //설정 -->
        </ul>

        <ul class="profile">
          <a href>
            <img src="../assets/user.svg" alt="프로필사진" />
            <strong>운영</strong>
            <span>pro님</span>
          </a>
        </ul>
        <!-- //profile -->
      </div>
    </div>
    <!-- //header -->
    <transition name="slide-down">
      <div class="slid-menu" v-show="active" @mouseover="active=true" @mouseout="active=false">
        <div class="content">
          <ul>
            <li>
              <router-link to="/studentManagement">교육생관리</router-link>
            </li>
          </ul>
          <ul>
            <li>
              <router-link to="/attendanceCheck">입 &middot; 퇴실 조회</router-link>
            </li>
            <li>
              <router-link to="/earlyLeaveCheck">외출 &middot; 조퇴 조회</router-link>
            </li>
          </ul>
          <ul>
            <li>
              <router-link to="/noticeList">공지사항 관리</router-link>
            </li>
            <li>
              <router-link to="/timeConfig">입&middot;퇴실 모드 관리</router-link>
            </li>
          </ul>
        </div>
        <!-- //content -->
      </div>
      <!-- //slid-menu -->
    </transition>
  </div>
  <!-- //nav -->
</template>

<script>
export default {
  data() {
    return {
      active: false // slid-menu toggle
    };
  },
  methods: {}
};
</script>

<style>
.slide-down-enter,
.slide-down-leave-active {
  opacity: 1;
  transform: scaleY(0);
}

.nav {
  width: 100%;
  position: relative;
  align-content: center;
  overflow: hidden;
}
.nav .header {
  width: 100%;
  height: 100px;
  border-bottom: 1px solid #ccc;
  position: relative;
  overflow: hidden;
}

.header .content {
  margin-left: 10%;
  width: 80%;
  position: relative;
  overflow: hidden;
}
ul.home {
  width: 20%;
  height: 100px;
  float: left;
  display: block;
  height: inherit;
}
ul.home img {
  margin: 10% 50%;
  vertical-align: middle;
}
.content .menu {
  width: 60%;
  float: left;
  position: relative;
  overflow: hidden;
  padding-left: 0;
}

.menu a {
  display: block;
  float: left;
  width: 33.3%;
  height: inherit;
  font-size: 18px;
  text-align: center;
  line-height: 100px;
  margin: 0 auto;
}
.menu a:hover {
  color: #3395f4 !important;
}

.content .profile {
  width: 20%;
  height: 100px;
  float: left;
}
.profile a {
  display: block;
  margin: 15% 50% 0 0;
}
.profile a:hover {
  color: #3395f4 !important;
}
.content .profile img {
  width: 23%;
  margin-right: 5px;
  vertical-align: middle;
}

.slid-menu {
  transform-origin: top;
  transition: 0.4s ease-in-out;
  width: 60%;
  margin-left: 20%;
  padding-top: 15px;
  padding-bottom: 15px;
  text-align: center;
  overflow: hidden;
  position: relative;
  border: 1px solid #ccc;
  border-top: 1px solid#fff;
  background: #fff;
}
.slid-menu .content {
  width: 80%;
  overflow: hidden;
  position: relative;
  margin: 0 auto;
}
.slid-menu .content ul {
  float: left;
  width: 33.3%;
  padding-left: 0;
}
.slid-menu .content ul li:hover {
  color: #3395f4 !important;
}

ul,
li {
  list-style: none;
}
.nav a {
  color: #222 !important;
  text-decoration: none;
}
</style>