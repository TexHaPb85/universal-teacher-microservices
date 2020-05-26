import axios from 'axios'
import {grammarTopic} from "../components/Courses/GrammarLessons"
import store from "../index";
// const  WEB_API_URL = 'http://localhost:8081';


class Login {


    topicFetch() {

        const grammarPath = grammarTopic()
         return  axios.get(`${'http://localhost:9001/grammar/'+grammarPath}`)
}
    grammarLessonsFetch() {
         return  axios.get(`${'http://localhost:9001/grammar/'}`)
}
//     lessonFetch() {
//          return  axios.get(`${'http://localhost:9001/grammar/'+{lessonId}}`)
// }
    irregularFetch (){
        return  axios.get(`${'http://localhost:9001/irregular-verbs'}`
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
    phrasalFetch (){
        return  axios.get(`${'http://localhost:9001/phrasal-verbs'}`

        )
    }
    nounFetch (){
        return  axios.get(`${'http://localhost:9001/noun-verbs'}`

        )
    }
    irregularTrain(){
        return axios.get(`${'http://localhost:9001/irregular-verbs/train'}`

        )
    }
    phrasalTrain(){
        return axios.get(`${'http://localhost:9001/phrasal-verbs/train'}`

        )
    }

    nounTrain(){
        return axios.get(`${'http://localhost:9001/noun-verbs/train'}`
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
