import Vue from 'vue'
import Vuex from 'vuex'
import {api } from './components/backend-api'
import axios from 'axios'
Vue.use(Vuex, axios);

export default new Vuex.Store({
//Starting State
    state: {
      users:[]
    },
//Action that needs to be taken
    actions: {
        loadUsers({commit}){
          console.log ("Load Users")
          axios
          .get('http://localhost:3000/users/')
          .then(data =>{
            console.log(data.data)
            let users = data.data
            commit('SET_USERS', users)
          })
          .catch(error => {
            console.log(error)
          })
        },
        logout({commit}){
          //
        }
      },
//changes to make to incoming data
mutations: {
  //This passes the users data we got in the loadUsers Action and sets it to the state variable/array
  SET_USERS(state, users){
    state.users = users
  }
},

    getters: {

        getUserEmail: state => state.email,
        getUserName: state => state.username,
        getUserPass: state => state.pass,
        getUserId: state => state.id
    }
})
