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
      foundUser:[],
      foundUserEvents:[],
      userEvents:[],
      UserName: localStorage.getItem('user_name') || null,
      UserEmail: null,
      UserId: localStorage.getItem('user_id') || null,
      loginSuccess: localStorage.getItem('login_success') || false,
      loginError: false
    },
//Action that needs to be taken
  actions: {
//<<-------------------------Loading User --------------------------------------->>
  loadUsers({commit}){
      console.log ("Load Users")
      api.getUserData() //<--Attachment to real API; replace below line
      //axios.get('http://localhost:3000/users/')

      .then(data => {
        let users = data.data
        console.log("store::loadUsers:: "+ users)
        commit('SET_USERS', users)
      })
      .catch(error => {
        console.log(error)
      })
    },
 logout({commit}){
      localStorage.removeItem('user_name');
      localStorage.removeItem('user_id');
      localStorage.removeItem('login_success');
        },
  //DEMO logic

//<<--------------------Events/Tickets------------------------------------------->>
  loadEvents({commit, state}){
        console.log("Store :: Load Events")
    api.getEventData().then(data => {
          let events = data.data
          console.log("Store: Load Events: User ");
    //      commit('SET_EVENTS', events)
    let foundUserEvents = events.filter(event => {
      return state.UserId == event.userId;
      });
    commit('SET_EVENTS', foundUserEvents);
        })
        .catch(error => {
          console.log(error)
        })

},
//DEMO logic
/*findUserEvents({commit, state}){
  console.log("Store:: findUserEvents")

  let events = state.events

  let foundUserEvents = events.filter(event => {
    return UserId === events.userId;
});
  commit('SET_USER_EVENTS', foundUserEvents);


},*/

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
    localStorage.setItem('login_success', state.loginSuccess = true);
    state.UserName = payload.UserName;
    state.UserEmail = payload.UserEmail;
    state.UserId = payload.UserId;

   localStorage.setItem('user_name', state.UserName);
   localStorage.setItem('user_id', state.UserId);
  },
  SET_EVENTS(state, events){
    state.events = events;
    console.log("Store:: Set Events " + events);
  },
  SET_USER_EVENTS(state, payload){
   state.foundUserEvents = payload;
   console.log("store:: Set User Events " + foundUserEvents)

  },
  LOGIN_ERROR(){}
},

getters: {

        isLoggedIn: state => state.loginSuccess,
        getUserEmail: state => state.UserEmail,
        getUserName: state => state.UserName,
        getUserId: state => state.UserId,

        getContacts: state => state.users,
        getUserEvents: state => state.events
    }
})
