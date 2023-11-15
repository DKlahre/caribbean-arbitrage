import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div>
<nav className="navbar navbar-expand-lg navbar-dark bg-primary">
  <div className="container-fluid">
    <Link className="navbar-brand" to="/">Home</Link>
    <Link className="navbar-brand" >Occidental Cruises Purser App</Link>
    <button className="navbar-toggler" 
    type="button" 
    data-bs-toggle="collapse" 
    data-bs-target="#navbarSupportedContent" 
    aria-controls="navbarSupportedContent" 
    aria-expanded="false" 
    aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>

    <div className=" text-right">
            <Link className= 'btn btn-outline-light ' to = {"/addemp"} >Add Employee</Link>
            <Link className= 'btn btn-outline-light mx-2' to = {"/addpass"} >Add Passenger</Link>

    </div>
  </div>
</nav>

    </div>
  );
}