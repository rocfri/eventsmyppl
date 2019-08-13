<template>
<div>
    <h1><b-badge>My Event</b-badge></h1>
    <h3> Welcome {{username}} {{userid}}</h3>
    <form @submit.prevent="vCreateEvent()">
    <h3>Event Information</h3>
    <p>Title: <input type="text" placeholder="title" v-model="title"></p>
    <p>Date: <input type="date" placeholder="" v-model="when"> Time:<input type="time" v-model="time"></p>
    <p>Where: <input type="text" placeholder="where" v-model="location"></p>
    <p>Details: <input type="text" placeholder="details" v-model="what"></p>
    <p>Guests: <input type="text" placeholder="guest" v-model="who"></p>
      <b-btn variant="success" type="submit">Create</b-btn>

    </form>

  </div>


</template>

<script>
import api from "./backend-api";
  import store from './../store';

export default {
  name: 'event',
data () {
  return {
    response: [],
    errors: [],

    title:'',
    when:'',
    time:'',
    location:'',
    what:'',
    who:'',

    userid:'',
    username:''
  }
},

mounted() {
this.getUser();
},

methods: {
  vCreateEvent(){
    api.createEvent(this.title, this.when,this.time, this.location, this.what, this.who, this.userid).then(response => {

        this.response =  response.data;
        console.log('Event created: ' + response.data);
      })
      .catch(e => {
        this.errors.push(e)
      })

    this.title =''
    this.when =''
    this.time=''
    this.location =''
    this.what=''
    this.who=''

  },

  getUser(username, userid, useremail){
      this.username = store.getters.getUserName;
      this.userid = store.getters.getUserId;
       this.useremail = store.getters.getUserEmail;
      console.log("Event:: getUser: " + username + " " + userid + " " + useremail);
  }

}
}
</script>

<style>
.smallInput{
  width: 50px;
}
#justify{
  width: 80%;
}
</style>
