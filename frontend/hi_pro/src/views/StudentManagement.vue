
<template>
  <div>
    <h3>교육생 관리</h3>
    <v-data-table :headers="headers" :items="students" sort-by="id" class="elevation-1">
      <template v-slot:top>
        <v-toolbar flat color="white">
          <v-spacer></v-spacer>
          <v-dialog v-model="dialog" max-width="500px">
            <template v-slot:activator="{ on }">
              <v-btn color="primary" dark class="mb-2 mx-2" v-show="edit" @click="editCancel">취소</v-btn>
              <v-btn color="primary" dark class="mb-2" @click="editMode">{{edit_button}}</v-btn>
              <v-btn color="primary" dark class="mb-2 mx-2" v-show="edit" v-on="on">추가</v-btn>
            </template>
            <v-card>
              <v-card-title>
                <span class="headline">{{ formTitle }}</span>
              </v-card-title>

              <v-card-text>
                <v-container>
                  <v-form ref="form" v-model="valid" lazy-validation>
                    <v-row>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field v-model="editedItem.id" label="학번" :rules="id_rules"></v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field type="number" v-model="editedItem.group_num" label="기수"></v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-select
                          v-model="editedItem.area"
                          :items="area_options"
                          outlined
                          label="지역"
                        ></v-select>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field v-model="editedItem.class" type="number" label="반"></v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field v-model="editedItem.name" label="이름" :rules="rules"></v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-select
                          v-model="editedItem.state"
                          :items="state_options"
                          outlined
                          label="재학/퇴소"
                        ></v-select>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field v-model="editedItem.face_id" label="face_id"></v-text-field>
                      </v-col>
                    </v-row>
                  </v-form>
                </v-container>
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="close">Cancel</v-btn>
                <v-btn color="blue darken-1" text @click="save" :disabled="!valid">Save</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-toolbar>
      </template>
      <template v-slot:item.actions="{ item }">
        <v-icon small class="mr-2" @click="editItem(item)">mdi-pencil</v-icon>
        <v-icon small @click="deleteItem(item)">mdi-delete</v-icon>
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
          value: "id"
        },
        { text: "기수", value: "group_num" },
        { text: "지역", value: "area" },
        { text: "반", value: "class" },
        { text: "이름", value: "name" },
        { text: "재학/퇴소", value: "state" },
        { text: "사진", value: "face_id" }
        // { text: "Actions", value: "actions", sortable: false }
      ],
      students: [],
      editedIndex: -1,
      editedItem: {
        id: "",
        group_num: 2,
        area: "서울",
        class: 1,
        name: "",
        state: "재학",
        face_id: ""
      },
      defaultItem: {
        id: "",
        group_num: "",
        area: "",
        class: "",
        name: "",
        state: "재학",
        face_id: ""
      }
    };
  },
  mounted() {},

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
        .get(`student/studentList`)
        .then(response => {
          this.students = response.data.list;
        })
        .catch(() => {
          this.error = true;
        })
        .finally(() => (this.loading = false));
    },
    //저장하기
    editMode() {
      this.editCancel();
      //aixos 추가
    },
    //취소
    editCancel() {
      if (this.edit === false) {
        this.headers.push({
          text: "Actions",
          value: "actions",
          sortable: false
        });
        this.edit_button = "저장하기";
        this.edit = true;
      } else {
        this.edit_button = "수정하기";
        this.headers.splice(7, 1);
        this.edit = false;
      }
    },
    editItem(item) {
      this.editedIndex = this.students.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },

    deleteItem(item) {
      const index = this.students.indexOf(item);
      confirm("정말 삭제하시겠습니까?") && this.students.splice(index, 1);
    },

    close() {
      this.dialog = false;
      setTimeout(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      }, 300);
    },

    save() {
      console.log(this.valid);
      if (this.$refs.form.validate()) {
        if (this.editedIndex > -1) {
          Object.assign(this.students[this.editedIndex], this.editedItem);
        } else {
          this.students.push(this.editedItem);
        }
        this.close();
      }
    }
  }
};
</script>

<style>
#studentManagement {
  margin-top: 100px;
}
</style>