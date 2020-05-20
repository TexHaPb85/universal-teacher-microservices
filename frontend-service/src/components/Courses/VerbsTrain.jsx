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



        // console.log(this.props.lesson)
    }
    render() {
        const project = () => {

            switch(window.location.pathname) {

                case "/english/irregular-verbs/train": return <div>{this.props.randTrain.infinitive}<input type={"text"}/></div>;
                case "/english/phrasal-verbs/train": return <div>{this.props.randTrain.map(({verb}) =>
                    <div>{verb}{console.log(verb+"WTF?")}<input type={"text"}/></div>)}</div>;
                case "/english/noun-verbs/train": return <div>{this.props.randTrain.nounVerb}<input type={"text"}/></div>;

                default:      return <h1>No verbs</h1>
            }
        }
        return (

            <div>

                {project()}
                {/*<td>{this.props.randTrain.map(({infinitive}) =>*/}
                {/*    <tr>{infinitive}</tr>)}</td>*/}

                {/*<td>{this.props.randTrain.map(({pastSimple}) =>*/}
                {/*    <tr>{pastSimple}</tr>)}</td>*/}

                {/*<td>{this.props.randTrain.map(({pastParticiple}) =>*/}
                {/*    <tr>{pastParticiple}</tr>)}</td>*/}

                {/*<td>{this.props.randTrain.map(({translation}) =>*/}
                {/*    <tr>{translation}</tr>)}</td>*/}
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