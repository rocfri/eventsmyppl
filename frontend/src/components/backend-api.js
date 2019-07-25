import axios from 'axios'

const AXIOS = axios.create({
  baseURL: '/api',
  //Quick test to JSON server `http://localhost:3000`,
  timeout: 1000
});


export default {
    hello() {
        return AXIOS.get(`/`);
    },
    createUser(username, email, pass) {
      console.log("createUser Frontend found");
        return AXIOS.post('/register',{
            username: username,
            email: email,
            pass: pass
        });
    },

    getUserData() {
      try{
        console.log("try getData reached")
        return AXIOS.get('/users')

        } catch(e){
          console.error(e)
        }
    },//getUser

    getEventData(){
      try{
        return AXIOS.get('/events')
      }catch(ee){
        console.error(ee)
      }
    }//getEvent
}//
