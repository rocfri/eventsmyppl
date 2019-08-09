import Vue from 'vue'
import Vuex from 'vuex'
import api from './components/backend-api'
import axios from 'axios'

Vue.use(Vuex, axios);

export default new Vuex.Store({
//Starting State
    state: {
      users:[],
      events:[],
      foundUser:'',
      UserName: null,
      UserEmail: null,
      UserId: null,
      loginSuccess:  false,
      loginError: false
    },
//Action that needs to be taken
  actions: {
//<<-------------------------Loading User --------------------------------------->>
        loadUsers({commit}){
          console.log ("Load Users")
          //api.getUserData() //<--Attachment to real API; replace below line
          axios.get('http://localhost:3000/users/')
          .then(data => {
            let users = data.data
            console.log("store::loadUsers:: "+ users)
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
    console.log("store:: findPerson reached")
      let users = state.users

      let foundUser = users.filter(user =>{
          return email === user.userEmail && password === user.userPass;
        });
        console.log(foundUser);
          if(foundUser.length){
            let user = foundUser[0];
            console.log("User:" + user.userName +" " +"found");
            //setter
              commit('SET_PERSON',{
                UserName: user.userName,
                UserEmail: user.userEmail,
                id: user.id
              });

         }else{
      //TODO: Bool for loginSuccess
        console.log("Store: Invalid user request");
        state.loginSuccess = false
         }
       },//loadPerson
//<<--------------------Events/Tickets------------------------------------------->>
      loadEvents({commit, state}){
        console.log("Load Events")
        api.getEventData()
        .then(data => {
          let events = data.data
          commit('SET_EVENTS', events)
        })
        .catch(error => {
          console.log(error)
        })
      },

        createEvent(){},
        editEvent(){},
        deleteEvent(){

        }//End of events, deleteEvent
      },
//changes to make to incoming data
mutations: {
  //This passes the users data we got in the loadUsers Action and sets it to the state variable/array
  SET_USERS(state, users){
    state.users = users;
  },
  SET_PERSON(state, payload){
    state.loginSuccess = true;
    state.UserName = payload.UserName;
    state.UserEmail = payload.UserEmail;
    state.UserId = payload.UserId;

  },
  SET_EVENTS(state, events){
    state.events = events;
    console.log("Store" + " " + events)
  },
  LOGIN_ERROR(){}
},

getters: {

        getUserEmail: state => state.UserEmail,
        getUserName: state => state.UserName,
        getUserId: state => state.UserId,

        getUserEvents: state => state.events
    }
})
