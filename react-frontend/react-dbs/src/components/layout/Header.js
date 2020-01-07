import React from 'react';
import { Link } from 'react-router-dom';

function Header() {
    return (
        <header style={headerStyle}>
            <div style={{ display: "inline" }}>
                <h1 style={{ display: "inline" }}>Overview</h1>
                {/* <Link style={logoutStyle} to="/login">Logout</Link> */}
            </div>
            <Link style={linkStyle} to="/Login">Home</Link>
            {/* |
            <Link style={linkStyle} to="/Login">Login</Link> */}
            |
            <Link style={linkStyle} to="/Dashboard">Dashboard</Link>
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

const logoutStyle = {
    color: '#fff',
    textDecoration: 'none',
    padding: '5px',
    float: 'right',
    display: 'inline',
}

export default Header;