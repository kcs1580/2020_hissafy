<template>
  <div id="app">
    <v-app id="inspire">
      <v-app-bar app color="indigo" dark>
        <v-toolbar-title>1인 모드</v-toolbar-title>
      </v-app-bar>

      <v-content>
        <v-container>
          <v-layout row wrap align-center>
            <v-flex xs12 md4>사용자 인식</v-flex>
            <v-flex xs12 md5 offset-md2>
              1인용 메뉴들
              <onemenus />
            </v-flex>
          </v-layout>
        </v-container>
      </v-content>
      <v-footer color="indigo" app>
        <span class="white--text">&copy; 2019</span>
      </v-footer>
    </v-app>
  </div>
</template>

<script>
export default {
  name: "OneMode",
  data() {},
  mounted() {},
  methods: {},
  components: {
    onemenus: () => import("@/components/onemode/onemenus")
  }
};
</script>

<style>
body: {
  background-color: #f0f0f0;
}
#app {
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
#video {
  background-color: #000000;
}
#canvas {
  display: none;
}
li {
  display: inline;
  padding: 5px;
}
</style>
