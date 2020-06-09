<template>
  <v-app id="app">
    <v-content id="content">
      <nav>
        <Nav></Nav>
      </nav>
      <router-view class="router-view" />
    </v-content>
    <footer>
      <ul>
        <li>
          <a href="#">사이트 도움말</a>
        </li>
        <li>
          <a href="#">사이트 이용약관</a>
        </li>
        <li>
          <a href="#">사이트 운영규칙</a>
        </li>
        <li>
          <a href="#">
            <strong>개인정보취급방침</strong>
          </a>
        </li>
        <li>
          <a href="#">고객센터</a>
        </li>
      </ul>
      <address>Copyright&copy; All Right Reserved</address>
    </footer>
  </v-app>
</template>

<script>
import Nav from "./components/Nav";
export default {
  name: "App",

  components: {
    Nav
  }
};
</script>

<style>
#app #content {
  width: 100%;
  margin: 0 auto;
}
nav {
  width: 100%;
  z-index: 2;
  position: absolute;
}
.router-view {
  position: relative;
  margin-top: 200px !important;
  z-index: 0;
  width: 80%;
  margin: 0 auto;
}
footer {
  height: 100px;
  background: #aaa;
}
footer a,
li,
ul {
  text-decoration: none;
  color: #000 !important;
}
footer {
  padding: 25px 0;
  text-align: center;
}
footer ul {
  margin-bottom: 15px;
}
footer li {
  position: relative;
  display: inline;
  padding: 0 7px 0 10px;
}
footer li:before {
  content: "";
  width: 1px;
  height: 12px;
  background: #ccc;
  position: absolute;
  left: 0;
  top: 2px;
}
footer li:first-child::before {
  width: 0;
  height: 0;
}
</style>