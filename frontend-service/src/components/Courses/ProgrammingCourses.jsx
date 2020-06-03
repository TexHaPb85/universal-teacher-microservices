import React, {Component} from 'react';
import { Link, NavLink, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {grammarFetch, programmingFetch,} from "../../actions/personActions";


class ProgammingCourses extends Component {

    componentWillMount() {

        this.props.testData(programmingFetch())
    }

    render() {

        const grammarLessons =()=>{ return (this.props.programming.map(lesson => {
            return <React.Fragment>
                {console.log(lesson)}
                <Link onClick={this.props.getTopic.bind(this,lesson)}  to={"programming/topic/"+lesson}>
                    <li key={lesson}>{lesson}</li></Link>
            </React.Fragment>

        }))}

        return (
            <section className={"english-courses verbs"}>

                <h1>Граматика</h1>
                <div className={"english-tests"}>
                    <ul className={"english-list"}>
                        {grammarLessons()}

                    </ul>
                    <h1>chego</h1>
                </div>

            </section>
        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {
        getTopic: (topicData) => {
            dispatch({type: "GET_ACTIVE_TOPIC",payload: topicData })
        },
        testData: bindActionCreators(programmingFetch, dispatch),
    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        programming: state.programming,
        activeGrammarTopic: state.activeGrammarTopic
    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(ProgammingCourses));