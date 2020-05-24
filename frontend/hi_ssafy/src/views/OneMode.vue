<template>
  <div id="app">
    <v-app id="inspire">
      <v-app id="inspire">
        <v-app-bar app color="indigo" dark>
          <v-toolbar-title>1인 모드</v-toolbar-title>
        </v-app-bar>

        <v-content>
          <v-container>
            <v-layout row wrap align-center>
              <v-flex xs12 md4>사용자인식</v-flex>
              <v-flex xs12 md5 offset-md2>1인용 메뉴들</v-flex>
            </v-layout>
          </v-container>
        </v-content>
        <v-footer color="indigo" app>
          <span class="white--text">&copy; 2019</span>
        </v-footer>
      </v-app>
    </v-app>
  </div>
</template>

<script>
export default {
  name: "OneMode",
  components: {}
};
</script>

<style scoped>
#home {
  min-width: 100%;
  min-height: 100%;
}
</style>
