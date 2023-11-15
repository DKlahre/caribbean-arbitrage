

import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';


export default function HomeEmp() {
  const [employees, setEmployees] = useState([]);

  const {id} = useParams();

  useEffect(() => {
   loadEmployees();
  },[]);



  const loadEmployees= async ()=>{
    const result= await axios.get("http://localhost:8080/employees");
    setEmployees(result.data);
  };

  const deleteEmployee=async (id)=>{
    await axios.delete(`http://localhost:8080/employee/${id}`);
    loadEmployees();
  }

  return (
    <div className="mt-4">
    <div className='container'>
    <h2 className="text-center">Ship Employees</h2>
            <table className="table border shadow">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Gender</th>
          <th scope="col">Job Title</th>
          <th scope="col">Room #</th>
          <th scope="col">Checked In</th>
        </tr>
      </thead>
      <tbody>

        {
        employees.map((employee,index) => (
          <tr>
          <th scope="row" key={index}>
            {index + 1}
            </th>
          <td>{employee.name}</td>
          <td>{employee.gender}</td> 
          <td>{employee.jobTitle}</td>
          <td>{employee.roomNum}</td>
          <td>{`${employee.checkedIn}`}</td>
          <td>
            <Link className="btn btn-primary mx-2" to={`/viewemp/${employee.id}`}>View</Link>
            <Link className="btn btn-outline-primary mx-2"
            to={`/editemp/${employee.id}`}>
              Edit</Link>
            <button className="btn btn-danger mx-2"
            onClick={() => deleteEmployee(employee.id)}
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