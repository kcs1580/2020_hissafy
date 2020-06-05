<template>
  <v-content id="menus">
    <v-container class="grey lighten-5">
      <v-dialog v-model="dialog" persistent max-width="600px">
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark v-on="on" class="earlybtn">조퇴/외출 신청</v-btn>
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

                <v-radio-group v-model="subj" row justify="center">
                  <v-radio label="조퇴" value="조퇴"></v-radio>
                  <v-radio label="외출" value="외출"></v-radio>
                </v-radio-group>

                <v-radio-group v-model="sort" row>
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
                  <v-textarea label="외출 사유를 입력하세요" auto-grow outlined rows="3" row-height="25"></v-textarea>
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
                        v-model="outtime"
                        label="외출 시간을 선택하세요"
                        prepend-icon="mdi-alarm"
                        readonly
                        v-on="on"
                      ></v-text-field>
                    </template>
                    <v-time-picker v-if="modal2" v-model="outtime" full-width>
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

      <v-icon large color="blue darken-2">mdi-login</v-icon>
      <v-icon large color="blue darken-2">mdi-logout</v-icon>
    </v-container>
  </v-content>
</template>
<script>
export default {
  data() {
    return {
      subj: "조퇴",
      sort: "병원",
      dialog: false,
      dialog2: false,
      outtime: null,
      intime: null,
      menu2: false,
      modal2: false
    };
  },
  methods: {
    Submitform() {},
    clear() {
      this.dialog = false;
      this.dialog2 = false;
      this.outtime = null;
      this.intime = null;
    }
  }
};
</script>
<style scoped>
#menus {
  min-height: 100%;
}
.earlybtn {
  width: 500px;
  height: 500px;
}
</style>
