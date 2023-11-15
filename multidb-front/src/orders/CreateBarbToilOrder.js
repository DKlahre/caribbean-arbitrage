
import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'

export default function CreateBarbToilOrder() {

    let navigate=useNavigate();
    const {id}=useParams();
    
    const [barbToilOrder,setBarbToilOrder]= useState({
        country:"",
        provisioner:"",
        item:"",
        itemCostNat:"",
        itemCostUs:"",
        quantity:"",
        itemTotalCostUs:"",
        purchDate:"",
        allItemsCost:""
    });

    const{item, quantity, purchDate}=barbToilOrder;

    const onInputChange=(e)=>{
        setBarbToilOrder({...barbToilOrder,[e.target.name]: e.target.value});
    };

    useEffect(() => {
        loadBarbToilOrder();
    },[]);

    const onSubmit= async(e)=>{
        e.preventDefault();
        await axios.put(`http://localhost:8080/barbtoiletryorder/${id}/`, barbToilOrder);
         navigate("/barbordertoiletries");
    };

    const loadBarbToilOrder =async ()=>{
        const result=await axios.get(`http://localhost:8080/barbtoiletryorder/${id}`);
        setBarbToilOrder(result.data);
    };

  return (
    <div className="container">
        <div className ="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center">Create Order</h2>
                <form onSubmit={(e) => onSubmit(e)}>

                <div className="mb-3">
                    <label htmlFor="Item" className="form-label">
                        Item
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter item"
                        name="item"
                        value={item}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="Quantity" className="form-label">
                        Quantity
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter quantity"
                        name="quantity"
                        value={quantity}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="PurchDate" className="form-label">
                        Pickup Date
                    </label>
      
                    <input
                        type="date" 
                        className="form-control"
                        placeholder="Enter pickup date"
                        name="purchDate"
                        value={purchDate}
                        onChange={(e)=>onInputChange(e)}
                    />
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