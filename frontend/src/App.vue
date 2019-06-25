<template>
  <div id="app">
  <h1>Events.MyPpl</h1>
    <div id="nav">
      <span v-if="isLoggedIn"> <a @click="logout">Logout</a></span>
      <span v-else> <router-link to="/">Login</router-link> | </span>
      <router-link to="/register">Register</router-link> | <router-link to="/dashboard">Dashboard</router-link>

    </div>
    <router-view></router-view>
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
  text-align: center;
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
</style>
