import Vue from 'vue'
import Vuex from 'vuex'
import api from './components/backend-api'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
      status:'',
        loginSuccess: false,
        loginError: false,
        email: null,
        pass: null,
        token: localStorage.getItem('token') || '',
        user: {}
    },
    mutations: {
      auth_request(state){
        state.status = 'loading'
      },

        auth_success(state, token, user){
          state.status = 'success'
          state.token = token
          state.user = user
        },
        auth_error(state){
          state.status = 'error'
        },
        logout(state){
          state.status = ''
          state.token = ''
        },
    },
    actions: {
        login({commit}, user) {
            return new Promise((resolve, reject) => {
              commit('auth_request')
                api.getUser(email, pass)
                    .then(response => {
                      const token = response.data.token
                      const user = response.data.user
                      localStorage.setItem('token', token)
                      axios.defaults.headers.common['Authroization'] = getSecuredTextFromBackend
                      commit('auth_success', token, user)
                      resolve(response)
                  })
                    .catch(error => {
                        console.log("Error: " + error);
                        // place the loginError state into our vuex store
                        commit('auth_error')
                            localStorage.removeItem('token')
                            reject(error)
                        })
                    })
                  },

          logout({commit}){
            return new Promise((resolve, reject) =>{
              commit('logout')
              localStorage.remoteItem('token')
              delete axios.defaults.headers.common['Authorization']
              resolve()
            })
          }
      },


    getters: {
        isLoggedIn: state => !!state.token,
        authStatus: state => state.status,
        getUserEmail: state => state.email,
        getUserName: state => state.username,
        getUserPass: state => state.pass
    }
})
