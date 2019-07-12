<template>
  <div>
    <div class="centermain">
    <h1><b-badge>Dashboard</b-badge></h1>
    <h3>Welcome {{ username }}</h3>

  </div>
<b-container>
<b-row>
  <b-col lg="7">
    <div>
      <h2>MyEvents</h2>
    <ul class="list-unstyled" >

   <b-media tag="li" v-for="e in events">
    <b-img slot="aside" blank blank-color="#abc" width="64" alt="placeholder"></b-img>

    <span class="mt-0 mb-1"><span id="title">{{e.title}}</span> @ {{e.where}} || {{e.timedate}}</span>
    <br>
    You Are: <a href="#">Invited</a>
    <p class="mb-4">
      {{e.what}}
    </p>
  </b-media>

   </ul>
</div>
</b-col><!--Events Column-->

<b-col> <div id="dim"><h3>Messages</h3>
  <b-list-group>
    <b-list-group-item>Cras justo odio</b-list-group-item>
    <b-list-group-item>Dapibus ac facilisis in</b-list-group-item>
    <b-list-group-item>Morbi leo risus</b-list-group-item>
    <b-list-group-item>Porta ac consectetur ac</b-list-group-item>
    <b-list-group-item>Vestibulum at eros</b-list-group-item>
  </b-list-group></div></b-col>
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
      username:'',
      userid:'',
      newevent:'',
      securedApiCallSuccess: false,
      errors: null
    }
  },
  computed: {
    ...mapGetters({
      events: 'getUserEvents'
    })
  },

  mounted() {
    this.displayUserInfo(),
    this.displayEvents()
  },
  methods: {
    //test
    displayUserInfo(username, userid, useremail){
      this.username = store.getters.getUserName;
      this.userid = store.getters.getUserId;
       this.useremail = store.getters.getUserEmail;
      console.log("display User Info :" + username + " " + userid + " " + useremail);
    },
    displayEvents(){
      this.$store.dispatch('loadEvents')
    //  this.userevents= store.getters.getUserEvents;
    //  console.log(userevents)


    }
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
