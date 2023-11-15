import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'

export default function EditPassenger() {

    const routeChange = () =>{ 
        let path = `/homepass`; 
        navigate(path);
      }

    let navigate=useNavigate();

    const {id}=useParams();

    const [passenger,setPassenger]= useState({
        name:"",
        ppNum:"",
        gender:"",
        country:"",
        roomNum:"",
        checkedIn:""
    });

    const{name,ppNum,gender,country,roomNum,checkedIn}=passenger;

    const onInputChange=(e)=>{
        setPassenger({...passenger,[e.target.name]: e.target.value});
    };

    useEffect(() => {
        loadPassenger();
    },[]);

    const onSubmit= async(e)=>{
        e.preventDefault();
        await axios.put(`http://localhost:8080/passenger/${id}`, passenger); 
        navigate("/");
    };

    const loadPassenger =async ()=>{
        const result=await axios.get(`http://localhost:8080/passenger/${id}`);
        setPassenger(result.data);
    };

  return (
    <div className="container">
        <div className ="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center">Edit Passenger</h2>
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
                    <label htmlFor="PassportNum" className="form-label">
                        Passport #
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter passport #"
                        name="ppNum"
                        value={ppNum}
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
                    <label htmlFor="Country" className="form-label">
                        Country
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter country of citizenship"
                        name="country"
                        value={country}
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

                <div className="mb-3">
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


                <button type="submit" className="btn btn-outline-primary" >
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