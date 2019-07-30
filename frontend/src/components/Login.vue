<template>
  <div class="centermain">
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


export default {

  name: 'login',
  data () {

    return {
      message: "Please enter email and password",
      loginError: false,
      loginSuccess: false,
      vemail: '',
      vpassword: '',
      errors: [],
      error:''
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
    //this.$store.dispatch('loadUsers')
  },
computed:{

},//computed

  methods: {
    callLogin(){
      this.errors=[];
       this.$store.dispatch("findPerson", {email: this.vemail, password: this.vpassword })
        .then(() => {
          let loginSuccess = this.$store.state.loginSuccess;
            if(loginSuccess === true){
                this.$router.push('/Dashboard')
            } else if( loginSuccess === false) {
              this.message = "Email or password incorrect"
            }
        })
        .catch(error =>{
          this.loginError = true;
          this.errors.push(error);

        })

      }//callLogin

},//methods
}//export
</script>
