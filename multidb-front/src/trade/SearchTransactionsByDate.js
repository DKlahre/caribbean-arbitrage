import axios from 'axios'
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function SearchTransactionsByDate() {

    let navigate=useNavigate();

    const [transaction,setTransaction]= useState({
        firstDate: "0-0-0",
        secondDate: "0-0-0",
        transType: ""
    });
    const{firstDate, secondDate, transType}=transaction;

    const onInputChange=(e)=>{
        setTransaction({...transaction,[e.target.name]: e.target.value});
    };

    const onSubmit= async(e)=>{
        e.preventDefault();
        await axios.get(`http://localhost:8080/transactionsbetweendates/firstdate/${firstDate}/seconddate/${secondDate}/transtype/${transType}/`);
         navigate(`/showtransactionsbydate/${firstDate}/${secondDate}/${transType}`);
    };

  return (
    <div className="container">
        <div className ="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center">Search transactions between dates</h2>
                <form onSubmit={(e) => onSubmit(e)}>

                <div className="mb-3">
                    <label htmlFor="PurchDate" className="form-label">
                        Start Date
                    </label>
                    <input
                        type="date" 
                        className="form-control"
                        placeholder="Enter pickup date"
                        name="firstDate"
                        value={firstDate}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="PurchDate" className="form-label">
                        End Date
                    </label>
                    <input
                        type="date" 
                        className="form-control"
                        placeholder="Enter pickup date"
                        name="secondDate"
                        value={secondDate}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="TransType" className="form-label">
                        Transaction Type
                    </label>
                    <br></br>
                    <select   
                       name="transType"
                       value={transType}
                       onChange={(e)=>onInputChange(e)}>
                    <option value="">Choose provisioner trade type</option>
                    <option value="buy">buy</option>
                    <option value="sell">sell</option>
                    <option value="all">all</option>
                    </select>
                </div>

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