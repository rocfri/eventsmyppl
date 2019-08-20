<template>
  <div id="app">
    <div class="centermain">
  <h1>Events.MyPpl</h1>
    <div id="nav">
<<<<<<< Updated upstream
      <span v-if="isLoggedIn"> <a @click="logout">Logout </a></span>
      <span v-else> <router-link to="/">Login</router-link> | <router-link to="/register">Register</router-link></span>
      | <router-link to="/dashboard">Dashboard</router-link> | <router-link to="/event"> Event WIP</router-link>
=======
      <span v-if="isLoggedIn"> <router-link to="/" @click="logout">Logout </router-link></span>
      <span v-else> <router-link to="/">Login</router-link> | <router-link to="/register">Register</router-link></span>
      | <router-link to="/dashboard">Dashboard</router-link> <span v-if="isLoggedIn">| <router-link to="/event"> Event WIP</router-link></span>
>>>>>>> Stashed changes

    </div>
</div>
<div class="centermain">
    <router-view></router-view>
</div>
  </div>
</template>

<script>

export default {
  name: 'app',
  data () {
    return {
    }
  },
  computed: {
    isLoggedIn: function(){
      return this.$store.getters.isLoggedIn;
    }
  },
  methods:{
    logout: function  (){
      this.$store.dispatch('logout').then(() =>{
      this.$router.push('/');
    })
    }
  },
}
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 20px;
}

#nav {
  padding: 30px;
  a {
    font-weight: bold;
    color: #2c3e50;
    &.router-link-exact-active {
     color: #705823;
    }
  }
}
.centermain{
  text-align: center;
}
</style>
