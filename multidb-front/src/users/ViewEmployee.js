import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export default function ViewEmployee() {


    const [employee,setEmployee]=useState(
    {
        name:"",
        gender:"",
        jobTitle:"",
        roomNum:"",
        checkedIn:""
    });

    const {id}=useParams();

    useEffect(()=>{
        loadEmployee();
    },[]);

    const loadEmployee=async()=>{
        const result=await axios.get(`http://localhost:8080/employee/${id}`);
        setEmployee(result.data);
    };

  return (
    
        <div className="container">
            <div className ="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center">Employee Details</h2>

                    <div className="card">
                        <div className="card-header">
                            Details of employee id : {employee.id}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>Name: </b>
                                    {employee.name}
                                </li>
                                <li className="list-group-item">
                                    <b>Gender: </b>
                                    {employee.gender}
                                </li>
                                <li className="list-group-item">
                                    <b>Job title: </b>
                                    {employee.jobTitle}
                                </li>
                                <li className="list-group-item">
                                    <b>Room #: </b>
                                    {employee.roomNum}
                                </li>
                                <li className="list-group-item">
                                    <b>Check-in status: </b>
                                    {`${employee.checkedIn}`}
                                </li>
                                
                            </ul>
                        </div>
                    </div>                    
                    <Link className="btn btn-primary my-2" to={"/"}>
                    Back to Home
                </Link>
                </div>
            </div>
        </div>
            
  );
}