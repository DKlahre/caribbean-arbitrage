import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';


export default function ShowTransactionsByDate() {

  const [transactions, setTransactions] = useState([]);
  const {firstDate, secondDate, transType} = useParams();

  useEffect(() => {
   loadTransactions();
  },[]);

  const loadTransactions= async ()=>{
    const result= await axios.get(`http://localhost:8080/transactionsbetweendates/firstdate/${firstDate}/seconddate/${secondDate}/transtype/${transType}/`);
    setTransactions(result.data);
  };


  return (
    <div className="mt-4">
    <div className='container'>
    <h2 className="text-center">Transactions</h2>
    <br></br>
            <table className="table border shadow">
      <thead>
        <tr>
          <th scope="col">Provisioner</th>
          <th scope="col">Country of business</th>
          <th scope="col">Product quantity</th>
          <th scope="col">Transaction total</th>
          <th scope="col">Transaction type</th>
          <th scope="col">Transaction date</th>
        </tr>
      </thead>
      <tbody>

        {
        transactions.map((transaction,index) => (
          <tr scope="row" key={index}>
          <td>{transaction.provisionerName}</td>
          <td>{transaction.countryOfBusiness}</td> 
          <td>{transaction.productQuantity}</td>
          <td>{transaction.purchaseTotal}</td>
          <td>{transaction.transType}</td>
          <td>{transaction.purchDate}</td>
 
        </tr>
        ))
    }

      </tbody>
    </table>

    </div>
    </div>
  )
}