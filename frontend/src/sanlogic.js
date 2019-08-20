import Vue from 'vue'
import api from './components/backend-api'
import axios from 'axios'

//Sanitization Logic. Let's try not to send something gnarly to the backend.

//Demo App Logic
/*
if id is user id then user is host, else user is guest
bool guest: false "invited" / if decline stays false else becomes true guest to event

*/
