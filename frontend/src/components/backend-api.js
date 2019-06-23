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
    getUser( email, pass) {
        return AXIOS.get(`/users`,{
                email: email,
                pass: pass
            })
            .catch(error => {
              console.log(error.response)
            });
    }
}
