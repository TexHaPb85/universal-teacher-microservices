
const initialState = {
    persons: {},
    irVerbs:[{"id":1,"infinitive":"ch","pastSimple":"ew","pastParticiple":"d","translation":"d"}],
    phrVerbs:[{"id":1,"infinitive":"ch","pastSimple":"ew","pastParticiple":"d","translation":"d"}],
    nounVerbs:[{"id":1,"infinitive":"ch","pastSimple":"ew","pastParticiple":"d","translation":"d"}],
    grammar:["english"],
    activeGrammarTopic:'',
    grammarLessons:[],
    activeLesson:[],
    randTrain:[],
    isLogged: true,
    creating: false,

};

const reducer = (state = initialState, action) => {

    if (action.type === "FETCH_START") {
        // window.open("http://localhost:8081/login");
        return {...state}
    }
    if (action.type === "FETCH_START1") {

        return {...state}
    }
    if (action.type === "GET_TEST_START"){
        return  {...state}
    }
    if (action.type === "RESET_TOPICS"){
        return  {...state,grammarLessons:initialState.grammarLessons}
    }
    if (action.type === "RESET_TRAIN"){
        return  {...state, randTrain: initialState.randTrain}
    }
    if (action.type === "GET_GRAMMAR_LESSONS"){
        return  {...state, grammar: action.payload}
    }
    if(action.type ==="GET_ACTIVE_TOPIC"){
        return {...state, activeGrammarTopic: action.payload}
    }
    if(action.type ==="GET_ACTIVE_LESSON"){
        return {...state, activeLesson: action.payload}
    }
    if (action.type === "GET_TOPIC_LESSONS"){
        return  {...state, grammarLessons: action.payload}
    }
    if (action.type === "GET_IRR") {
       console.log(action.payload);
        return {...state,irVerbs: action.payload}
    }
    if (action.type === "GET_PHRASAL") {
        console.log(action.payload);
        return {...state,phrVerbs: action.payload}
    }
    if (action.type === "GET_NOUN") {
        console.log(action.payload);
        return {...state,nounVerbs: action.payload}
    }if (action.type === "GET_IRR_TRAIN") {
       console.log(action.payload);
        return {...state,randTrain: action.payload}
    }
    if (action.type === "GET_PHR_TRAIN") {
        console.log(action.payload);
        return {...state,randTrain: action.payload}
    }
    if (action.type === "GET_NOUN_TRAIN") {
        console.log(action.payload);
        return {...state,randTrain: action.payload}
    }
    if (action.type === "loginData") {
        // state.persons = action.payload;
        // console.log(action.payload);
        // if (state.persons === null) {
        //
        //     state.isLogged = false
        // } else if (state.persons !== undefined) {
        //
        //     state.isLogged = true;
        //         state.creating = false;
        // }
        //
        // console.log(state.isLogged);
        // console.log(state);
        return {...state};
    }
    if (action.type === "deadData") {
        // newState.persons = action.error
    }
    if (action.type === "ON_LOGOUT") {
        return {initialState}
    }
    if (action.type === "CREATE_MOD") {
        return {...state, creating: true}
    }

    if (action.type === "EXIT_MOD") {
        return {...state, creating: false}
    }
    if (action.type === "LOGIN_WINDOW") {
        return {...state, creating: false}
    }


    return state;

};

export default reducer;