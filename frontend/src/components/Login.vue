<template>
  <div class="unprotected" v-if="loginError" >
    <h3>Username and/or password wasn't recognized</h3>
  </div>
  <div class="unprotected" v-else>
    <h2>Login</h2>
    <h5>{{message}}</h5>

    <form @submit.prevent="callLogin()">
      <input type="text" placeholder="email" v-model="email">
      <p><input type="password" placeholder="password" v-model="password"></p>
      <b-btn variant="success" type="submit">Login</b-btn>
      <p v-if="error" class="error">Bad login information</p>
    </form>
    </div>


</template>

<script>
import api from './backend-api'
import store from './../store'
import Vue from 'vue'

export default {
  name: 'login',
  data () {

    return {
      message: "Please enter email and password",
      loginError: false,
      email: '',
      password: '',
      error: false,
      errors: [],
      response: []
    }
  },

  mounted(){
    api.hello().then((response) => {
      console.log(response.data);
    })
    .catch(e => {
      this.errors.push(e)
    })
  },

  methods: {
    callLogin() {
      this.errors = [];
      this.$store.dispatch("login", { email: this.email, pass: this.password})
        .then((response) => {
          console.log ("Login vue login reached")

        //this.$router.push('/Dashboard')
        })
        .catch(error => {
          this.errors.push(error),
          this.message = "Could not find email and password. Please try again"
        })
      }
}
}
</script>
