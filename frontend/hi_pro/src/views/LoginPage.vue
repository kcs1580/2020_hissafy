<template>
  <div id="login" class="user">
    <div class="wrapC">
      <br />
      <br />
      <h1>
        로그인을 하고 나면
        <br />좋은 일만 있을 거예요.
      </h1>

      <div class="input-with-label">
        <input id="id" v-model="id" placeholder="ID" type="text" @keyup.enter="login" />
        <label for="id">ID</label>
      </div>
      <br />
      <br />
      <div class="input-with-label">
        <input
          id="password"
          v-model="password"
          type="password"
          :class="{error : error.password, complete:!error.password&&password.length!==0}"
          placeholder="비밀번호를 입력하세요."
          @keyup.enter="login"
        />
        <label for="password">비밀번호</label>
        <div v-if="error.password" class="error-text">{{ error.password }}</div>
      </div>
      <button
        class="btn btn--back btn--login"
        :disabled="!isSubmit"
        :class="{disabled : !isSubmit}"
        @click="login"
      >로그인</button>
    </div>
  </div>
</template>

<script>
import "../../assets/css/style.scss";
import "../../assets/css/user.scss";
import PV from "password-validator";
import * as EmailValidator from "email-validator";
import UserApi from "../../apis/UserApi";
import http from "../../http-common.js";
import jwtDecode from "jwt-decode";

export default {
  components: {},
  data() {
    return {
      id: "",
      password: "",
      passwordSchema: new PV(),
      error: {
        id: false,
        passowrd: false
      },
      isSubmit: false,
      component: this
    };
  },
  created() {
    this.component = this;
    this.passwordSchema
      .is()
      .min(8)
      .is()
      .max(100)
      .has()
      .digits()
      .has()
      .letters()
      .has()
      .symbols();
  },
  watch: {
    password: function(v) {
      this.checkForm();
    },
    email: function(v) {
      this.checkForm();
    }
  },
  methods: {
    checkForm() {
      let isSubmit = true;
      Object.values(this.error).map(v => {
        if (v) isSubmit = false;
      });
      this.isSubmit = isSubmit;
    },
    login() {
      if (this.isSubmit) {
        let { id, password } = this;
        let data = {
          id,
          password
        };
        //요청 후에는 버튼 비활성화
        this.isSubmit = false;
        http
          .post(
            "/user/login",
            {
              id: this.id,
              pw: this.password
            },
            {
              headers: {
                Authorization: "this.$store.state.token"
              }
            }
          )
          .then(Response => {
            console.log(Response);
            if (Response.data.resvalue) {
              this.$router.push("/main");
              this.$store.dispatch("login", Response.data.resvalue);
            } else {
              alert("로그인에 실패하였습니다.");
              this.password = "";
            }
            this.isSubmit = true;
          })
          .catch(err => {
            console.log(err);
            alert("로그인에 실패하였습니다.");
            this.isSubmit = true;
          });
      }
    }
  }
};
</script>