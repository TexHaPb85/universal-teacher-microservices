import React, {Component} from 'react';
import {Link, NavLink, Route, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import Image2 from "../../imgs/content-carousel/javaImg.jpg";
import Flickity from "react-flickity-component";
import Image1 from "../../imgs/content-carousel/englishImg.jpg";
import CoursesNavigation from "./CoursesNavigation";


class Courses extends Component {
    // constructor (props){
    //     super(props);
    //     this.state ={
    //         bool : false
    //     }
    //
    //     this.XD = this.XD.bind(this);
    //
    // }
    XD (){
        if(window.location.pathname === "/courses/my-courses"){
          return "replace={true}"
        }
        else {
            return "replace={false}"
            }
        }



    ROFL (){
        this.props.history.push("/courses/my-courses");
        console.log(window.location.pathname)
    }


    // componentWillUpdate(nextProps, nextState, nextContext) {
    //     console.log(this.props.location.pathname)
    // }

    render() {
        // console.log(this.props,"xDXD");
        return (
            <React.Fragment>
            <Route>

                <section className={"courses"}>
                    <h1>Курсы</h1>
                    <CoursesNavigation/>
                    <div className="courses-flex">

                    <div className="carousel-cell themes" ><img src={Image1}/>
                        <Link className={"link-cell"} to={"/english"}>
                            <h2> Английский</h2>
                            <p>В этом курсе вам раскажут как прожить и многое другое</p>
                        </Link>

                    </div>
                    <div className="carousel-cell themes"><img src={Image2}/>
                        <Link className={"link-cell"} to={"/programming"}>
                            <h2> Программирование</h2>
                            <p>В этом курсе вам раскажут как прожить и многое другое</p>
                        </Link>
                    </div> <div className="carousel-cell themes"><img src={Image2}/>
                        <Link className={"link-cell"} to={"/"}>
                            <h2> Программирование</h2>
                            <p>В этом курсе вам раскажут как прожить и многое другое</p>
                        </Link>
                    </div> <div className="carousel-cell themes"><img src={Image2}/>
                        <Link className={"link-cell"} to={"/"}>
                            <h2> Программирование</h2>
                            <p>В этом курсе вам раскажут как прожить и многое другое</p>
                        </Link>
                    </div>
                    </div>
                </section>



            </Route>
            </React.Fragment>

        )
    }

}

const mapDispatchToProps = (dispatch) => {
    return{}


};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged


    }
};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Courses));