import React, {Component} from 'react';
import {Link, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {topic} from "../../actions/personActions";
import {bindActionCreators} from "redux";

class GrammarLesson extends Component {
    componentWillMount() {}
    render() {
        const {lessonIdCheck,x} = this.props.getActiveLesson
        const grammarLessons =()=>{ return (this.props.grammarLessons.map(({topic,lessonId,youTubeUrl,textDescription}) => {
            if (lessonId ===lessonIdCheck){
            return <React.Fragment>
                <div>Описаник Урока: {textDescription}</div>
                <iframe width="729" height="410" src={"https://www.youtube.com/embed/47LEelX7nhg"} frameBorder="0"
                        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                        allowFullScreen></iframe>

            </React.Fragment>}

        }))}
        return (
            <section className={"verbs"}>
                <h1>Урок {x} </h1>
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
        grammarLessons: state.grammarLessons,
        getActiveLesson: state.activeLesson


    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(GrammarLesson));