import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';


export default function BarbOrderToiletries() {
  const [barbToiletryOrders, setBarbToiletryOrders] = useState([]);

  useEffect(() => {
   loadBarbToiletryOrders();
   loadSubmitOrders();
  },[]);

  const loadBarbToiletryOrders= async ()=>{
   
    const result= await axios.get("http://localhost:8080/barbtoiletryorders");
    setBarbToiletryOrders(result.data);
  };

  const deleteBarbToiletryOrder=async (id)=>{
    await axios.delete(`http://localhost:8080/barbtoiletryorder/${id}`);
    loadBarbToiletryOrders();
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
      <h2 className="text-center">Martinique Toiletry Supply Portal</h2>
      
            <table className="table table-striped">
      <thead>
        <tr>
          <th scope="col">Provisioner</th>
          <th scope="col">Item</th>
          <th scope="col">Euros €</th>
          <th scope="col">US $</th>
          <th scope="col">Quantity</th>
          <th scope="col">Pickup Date</th>
          <th scope="col">Row Cost US</th>
          <th scope="col">Total Tally US</th>

        </tr>
      </thead>
      <tbody>


        {
            
          barbToiletryOrders.map((barbToiletryOrder,index) => (
                  
          <tr scope="row" key={index}>
           
          <td>{barbToiletryOrder.provisioner}</td> 
          <td>{barbToiletryOrder.item}</td>
          <td>{barbToiletryOrder.itemCostNat}</td>
          <td>{barbToiletryOrder.itemCostUs}</td>
          <td>{barbToiletryOrder.quantity}</td> 
          <td>{barbToiletryOrder.purchDate}</td>
          <th>{barbToiletryOrder.itemTotalCostUs}</th>
          <th>{barbToiletryOrder.allItemsCost}</th> 

            
          <td>
            <Link className="btn btn-outline-primary mx-2" 
            to={`/createbarbtoilorder/${barbToiletryOrder.id}`}>
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
              <Link className="btn btn-primary mx-2" to={`/confirmsubmittoilorder/${submitOrder.id}`}>Place Order</Link>
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