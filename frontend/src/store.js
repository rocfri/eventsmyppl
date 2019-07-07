import Vue from 'vue'
import Vuex from 'vuex'
import {api } from './components/backend-api'
import axios from 'axios'
import vemail from Login

Vue.use(Vuex, axios);

export default new Vuex.Store({
//Starting State
    state: {
      users:[],
      user:''
    },
//Action that needs to be taken
  actions: {
        loadUsers({commit}){
          console.log ("Load Users")
          axios.get('http://localhost:3000/users/')
          .then(data =>{
            console.log(data.data)
            let users = data.data
            commit('SET_USERS', users)
          })
          .catch(error => {
            console.log(error)
          })
        },
 logoutUser({commit}){
          //
        },
  loadPerson(vemail, vpassword){
          let users = this.users
          let foundUser = users.filter(user =>{
            return this.vemail === user.email && this.vpassword ===user.pass;
          })
          if(foundUser.length){
            let user = foundUser[0];
            //this.$router.push('/Dashboard')
          }else{
            this.message = "Email or password incorrect"
          }
        }//loadPerson
      },
//changes to make to incoming data
mutations: {
  //This passes the users data we got in the loadUsers Action and sets it to the state variable/array
  SET_USERS(state, users){
    state.users = users
    state.UserName = users.username,
    state.UserId = users.id
  }
},
getters: {

        getUserEmail: state => state.email,
        getUserName: state => state.UserName,
        getUserId: state => state.UserId
    }
})
