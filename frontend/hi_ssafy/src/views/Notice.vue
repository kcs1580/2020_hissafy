<template>
    <v-container id="Notice" style="padding:10px;">
        <v-row no-gutters style="height:100%; width:100%;">
            <v-col
                cols="12"
                sm="12"
                style="height:100%; width:100%"
            >
                <v-row no-gutters style="height:10%; padding-bottom:5px;">
                    <v-col
                        cols="8"
                        sm="8"
                        style="height:100%;"
                    >
                        <v-card
                        class="pa-2 white--text d-flex align-center justify-center"
                        outlined
                        tile
                        style="height:100%; background-color:#3FCE32;"
                        >
                            <div style="height:100%;">{{year}}년 {{month}}월 {{day}}일 {{currentTime}}</div>
                        </v-card>
                    </v-col>
                    <v-col
                        cols="4"
                        sm="4"
                        style="height:100%;"
                    >
                        <v-card
                        class="pa-2 white--text d-flex align-center justify-center"
                        outlined
                        tile
                        style="height:100%; background-color:#FFE651;"
                        >
                            <v-btn text large class="text-center" @click="goOneMode" style="height:100%;">1인모드[입실,퇴실,조퇴,외출]</v-btn>
                        </v-card>
                    </v-col>
                </v-row>
                <v-row no-gutters style="height:90%; padding-top: 5px;">
                    <v-col
                        cols="12"
                        sm="12"
                        style="height:100%;"
                    >
                        <carousel :per-page="1" :navigate-to="noticeList" :autoplay="true" :loop="true" :autoplayTimeout="3000" :mouse-drag="false" :paginationEnabled="false">
                            <slide v-for="item in noticeList" :key="item.src">
                                <img :src="item.src" style="width:100%; height:100%; object-fit: contain;">
                            </slide>
                        </carousel>
                    </v-col>
                </v-row>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
import { Carousel, Slide } from 'vue-carousel';
export default {
  name: "Notice",
  components: {
    Carousel,
    Slide
  },
  data : function() {
    return {
      noticeList: [
          {
              src: require('../assets/notice1.png')
          },
          {
              src: require('../assets/notice2.png')
          },
          {
              src: require('../assets/notice3.png')
          },
          {
              src: require('../assets/notice4.png')
          }
      ],
      timer: '',
      year: '',
      month: '',
      day: '',
      currentTime : ''
    }
  },
  mounted : function() {
    this.setTime()     
  },
  beforeDestroy () {
    clearInterval(this.timer)
  },
  methods: {
    setTime : function() {
      var self = this
      let moment = require('moment'); 
      this.timer = setInterval(function() {
        self.currentTime = moment().format('LTS')
        self.year = moment().format('YYYY')
        self.month = moment().format('MM')
        self.day = moment().format('DD')
      }, 1000);
    },
    goOneMode : function() {
        this.$router.push(`/onemode`)
    }
  }
};
</script>

<style scoped>
#Notice {
  min-height: 100%;
  min-width: 100%;
}
</style>
