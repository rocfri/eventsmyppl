<template>
<div>
    <h1>Register an Account</h1>

    <form @submit.prevent="userRegister()">
    <h3>Login Information</h3>
    <p>Username: <input type="text" placeholder="username" v-model="username"></p>
    <p>Email: <input type="text" placeholder="email" v-model="email"></p>
    <p>Password: <input type="password" placeholder="password" v-model="password"></p>
    <p><h3>Personal Information</h3> (optional)</p>
    <h4>Address</h4>
    <p>Street: <input type="text" placeholder="street" v-model="street"></p>
    <p>City: <input type="text" placeholder="city" v-model="city">
      <p>State: <input type="text" placeholder=" " v-model="state" class="smallInput"> Zip Code: <input type="text" placeholder=" " v-model="zip" size="10"> </p>
    <p>Phone: <input type="text" placeholder=" " v-model="phone"></p>
      <b-btn variant="success" type="submit">Sign Up</b-btn>

    </form>

  </div>


</template>

<script>
import api from "./backend-api";

export default {
  name: 'register',
data () {
  return {
    response: [],
    errors: [],

    username: '',
    email:'',
    password:'',
    street:'',
    city:'',
    state:'',
    zip:'',
    phone:''
  }
},

methods: {
  userRegister(){

    api.createUser(this.username, this.email, this.password).then(response => {

        this.response =  response.data;
        console.log('User created: ' + response.data);
      })
      .catch(e => {
        this.errors.push(e)
      })

      this.username =''
      this.email =''
      this.password =''

  }

}

}
</script>

<style>
.smallInput{
  width: 50px;
}
</style>
