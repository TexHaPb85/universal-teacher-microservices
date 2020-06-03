import React, {Component} from 'react';
import { NavLink} from "react-router-dom";
import "../../css/courses.css"




const CoursesNavigation =  () =>

    <React.Fragment>
        <h1 className={"courses-header"}>Страница курсов</h1>
    <ul className={"courses-menu"}>
        <li><NavLink replace={window.location.pathname === "/courses"} to={"/courses"}>Все темы </NavLink></li>
        <li><NavLink replace={window.location.pathname === "/courses/my-courses"} to={"/courses/my-courses"}>Мои
            курсы</NavLink></li>


    </ul>

    </React.Fragment>



export default CoursesNavigation;