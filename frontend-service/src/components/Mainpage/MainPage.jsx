import React, {Component} from 'react';
import Home from "./Home";
import Reviews from "./Reviews";
import Content from "./Content";
import Advantages from "./Advantages";


class MainPage extends Component {


    render() {
        return (
            <div>
                <Home/>
                <Content/>
                <Advantages/>
                <Reviews/>
            </div>


        )
    }

}


export default MainPage;