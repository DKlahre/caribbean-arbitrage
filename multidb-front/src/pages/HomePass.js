
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';


export default function HomePass() {
  const [passengers, setPassengers] = useState([]);


  useEffect(() => {
   loadPassengers();
  },[]);

  const loadPassengers= async ()=>{
    const result= await axios.get("http://localhost:8080/passengers");
  setPassengers(result.data);
  };

  const deletePassenger=async (id)=>{
    await axios.delete(`http://localhost:8080/passenger/${id}`);
    loadPassengers();
  }

  return (
    <div className="mt-4">
    <div className='container'>
<h2 className="text-center">Passengers</h2>
            <table className="table border shadow">
            
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Passport #</th>
          <th scope="col">Gender</th>
          <th scope="col">Country</th>
          <th scope="col">Room #</th>
          <th scope="col">Checked In</th>
        </tr>
      </thead>
      <tbody>

        {
        passengers.map((passenger,index) => (
          <tr>
          <th scope="row" key={index}>
            {index + 1}
            </th>
          <td>{passenger.name}</td>
          <td>{passenger.ppNum}</td>
          <td>{passenger.gender}</td>
          <td>{passenger.country}</td>
          <td>{passenger.roomNum}</td>
          <td>{`${passenger.checkedIn}`}</td>
          <td>
            <Link className="btn btn-primary mx-2" to={`/viewpass/${passenger.id}`}>View</Link>
            <Link className="btn btn-outline-primary mx-2"
            to={`/editpass/${passenger.id}`}>
              Edit</Link>
            <button className="btn btn-danger mx-2"
            onClick={() => deletePassenger(passenger.id)}
            >Delete</button>
          </td>
        </tr>
        ))
    }

      </tbody>
    </table>
    </div>
    </div>
  )
}