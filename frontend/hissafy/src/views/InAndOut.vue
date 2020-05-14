<template>
  <v-container id="home">
    <v-row no-gutters>
      <v-col
        cols="12"
        sm="12"
        style="height:100%"
      >
        <!--위쪽 시작-->
        <v-row no-gutters style="height:800px">
          <!--왼쪽 시작-->
          <v-col
            cols="6"
            sm="6"
            style="height:100%"
            class="pr-2 pb-2"
          >
            <v-img src="../assets/recognition.jpg" aspect-ratio="1.7"></v-img>
          </v-col>
          <!--왼쪽 끝-->
          <!--오른쪽 시작-->
          <v-col
            cols="6"
            sm="6"
            style="height:100%"
            class="pl-2 pb-2"
          >
            <v-row no-gutters style="height:10%">
              <v-col
                cols="4"
                sm="4"
                style="height:100%;"
                class="pr-2 pb-2 "
              >
                <v-card
                  class="pa-2 white--text d-flex align-center"
                  outlined
                  tile
                  style="height:100%; width:100%; background-color:#3FCE32;"
                >
                  <v-btn text large class="text-center" style="width:100%;">입퇴실 모드</v-btn>
                </v-card>
              </v-col>
              <v-col
                cols="4"
                sm="4"
                style="height:100%"
                class="pl-2 pr-2 pb-2"
              >
                <v-card
                  class="pa-2 d-flex align-center"
                  outlined
                  tile
                  style="height:100%; width:100%; background-color:#FFE651;"
                >
                  <v-btn text large class="text-center" style="width:100%;">1:1 모드</v-btn>
                </v-card>
              </v-col>
              <v-col
                cols="4"
                sm="4"
                style="height:100%;"
                class="pl-2 pb-2"
              >
                <v-card
                  class="pa-2 d-flex align-center"
                  outlined
                  tile
                  style="height:100%; width:100%; background-color:#ABABAB;"
                >
                  <v-btn text large class="text-center" style="width:100%;">공지사항</v-btn>
                </v-card>
              </v-col>
            </v-row>
            <v-row no-gutters style="height:90%">
              <v-col
                cols="12"
                sm="12"
                style="height:100%; background-color:#3396F4;"
                class="pt-2 pb-2"
              >
                <v-card
                  v-for="item in 5"
                  :key="item"
                  class="pa-2 text-center"
                  outlined
                  tile
                  style="height:50px; width:100%;"
                >
                  리스트 업
                </v-card>
              </v-col>
            </v-row>
          </v-col>
          <!--오른쪽 끝-->
        </v-row>
        <!--위쪽 끝-->
        <!--아래쪽 시작-->
        <v-row no-gutters style="height:100px">
          <v-col
            cols="12"
            sm="12"
            style="height:100%"
          >
            <v-card
              class="pa-2 white--text"
              outlined
              tile
              style="height:100%; width:100%; background-color:#24282B;"
            >
              <marquee scrolldelay="10" style="font-size: 50px;">
                변화를 위해 가장 필요한 자질은 지치지 않는 것이다.
              </marquee>
            </v-card>
          </v-col>
        </v-row>
        <!--아래쪽 끝-->
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "Home",
  components: {
    
  }
};
</script>

<style scoped>
#home {
  min-width: 100%;
  min-height: 100%;
}
</style>
