<template>
  <div>
    <h2>Login</h2>
    <h5>{{message}}</h5>

    <form @submit.prevent="callLogin()">
      <input type="text" placeholder="email" v-model="vemail">
      <p><input type="password" placeholder="password" v-model="vpassword"></p>
      <b-btn variant="success" type="submit">Login</b-btn>
      <!--<p v-if="error" class="error">Bad login information</p>-->
    </form>

    </div>


</template>

<script>
import api from './backend-api'
import store from './../store'
import Vue from 'vue'
import {mapState} from 'vuex'
export default {
  name: 'login',
  data () {

    return {
      message: "Please enter email and password",
      loginError: false,
      vemail: '',
      vpassword: '',
      errors: [],
      error:'',
      response: []
    }
  },

  mounted(){
    //This is a call made to the actual Java backend
    api.hello().then((response) => {
      console.log(response.data);
    })
    .catch(e => {
      this.errors.push(e)
    });
    this.$store.dispatch('loadUsers')

  },
computed:{
 ...mapState(['users'])
},//computed

  methods: {
    callLogin(){
      //for demo and testing on frontend
        console.log ("Call login reached")
        let users = this.users
        let foundUser = users.filter(user =>{
          return this.vemail === user.email && this.vpassword ===user.pass;
        })
        if(foundUser.length){
          let user = foundUser[0];
          this.$router.push('/Dashboard')
        }else{
          this.message = "Email or password incorrect"
        }

      }//callLogin

},//methods
}//export
</script>
