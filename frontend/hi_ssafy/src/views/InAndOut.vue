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
                cols="4"
                sm="4"
                style="height:100%;"
              >
                <v-card
                  class="pa-2 white--text d-flex align-center"
                  outlined
                  tile
                  style="height:100%; background-color:#3FCE32;"
                >
                  <v-btn text large class="text-center">입퇴실 모드</v-btn>
                </v-card>
              </v-col>
              <v-col
                cols="4"
                sm="4"
                style="height:100%;"
              >
                <v-card
                  class=" d-flex align-center"
                  outlined
                  tile
                  style="height:100%; background-color:#FFE651;"
                >
                  <v-btn text large class="text-center">1:1 모드</v-btn>
                </v-card>
              </v-col>
              <v-col
                cols="4"
                sm="4"
                style="height:100%;"
              >
                <v-card
                  class=" d-flex align-center"
                  outlined
                  tile
                  style="height:100%; background-color:#ABABAB;"
                >
                  <v-btn text large class="text-center" @click="addStudent">입실학생추가</v-btn>
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
                      <p>{{new Date()}}</p>
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
export default {
  name: "Home",
  components: {
  },
  data(){
    return{
      currentStudentList: [],
      studentList: [],
      page: 1,
      items: [],
      loading: false,
      studentIndex: 0
    }
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
    addStudent () {
      let randomNumber = this.getRandomIntInclusive(0,23)
      // let student = this.studentList[this.studentIndex]
      let student = this.studentList[randomNumber]
      if(student.attendance_state === false) {
        student.attendance_state = true
        this.currentStudentList.unshift(student)
        console.log(student.name + " " + student.attendance_state)
      } else {
        console.log(student.name + "은(는) 이미 입실 처리 되었습니다.")
      }
      // this.studentIndex++
    },
    getRandomIntInclusive(min, max) {
      min = Math.ceil(min);
      max = Math.floor(max);
      return Math.floor(Math.random() * (max - min + 1)) + min; //최댓값도 포함, 최솟값도 포함
    }
  },
  mounted() {
    this.studentList = [
      {
        id: 1,
        name: "강기동",
        faceId: 1,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 2,
        name: "김대들",
        faceId: 2,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 3,
        name: "김보현",
        faceId: 3,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 4,
        name: "김진출",
        faceId: 4,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 5,
        name: "김창수",
        faceId: 5,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 6,
        name: "김태동",
        faceId: 6,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 7,
        name: "문지환",
        faceId: 7,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 8,
        name: "박종수",
        faceId: 8,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 9,
        name: "박호연",
        faceId: 9,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 10,
        name: "방준영",
        faceId: 10,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 11,
        name: "서현준",
        faceId: 11,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 12,
        name: "송광우",
        faceId: 12,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 13,
        name: "양성진",
        faceId: 13,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 14,
        name: "오지윤",
        faceId: 14,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 15,
        name: "원태희",
        faceId: 15,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 16,
        name: "이경석",
        faceId: 16,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 17,
        name: "이상아",
        faceId: 17,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 18,
        name: "이하연",
        faceId: 18,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 19,
        name: "정성원",
        faceId: 19,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 20,
        name: "정준호",
        faceId: 20,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 21,
        name: "정희선",
        faceId: 21,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 22,
        name: "조승우",
        faceId: 22,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 23,
        name: "최용선",
        faceId: 23,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      },
      {
        id: 24,
        name: "최창현",
        faceId: 24,
        area: "광주",
        class: 2,
        group_num: 2,
        attendance_state: false
      }
    ]
  }
};
</script>

<style scoped>
#home {
  margin: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
}
</style>
