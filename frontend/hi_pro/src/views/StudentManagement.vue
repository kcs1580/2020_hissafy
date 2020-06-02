
<template>
  <div>
    <h3>교육생 관리</h3>
    <v-layout :class="`d-flex justify-end`">
      <router-link to="updateStudent">
        <v-btn color="primary" dark class="mb-2">수정하기</v-btn>
      </router-link>
    </v-layout>
    <v-data-table :headers="headers" :items="students" sort-by="id" class="elevation-1"></v-data-table>
  </div>
</template>

<script>
import http from "../http-common.js";
export default {
  components: {},
  data() {
    return {
      dialog: false,
      edit: false,
      edit_button: "수정하기",
      state_options: ["재학", "퇴소"],
      area_options: ["광주", "서울", "대전", "구미"],
      valid: true,
      rules: [v => !!v || "이름을 입력해주세요"],
      id_rules: [
        v => !!v || "학번을 입력해주세요",
        v => /[\d]$/.test(v) || "숫자만 입력 가능합니다."
      ],
      //학번 기수 지역 반 이름 재학/퇴소 사진
      headers: [
        {
          text: "학번",
          align: "left",
          value: "student_id"
        },
        { text: "기수", value: "group_num" },
        { text: "지역", value: "area" },
        { text: "반", value: "class_num" },
        { text: "이름", value: "name" },
        { text: "재학/퇴소", value: "state" },
        { text: "사진", value: "face_id" }
        // { text: "Actions", value: "actions", sortable: false }
      ],
      students: [],
      editedIndex: -1,
      editedItem: {
        student_id: "",
        group_num: 2,
        area: "서울",
        class_num: 1,
        name: "",
        state: "재학",
        face_id: ""
      },
      defaultItem: {
        student_id: "",
        group_num: "",
        area: "",
        class_num: "",
        name: "",
        state: "재학",
        face_id: ""
      }
    };
  },

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? "교육생 등록" : "교육생 수정";
    }
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
      http
        .get(`student/studentlist`)
        .then(response => {
          this.students = response.data.list;
        })
        .catch(() => {
          this.error = true;
        })
        .finally(() => (this.loading = false));
      console.log("initialize::::", this.students);
    }
  }
};
</script>

<style>
#studentManagement {
  margin-top: 100px;
}
</style>