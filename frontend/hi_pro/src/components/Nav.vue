<template>
  <div class="nav">
    <div class="content">
      <div class="header">
        <ul class="home">
          <img src="../assets/header-logo.jpg" />
        </ul>
        <ul class="menu">
          <li>
            <a>교육생관리</a>
          </li>
          <!-- //교육생관리 -->
          <li>
            <a href="#">출결관리</a>
          </li>
          <!--//출결관리 -->
          <li>
            <a href="#">공지사항</a>
          </li>
          <!-- //공지사항관리 -->
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

      <div class="slid-menu">
        <ul>
          <li>교육생보기</li>
        </ul>
        <ul>
          <li>입 &middot; 퇴실 조회</li>
          <li>지각 &middot; 조퇴 조회</li>
        </ul>
        <ul>
          <li>공지사항관리</li>
        </ul>
      </div>
    </div>
    <!-- //content -->
  </div>
  <!-- //nav -->
</template>

<script>
export default {
  data() {
    return {
      active: false // dropmenu toggle
    };
  },
  methods: {
    dropmenu() {
      this.active = !this.active;
    }
  }
};
</script>

<style>
.nav {
  width: 100%;
  position: relative;
  align-content: center;
  overflow: hidden;
}

.nav .content {
  margin-left: 10%;
  /* height: 100px; */
  width: 80%;
  /* position: relative;
  overflow: hidden; */
}
.content .head {
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
.content .slid-menu {
  /* margin-left: 20%; */
  width: 100%;
  margin: 0 auto;
  text-align: center;
  overflow: hidden;
  position: relative;
}
.content .slid-menu ul {
  float: left;
  width: 33.3%;
}
/* .menu ul {
  display: none;
  height: 190px;
  padding-top: 24px;
  margin-top: 0px;
  padding-bottom: 0px;
  margin-bottom: 0px;
} */

ul,
li {
  list-style: none;
}
.nav a {
  color: #222 !important;
  text-decoration: none;
}
</style>