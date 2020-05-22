import React, {Component} from 'react';
import {BrowserRouter as Router, Link, NavLink, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";

class EnglishCourses extends Component {

    render() {

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
                    <Link  to={"/english/grammar/"}><li>Граматика</li></Link>
                   <Link  to={"/english/phrasal-verbs"}> <li>Фразові дієслова</li></Link>
                   <Link  to={"/english/noun-verbs"}> <li>Іменні дієслова</li></Link>

                </ul>
                <ul className={"english-test-list"}>
                    <Link  to={"/english/irregular-verbs/train"}><li>Тест по неправильним дієсловам</li> </Link>
                   <Link  to={"/english/phrasal-verbs/train"}> <li>Тест по фразовим дієсловам</li></Link>
                   <Link  to={"/english/noun-verbs/train"}> <li>Тест по іменним дієслова</li></Link>
                </ul>
                </div>
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

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(EnglishCourses));