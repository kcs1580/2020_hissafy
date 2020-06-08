<template>
  
    <v-app id="app">
      <v-app-bar app color="#000839" dark>
        <v-toolbar-title>1인 모드</v-toolbar-title>
      </v-app-bar>

      <v-content id="menus">
        <v-row >
          <v-col cols="12" sm="6">
            <v-container ></v-container>
          </v-col>
          <v-col cols="12" sm="6">
            <v-container >
               <v-card
    class="mx-auto"
    max-width="150"
  >
    <v-card-text>
      
      <p class="display-1 text--primary">
    <v-icon x-large color="blue darken-2" >mdi-home-export-outline</v-icon>
      </p>
   
    </v-card-text>
    <v-card-actions class="justify-center">
       
      <v-dialog v-model="dialog" persistent max-width="600px">
                <template v-slot:activator="{ on }">
                   
                   
                  <v-btn color="#005082" dark v-on="on"  x-large="true" >조퇴/외출 신청</v-btn>
                </template>
                <v-card>
                  <v-card-title>
                    <span class="headline">조퇴/외출 신청</span>
                  </v-card-title>
                  <v-card-text>
                    <div>
                      <v-row justify="space-around">
                        <v-col cols="12" sm="6">
                          <header>조퇴/외출</header>
                        </v-col>
                        <v-col cols="12" sm="6">
                          <header>분류</header>
                        </v-col>

                        <v-radio-group v-model="earlyleave.division" row justify="center">
                          <v-radio label="조퇴" value="조퇴"></v-radio>
                          <v-radio label="외출" value="외출"></v-radio>
                        </v-radio-group>

                        <v-radio-group v-model="earlyleave.sort" row>
                          <v-radio label="병원" value="병원"></v-radio>
                          <v-radio label="취업" value="취업"></v-radio>
                          <v-radio label="기타" value="기타"></v-radio>
                        </v-radio-group>

                        <v-col cols="12" sm="6">
                          <header>사유</header>
                        </v-col>

                        <v-col cols="12" sm="6">
                          <header>외출시간</header>
                        </v-col>

                        <v-col cols="12" sm="6">
                          <v-textarea
                            v-model="earlyleave.reason"
                            label="외출 사유를 입력하세요"
                            auto-grow
                            outlined
                            rows="3"
                            row-height="25"
                          ></v-textarea>
                        </v-col>

                        <v-col cols="12" sm="6">
                          <v-dialog
                            ref="dialog"
                            v-model="modal2"
                            :return-value.sync="time"
                            persistent
                            width="290px"
                          >
                            <template v-slot:activator="{ on }">
                              <v-text-field
                                v-model="earlyleave.leaving_time"
                                label="외출 시간을 선택하세요"
                                prepend-icon="mdi-alarm"
                                readonly
                                v-on="on"
                              ></v-text-field>
                            </template>
                            <v-time-picker
                              v-if="modal2"
                              v-model="earlyleave.leaving_time"
                              full-width
                            >
                              <v-spacer></v-spacer>
                              <v-btn text color="primary" @click="modal2 = false">Cancel</v-btn>
                              <v-btn text color="primary" @click="$refs.dialog.save(time)">OK</v-btn>
                            </v-time-picker>
                          </v-dialog>
                        </v-col>
                      </v-row>
                    </div>
                  </v-card-text>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1"  text @click="dialog = false">취소</v-btn>
                    <v-btn color="blue darken-1" text @click="submitForm">신청</v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
    
    </v-card-actions>
  </v-card>
              
              <v-row >
                <v-col cols="12" sm="2">
                </v-col>
                <v-col cols="12" sm="4">
                  <v-card
    class="mx-auto"
    max-width="150"
  >
    <v-card-text>
      
      <p class="display-1 text--primary">
        
       <v-icon x-large color="blue darken-2" >mdi-login</v-icon>
      
      </p>
   
    </v-card-text>
    <v-card-actions class="justify-center">
      <div align="center">
      <v-btn
        dark
        x-large
        color="#005082"
       @click="addAttendanceStudent"
      >
       입실하기
      </v-btn>
      </div>
    </v-card-actions>
  </v-card>

                </v-col>
              
                <v-col cols="12" sm="4">
                  <v-card
    class="mx-auto"
    max-width="150"
  >
    <v-card-text>
      
      <p class="display-1 text--primary">
       <v-icon x-large color="blue darken-2" >mdi-logout</v-icon>
      </p>
   
    </v-card-text>
    <v-card-actions class="justify-center">
       <div align="center">
      <v-btn
        dark
        x-large
      color="#005082"
       @click="addAttendanceStudent"
      >
       퇴실하기
      </v-btn>
       </div>
    </v-card-actions>
  </v-card>
                </v-col>
                  <v-col cols="12" sm="2">
                </v-col>
              </v-row>
            
  
    
            </v-container>
          </v-col>
        </v-row>
      </v-content>

      <v-footer color="#000839" app>
        <span class="white--text">&copy; 2020 하이바이싸피</span>
      </v-footer>
    </v-app>
  
</template>

<script>
import http from "../http-common.js";
export default {
  name: "OneMode",
  data() {
    return {
            studentList: [],
      faceid: "",
      dialog: false,
      modal2: false,
      earlyleave: {
        student_id: "0211730",
        division: "조퇴",
        sort: "병원",
        reason: "",
        leaving_time: null,
        approval_state: "승인대기"
      }
    };
  },
  methods: {
    getFaceid() {},
    getStudentid() {},
    submitForm() {
      console.log(this.earlyleave);

      http
        .post("earlyleave/registerearlyleave", this.earlyleave)
        .then(response => {
          this.earlyleave = response.data.list;
          console.log("입력완료");
        })
        .catch(() => {
          this.error = true;
        })
        .finally(() => (this.loading = false));
      this.clear();
    },

    clear() {
      this.dialog = false;
      this.outtime = null;
    },
     addAttendanceStudent () {
      let randomFaceId = String(this.getRandomIntInclusive(0,23))
      let student = null
      for(let i = 0 ; i < this.studentList.length ; i++) {
        if(this.studentList[i].face_id === randomFaceId){
            student = this.studentList[i];
            break;
        }
      }
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
          .put('/student/updateAttendance', fdata)
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
    login() {},
    logout() {}
  },
  mounted() {
     http
      .get('/student/studentduringlist')
      .then(
        response => {
          console.log(response.data.message)
          this.studentList = response.data.result;
        }
      )
      .catch(err => console.log(err))
      .finally(
      )
  },

  components: {}
};
</script>

<style>
#menus {
 
}
#app {
 background-color: #00a8cc;
}
.inbtn {
  min-height: 500px;
  size: 500px;
}
.grey lighten-5 {
  height: 1000px;
}
.headline {
  font-size: 500px;
  size: 500px;
}
.earlybtn {
  width: 400px;
  min-height: 200px;
}
#app {
  text-align: center;
  
  margin-top: 60px;
}
#video {
  background-color: #000000;
}
#canvas {
  display: none;
}

</style>
