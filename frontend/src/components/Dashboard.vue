<template>
  <div>
    <h1><b-badge>Dashboard</b-badge></h1>
    <h3>Welcome {{user.getUserName}}</h3>

    <p></p>
<b-container id="content-wrapper">
<b-row>
  <b-col cols="7">
    <div id="events"><h2>MyEvents</h2>
      <ul class="list-unstyled">
     <b-media tag="li">
       <b-img slot="aside" blank blank-color="#abc" width="64" alt="placeholder"></b-img>

       <h5 class="mt-0 mb-1">List-based media object</h5>
       <p class="mb-0">
         Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin.
         Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc
         ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
       </p>
     </b-media>

     <b-media tag="li" class="my-4">
       <b-img slot="aside" blank blank-color="#cba" width="64" alt="placeholder"></b-img>

       <h5 class="mt-0 mb-1">List-based media object</h5>
       <p class="mb-0">
         Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin.
         Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc
         ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
       </p>
     </b-media>

     <b-media tag="li">
       <b-img slot="aside" blank blank-color="#bac" width="64" alt="placeholder"></b-img>

       <h5 class="mt-0 mb-1">List-based media object</h5>
       <p class="mb-0">
         Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin.
         Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc
         ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
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

export default {
  name: 'dashboard',

  data () {
    return {
      user:{},
      backendResponse: '',
      securedApiCallSuccess: false,
      errors: null
    }
  },
  methods: {
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
