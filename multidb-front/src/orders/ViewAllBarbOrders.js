import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function ViewAllBarbOrders() {
  const [barbadosOrders, setBarbadosOrders] = useState([]);

  useEffect(() => {
   loadBarbadosOrders();
  },[]);

  const loadBarbadosOrders= async ()=>{
   
    const result= await axios.get("http://localhost:8080/barbadosorders");
    setBarbadosOrders(result.data);
  };

  const deleteBarbadosOrder=async (id)=>{
    await axios.delete(`http://localhost:8080/barbadosorder/${id}`);
    loadBarbadosOrders();
  }

  return (
    <div className='container'>

      <table className="table border shadow">
        <thead>
        <tr>
          
          <th scope="col">Country</th>
          <th scope="col">Provisioner</th>
          <th scope="col">Item</th>
          <th scope="col">Cost Native</th>
          <th scope="col">Cost US</th>
          <th scope="col">Quantity</th> 
          <th scope="col">Total Cost US</th>
          <th scope="col">Pickup Date</th>
          <th scope="col">All Items Cost</th>
        </tr>
      </thead>
      <tbody>

        {
        barbadosOrders.map((barbadosOrder,index) => (
          <tr scope="row" key={index}>
          <td>{barbadosOrder.country}</td>
          <td>{barbadosOrder.provisioner}</td> 
          <td>{barbadosOrder.item}</td>
          <td>{barbadosOrder.itemCostNat}</td>
          <td>{barbadosOrder.itemCostUs}</td>
          <td>{barbadosOrder.quantity}</td> 
          <td>{barbadosOrder.itemTotalCostUs}</td>
          <td>{barbadosOrder.purchDate}</td>
          <td>{barbadosOrder.allItemsCost}</td> 

          <td>
            <button className="btn btn-danger mx-2"
            onClick={() => deleteBarbadosOrder(barbadosOrder.id)}
            >Delete</button>
          </td>
        </tr>
        ))
    }

      </tbody>
    </table>

    </div>
  )
}