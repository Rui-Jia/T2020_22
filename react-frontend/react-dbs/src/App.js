import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import './App.css';
import Dashboard from './components/pages/Dashboard'
import Header from './components/layout/Header'
import Login from './components/pages/Login';


function App() {
  return (
    <Router>
    <div className="App">
      <div className="container">
        {<Header />}
        <Route exact path="/" render={props => (
          <React.Fragment>
          </React.Fragment>)} />
        <Route path="/Dashboard" component={Dashboard} />
        <Route path="/Login" component={Login} />

      </div>
    </div>
  </Router>
  );
}

export default App;