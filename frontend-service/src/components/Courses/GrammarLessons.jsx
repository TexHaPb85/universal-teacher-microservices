import React, {Component} from 'react';
import {BrowserRouter as Router, Link, NavLink, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {grammarFetch, irregularVerbs} from "../../actions/personActions";

class EnglishCourses extends Component {
//     componentDidMount() {
//     this.props.testData(grammarFetch())
// }
    componentWillMount() {

        this.props.testData(grammarFetch())
    }


    render() {
        const grammarLessons =()=>{ return (this.props.grammar.map(lesson => {
            return <Link to={"english/grammar/"+lesson}><li key={lesson}>{lesson}</li></Link>

        }))}


        return (
            <section className={"english-courses verbs"}>

                <h1>Уроки</h1>
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
        testData: bindActionCreators(grammarFetch, dispatch),
    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        grammarLessons: state.grammarLessons
    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(EnglishCourses));