import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export default function ViewProduct() {

    const [product,setProduct]=useState(
    {
        productName:"",
        productDescription:"",
        productPrice:"",
        transAvailable:"",
        country: {
             id: 0,
             countryName: "",
             natCurrency: "",
             taxRate: 0.0,
             portName: ""

        } 
    });

    const{productName,productDescription,productPrice,transAvailable,country}=product;

    const {id}=useParams();

    useEffect(()=>{
        loadProduct();
    },[]);

    const loadProduct=async()=>{
        const result=await axios.get(`http://localhost:8080/product/${id}`);
        setProduct(result.data);
    };

  return (  
        <div className="container">
            <div className ="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center">Product Added</h2>

                    <div className="card">
                        <div className="card-header">
                            Product database ID : {product.id}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>Product: </b>
                                    {productName}
                                </li>
                                <li className="list-group-item">
                                    <b>UPC/ID #: </b>
                                    {productDescription}
                                </li>
                                <li className="list-group-item">
                                    <b>Price: </b>
                                    {productPrice}
                                </li>
                                <li className="list-group-item">
                                    <b>Trade type: </b>
                                    {transAvailable}
                                </li>
                                <li className="list-group-item">
                                    <b>Country name: </b>
                                    {country.countryName}
                                </li>
                                <li className="list-group-item">
                                    <b>National Currency: </b>
                                    {country.natCurrency}
                                </li>
                                <li className="list-group-item">
                                    <b>Tax Rate: </b>
                                    {country.taxRate}
                                    <span>% </span> 
                                </li>
                                <li className="list-group-item">
                                    <b>Port name: </b>
                                    {country.portName}
                                </li>
                             
                            </ul>
                        </div>
                    </div>                    
                    <Link className="btn btn-primary my-2" to={"/"}>
                    Back to Home
                </Link>
                </div>
            </div>
        </div>
            
  );
}