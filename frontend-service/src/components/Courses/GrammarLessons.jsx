import React, {Component} from 'react';
import {Link, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {topic} from "../../actions/personActions";
import {bindActionCreators} from "redux";

export const  grammarTopic =()=>{

    let str = window.location.pathname;
    let n = str.lastIndexOf('/');

    return str.substring(n + 1);
}

class GrammarLessons extends Component {
    componentWillMount() {
        this.props.grammarLessonsData(topic())
    }

    render() {

        const grammarLessons =()=>{  let x=1; return (this.props.grammarLessons.map(({topic,lessonId}) => {

            return <Link onClick={this.props.getLesson.bind(this,lessonId,x)} key={x} to={`${topic}/${lessonId}`}><li  id={lessonId}>Урок {x++} </li></Link>


        }))}
        return (
            <section className={"verbs"}>
                <ul className={"english-list"}>
                    { grammarLessons()}
                    <Link to={"/english/grammar/edit/"+grammarTopic()}>Добавить новый урок</Link>
                </ul>

            </section>

        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {
        getLesson: (lessonId,x) => {
            dispatch({type: "GET_ACTIVE_LESSON",payload: {lessonIdCheck:lessonId,x:x} })
        },
        grammarLessonsData: bindActionCreators(topic, dispatch)

    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        grammarLessons: state.grammarLessons,
    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(GrammarLessons));