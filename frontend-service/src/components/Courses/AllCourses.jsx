import React, {Component} from 'react';
import "../../css/courses.css"
import {connect} from "react-redux";
import {irregularVerbs} from "../../actions/personActions"
import {NavLink, withRouter} from "react-router-dom";
import {loginData} from "../../actions/personActions";
import {bindActionCreators} from "redux";
import CoursesNavigation from "./CoursesNavigation";

class AllCourses extends Component {

    componentWillMount() {

        this.props.testData(irregularVerbs());
    }
    render() {

        return (
            <section className={"all-courses"}>
                <h1>ALL-COURSES</h1>
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

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(AllCourses));