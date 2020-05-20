import React, {Component} from 'react';
import {BrowserRouter as Router, Link, NavLink, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {nounVerbs} from "../../actions/personActions";
import {bindActionCreators} from "redux";



class NounVerbs extends Component {
    componentWillMount() {

        this.props.testData(nounVerbs());


        // console.log(this.props.lesson)
    }
    render() {

        return (
            <section className={"verbs"}>
            <table>
                <tr>
                    <th>Noun verb</th>
                    <th>Noun translation</th>
                </tr>
                {this.props.nounVerbs.map(({nounVerb,nounTranslation,id}) =>{
                    return <tr key={id}>
                        <td>{nounVerb}</td>
                        <td>{nounTranslation}</td>

                    </tr>
                })}

            </table>
            </section>
        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {
        testData: bindActionCreators(nounVerbs, dispatch),

    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        nounVerbs: state.nounVerbs


    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(NounVerbs));