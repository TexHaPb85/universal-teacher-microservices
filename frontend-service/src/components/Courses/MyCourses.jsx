import React, {Component} from 'react';
import "../../css/courses.css"
import {connect} from "react-redux";
import {irregularVerbs} from "../../actions/personActions"
import {NavLink, withRouter} from "react-router-dom";
import {loginData} from "../../actions/personActions";
import {bindActionCreators} from "redux";
import CoursesNavigation from "./CoursesNavigation";

class MyCourses extends Component {

    componentWillMount() {

        if(Object.keys(this.props.lesson).length===0){
        this.props.testData(irregularVerbs());}

    }
    render() {

        return (
            <section className={"all-courses"}>
                <h1>MYCOURSES</h1>
                <table>
                    <tr>
                        <th>Infinitive</th>
                        <th>Past simple</th>
                        <th>Past participle</th>
                        <th>Translation</th>
                    </tr>
                    <td>{this.props.irVerbs.map(({infinitive}) =>
                        <tr>{infinitive}</tr>)}</td>

                    <td>{this.props.irVerbs.map(({pastSimple}) =>
                        <tr>{pastSimple}</tr>)}</td>

                    <td>{this.props.irVerbs.map(({pastParticiple}) =>
                        <tr>{pastParticiple}</tr>)}</td>

                    <td>{this.props.irVerbs.map(({translation}) =>
                        <tr>{translation}</tr>)}</td>
                </table>
            </section>
        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {
        testData: bindActionCreators(irregularVerbs, dispatch),
    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        lesson : state.lesson

    }
};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(MyCourses));