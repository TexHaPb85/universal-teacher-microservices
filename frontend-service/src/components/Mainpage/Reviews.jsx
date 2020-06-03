import React, { Component } from 'react';
import content from "../../css/content.css"
import Anastas from "../../imgs/rewievs/AnastasiaBasyuk.jpg";
import Andrew from "../../imgs/rewievs/AndryiGerasimenko.jpg";
import Artemiy from "../../imgs/rewievs/ArtemiyKirienko.jpg";
import { Scrollbars } from "react-custom-scrollbars";
const shadowTopStyle = {
    position: 'absolute',
    top: 0,
    left: 0,
    right: 0,
    height: 10,
    background: 'linear-gradient(to bottom, rgba(0, 4, , 0.2) 0%, rgba(0, 0, 0, 0) 100%)'

};
class Reviews extends  Component{
    render() {
        return(

            <section className="container-content">
                <h1>Ваши отзывы</h1>
                <div className={"review-container"}>
                    <div className={"review-card"}>
                        <img src={Anastas} alt="123"/>
                    <Scrollbars>
                        <p>Я начинаю свой путь в новую для себя сферу вместе с Universal Teachers. Для меня это новый
                            неизведанный мир. Возлагаю очень большие надежды, мне очень нужна новая профессия.
                            Интересная подача материала, все подробно объяснятся, уже начинаю что-то понимать.
                            Благодарю!</p>
                    </Scrollbars>

                    </div>
                    <div className={"review-card"}>
                        <img src={Andrew} alt="123"/>
                        <Scrollbars thumbMinSize={30}>

                        <p>Топ сервис, топ поддержка. Большое коммьюнити так же хорошо способствует обучению.
                            Создал аккаунт первоначально на англ. версии сайта, уже прошел часть курса как узнал, что
                            оказывается это перевод с русского все и на русской версии есть стажировка. Подписка была
                            куплена на год и поддержке понадобиось менее получаса для трансфера подписки, хоть сначала
                            был не уверен будут ли они такое делать вообще.
                            Сам курс хорошо охватывает и описывает материал. Книги и ютуб в дополнение.
                            Разновидные задания - от простых до тех, над которымы немало времени придется поломать голову.
                            Как только закончу курс и пройду стажировку будет апдейт.</p>
                        </Scrollbars>
                    </div>
                    <div className={"review-card"}>
                        <img src={Artemiy} alt="123"/>
                        <Scrollbars>
                        <p className={"mda"}>Всем Рекомендую! Я готовлюсь к сдаче ЗНО по английскому языку и, учитывая знания которые дают
                            нам в школе, теперь я уверен что сдам экзамен на отлично! Подход к обучению прекрасный, на
                            уроках никогда не бывает скучно! Материал легко усваивается. Спасибо большое!!! dfdf fd dfdf d df d df dfd df df </p>
                        </Scrollbars>
                    </div>
                </div>
            </section>

        )
    }

}


export default Reviews;