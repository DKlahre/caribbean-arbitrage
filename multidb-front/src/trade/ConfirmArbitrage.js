import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';



export default function ConfirmArbitrage() {

    let navigate=useNavigate();

    useEffect(()=>{
        loadProvisioner1();
        loadProvisioner2();
    },[]);

    const {provisionerId1, provisionerId2} = useParams();
    var convNum = 1.0;


    const loadProvisioner1=async()=>{
        const result=await axios.get(`http://localhost:8080/provisioner/${provisionerId1}`);
        setProvisioner1(result.data);
    };
    const loadProvisioner2=async()=>{
        const result=await axios.get(`http://localhost:8080/provisioner/${provisionerId2}`);
        setProvisioner2(result.data);
    };

    const [provisioner1, setProvisioner1] = useState({
        id: "",
        provisionerName: "",
        countryOfBusiness: "",
        productQuantity: "",
        purchaseTotal: "0.0",
        transType: "buy",
        purchDate: "null",
        country: {
            id: 0,
            countryName: "",
            natCurrency: "",
            taxRate: 0.0,
            portName: ""
        },
        product: {
            id: 0,
            productName:"",
            productDescription:"0",
            productPrice:"0.0",
            transAvailable:"",
        }
    })

    const [provisioner2, setProvisioner2] = useState({
        id: "",
        provisionerName: "",
        countryOfBusiness: "",
        productQuantity: "",
        purchaseTotal: "0.0",
        transType: "buy",
        purchDate: "null",
        country: {
            id: 0,
            countryName: "",
            natCurrency: "",
            taxRate: 0.0,
            portName: ""
        },
        product: {
            id: 0,
            productName:"",
            productDescription:"0",
            productPrice:"0.0",
            transAvailable:"",
        }
    })

  return (
    
        <div className="container">
            <div className ="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center">Transaction Summary</h2>

                    <div className="card">
                        <div className="card-header">
                          
                            <ul className="list-group list-group-flush">
                         
                                <li className="list-group-item">
                                    <b>Arbitrage date: </b>
                                    {provisioner1.purchDate}
                                </li>
                                <li className="list-group-item">
                                    <b>Product: </b>
                                    {provisioner1.product.productName}
                                </li>
                                <li className="list-group-item">
                                    <b>UPC #: </b>
                                    {provisioner1.product.productDescription}
                                </li>
                                <li className="list-group-item">
                                    <b>Units: </b>
                                    {provisioner1.productQuantity}
                                </li>
                                <li className="list-group-item">
                                    <b>Total sale: </b>
                                    {((provisioner2.productQuantity) * (provisioner2.product.productPrice)).toFixed(2)}
                                    <span> USD</span>
                                </li>
                                <li className="list-group-item">
                                {(() => {
                                switch (provisioner2.country.countryName) {
                                case "BARBADOS": convNum = '2.00'; 
                                break;
                                case "MONTSERRAT": convNum = '2.70';
                                break;
                                case "GUADALOUPE": convNum = '0.93';
                                break;
                                case "MARTINIQUE": convNum = '0.93';
                                break;
                                case "DOMINICA": convNum = '2.70';
                                break;
                                case "ST_VINCENT": convNum = '2.70';
                                break;
                                case "ANGUILLA": convNum = '2.70';
                                break;
                                case "TRINIDAD": convNum = '6.73';
                                break;
                                case "ST_KITTS": convNum = '2.70';
                                break;
                                case "USVI": convNum = '1.0';
                                break;
                                case "BVI": convNum = '0.81';
                                break;
                                case "ST_LUCIA": convNum = '2.70';
                                break;
                                case "ANTIGUA": convNum = '2.70';
                                default:
                                case "NoCountry": convNum = '1.0';
                                
                                }
                                })()}
                                   <b>Sale in </b><i><b>{provisioner2.country.countryName}</b></i><b> currency: </b>
                                    {((((provisioner2.productQuantity) * (provisioner2.product.productPrice)) * convNum)).toFixed(2)}<span> </span>
                                    {provisioner2.country.natCurrency}
                                </li>
                                <li className="list-group-item">
                                    <b>Total Profit: </b>
                                    {((provisioner2.productQuantity * provisioner2.product.productPrice) - ((provisioner1.productQuantity * provisioner1.product.productPrice) + ((provisioner1.productQuantity * provisioner1.product.productPrice)*(provisioner1.country.taxRate/100)))).toFixed(2)}
                                    <span> USD</span>
                                </li>
                                <li className="list-group-item">
                                    <span>Pick up </span> {provisioner1.country.countryName} <span>
                                        order from </span>
                                    {provisioner1.country.portName} <span> port within the next
                                        24 hours. Contact provisioner </span> {provisioner1.provisionerName}
                                        <span> for further details.</span>
                                </li>
                                <li className="list-group-item">
                                    <span>For second leg of arbitrage transaction contact buyer </span>
                                    {provisioner2.provisionerName} <span> in </span>{provisioner2.country.countryName}<span> for delivery scheduling 
                                        at </span>{provisioner2.country.portName}<span> port.</span>             
                                   
                                </li>
                                      
                            </ul>
                        </div>
                    </div>                    
                    <Link className="btn btn-primary my-2" to={"/"}>
                    Exit
                    </Link>


                </div>
            </div>
        </div>
            
  );
}