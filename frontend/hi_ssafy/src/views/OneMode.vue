<template>
  <div id="app">
    <v-app id="inspire">
      <v-app-bar app color="indigo" dark>
        <v-toolbar-title>1인 모드</v-toolbar-title>
      </v-app-bar>

      <v-content id="menus">
        <v-row justify="space-around">
          <v-col cols="12" sm="6">
            <v-container class="grey lighten-5"></v-container>
          </v-col>
          <v-col cols="12" sm="6">
            <v-container class="grey lighten-5">
              <v-dialog v-model="dialog" persistent max-width="600px">
                <template v-slot:activator="{ on }">
                  <v-btn color="primary" dark v-on="on" large="true" class="earlybtn">조퇴/외출 신청</v-btn>
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
                    <v-btn color="blue darken-1" text @click="dialog = false">취소</v-btn>
                    <v-btn color="blue darken-1" text @click="submitForm">신청</v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
              <v-row>
                <v-col cols="12" sm="6">
                  <v-icon large color="blue darken-2">mdi-login</v-icon>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-icon large color="blue darken-2">mdi-logout</v-icon>
                </v-col>
              </v-row>
            </v-container>
          </v-col>
        </v-row>
      </v-content>

      <v-footer color="indigo" app>
        <span class="white--text">&copy; 2019</span>
      </v-footer>
    </v-app>
  </div>
</template>

<script>
import http from "../http-common.js";
export default {
  name: "OneMode",
  data() {
    return {
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
    login() {},
    logout() {}
  },
  mounted() {},

  components: {}
};
</script>

<style>
#menus: {
  height: 1000px;
}
body: {
  background-color: #f0f0f0;
}
.inbtn: {
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
