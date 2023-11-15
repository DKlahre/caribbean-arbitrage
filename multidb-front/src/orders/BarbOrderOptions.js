import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

export default function BarbOrderOptions() {
  const [barbadosOrders, setBarbadosOrders] = useState([]);

  useEffect(() => {
   loadBarbadosOrders();
   loadSubmitOrders();
  },[]);

  const loadBarbadosOrders= async ()=>{
   
    const result= await axios.get("http://localhost:8080/barbadosorders");
    setBarbadosOrders(result.data);
  };

  const deleteBarbadosOrder=async (id)=>{
    await axios.delete(`http://localhost:8080/barbadosorder/${id}`);
    loadBarbadosOrders();
  }

  const loadSubmitOrders= async ()=>{
    const result2= await axios.get("http://localhost:8080/submitorders/");
  setSubmitOrders(result2.data);
  };

  const deleteSubmitOrder=async (id)=>{
    await axios.delete(`http://localhost:8080/submitorder/${id}`);
    loadSubmitOrders();
  }

    const [submitOrders, setSubmitOrders] = useState([]);

  return (
    
    <div className='container'>
      <div className="mt-5">
      <h2 className="text-center">Barbados Liquor Supply Order Portal</h2>
      
            <table className="table table-striped">
      <thead>
        <tr>
          <th scope="col">Provisioner</th>
          <th scope="col">Item</th>
          <th scope="col">Barbadian$</th>
          <th scope="col">US$</th>
          <th scope="col">Quantity</th>
          <th scope="col">Pickup Date</th>
          <th scope="col">Row Cost US</th>
          <th scope="col">Total Tally US</th>

        </tr>
      </thead>
      <tbody>


        {            
        barbadosOrders.map((barbadosOrder,index) => (
                  
          <tr scope="row" key={index}>
           
          <td>{barbadosOrder.provisioner}</td> 
          <td>{barbadosOrder.item}</td>
          <td>{barbadosOrder.itemCostNat}</td>
          <td>{barbadosOrder.itemCostUs}</td>
          <td>{barbadosOrder.quantity}</td> 
          <td>{barbadosOrder.purchDate}</td>
          <th>{barbadosOrder.itemTotalCostUs}</th>
          <th>{barbadosOrder.allItemsCost}</th> 
     
          <td>
            <Link className="btn btn-outline-primary mx-2" 
            to={`/createbarborder/${barbadosOrder.id}`}>
              Stage Order</Link>     
          </td>  
        </tr>
  
        ))
        
        }
      </tbody> 
        </table>
          </div>




         
<div className = "container-fluid">
  <div className="mt-1">
    <table className="table">
        <thead align = "right">
          <tr>
          <th scope="col" style = {{color: 'white' }}>_______</th>
          <th scope="col" style = {{color: 'white' }}>_______</th>
          <th scope="col" style = {{color: 'white' }}>_______</th>
          <th scope="col" style = {{color: 'white' }}>_______</th>
          <th scope="col" style = {{color: 'white' }}>_______</th>
          <th scope="col" style = {{color: 'white' }}>_______</th>
          <th scope="col" style = {{color: 'white' }}>_______</th>
          <th scope="col" style = {{color: 'white' }}>_______</th>
          <th scope="col" style = {{color: 'white' }}>_______</th>
          <th scope="col" style = {{color: 'white' }}>_______</th>
          <th scope="col" style = {{color: 'white' }}>________</th>
            <th scope="col" style = {{fontWeight: 'bold', fontSize: 19  }}>Total</th>
          </tr>
        </thead>
        <tbody align="right">
        {
        submitOrders.map((submitOrder,index) => (

            <tr scope="row" key={index}>
              <td colSpan = "11" style = {{color: 'white' }}>_____</td>
            <td style = {{fontWeight: 'bold', fontSize: 19  }}>{submitOrder.allItemsCost}</td>
            <td>
              <Link className="btn btn-primary mx-2" to={`/confirmsubmitorder/${submitOrder.id}`}>Place Order</Link>
            </td>
          </tr>
          ))
        }

        </tbody>
    </table>
  </div>
  </div>
</div>
  )
}