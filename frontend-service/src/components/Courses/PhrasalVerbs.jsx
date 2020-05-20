import React, {Component} from 'react';
import {BrowserRouter as Router, Link, NavLink, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {phrasalVerbs} from "../../actions/personActions";
import {bindActionCreators} from "redux";



class PhrasalVerbs extends Component {
    componentWillMount() {

        this.props.testData(phrasalVerbs());


        // console.log(this.props.lesson)
    }
    render() {

        return (
            <section className={"verbs"}>
            <table>
                <tr>
                    <th>Phrasal verb</th>
                    <th>Verb</th>
                    <th>Translation</th>
                </tr>
                {this.props.phrVerbs.map(({phrasalVerb,verb,translation,id}) =>{
                    return <tr key={id}>
                        <td>{phrasalVerb}</td>
                        <td>{verb}</td>

                        <td>{translation}</td>
                    </tr>
                })}
            </table>
            </section>
        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {
        testData: bindActionCreators(phrasalVerbs, dispatch),

    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        phrVerbs: state.phrVerbs


    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(PhrasalVerbs));