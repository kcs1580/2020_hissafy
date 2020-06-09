<template>
  <div id="noticeList">
    <router-link to="addNotice">
      <v-btn color="primary" dark class="mb-2 mx-2" id="insert">공지사항 등록</v-btn>
    </router-link>
    <v-data-table
      :headers="headers"
      :items="notice"
      sort-by="start_date"
      class="elevation-1"
      @click:row="noticeView"
    ></v-data-table>
  </div>
</template>

<script>
import http from "../http-common.js";
export default {
  data() {
    return {
      notice: [],
      headers: [
        {
          text: "날짜",
          align: "left",
          value: "reg_date"
        },
        { text: "제목", value: "notice_title" },
        { text: "공지 시작 날짜", value: "start_date" },
        { text: "공지 마감 날짜", value: "end_date" }
      ]
    };
  },
  methods: {
    initialize() {
      http
        .get("/notice/list")
        .then(response => {
          this.notice = response.data.list;
          console.log(this.notice);
        })
        .catch(() => {
          this.error = true;
        })
        .finally(() => (this.loading = false));
    },
    noticeView(value) {
      console.log(value);
      this.$router.push("/noticeInfo/" + value.notice_id);
    }
  },
  mounted() {
    this.initialize();
  }
};
</script>

<style>
</style>