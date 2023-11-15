import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

var taxPercent;

export default function ConfirmSubmitOrder() {

    const [submitOrder,setSubmitOrder]=useState(
    {
		country:"",
        provisioner:"",
        item:"",
        itemCostNat:"",
        itemCostUs:"",
        quantity:"",
		purchDate:"",
		itemTotalCostUs:"",
		allItemsCost:""
    });

    const {id}=useParams();

    useEffect(()=>{
        loadSubmitOrder();
    },[]);

    const loadSubmitOrder=async()=>{
        const result=await axios.get(`http://localhost:8080/submitorder/${id}`);
        setSubmitOrder(result.data);
    };

  return (
    
        <div className="container">
            <div className ="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center">Finalize Order</h2>

                    <div className="card">
                        <div className="card-header">
                            Order total to be wired immediately
                            <ul className="list-group list-group-flush">
                         
                                <li className="list-group-item">
                                    <b>Pickup Date: </b>
                                    {submitOrder.purchDate}
                                </li>
                                <li className="list-group-item">
                                    <b>Country: </b>
                                    {submitOrder.country}
                                </li>
                                <li className="list-group-item">
                                    <b>Provisioner: </b>
                                    {submitOrder.provisioner}
                                </li>
                                <li className="list-group-item">
                                    <b>Raw Total:</b><span> US $</span>
                                    {submitOrder.allItemsCost}
                                </li>
                                <li className="list-group-item">
                                {(() => {
                                switch (submitOrder.country) {
                                case "Barbados": taxPercent = '.175'; 
                                break;
                                case "Montserrat": taxPercent = '.05';
                                break;
                                case "Guadaloupe": taxPercent = '.085';
                                break;
                                case "Martinique": taxPercent = '.085';
                                break;
                                case "Dominica": taxPercent = '.18';
                                break;
                                case "Anguilla": taxPercent = '.13';
                                break;
                                case "Trinidad": taxPercent = '.084';
                                break;
                                case "Antiqua": taxPercent = '.15';
                                default:
                                case "NoCountry": taxPercent = '0.0';
                                
                                }
                                })()}
                                    <b>Tax @ 17.5%:</b><span> US $</span>
                                    {(Math.round(submitOrder.allItemsCost * taxPercent * 100) / 100).toFixed(2)}
                                </li>
                                <li className="list-group-item">
                                    <b>Grand Total: US $</b>
                                    <b>{(+(Number(submitOrder.allItemsCost)) + (Number(submitOrder.allItemsCost * taxPercent))).toFixed(2)}</b>
                                    
                                </li>
                                                                
                            </ul>
                        </div>
                    </div>                    
                    <Link className="btn btn-primary my-2" to={"/confirmationpage"}>
                    Process Order
                    </Link>

                </div>
            </div>
        </div>
            
  );
}