import React, { Component } from 'react';
import header from '../assets/header.jpg';

export class Login extends Component {
   
    constructor(props) {
        super(props);
        this.state = {
            username : '',
            password: '',
            value: ''
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
      }
    
      handleChange(event) 
      {
        this.setState({
            [event.target.name]:event.target.value
        })
      }

      handleSubmit(event) {
        // alert('A name was submitted: ' + this.state.value);
        this.props.UserLogin(this.state.username, this.state.password);
      }

    render() {
        return (
            <div class="login">
                <div class="header">
                    <img src={header} alt="Logo" />
                </div>

                <div className='form-wrapper'>
                    <h2>LOGIN</h2>
                    <form onSubmit={this.handleSubmit}>
                        <label>
                            Username:
                        <input value={this.state.username} onChange={this.handleChange} type="text" placeholder="Username" name="username"/>
                        </label><br />

                        <label>
                            Password:
                        <input type="password" value={this.state.password} onChange={this.handleChange} name="password"/>
                        </label><br /><br />

                        <input type="submit" value="Login" />
                    </form>
                </div>
            </div>
        )
    }
}

export default Login

// export function UserLogin(username, password) {
//     return async dispatch => {
//       dispatch(UserLoginPending());
//       try {
//         // let response = await fetch('http://127.0.0.1:5000/login', {
//         let response = await fetch(backendEndpoint + '/login', {
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
//           dispatch(UserLoginFailure(responseJson.error));
//         } else {
//           dispatch(UserLoginSuccess(responseJson.metadata));
//           nav.push('Overview');
//         }
//       } catch (error) {
//         Alert.alert(error)
//       }
//     };
//   }