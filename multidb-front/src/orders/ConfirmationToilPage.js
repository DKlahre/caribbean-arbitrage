import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

export default function ConfirmationToilPage() {

    const [barbToiletryItems,setBarbToiletryItems]=useState(
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
      loadBarbToiletryItems();
    },[]);

    const loadBarbToiletryItems=async()=>{
         await axios.get(`http://localhost:8080/barbtoiletryitems`);
        setBarbToiletryItems();
      }

  return (
    
        <div className="container">
            <div className ="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center">Order Submitted</h2>

                    <div className="card">
                        <div className="card-header">
                            Order will be available at 12:00 pm (noon) at the 
                            Quai Rouge Docking area of the Fort De France Port.
                            Nautical identification will be required for pick up. 
                            For logistical concerns call (596-596-75-15-75) or email
                            MesAffaires@ProduitsDuMatin.com. 
                        </div>
                    </div>                    
                    <Link className="btn btn-primary my-2" to={"/barbordertoiletries"}>
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