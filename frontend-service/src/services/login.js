import axios from 'axios'


// const  WEB_API_URL = 'http://localhost:8081';
// const LOGIN_API_URL = `${WEB_API_URL}/login`;

class Login {


    testFetch(){
        return axios.get(`${'http://localhost:9001/irregular-verbs-train'}`
        //     , {
        //     headers: {
        //         'Content-Type': 'application/json',
        //         'Access-Control-Allow-Origin': '*',
        //         'withCredentials' : 'true',
        //         'credentials' : 'same-origin',
        //
        //
        //     },withCredentials:true, credentials: "same-origin"
        // }
        )
    }


    googleAuth() {


            return axios.get(`${'http://localhost:8081'}`, {
            headers: {
                'Content-Type': 'application/json',

                'withCredentials' : 'true',
                    'credentials' : 'same-origin',


            },withCredentials:true, credentials: "same-origin"

        })

    }

}

export default new Login;
