import React, { Component } from 'react';
import header from '../assets/header.jpg';
import axios from 'axios';
import { Redirect } from 'react-router-dom';

export class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            value: '',
            customerid: ''
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    handleSubmit(event) {
        // alert('A name was submitted: ' + this.state.value);
        // this.props.UserLogin(this.state.username, this.state.password);
        event.preventDefault();
        var data = {};
        data.username = this.state.username;
        data.password = this.state.password;
        axios.post('http://127.0.0.1:8080/login', data)
            .then((response) => {
                console.log(response);
                if (response.status > 300) {
                    alert('fail')
                } else {
                    // alert('success')
                    console.log('success')
                    // console.log(response)
                    // this.setState({customerid: response.data.customerid})
                    window.sessionStorage.setItem("customerid", response.data.customerId);
                    // console.log(response.data);
                    // console.log(response.data.customerId);
                    this.props.history.push('/Overview/');
                }
            }, (error) => {
                console.log(error);
            });
    }

    render() {


        return (
            <div className="login">
                <div className="header">
                    <img src={header} alt="Logo" />
                </div>

                <div className='form-wrapper'>
                    <h2>LOGIN</h2>
                    <form>
                        <label>
                            Username:
                        <input value={this.state.username} onChange={this.handleChange} type="text" placeholder="Username" name="username" />
                        </label><br />

                        <label>
                            Password:
                        <input type="password" value={this.state.password} onChange={this.handleChange} name="password" />
                        </label><br /><br />

                        <button onClick={this.handleSubmit}>submit</button>
                    </form>
                </div>
            </div>
        )
    }
}

export default Login

// export function UserLogin(username, password) {
//     return async dispatch => {
//       try {
//           alert('enter function')
//         // let response = await fetch('http://127.0.0.1:8080/login', {
//         let response = await fetch('http://127.0.0.1:8080/login', {
//           method: 'POST',
//           headers: {
//             Accept: 'application/json',
//             'Content-Type': 'application/json',
//           },
//           body: JSON.stringify({
//             "username": username,
//             "password": password,
//           }),
//         })
//         let responseJson = await response.json();
//         if (response.status > 300) {
//           alert('fail')
//         } else {
//             alert('success')
//         }
//       } catch (error) {
//         alert('error')
//       }
//     };
//   }