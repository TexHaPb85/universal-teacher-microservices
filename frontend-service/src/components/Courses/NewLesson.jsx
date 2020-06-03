import React, {Component} from 'react';
import {Link, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {newLessonPost} from "../../actions/personActions";
import {bindActionCreators} from "redux";


export const  grammarTopic =()=>{

    let str = window.location.pathname;
    let n = str.lastIndexOf('/');

    return str.substring(n + 1);

}
class NewLesson extends Component {

    componentWillMount() {
    }
    newLessonSubmit(){
        let youTubeUrl = document.getElementById("youTubeUrl").value
        let textDescription = document.getElementById("textDescription").value
        let topic = grammarTopic()
        this.props.getLesson(youTubeUrl,textDescription,topic)
        // console.log(JSON.stringify(this.props.newLesson))

        this.props.addNewLesson(newLessonPost())
    }

    render() {

        // const grammarLessons =()=>{  let x=1; return (this.props.grammarLessons.map(({topic,lessonId}) => {
        //
        //     return <Link onClick={this.props.getLesson.bind(this,lessonId,x)} key={x} to={`${topic}/${lessonId}`}><li  id={lessonId}>{topic} {x++} </li></Link>
        //
        //
        // }))}
        return (
            <section className={"verbs"}>
                <ul className={"english-list"}>
                    <form>
                        <label>Ссылка на ютуб</label>
                        <input className={"lesson-input"} id={"youTubeUrl"} type={"text"} />
                        <label>Описание урока</label>
                        <input className={"lesson-input"} id={"textDescription"} type={"text"} />
                        <button className={"lesson-submit"} type={"button"} onClick={this.newLessonSubmit.bind(this)} >Добавить урок</button>
                    </form>
                </ul>

            </section>

        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {
        getLesson: (youTubeUrl,textDescription,topic) => {
            dispatch({type: "ADD_NEW_LESSON",payload: {youTubeUrl:youTubeUrl,
                    textDescription:textDescription,topic:topic,tasks:null} })
        },
        addNewLesson: bindActionCreators(newLessonPost, dispatch)

    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        grammarLessons: state.grammarLessons,
        newLesson : state.newLesson
    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(NewLesson));