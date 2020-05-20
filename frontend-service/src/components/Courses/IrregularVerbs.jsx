import React, {Component} from 'react';
import {BrowserRouter as Router, Link, NavLink, Route, Switch, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {irregularVerbs} from "../../actions/personActions";
import {bindActionCreators} from "redux";



class IrregularVerbs extends Component {
    componentWillMount() {

            this.props.testData(irregularVerbs());


        // console.log(this.props.lesson)
    }
    render() {

        return (
            <section className={"verbs"}>
            <table>
                <tr>
                    <th>Infinitive</th>
                    <th>Past simple</th>
                    <th>Past participle</th>
                    <th>Translation</th>
                </tr>
                {this.props.irVerbs.map(({infinitive,pastSimple,pastParticiple,translation,id}) =>{
                    return <tr key={id}>
                        <td>{infinitive}</td>
                        <td>{pastSimple}</td>
                        <td>{pastParticiple}</td>
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
        testData: bindActionCreators(irregularVerbs, dispatch),

    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        irVerbs: state.irVerbs


    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(IrregularVerbs));