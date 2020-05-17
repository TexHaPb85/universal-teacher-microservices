import React from 'react';
import Header from "./components/Mainpage/Header";
import Footer from "./components/Mainpage/Footer";
import Mainpage from "./components/Mainpage/MainPage"
import Courses from "./components/Courses/Courses"
import MyCourses from "./components/Courses/MyCourses"
import AllThemes from "./components/Courses/AllThemes"
import AllCourses from "./components/Courses/AllCourses"
import EnglishCourses from "./components/Courses/EnglishCourses"
import Homepage from "./components/Homepage/HomePage"
import './App.css';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import CoursesNavigation from "./components/Courses/CoursesNavigation";


class App extends React.Component {

    render() {


        return (

            <Router>
                <div></div>
                <Header/>
                <Switch>
                    <Route path={"/"} exact component={Mainpage}/>
                    <Route  path={"/courses"} exact component={Courses}/>
                    <Route  path={"/courses"} component={CoursesNavigation}/>

                    <Route path={"/english"} component={EnglishCourses}/>
                    <Route path={"/home"} component={Homepage}/>
                </Switch>
                <Switch>
                    <Route path={"/courses/all-courses"} exact component={AllCourses}/>
                    <Route path={"/courses/my-courses"}   component={MyCourses}/>

                </Switch>

                <Footer/>
            </Router>

        );


    }
}

export default App;
