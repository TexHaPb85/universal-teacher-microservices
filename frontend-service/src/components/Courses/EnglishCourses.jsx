import React, {Component} from 'react';
import { Link, NavLink, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {grammarFetch, } from "../../actions/personActions";


class EnglishCourses extends Component {

    componentWillMount() {

            this.props.testData(grammarFetch())
    }

    render() {

    const grammarLessons =()=>{ return (this.props.grammar.map(lesson => {
        return <React.Fragment>
     <Link onClick={this.props.getTopic.bind(this,lesson)}  to={"english/grammar/"+lesson}>
            <li key={lesson}>{lesson}</li></Link>
        </React.Fragment>

    }))}

        return (
            <section className={"english-courses verbs"}>
                <h1>Словарний запас</h1>
                <div className={"english-tests"}>
                <ul className={"english-list"}>
                    <Link  to={"/english/irregular-verbs"}><li>Неправильні дієслова </li></Link>
                   <Link  to={"/english/phrasal-verbs"}> <li>Фразові дієслова</li></Link>
                   <Link  to={"/english/noun-verbs"}> <li>Іменні дієслова</li></Link>

                </ul>
                <ul className={"english-test-list"}>
                    <Link  to={"/english/irregular-verbs/train"}><li>Тест по неправильним дієсловам</li> </Link>
                   <Link  to={"/english/phrasal-verbs/train"}> <li>Тест по фразовим дієсловам</li></Link>
                   <Link  to={"/english/noun-verbs/train"}> <li>Тест по іменним дієслова</li></Link>
                </ul>
                </div>
                <h1>Граматика</h1>
                <div className={"english-tests"}>
                <ul className={"english-list"}>
                    {grammarLessons()}

                </ul>
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
        testData: bindActionCreators(grammarFetch, dispatch),
    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        grammar: state.grammar,
        activeGrammarTopic: state.activeGrammarTopic
    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(EnglishCourses));