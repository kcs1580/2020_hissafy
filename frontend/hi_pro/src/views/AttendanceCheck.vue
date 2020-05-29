
<template>
  <div>
    <v-row justify="space-between">
      <v-col cols="12" sm="6" md="2">
        <h3>입&middot;퇴실 조회</h3>
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
    ></v-data-table>
  </div>
</template>

<script>
export default {
  components: {},
  data() {
    return {
      date: new Date().toISOString().substr(0, 10),
      menu: false,
      modal: false,

      //날짜 학번 기수 반 이름 출석시간 퇴실시간 출석이미지
      headers: [
        {
          text: "날짜",
          align: "left",
          value: "date"
        },
        {
          text: "학번",
          value: "id"
        },
        { text: "기수", value: "group_num" },
        { text: "반", value: "class" },
        { text: "이름", value: "name" },
        { text: "출석시간", value: "attendance_time" },
        { text: "퇴실시간", value: "leaving_time" },
        { text: "사진", value: "face_id" }
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

  methods: {
    initialize() {
      this.students = [
        {
          id: "0211062",
          group_num: 2,
          area: "광주",
          class: 1,
          name: "이하연",
          state: "재학",
          face_id: "1111"
        }
      ];
    },
    changeDate() {
      this.$refs.menu.save(this.date);
      // 날짜별 요청
    }
  }
};
</script>

<style>
#studentManagement {
  margin-top: 100px;
}
</style>