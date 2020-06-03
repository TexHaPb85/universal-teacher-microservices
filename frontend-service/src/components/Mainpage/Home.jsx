import React, { Component } from 'react';
import home from "../../css/home.css"
import {Link} from "react-router-dom";
class Home extends  Component{
    render() {

        return(
            <section className="container-home">
                <div className="img">
                    <div className="overlay">
                        <div id="triangle-left"></div>
                        <div id="pentagon"></div>
                        <div className="home-text">
                            <h2>Получите востребованные<br/>знания бесплатно</h2>
                            <p>Онлайн-курсы от ведущих вузов и компаний страны</p>
                            <Link to={"/courses"}><button  className="home-button1">Посмотреть <br/>каталог</button></Link>
                        </div>
                    </div>


                </div>


            </section>

        )
    }

}



export default Home;