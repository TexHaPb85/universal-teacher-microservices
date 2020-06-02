import React, {Component} from 'react';
import {BrowserRouter as Router, Link, NavLink, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {irregularTrain, nounTrain, phrasalTrain} from "../../actions/personActions";
import {bindActionCreators} from "redux";



class VerbsTrain extends Component {
    componentDidUpdate(){
        window.onpopstate = e => {
            this.props.clean()
        }
        this.props.history.listen((location, action) => {
            this.props.clean()
        });
    }
    componentWillMount() {

        let train=0;
        switch (window.location.pathname) {
            case "/english/irregular-verbs/train":
                this.props.irrTrain(irregularTrain());

                break;
            case "/english/phrasal-verbs/train":
                this.props.phrTrain(phrasalTrain());
                break;
            case "/english/noun-verbs/train":
                this.props.nounTrain(nounTrain());
                break;
        }
    }
    handlePhrVerbsInput = () =>{
        let inputCounter =0
    console.log(this.props.randTrain)

        for (let i in this.props.randTrain.length) {
            this.props.randTrain.map(({phrasalVerb}) => {
                console.log(phrasalVerb.split(" ").pop() === document.getElementsByClassName(
                    "train-input")[inputCounter++].value)
                    if (phrasalVerb.split(" ").pop() === document.getElementsByClassName(
                        "train-input")[inputCounter++].value) {
                        console.log("OMG")
                    }
                }
            )
        }

}
    handleIrrVerbsInput = () => {
        if(this.props.randTrain.pastSimple === document.getElementById("verb-input1").value) {
            document.getElementById("verb-input1").classList.add('input-true');
            document.getElementById("verb-input1").classList.remove('input-false');
        }
        else{ document.getElementById("verb-input1").classList.add('input-false');
            document.getElementById("verb-input1").classList.remove('input-true');}

        if(this.props.randTrain.pastParticiple === document.getElementById("verb-input2").value) {
            document.getElementById("verb-input2").classList.add('input-true');
            document.getElementById("verb-input2").classList.remove('input-false');
        }
        else{ document.getElementById("verb-input2").classList.add('input-false');
            document.getElementById("verb-input2").classList.remove('input-true');}

    }
    handleUpdate = () =>{
        const inputs = document.querySelectorAll('.train-input');
        for (let i = 0;  i < inputs.length; i++) {
            inputs[i].value = '';
        }

        switch (window.location.pathname) {
            case "/english/irregular-verbs/train":
                this.props.irrTrain(irregularTrain());
                break;
            case "/english/phrasal-verbs/train":
                this.props.phrTrain(phrasalTrain());
                break;
            case "/english/noun-verbs/train":
                this.props.nounTrain(nounTrain());
                break;
        }
    }
    render() {
        const project = () => {
            switch(window.location.pathname) {
                case "/english/irregular-verbs/train":
                    return <React.Fragment>
                        <div className={"train-container"}>
                            <h2>Тренування неправильних дієслів</h2>
                            <h3>Ви отримуєте для тренування одне слово навмання</h3>
                            <h3>Ваша задача ввести дві форми цього слова</h3>
                            <div>{this.props.randTrain.infinitive}<input className={"train-input"} id={"verb-input1"}
                                                                         onChange={this.handleChange} type={"text"}/>
                                <input className={"train-input"}  id={"verb-input2"} onChange={this.handleChange} type={"text"}/>
                                <button className={"train-button"} onClick={this.handleIrrVerbsInput}>Перевірити</button>
                                <button className={"train-button"} onClick={this.handleUpdate}>Оновити</button>
                            </div>
                        </div>
                    </React.Fragment>;
                case "/english/phrasal-verbs/train":
                    return <React.Fragment>
                        <div className={"train-container"}>
                            <h2>Тренування фразових дієслів</h2>
                            <h3>Ви отримуєте для тренування одне фразове слово</h3>
                            <h3>Ваша задача ввести  </h3>
                            <div>{this.props.randTrain.map(({verb,translation}) => <div>{verb}{console.log(verb+"WTF?")}
                            <input className={"train-input"} onChange={this.handleChange} type={"text"}/>{translation}</div>)}</div>
                            <button className={"train-button"} onClick={this.handlePhrVerbsInput}>Перевірити</button>
                            <button className={"train-button"} onClick={this.handleUpdate}>Оновити</button>
                        </div>
                    </React.Fragment>;
                case "/english/noun-verbs/train":
                    return <React.Fragment>
                        <div className={"train-container"}>
                            <h2>Тренування іменних дієслів</h2>
                            <h3>Ви отримуєте для тренування одне слово навмання</h3>
                            <h3>Ваша задача ввести два переклади цього слова. Спочатку переклад в формі іменника,
                                а потім у формі дієслова</h3>
                            <div>{this.props.randTrain.nounVerb}<input className={"train-input"} type={"text"}/>
                                <input className={"train-input"} onChange={this.handleChange} type={"text"}/>
                                <button className={"train-button"}>Перевірити</button>
                                <button className={"train-button"} onClick={this.handleUpdate}>Оновити</button>
                            </div>
                        </div>
                    </React.Fragment>;

                default:      return <h1>No verbs</h1>
            }
        }
        return (

            <div>

                {project()}
            </div>
        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {
        irrTrain: bindActionCreators(irregularTrain, dispatch),
        phrTrain: bindActionCreators(phrasalTrain, dispatch),
        nounTrain: bindActionCreators(nounTrain, dispatch),
        clean: () => dispatch({type: "RESET_TRAIN"}),

    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        randTrain: state.randTrain



    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(VerbsTrain));