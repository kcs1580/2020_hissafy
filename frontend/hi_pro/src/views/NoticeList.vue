<template>
  <div id="noticeList">
    <router-link to="addNotice">
      <v-btn color="primary" dark class="mb-2 mx-2" id="insert">공지사항 추가</v-btn>
    </router-link>
    <v-data-table :headers="headers" :items="notice" sort-by="notice_start" class="elevation-1"></v-data-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      notice: [],
      headers: [
        {
          text: "날짜",
          align: "left",
          value: "date"
        },
        { text: "제목", value: "notice" },
        { text: "공지 시작 날짜", value: "notice_start" },
        { text: "공지 마감 날짜", value: "notice_end" }
      ]
    };
  }
};
</script>

<style>
</style>