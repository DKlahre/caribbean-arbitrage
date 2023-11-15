import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export default function ViewPassenger() {


    const [passenger,setPassenger]=useState(
    {
        name:"",
        ppNum:"",
        gender:"",
        country:"",
        roomNum:"",
        checkedIn:""
    });

    const {id}=useParams();

    useEffect(()=>{
        loadPassenger();
    },[]);

    const loadPassenger=async()=>{
        const result=await axios.get(`http://localhost:8080/passenger/${id}`);
        setPassenger(result.data);
    };

  return (
    
        <div className="container">
            <div className ="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center">Passenger Details</h2>

                    <div className="card">
                        <div className="card-header">
                            Details of user id : {passenger.id}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>Name: </b>
                                    {passenger.name}
                                </li>
                                <li className="list-group-item">
                                    <b>Passport #: </b>
                                    {passenger.ppNum}
                                </li>
                                <li className="list-group-item">
                                    <b>Gender: </b>
                                    {passenger.gender}
                                </li>
                                <li className="list-group-item">
                                    <b>Country: </b>
                                    {passenger.country}
                                </li>
                                <li className="list-group-item">
                                    <b>Room #: </b>
                                    {passenger.roomNum}
                                </li>
                                <li className="list-group-item">
                                    <b>Check-in status: </b>
                                    {`${passenger.checkedIn}`}
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