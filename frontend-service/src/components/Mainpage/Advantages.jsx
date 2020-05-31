import React, { Component } from 'react';
import Img1 from "../../imgs/advantages/advantages1.png";
import Img2 from "../../imgs/advantages/advantages2.png";
import Img3 from "../../imgs/advantages/advantages3.png";
import "react-perfect-scrollbar/dist/css/styles.css";
import  "../../css/advantages.css";
class Advantages extends  Component{
    render() {

        return(
            <section className="advantages">
                <h1>Почему мы?</h1>
                <div className={"advantages-container"}>
                    <div className={"advantages-card card1"}>
                        <img src={Img1} alt="1"/>
                        <p>Возможность проверить и закрепить знания с помощью различных тестов</p>
                        <div className={"triangle1"}></div>
                    </div>
                    <div className={"advantages-card"}>
                        <img src={Img2} alt="2"/>
                        <p>Возможность проверить и закрепить знания с помощью различных тестов</p>
                        <div className={"triangle2"}></div>
                    </div>
                    <div className={"advantages-card"}>
                        <img src={Img3} alt="3"/>
                        <p>Присутствие широкой колекции видеоматериалов,
                            которые помогают в изучении и усвоении новых знаний</p>
                        <div className={"triangle1"}></div>
                    </div>
                </div>
            </section>

        )
    }

}

export default Advantages;