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

    createUser(username, email, password, phone, street) {

      console.log("createUser Frontend found");
        return AXIOS.post('/register',{
          headers:{
            'Content-Type': 'application/json',
          },

            userName: username,
            userEmail: email,
            userPass: password,
            userStreet: street,
            userPhone: phone

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
