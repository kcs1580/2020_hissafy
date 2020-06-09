<template>
  <div id="addNotice">
    <v-layout row :class="`d-flex justify-center mb-6`">
      <v-flex xs2 :class="`d-flex justify-center align-self-center`">
        <v-subheader>Title</v-subheader>
      </v-flex>
      <v-flex xs6>
        <v-text-field v-model="title" name="input-1"></v-text-field>
      </v-flex>
      <v-flex xs8 :class="`d-flex justify-center mb-6`">
        <v-file-input accept="image/*" label="File input" @change="onFileChange"></v-file-input>
      </v-flex>
      <v-flex v-if="img_src" xs8 :class="`d-flex justify-center mb-6`">
        <v-img :src="img_src"></v-img>
      </v-flex>
      <v-row :class="`d-flex justify-center mb-6`">
        <v-col cols="12" sm="6" md="4">
          <v-menu
            ref="start_menu"
            v-model="start_menu"
            :close-on-content-click="false"
            :return-value.sync="start_date"
            transition="scale-transition"
            offset-y
            min-width="290px"
          >
            <template v-slot:activator="{ on }">
              <v-text-field
                v-model="start_date"
                label="시작 날짜"
                prepend-icon="event"
                readonly
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker v-model="start_date" no-title scrollable>
              <v-spacer></v-spacer>
              <v-btn text color="primary" @click="start_menu = false">Cancel</v-btn>
              <v-btn text color="primary" @click="$refs.start_menu.save(start_date)">OK</v-btn>
            </v-date-picker>
          </v-menu>
        </v-col>
        <v-col cols="12" sm="6" md="4">
          <v-menu
            ref="end_menu"
            v-model="end_menu"
            :close-on-content-click="false"
            :return-value.sync="end_date"
            transition="scale-transition"
            offset-y
            min-width="290px"
          >
            <template v-slot:activator="{ on }">
              <v-text-field v-model="end_date" label="마감날짜" prepend-icon="event" readonly v-on="on"></v-text-field>
            </template>
            <v-date-picker v-model="end_date" no-title scrollable>
              <v-spacer></v-spacer>
              <v-btn text color="primary" @click="end_menu = false">Cancel</v-btn>
              <v-btn text color="primary" @click="$refs.end_menu.save(end_date)">OK</v-btn>
            </v-date-picker>
          </v-menu>
        </v-col>
      </v-row>
    </v-layout>
    <v-flex :class="`d-flex justify-end`">
      <v-btn color="primary" @click="save()">저장</v-btn>
    </v-flex>
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
      frm: new FormData()
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
        .post("notice/register", this.frm)
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
    }
  }
};
</script>

<style>
#addNotice > .layout {
  margin: 0 auto;
  border: 1px solid #ccc;
}
.layout .v-responsive__content {
  border: 1px solid #ccc;
}
</style>