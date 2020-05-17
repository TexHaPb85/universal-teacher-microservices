import React, {Component} from 'react';
import {BrowserRouter as Router, Link, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";

class AllThemes extends Component {

    render() {

        return (
          <section className={"all-courses"}>
        <h1></h1>
          </section>
        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {}

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged


    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(AllThemes));