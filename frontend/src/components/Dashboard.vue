<template>
  <div>
    <h1><b-badge variant="success">Welcome</b-badge></h1>

    <b-btn variant="primary" @click="getSecuredTextFromBackend()">Call the secured API</b-btn>
    <p></p>

    <div v-if="securedApiCallSuccess">
      <b-badge variant="success">API call</b-badge> Full response: {{ backendResponse }} <b-badge variant="success">successful</b-badge>
    </div>
    <div v-if="errors">
      <b-badge variant="warning">API call</b-badge> {{ errors }} <b-badge variant="warning">NOT successful</b-badge>
    </div>
  </div>

</template>

<script>
  import api from './backend-api'
  import store from './../store'

export default {
  name: 'dashboard',

  data () {
    return {
      backendResponse: '',
      securedApiCallSuccess: false,
      errors: null
    }
  },
  methods: {
    getSecuredTextFromBackend() {
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
    }
  }
}

</script>
