import axios from 'axios'

const AXIOS = axios.create({
  baseURL: 'http://localhost:3000',
  //Quick test to JSON server `http://localhost:3000`,
  timeout: 1000
});


export default {
    hello() {
        return AXIOS.get(`/`);
    },

    createUser(username, email, password, phone, street) {

      console.log("Backend API :: createUser Frontend found");
        return AXIOS.post('/register',{

            userName: username,
            userEmail: email,
            userPass: password,
            userStreet: street,
            userPhone: phone

        });
    },//ceateUser

    getUserData(email) {
      try{
        console.log("backend-api:: getUserData ::")
        return AXIOS.post('/login', {
          email: email
        });

        } catch(e){
          console.error(e)
        }
    },//getUser

    createEvent(title, when, time, location, what, who, userid) {

      console.log("Backend API :: createEvent found");
        return AXIOS.post('/events',{

            eventTitle: title,
            eventDate: when,
            eventTime: time,
            eventLoc: location,
            eventDetail: what,
            eventGuest: who,
            userId: userid

        });
    },//ceateUser

    getEventData(){
      try{
        return AXIOS.get('/events')
      }catch(ee){
        console.error(ee)
      }
    }//getEvent
}//
