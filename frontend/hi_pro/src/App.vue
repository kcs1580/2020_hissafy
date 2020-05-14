<template>
  <v-app id="app">
    <v-content id="content">
      <nav>
        <Nav></Nav>
      </nav>
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
  width: 85%;
  margin: 0 auto;
}
nav {
  width: 100%;
  height: 120px;
  background: #ccc;
}
</style>