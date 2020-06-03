<template>
  <div id="timeConfig">
    <div class="my-2 py-2">
      <v-btn color="primary" @click="editTime">{{btn}}</v-btn>
    </div>
    <div>
      <span>
        <h3>입실</h3>
      </span>
      <span>
        <div class="d-flex flex-row mb-8">
          시작 시간 :
          <div class="d-flex flex-row mb-6 mx-2 px-2">
            <v-select
              class="mx-2 px-2"
              :items="hour"
              label="시"
              v-model="time.attendance_start_h"
              :disabled="disabled"
            ></v-select>
            <v-select :items="min" label="분" v-model="time.attendance_start_m" :disabled="disabled"></v-select>
          </div>마감 시간 :
          <div class="d-flex flex-row mb-6 mx-2 px-2">
            <v-select
              class="mx-2 px-2"
              :items="hour"
              label="시"
              v-model="time.attendance_end_h"
              :disabled="disabled"
            ></v-select>
            <v-select :items="min" label="분" v-model="time.attendance_end_m" :disabled="disabled"></v-select>
          </div>
        </div>
      </span>
    </div>
    <div>
      <h3>퇴실</h3>
      <div>
        <div class="d-flex flex-row mb-8">
          시작 시간 :
          <div class="d-flex flex-row mb-6 mx-2 px-2">
            <v-select
              class="mx-2 px-2"
              :items="hour"
              label="시"
              v-model="time.leaving_start_h"
              :disabled="disabled"
            ></v-select>
            <v-select :items="min" label="분" v-model="time.leaving_start_m" :disabled="disabled"></v-select>
          </div>마감 시간 :
          <div class="d-flex flex-row mb-6">
            <v-select
              class="mx-2 px-2"
              :items="hour"
              label="시"
              v-model="time.leaving_end_h"
              :disabled="disabled"
            ></v-select>
            <v-select :items="min" label="분" v-model="time.leaving_end_m" :disabled="disabled"></v-select>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "../http-common";
export default {
  data() {
    return {
      hour: [
        "0",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16",
        "17",
        "18",
        "19",
        "20",
        "21",
        "22",
        "23"
      ],
      min: [
        "0",
        "5",
        "10",
        "15",
        "20",
        "25",
        "30",
        "35",
        "40",
        "45",
        "50",
        "55"
      ],
      time: {
        time_id: "",
        attendance_start_h: "",
        attendance_start_m: "",
        attendance_end_h: "",
        attendance_end_m: "",
        leaving_start_h: "",
        leaving_start_m: "",
        leaving_end_h: "",
        leaving_end_m: ""
      },

      edit: false,
      disabled: true,
      btn: "수정하기"
    };
  },
  mounted() {
    this.initialize();
  },
  methods: {
    initialize() {
      http
        .get("time/info")
        .then(response => {
          var gtime = response.data.time;
          console.log(gtime);
          if (gtime !== null) {
            this.time.time_id = gtime.time_id;
            this.time.attendance_start_h = gtime.attendance_start_h;
            this.time.attendance_start_m = gtime.attendance_start_m;
            this.time.attendance_end_h = gtime.attendance_end_h;
            this.time.attendance_end_m = gtime.attendance_end_m;
            this.time.leaving_start_h = gtime.leaving_start_h;
            this.time.leaving_start_m = gtime.leaving_start_m;
            this.time.leaving_end_h = gtime.leaving_end_h;
            this.time.leaving_end_m = gtime.leaving_end_m;
          }
          console.log(this.time);
        })
        .catch(() => {
          this.error = true;
        })
        .finally(() => (this.loading = false));
    },
    editTime() {
      if (this.edit) {
        this.btn = "수정하기";
        // 저장하기
        this.saveTime();
        //time select 가능, aixos
        this.edit = false;
        this.disabled = true;
      } else {
        //수정하기
        this.btn = "저장하기";

        this.edit = true;
        this.disabled = false;
      }
    },
    saveTime() {
      console.log(this.time);
      http
        .post("time/update", this.time)
        .then(response => {
          console.log(response);
          this.$router.go(0);
        })
        .catch(() => {
          this.error = true;
        })
        .finally(() => (this.loading = false));
    },
    validateTime() {
      //시간 검사
    }
  }
};
</script>

<style>
</style>