import React, {Component} from 'react';
import {Link, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";
import {topic} from "../../actions/personActions";
import {bindActionCreators} from "redux";

export const  grammarTopic =()=>{

    let str = window.location.pathname;
    let n = str.lastIndexOf('/');

    return str.substring(n + 1);
}

class Lessons extends Component {
    componentWillMount() {

        this.props.grammarLessonsData(topic())

    }
    render() {
        const grammarLessons =()=>{ return (this.props.grammarLessons.map(({topic,id}) => {
            // console.log(topic)
            return <Link to={"english/grammar/"+id}><li  key={id}>{topic}</li></Link>

        }))}
        return (

                grammarLessons()


        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {
        grammarLessonsData: bindActionCreators(topic, dispatch),

    }

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged,
        grammarLessons: state.grammarLessons


    }
};

export default withRouter( connect(mapStateToProps, mapDispatchToProps)(Lessons));