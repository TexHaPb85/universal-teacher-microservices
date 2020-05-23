import React, {Component} from 'react';
import {Link, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {topic} from "../../actions/personActions";
import {bindActionCreators} from "redux";
import Lessons from "./Lessons";

export const  grammarTopic =()=>{

    let str = window.location.pathname;
    let n = str.lastIndexOf('/');

    return str.substring(n + 1);
}

class GrammarLesson extends Component {
    componentWillMount() {

        this.props.grammarLessonsData(topic())
    //
    // this.props.presentSimpleData(presentSimple())
    //
    // this.props.grammarLesson.map(({youTubeUrl})=>{console.log(youTubeUrl)})

        // console.log(this.props.lesson)
    }
    render() {
        const grammarLessons =()=>{ return (this.props.grammarLessons.map(({topic,lessonId}) => {
            // console.log(topic)
            return <Link to={"english/grammar/"+lessonId}><li  id={lessonId}>{topic}</li></Link>

        }))}
        return (
            <section className={"verbs"}>
                <ul className={"english-list"}>
                { grammarLessons()}
                </ul>

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
        grammarLessons: state.grammarLessons


    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(GrammarLesson));