import Vue from 'vue'
import Vuex from 'vuex'
import api  from './components/backend-api'
import axios from 'axios'

Vue.use(Vuex, axios);

export default new Vuex.Store({
//Starting State
    state: {
      users:[],
      foundUser:'',
      UserName: null,
      UserEmail: null,
      UserId: null,
      loginSuccess:  false,
      loginError: false
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
          //TODO
        },
  findPerson({commit, state},{email, password}){

      let users = state.users

      let foundUser = users.filter(user =>{
          return email === user.email && password === user.pass;
        });

          if(foundUser.length){
            let user = foundUser[0];
            console.log("User:" + user.username +" " +"found")
            //setter
              commit('SET_PERSON',{
                UserName: user.username,
                UserEmail: user.email,
                UserId: user.id
              });

         }else{
      //TODO: Bool for loginSuccess
        console.log("Store: Invalid user request");
        state.loginSuccess= false
         }
        }//loadPerson
      },
//changes to make to incoming data
mutations: {
  //This passes the users data we got in the loadUsers Action and sets it to the state variable/array
  SET_USERS(state, users){
    state.users = users
  },
  SET_PERSON(state, payload){
    state.loginSuccess = true;
    state.UserName = payload.UserName;
    state.UserEmail = payload.UserEmail;
    state.UserId = payload.UserId;

  },
  LOGIN_ERROR(){}
},

getters: {

        getUserEmail: state => state.UserEmail,
        getUserName: state => state.UserName,
        getUserId: state => state.UserId
    }
})
