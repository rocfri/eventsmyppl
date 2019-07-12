import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `http://localhost:3000`,
  timeout: 1000
});


export default {
    hello() {
        return AXIOS.get(`/`);
    },
    createUser(username, email, pass, street, city, state, zip, phone) {
        return AXIOS.post('/users',{
            username: username,
            email: email,
            pass: pass,
            street: street,
            city: city,
            state: state,
            zip: zip,
            phone: phone

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
