import axios from 'axios'
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function AddEmployee() {

    let navigate=useNavigate();

    const [employee,setEmployee]= useState({
        name:"",
        gender:"",
        jobTitle:"",
        roomNum:"",
        checkedIn:""

    });

    const{name,gender,jobTitle,roomNum,checkedIn}=employee;
    const onInputChange=(e)=>{
        setEmployee({...employee,[e.target.name]: e.target.value});
    };

    const onSubmit= async(e)=>{
        e.preventDefault();
        await axios.post("http://localhost:8080/employee", employee); 
        navigate("/");
    };

  return (
    <div className="container">
        <div className ="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center">Register Employee</h2>
                <form onSubmit={(e) => onSubmit(e)}>
                <div className="mb-3 mt-4">
                    <label htmlFor="Name" className="form-label">
                        Name
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter name"
                        name="name"
                        value={name}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="Gender" className="form-label">
                        Gender
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter gender"
                        name="gender"
                        value={gender}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="JobTitle" className="form-label">
                        Job Title
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter job title"
                        name="jobTitle"
                        value={jobTitle}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="RoomNum" className="form-label">
                        Room #
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter room #"
                        name="roomNum"
                        value={roomNum}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3 mt-10">
                    <label htmlFor="CheckedIn" className="form-label">
                        Check-in status
                    </label>
                    <br></br>
                    <select   
                       name="checkedIn"
                       value={checkedIn}
                       onChange={(e)=>onInputChange(e)}>
                    <option value="">Enter check-in status</option>
                    <option value="true">true</option>
                    <option value="false">false</option>
                    </select>

                </div>
                <br></br>


                <button type="submit" className="btn btn-outline-primary">
                    Submit
                </button>
                <Link className="btn btn-outline-danger mx-2" to="/">
                    Cancel
                </Link>
                </form>
            </div>
        </div>
    </div>    
  );
}