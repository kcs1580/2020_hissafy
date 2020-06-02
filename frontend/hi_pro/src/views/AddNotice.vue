<template>
  <div id="addNotice">
    <v-layout row :class="`d-flex justify-center mb-6`">
      <v-flex xs2 :class="`d-flex justify-center align-self-center`">
        <v-subheader>Title</v-subheader>
      </v-flex>
      <v-flex xs6>
        <v-text-field id="testing" name="input-1"></v-text-field>
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
export default {
  data() {
    return {
      start_date: "",
      end_date: "",
      start_menu: false,
      end_menu: false,
      img_src: "",
      img: ""
    };
  },
  methods: {
    save() {
      console.log(this.start_date);
      console.log(this.end_date);
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