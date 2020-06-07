<template>
  <div id="infoNotice">
    <v-layout row :class="`d-flex justify-center mb-6`">
      <v-flex xs2 :class="`d-flex justify-center align-self-center`">
        <v-subheader>Title</v-subheader>
      </v-flex>
      <v-flex xs6>
        <v-text-field :readonly="read" v-model="title" name="input-1"></v-text-field>
      </v-flex>
      <v-flex xs8 :class="`d-flex justify-center mb-6`">
        <v-file-input v-if="isUpdate" accept="image/*" label="File input" @change="onFileChange"></v-file-input>
      </v-flex>
      <v-flex v-if="img_src" xs8 :class="`d-flex justify-center mb-6`">
        <v-img :src="img_src"></v-img>
      </v-flex>
      <v-row :class="`d-flex justify-center mb-6`">
        <v-col cols="12" sm="6" md="4">
          <v-text-field
            v-model="start_date"
            label="시작 날짜"
            prepend-icon="event"
            :readonly="read"
            v-on="on"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="6" md="4">
          <v-text-field
            :disable="isUpdate"
            v-model="end_date"
            label="마감날짜"
            prepend-icon="event"
            readonly
            v-on="on"
          ></v-text-field>
        </v-col>
      </v-row>
    </v-layout>
  </div>
</template>

<script>
import http from "../http-common.js";
export default {
  data() {
    return {
      title: "",
      start_date: "",
      end_date: "",
      start_menu: false,
      end_menu: false,
      img_src: "",
      img: "",
      isUpdate: false,
      btn_val: "수정",
      frm: new FormData(),
      read: true
    };
  },
  methods: {
    save() {
      this.frm.append("start_date", this.start_date);
      this.frm.append("end_date", this.end_date);
      this.frm.append("img", this.img);
      this.frm.append("title", this.title);
      var dt = new Date();
      var tdt = dt.toISOString().substring(0, 10);
      this.frm.append("reg_date", tdt);
      console.log(this.frm);
      http
        .post("notice/info", this.frm)
        .then(response => {
          console.log("res", response);
          this.$router.push("/noticeList");
        })
        .catch(() => {
          this.error = true;
        })
        .finally(() => (this.loading = false));
    },
    onFileChange(e) {
      this.img = e;

      this.img_src = URL.createObjectURL(this.img);
      console.log(this.img);
    },
    initialize() {
      let id = this.$route.params.notice_id;
      http
        .get("notice/info/" + id)
        .then(res => {
          const notice = res.data.notice;
          this.img_src = notice.notice_img;
          this.title = notice.notice_title;
          this.start_date = notice.start_date;
          this.end_date = notice.end_date;
        })
        .catch(() => {
          this.error = true;
        })
        .finally(() => (this.loading = false));
    }
  },
  mounted() {
    this.initialize();
  }
};
</script>

<style>
#infoNotice {
  margin-bottom: 30px;
}
#infoNotice > .layout {
  margin: 0 auto;
  padding-top: 20px;
  border: 1px solid #ccc;
}
#infoNotice .layout .v-responsive__content {
  border: 1px solid #ccc;
}
</style>