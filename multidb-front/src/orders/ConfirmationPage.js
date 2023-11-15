import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

export default function ConfirmationPage() {

    const [barbLiqSelections,setBarbLiqSelections]=useState(
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

    useEffect(()=>{        
      loadBarbLiqSelections();
    },[]);

    const loadBarbLiqSelections=async()=>{
         await axios.get(`http://localhost:8080/barbliqselections`);
        setBarbLiqSelections();
      }

  return (
    
        <div className="container">
            <div className ="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center">Order Submitted</h2>

                    <div className="card">
                        <div className="card-header">
                            Order will be available 12:00 pm (noon) at Dock E, Bay 2 of the Bridgetown Deep Water Harbour.
                            Nautical identification will be required for pick up. For logistical concerns call (1-246-536-3800) or email
                            WhereIsMyStuff@BarbadosProvisioning.com. 
                        </div>
                    </div>                    
                    <Link className="btn btn-primary my-2" to={"/barborderoptions"}>
                    Order More
                    </Link>
                    <Link className="btn btn-primary my-2 mx-2" to={"/"}>
                    Home
                    </Link>

                </div>
            </div>
        </div>
            
  );
}