import axios from "axios"
import login from "../services/login"

export const googleAuth = () => {
    return function (dispatch) {
        dispatch({type: "FETCH_START"});
        // login.googleAuth().then((res) => dispatch({
        //     type: "loginData",
        //     // payload: res.data.profile
        // })).catch((response) => dispatch({
        //     type: "deadData",
        //     error: response.error
        // }))
    }};


export const irregularVerbs =() =>{
    return function (dispatch) {
        dispatch({type: "GET_TEST_START"});
        login.irregularFetch().then((res) => dispatch({
            type: "GET_IRR",
            payload: res.data
        })).catch((response) => dispatch({
            type: "deadData",
            error: response.error
        }))
    }};
export const phrasalVerbs =() =>{
    return function (dispatch) {
        dispatch({type: "GET_TEST_START"});
        login.phrasalFetch().then((res) => dispatch({
            type: "GET_PHRASAL",
            payload: res.data
        })).catch((response) => dispatch({
            type: "deadData",
            error: response.error
        }))
    }};
export const nounVerbs =() =>{
    return function (dispatch) {
        dispatch({type: "GET_TEST_START"});
        login.nounFetch().then((res) => dispatch({
            type: "GET_NOUN",
            payload: res.data
        })).catch((response) => dispatch({
            type: "deadData",
            error: response.error
        }))
    }};
    export const irregularTrain =() =>{
    return function (dispatch) {
        dispatch({type: "GET_TEST_START"});
        login.irregularTrain().then((res) => dispatch({
            type: "GET_IRR_TRAIN",
            payload: res.data
        })).catch((response) => dispatch({
            type: "deadData",
            error: response.error
        }))
    }};
export const phrasalTrain =() =>{
    return function (dispatch) {
        dispatch({type: "GET_TEST_START"});
        login.phrasalTrain().then((res) => dispatch({
            type: "GET_PHR_TRAIN",
            payload: res.data
        })).catch((response) => dispatch({
            type: "deadData",
            error: response.error
        }))
    }};
export const nounTrain =() =>{
    return function (dispatch) {
        dispatch({type: "GET_TEST_START"});
        login.nounTrain().then((res) => dispatch({
            type: "GET_NOUN_TRAIN",
            payload: res.data
        })).catch((response) => dispatch({
            type: "deadData",
            error: response.error
        }))
    }};


export const loginData = () => {
    return function (dispatch) {
        // dispatch({type: "FETCH_START1"});
        // login.googleAuth().then((res) => dispatch({
        //     type: "loginData",
        //     // payload: res.data.profile
        // })).catch((response) => dispatch({
        //     type: "deadData",
        //     error: response.error
        // }))

    }
};

export const ModalOpen = () => {
    return function (dispatch) {
        // dispatch({type:"START_CREATE_MOD"});
        setTimeout(() => {
            dispatch({type: "CREATE_MOD"})
        }, 2000)


    }


};