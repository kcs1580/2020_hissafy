<template>
  <v-app id="app">
    <!-- <p>현재일 : {{ currentTime }}</p>
    <p>{{frontState}}</p> -->
    <HissafyMain v-if="frontState === 0"/>
    <InAndOut v-else/>
  </v-app>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import InAndOut from "./views/InAndOut.vue";
import HissafyMain from "./views/HissafyMain.vue";
export default {
  name: "App",
  components: {
    // CoreView: () => import('@/components/core/View'),
    InAndOut,
    HissafyMain
  },
  data : function() {
    return {
      currentTime : '',
      timer:'',
    }
  },
  computed: {
    ...mapState(['times']),
    ...mapState(['frontState']),
    // changes : {
    //   // get : function(){
    //   //   console.log("computed 실행")
    //   //   return this.currentTime;
    //   // },
    //   // set : function(v){
    //   //   this.currentTime =  v;
    //   // }
    //   string: function () {
    //     return this.currentTime
    //   }
    // }
  },
  mounted : function() {
    this.setTime()     
  },
  beforeDestroy () {
    clearInterval(this.timer)
  },
  methods: {
    ...mapActions(["changeFrontState"]),
    setTime : function() {
      // console.log(this.times)
      var self = this
      let moment = require('moment'); 
      this.timer = setInterval(function() {
        let tt = moment().format('HH:mm:ss')
        // this.changes = tt
        // console.log (this.changes)
        self.currentTime = tt
        let hh = parseInt(moment().format('HH'))
        let mm = parseInt(moment().format('mm'))
        // console.log(self.currentTime)
        let current_time = hh*60 + mm
        // console.log("현재시간 환산" + current_time)
        let attendance_start = self.times.attendance_start_h*60 + self.times.attendance_start_m
        // console.log("입실시작시간 환산" + attendance_start)
        let attendance_end = self.times.attendance_end_h*60 + self.times.attendance_end_m
        // console.log("입실끝시간 환산" + attendance_end)
        let leaving_start = self.times.leaving_start_h*60 + self.times.leaving_start_m
        // console.log("퇴실시작시간 환산" + leaving_start)
        let leaving_end = self.times.leaving_end_h*60 + self.times.leaving_end_m
        // console.log("퇴실끝시간 환산" + leaving_end)
        const params = {
          cs: 0
        }
        if(current_time >= attendance_start && current_time < attendance_end) {
          let changeState = 1
          params.cs = changeState
          self.changeFrontState(params)
        } else if (current_time >= leaving_start && current_time < leaving_end) {
          let changeState = 2
          params.cs = changeState
          self.changeFrontState(params)
        } else {
          let changeState = 0
          params.cs = changeState
          self.changeFrontState(params)
        }
      }, 1000);
    }
  }
};
</script>

<style scoped>
#app {
  min-height: 100%;
  min-width: 100%;
  margin: 0;
}
</style>