import React, {Component,useState} from 'react';
import {Link, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {topic} from "../../actions/personActions";
import {bindActionCreators} from "redux";

class GrammarLessonTest extends Component {
    constructor(props) {
        super(props);
        this.state = {value: '',obj:[]};
        this.handleChange = this.handleChange.bind(this);
        this.handleUserInput = this.handleUserInput.bind(this);
    }

    handleChange = (e) => {



        // this.setState({value: e.target.value});
        // console.log(document.querySelector(".answer-check").innerHTML)
        // console.log(e.target.value);
    }
    handleUserInput = (e) => {
        this.props.grammarLessons.map(({lessonId,tasks}) => {
            let taskNumber = 0;
            let taskIdCount =0;
            if (lessonId === this.props.getActiveLesson.lessonIdCheck) {
                return (tasks.map(({taskId, question, answer,}) => {


                    if(parseInt(document.getElementsByClassName("task-input")[taskIdCount++].id)===taskId && answer===document.getElementsByClassName(
                        "task-input")[taskNumber++].value){
                        document.getElementById(taskId).style.background = "blue";
                    }

                }))
            }
        })

        e.preventDefault()
    }



    render() {
        const {lessonIdCheck,x} = this.props.getActiveLesson;
        const grammarLessons =()=>{  return (this.props.grammarLessons.map(({lessonId,tasks}) => {
            let taskNumber = 1;
            if (lessonId === lessonIdCheck ){
                return (tasks.map(({taskId,question,answer})=>{

                        return  <React.Fragment>
                            <div className={"task-number"}>Завдання {taskNumber++}</div>
                            <div className={"task-style"}>{question}</div>
                            <input className={"task-input"}  type={"text"} id={taskId} onChange={this.handleChange} ref={"title"}/>
                            <div className={"answer-check"} ref={`taskId+44`}>{answer}</div>


                    </React.Fragment>
                    }))
                    }


            else{return <React.Fragment>
                <div>Ты куда зашёл, петух</div></React.Fragment>}

        }))}
        return (
            <section className={"verbs"}>
                <h1>Урок {x} </h1>
                <ul className={"english-list"}>
                    {grammarLessons()}
                </ul>
                <button onClick={this.handleUserInput} type={"submit"} className={"task-button"}>Перевірити тест</button>
            </section>
        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {
        grammarLessonsData: bindActionCreators(topic, dispatch),

    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        grammarLessons: state.grammarLessons,
        getActiveLesson: state.activeLesson


    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(GrammarLessonTest));