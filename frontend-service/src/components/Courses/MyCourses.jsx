import React, {Component} from 'react';
import "../../css/courses.css"
import {connect} from "react-redux";
import {testContent} from "../../actions/personActions"
import {NavLink, withRouter} from "react-router-dom";
import {loginData} from "../../actions/personActions";
import {bindActionCreators} from "redux";

class MyCourses extends Component {

    componentWillMount() {

        this.props.testData(testContent());
    }
    render() {

        return (
            <section className={"all-courses"}>
                <h1>Курсы</h1>
                    <ul className={"courses-menu"}>
                        <li><NavLink to={"/courses"}>Все курсы</NavLink></li>
                        <li><NavLink replace={window.location.pathname === "/courses/my-courses"}  to={"/courses/my-courses"}>Мои курсы</NavLink></li>


                    </ul>
                <h1>LULULLULUL</h1>
            </section>
        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {
        testData: bindActionCreators(testContent, dispatch),
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