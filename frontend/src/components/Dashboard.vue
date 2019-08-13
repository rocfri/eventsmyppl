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
    You Are: <a href="#">Invited</a>
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
    <b-list-group-item>Cras justo odio</b-list-group-item>
    <b-list-group-item>Dapibus ac facilisis in</b-list-group-item>
    <b-list-group-item>Morbi leo risus</b-list-group-item>
    <b-list-group-item>Porta ac consectetur ac</b-list-group-item>
    <b-list-group-item>Vestibulum at eros</b-list-group-item>
  </b-list-group></div></b-col>
<b-col>
  <h2>Contacts</h2>
  <b-card-group deck>
    <b-card
    bg-variant="light"
    style="max-width: 20rem; height: 10rem;"
    img-src="" img-alt="contact" img-top>
      <b-card-text>MIA</b-card-text>
    </b-card>
    <b-card img-src="" img-alt="contact" img-top>
        <b-card-text>Jane Doe</b-card-text>
      </b-card>
      <b-card img-src="" img-alt="contact" img-top>
        <b-card-text>Jon Doe</b-card-text>
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
      when:''

    }
  },
  computed: {
    ...mapGetters({
      events: 'getUserEvents'
    })
  },

  mounted() {
    this.displayUserInfo()
    this.displayEvents()
  },
  methods: {
    //test
    displayUserInfo(username, userid, useremail){
      this.username = store.getters.getUserName;
      this.userid = store.getters.getUserId;
       this.useremail = store.getters.getUserEmail;

    },
    displayEvents(){
      this.$store.dispatch('loadEvents');
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
