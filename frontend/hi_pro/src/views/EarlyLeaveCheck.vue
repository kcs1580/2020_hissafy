
<template>
  <div id="earlyLeaveCheck">
    <v-row justify="space-between">
      <v-col cols="12" sm="6" md="2">
        <h3>외출&middot;조퇴 조회</h3>
      </v-col>
      <v-col cols="12" sm="6" md="2">
        <v-menu
          ref="menu"
          v-model="menu"
          :close-on-content-click="false"
          :return-value.sync="date"
          transition="scale-transition"
          offset-y
          min-width="290px"
        >
          <template v-slot:activator="{ on }">
            <v-text-field v-model="date" label="날짜 조회" readonly v-on="on"></v-text-field>
          </template>
          <v-date-picker v-model="date" no-title scrollable>
            <v-spacer></v-spacer>
            <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
            <v-btn text color="primary" @click="changeDate">OK</v-btn>
          </v-date-picker>
        </v-menu>
      </v-col>
    </v-row>
    <v-data-table
      :headers="headers"
      :items="students"
      sort-by="attendance_time"
      class="elevation-1"
    >
      <template v-slot:item.actions="{ item }">
        <v-btn
          v-if="item.approval_state==='승인대기'"
          color="primary"
          small
          class="mr-2"
          @click="update(item)"
        >승인</v-btn>
        <v-btn v-else color="error" small class="mr-2" @click="update(item)">승인취소</v-btn>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import http from "../http-common.js";
export default {
  components: {},
  data() {
    return {
      date: new Date().toISOString().substr(0, 10),
      menu: false,
      modal: false,

      headers: [
        {
          text: "학번",
          align: "left",
          value: "student_id"
        },
        { text: "이름", value: "student_name" },
        { text: "외출/조퇴", value: "division" },
        { text: "분류", value: "sort" },
        { text: "사유", value: "reason" },
        { text: "외출/조퇴 시간", value: "leaving_time" },
        { text: "상태", value: "approval_state" },
        { text: "Actions", value: "actions", sortable: false }
      ],
      students: []
    };
  },

  watch: {
    dialog(val) {
      val || this.close();
    }
  },

  created() {
    this.initialize();
  },
  moundted() {},
  methods: {
    initialize() {
      console.log(this.date);
      http
        .get("/earlyleave/earlyleavelist/" + this.date)
        .then(response => {
          this.students = response.data.list;
          console.log(this.students);
        })
        .catch(() => {
          this.error = true;
        })
        .finally(() => (this.loading = false));
    },

    changeDate() {
      // 날짜별 요청
      var today = new Date().toISOString().substr(0, 10);
      if (this.date <= today) {
        this.$refs.menu.save(this.date);
        this.initialize();
      } else {
        alert("이전 날짜를 선택해주세요");
        this.date = today;
      }
    },
    update(item) {
      console.log(item);
      if (item.approval_state === "승인") {
        item.approval_state = "승인대기";
      } else {
        item.approval_state = "승인";
      }
      http
        .post("/earlyleave/updateearlyleave", item)
        .then(response => {
          console.log(response);
          this.$router.go(0);
        })
        .catch(() => {
          this.error = true;
        })
        .finally(() => (this.loading = false));
    }
  }
};
</script>

<style>
#studentManagement {
  margin-top: 100px;
}
</style>