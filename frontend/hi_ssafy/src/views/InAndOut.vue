<template>
  <v-container id="home" style="padding:10px;">
    <v-row no-gutters style="height:100%; width:100%;">
      <v-col
        cols="12"
        sm="12"
        style="height:100%; width:100%"
      >
        <!--위쪽 시작-->
        <v-row no-gutters  style="height:85%; padding-bottom: 5px;">
          <!--왼쪽 시작-->
          <v-col
            cols="6"
            sm="6"
            style="height:100%; padding-right: 5px;"
          >
            <v-img src="../assets/recognition.jpg" aspect-ratio="1.7" height="100%"></v-img>
          </v-col>
          <!--왼쪽 끝-->
          
          <!--오른쪽 시작-->
          <v-col
            cols="6"
            sm="6"
            style="height:100%; padding-left:5px;"
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
              <!-- <v-col
                cols="4"
                sm="4"
                style="height:100%;"
              >
                <v-card
                  class=" d-flex align-center justify-center"
                  outlined
                  tile
                  style="height:100%; background-color:#FFE651;"
                >
                  <v-btn text large class="text-center">1:1 모드</v-btn>
                </v-card>
              </v-col> -->
              <v-col
                cols="4"
                sm="4"
                style="height:100%;"
              >
                <v-card
                  class="white--text d-flex align-center justify-center"
                  outlined
                  tile
                  style="height:100%; background-color:#FFE651;"
                >
                  <v-btn v-if="frontState===1" text large class="text-center" @click="addAttendanceStudent" style="height:100%;">입실학생추가</v-btn>
                  <v-btn v-else-if="frontState===2" text large class="text-center" @click="addAttendanceStudent" style="height:100%;">퇴실학생추가</v-btn>
                </v-card>
              </v-col>
            </v-row>

            <v-row no-gutters style="height:90%; padding-top: 5px;">
              <v-col
                cols="12"
                sm="12"
                style="height:100%; background-color:#3396F4;"
              >
                <v-infinite-scroll :loading="loading" @top="prevPage" @bottom="nextPage" :offset='1' style="max-height: 73vh; overflow-y: scroll; padding:2px;">
                
                  <v-card
                    v-for="item in currentStudentList"
                    :key="item.id"
                    class=" text-center"
                    outlined
                    tile
                    style="margin:2px;"
                  >
                    <v-row no-gutters>
                      <v-col
                        cols="3"
                        sm="3"
                      >
                      <v-img src="../assets/student.jpg" aspect-ratio="2.0" height="100%"></v-img>
                      
                      </v-col>
                      <v-col
                        cols="9"
                        sm="9"
                      >
                      <p>{{item.area}} {{item.group_num}}기 {{item.class}}반 {{item.name}}</p>
                      <p v-if="item.attendance_state === '입실완료'">입실완료</p>
                      <p v-if="item.attendance_state === '입실완료'">{{item.attendance_time}}</p>
                      <p v-if="item.attendance_state === '퇴실완료'">퇴실완료</p>
                      <p v-if="item.attendance_state === '퇴실완료'">{{item.leaving_time}}</p>
                      </v-col>
                    </v-row>
                  </v-card>
                </v-infinite-scroll>
              </v-col>
            </v-row>
          </v-col>
          <!--오른쪽 끝-->
        </v-row>
        <!--위쪽 끝-->
        
        <!--아래쪽 시작-->
        <v-row no-gutters style="height:15%; padding-top:5px;">
          <v-col
            cols="12"
            sm="12"
            style="height:100%;"
          >
            <v-card
              class="white--text"
              outlined
              tile
              style="height:100%; background-color:#24282B;"
            >
              <marquee scrolldelay="10" style="font-size: 50px;">
                오늘은 다들 피곤해 보이는 날이네요. 변화를 위해 가장 필요한 자질은 지치지 않는 것입니다. 오늘도 힘내봐요.
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
import { mapState } from 'vuex'
import http from '../http-common'
export default {
  name: "InAndOut",
  components: {
  },
  data() {
    return {
      currentStudentList: [],
      studentList: [],
      page: 1,
      items: [],
      loading: false,
      studentIndex: 0,
      timer: '',
      year: '',
      month: '',
      day: '',
      currentTime : ''
    }
  },
  computed: {
    ...mapState(['frontState'])
  },
  methods: {
    prevPage () {
      if (this.page == 1) return
      --this.page
      // this.api()
    },
    nextPage () {
      ++this.page
      // this.api()
    },
    // api () {
    //   this.loading = true
    //   myApi.get({page: this.page}).then((response) => {
    //     this.items = response
    //     this.loading = false
    //   })
    // },
    addAttendanceStudent () {
      let randomFaceId = String(this.getRandomIntInclusive(0,23))
      let student = null
      for(let i = 0 ; i < this.studentList.length ; i++) {
        if(this.studentList[i].face_id === randomFaceId){
            student = this.studentList[i]
            break
        }
      }
      console.log("student")
      console.log(student)
      if(student !== null && student.attendance_state === null) {
        student.attendance_state = "입실완료"
        student.attendance_time = new Date()
        this.currentStudentList.unshift(student)
        console.log(student.name + " " + student.attendance_state)
        let fdata = new FormData()
        fdata.append('student_id', student.student_id)
        fdata.append('attendance_date', student.attendance_date)
        fdata.append('attendance_time', student.attendance_time)
        fdata.append('leaving_time', student.leaving_time)
        fdata.append('attendance_state', student.attendance_state)
        http
          .put('/student/updateAttendance', fdata)
          .then(
            response => {
              console.log(response.data.message)
            }
          )
          .catch(err => console.log(err))
          .finally(
          )

      } else if(student !== null && student.attendance_state === "입실완료") {
        student.attendance_state = "퇴실완료"
        student.leaving_time = new Date()
        this.currentStudentList.unshift(student)
        console.log(student.name + " " + student.attendance_state)
        let fdata = new FormData()
        fdata.append('student_id', student.student_id)
        fdata.append('attendance_date', student.attendance_date)
        fdata.append('attendance_time', student.attendance_time)
        fdata.append('leaving_time', student.leaving_time)
        fdata.append('attendance_state', student.attendance_state)
        http
          .put('/student/updateAttendance', student)
          .then(
            response => {
              console.log(response.data.message)
            }
          )
          .catch(err => console.log(err))
          .finally(
          )

      } else if(student !== null) {
        console.log(student.name + "은(는) 이미 입퇴실 처리 되었습니다.")
      }
    },
    getRandomIntInclusive(min, max) {
      min = Math.ceil(min)
      max = Math.floor(max)
      return Math.floor(Math.random() * (max - min + 1)) + min; //최댓값도 포함, 최솟값도 포함
    },
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
  },
  mounted() {
    this.setTime(),
    http
      .get('/student/studentduringlist')
      .then(
        response => {
          console.log(response.data.message)
          this.studentList = response.data.result
        }
      )
      .catch(err => console.log(err))
      .finally(
      )
  },
  beforeDestroy () {
    clearInterval(this.timer)
  },
};
</script>

<style scoped>
#home {
  margin: 0;
  width: 100%;
  height: 100%;
  min-height: 100%;
  min-width: 100%;
  overflow: hidden;
}
</style>
