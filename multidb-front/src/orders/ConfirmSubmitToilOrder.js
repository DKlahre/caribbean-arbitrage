import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

var taxPercent;

export default function ConfirmSubmitToilOrder() {

    const [submitToilOrder,setSubmitToilOrder]=useState(
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
        loadSubmitToilOrder();
    },[]);

    const loadSubmitToilOrder=async()=>{
        const result=await axios.get(`http://localhost:8080/submitorder/${id}`);
        setSubmitToilOrder(result.data);
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
                                    {submitToilOrder.purchDate}
                                </li>
                                <li className="list-group-item">
                                    <b>Country: </b>
                                    {submitToilOrder.country}
                                </li>
                                <li className="list-group-item">
                                    <b>Provisioner: </b>
                                    {submitToilOrder.provisioner}
                                </li>
                                <li className="list-group-item">
                                    <b>Raw Total:</b><span> US $</span>
                                    {submitToilOrder.allItemsCost}
                                </li>
                                <li className="list-group-item">
                                {(() => {
                                switch (submitToilOrder.country) {
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
                                    <b>Tax @ 8.5%:</b><span> US $</span>
                                    {(Math.round(submitToilOrder.allItemsCost * taxPercent * 100) / 100).toFixed(2)}
                                </li>
                                <li className="list-group-item">
                                    <b>Grand Total: US $</b>
                                    <b>{(+(Number(submitToilOrder.allItemsCost)) + (Number(submitToilOrder.allItemsCost * taxPercent))).toFixed(2)}</b>                                   
                                </li>
                                                           
                            </ul>
                        </div>
                    </div>                    
                    <Link className="btn btn-primary my-2" to={"/confirmationtoilpage"}>
                    Process Order
                    </Link>

                </div>
            </div>
        </div>
            
  );
}