import React from 'react';
import Header from "./components/Mainpage/Header";
import Footer from "./components/Mainpage/Footer";
import Mainpage from "./components/Mainpage/MainPage"
import Courses from "./components/Courses/Courses"
import MyCourses from "./components/Courses/MyCourses"
import AllThemes from "./components/Courses/AllThemes"
import AllCourses from "./components/Courses/AllCourses"
import EnglishCourses from "./components/Courses/EnglishCourses"
import IrregularVerbs from "./components/Courses/IrregularVerbs"
import PhrasalVerbs from "./components/Courses/PhrasalVerbs"
import VerbsTrain from "./components/Courses/VerbsTrain"
import NounVerbs from "./components/Courses/NounVerbs"
import Homepage from "./components/Homepage/HomePage"
import ScrollToTop from "./components/Features/ScrollToTop";
import GrammarLessons from "./components/Courses/GrammarLessons";
import GrammarLesson from "./components/Courses/GrammarLesson";
import './App.css';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import CoursesNavigation from "./components/Courses/CoursesNavigation";


class App extends React.Component {

    render() {


        return (

            <Router>
                <ScrollToTop>
                <Header/>
                <Switch>
                    <Route path={"/"} exact component={Mainpage}/>
                    <Route  path={"/courses"} exact component={Courses}/>
                    <Route  path={"/courses"} component={CoursesNavigation}/>

                    <Route path={"/english"} exact component={EnglishCourses}/>
                        <Route path={"/english/irregular-verbs"} exact component={IrregularVerbs}/>
                        <Route path={"/english/irregular-verbs/train"}  component={VerbsTrain}/>
                        <Route path={"/english/phrasal-verbs"} exact component={PhrasalVerbs}/>
                        <Route path={"/english/phrasal-verbs/train"}  component={VerbsTrain}/>
                        <Route path={"/english/noun-verbs"} exact component={NounVerbs}/>
                        <Route path={"/english/noun-verbs/train"}  component={VerbsTrain}/>
                        <Route path={'/english/grammar/:lesson'}   exact component={GrammarLessons}/>
                        <Route path={'/english/grammar/:lesson/:lessonId'} exact component={GrammarLesson}/>


                    <Route path={"/home"} component={Homepage}/>
                </Switch>
                <Switch>
                    <Route path={"/courses/all-courses"} exact component={AllCourses}/>
                    <Route path={"/courses/my-courses"}   component={MyCourses}/>

                </Switch>

                <Footer/>
                </ScrollToTop>
            </Router>

        );


    }
}

export default App;
