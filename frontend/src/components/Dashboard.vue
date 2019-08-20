<template>
  <div>
    <div>
    <h1><b-badge>Dashboard</b-badge></h1>
    <h3>Welcome {{ username }}</h3>

  </div>
<b-container>
<b-row>
  <b-col lg="7">
    <div>
      <h2>Events</h2>
      <p>Add || Delete</p>
    <ul class="list-unstyled" >

   <b-media tag="li" v-for="e in events">
    <b-img slot="aside" blank blank-color="#abc" width="64" alt="placeholder"></b-img>

    <span class="mt-0 mb-1"><span id="title">{{e.eventTitle}}</span> @ {{e.eventLoc}} || {{e.eventDate}} {{e.eventTime}}</span>
    <br>
    You Are: <a href="/Event">{{role}}</a>
    <p class="mb-4">
      {{e.what}}
    </p>
  </b-media>

   </ul>
</div>
</b-col><!--Events Column-->
</b-row>
<!--New row for Msgs and Contacts-->
<b-row>
<b-col> <div id="dim"><h3>Messages</h3>
  <b-list-group>
    <b-list-group-item>Chat With Birdie</b-list-group-item>
    <b-list-group-item>Chat with Vendor</b-list-group-item>
    <b-list-group-item>Msgs TODO: Module</b-list-group-item>
    <b-list-group-item>Msg TODO: More flexible DB</b-list-group-item>
    <b-list-group-item>Chat with Tiger</b-list-group-item>
  </b-list-group></div></b-col>
<b-col>
  <h2>Contacts</h2>
=======
  <b-card-group deck v-for="u in contacts">
    <b-card
    bg-variant="light"
    img-src="" img-alt="contact" img-top >
      <b-card-text>{{u.userName}}</b-card-text>
      <b-btn @click="invite">Invite</b-btn>
    </b-card>

</b-card-group>
</b-col>
</b-row>
</b-container>


</div><!--Main Div-->



</template>

<script>
  import api from './backend-api'
  import store from './../store'
  import { mapGetters } from 'vuex'

export default {
  name: 'dashboard',

  data () {
    return {
//User Info
      username:'',
      userid:'',
      newevent:'',

      securedApiCallSuccess: false,
      errors: null,

//Event Display list
    userevents:[],
      title:'',
      location:'',
      timedate:'',
      when:'',
      role:'Host', //If statement to change this
      accept: false //TODO for guest
=======
      when:'',
      role:'Host', //If statement to change this
      accept: false //TODO for guest
>>>>>>> Stashed changes

    }
  },
  computed: {
    ...mapGetters({
      events: 'getUserEvents',
      contacts: 'getContacts'
    })
  },

  mounted() {
    this.displayUserInfo()
    this.displayContacts()
=======
    this.displayContacts()
>>>>>>> Stashed changes
    this.displayEvents()
  },
  methods: {
    invite(){
      alert("Hi");
    },
    displayContacts(){
      this.$store.dispatch('loadUsers');
    },
    displayUserInfo(username, userid, useremail){
      this.username = store.getters.getUserName;
      this.userid = store.getters.getUserId;
       this.useremail = store.getters.getUserEmail;

    },
    displayEvents(){
      this.$store.dispatch('loadEvents');
  }

=======

>>>>>>> Stashed changes
  /**  getSecuredTextFromBackend() {
      api.getUser(store.getters.getUserEmail, store.getters.getUserPass)
              .then(response => {
                console.log("Response: '" + response.data + "' with Statuscode " + response.status);
                this.securedApiCallSuccess = true;
                this.backendResponse = response.data;
              })
              .catch(error => {
                console.log("Error: " + error);
                this.errors = error;
              })
    }**/
  }
}

</script>
<style>
#title{
  font-weight: bold;
}
</style>
