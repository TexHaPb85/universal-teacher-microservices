import React, {Component} from 'react';
import {Link, NavLink, Route, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";



const CoursesNavigation =  () =>

    <React.Fragment>
    <ul className={"courses-menu"}>
        <li><NavLink replace={window.location.pathname === "/courses"} to={"/courses"}>Все темы </NavLink></li>
        <li><NavLink replace={window.location.pathname === "/courses/all-courses"} to={"/courses/all-courses"}>Все
            курсы</NavLink></li>
        <li><NavLink replace={window.location.pathname === "/courses/my-courses"} to={"/courses/my-courses"}>Мои
            курсы</NavLink></li>


    </ul>

    </React.Fragment>



export default CoursesNavigation;