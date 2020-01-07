import React from 'react';
import { Link } from 'react-router-dom';

function Header() {
    return (
        <header style={headerStyle}>
            <h1 stye={{marginTop:"0px"}}>Overview</h1>
            <Link style={linkStyle} to="/">Home</Link>
            |
            <Link style={linkStyle} to="/Login">Login</Link>
            |
            <Link style={linkStyle} to="/Overview">Overview</Link>
        </header>
    )
}

const headerStyle = {
    background: "#333",
    color: "#fff",
    textAlign: "center",
    paddingTop: "5px",
}

const linkStyle = {
    color: '#fff',
    textDecoration: 'none',
    padding: '5px',
}

export default Header;