<template>
  <v-app id="app">
    <v-content id="content">
      <nav>
        <Nav></Nav>
      </nav>
      <router-view class="router-view" />
    </v-content>
  </v-app>
</template>

<script>
import Nav from "./components/Nav";
export default {
  name: "App",

  components: {
    Nav
  }
};
</script>

<style>
#app #content {
  width: 100%;
  margin: 0 auto;
}
nav {
  width: 100%;
  z-index: 2;
  background: #fff;
  position: absolute;
}
.router-view {
  position: relative;
  margin-top: 200px !important;
  z-index: 0;
  width: 80%;
  margin: 0 auto;
}
</style>