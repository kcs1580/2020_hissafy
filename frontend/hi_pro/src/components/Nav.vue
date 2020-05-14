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
  </div>
</template>

<script>
export default {};
</script>

<style>
.menu {
  float: left;
  width: 25%;
  font-size: 20px;
  text-align: center;
  line-height: 120px;
}
.menu img {
  vertical-align: middle;
}
</style>