import React, {Component} from 'react';
import "../../css/courses.css"
import {connect} from "react-redux";
import {irregularVerbs} from "../../actions/personActions"
import {NavLink, withRouter} from "react-router-dom";

import {bindActionCreators} from "redux";
import CoursesNavigation from "./CoursesNavigation";

class MyCourses extends Component {

    componentWillMount() {


        this.props.testData(irregularVerbs());

    }
    render() {

        return (
            <section className={"all-courses"}>
                <h1>MYCOURSES</h1>
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
        irVerbs : state.irVerbs

    }
};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(MyCourses));