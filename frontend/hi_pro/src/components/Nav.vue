<template>
  <div class="nav">
    <div class="menu">
      <img src="../assets/header-logo.jpg" />
    </div>
    <div class="menu">
      <v-router>교육생관리</v-router>
    </div>
    <div class="menu">출결관리</div>
    <div class="menu">공지사항관리</div>
    <div class="menu">
      <div class="profile">
        <img src="../assets/user.svg" alt="프로필사진" />
        <strong>운영</strong>
        <span>pro님</span>
      </div>
      <!-- //profile -->
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.menu {
  float: left;
  width: 20%;
  font-size: 18px;
  text-align: center;
  line-height: 120px;
}
.menu img {
  vertical-align: middle;
}
.menu .profile img {
  width: 15%;
  height: 15%;
  margin-right: 15px;
}
</style>