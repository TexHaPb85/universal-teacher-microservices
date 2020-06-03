import React, {Component} from 'react';
import {Link, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {programmingLessonsFetch} from "../../actions/personActions";
import {bindActionCreators} from "redux";

export const  programmingLesson =()=>{

    let str = window.location.pathname;
    let n = str.lastIndexOf('/');

    return str.substring(n + 1);
}

class ProgrammingLessons extends Component {
    componentWillMount() {
        this.props.programmingLessonsData(programmingLessonsFetch())
    }

    render() {
            console.log(this.props.programmingLessons)
        const grammarLessons =()=>{let x=1; return (this.props.programmingLessons.map(({topic,lessonId}) => {

            return <Link onClick={this.props.getLesson.bind(this,lessonId,x)} key={x} to={`${topic}/${lessonId}`}><li  id={lessonId}>Урок {x++} </li></Link>


        }))}
        return (
            <section className={"verbs"}>
                <ul className={"english-list"}>
                    { grammarLessons()
                    }

                </ul>
                    huh?
            </section>

        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {
        getLesson: (lessonId,x) => {
            dispatch({type: "GET_ACTIVE_LESSON",payload: {lessonIdCheck:lessonId,x:x} })
        },
        programmingLessonsData: bindActionCreators(programmingLessonsFetch, dispatch)

    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        programmingLessons: state.programmingLessons,
    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(ProgrammingLessons));