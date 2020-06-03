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
        const checkRouteId = parseInt(window.location.pathname.
        substring(window.location.pathname.lastIndexOf('/') + 1)) ===lessonIdCheck


        const grammarLessons =()=>{ let checkRoute=false;
            (this.props.grammarLessons.map(({topic,lessonId,youTubeUrl,textDescription}) => {
                if (checkRouteId && lessonId===lessonIdCheck){
                    checkRoute=true;  }}))
            if(checkRoute) return (this.props.grammarLessons.map(({topic,lessonId,youTubeUrl,textDescription}) => {
                if (lessonId === lessonIdCheck && checkRouteId)
                    return <React.Fragment>

                        {console.log(checkRoute+"CHEGO")}
                        <div>Описаник Урока: {textDescription}</div>
                        <iframe width="729" height="410" src={youTubeUrl} frameBorder="0"
                                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                                allowFullScreen></iframe>

                    </React.Fragment>}))
            if(!checkRoute) return(
                <React.Fragment>
                    <div>Ты куда зашёл, петух</div></React.Fragment>)
        }
        return (
            <section className={"verbs"}>
                <h1>Урок {x} </h1>
                <ul className={"english-list"}>
                {grammarLessons()}
                </ul>

                <Link className={"task-button"} to={window.location.pathname+"/tests"}>Пройти тесты</Link>

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