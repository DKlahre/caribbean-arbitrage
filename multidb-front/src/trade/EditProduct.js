import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'

export default function EditProduct() {

    let navigate=useNavigate();
    const {id}=useParams();

    const [product,setProduct]= useState({
        "productName" :"",
        "productDescription" :"",
        "productPrice":0.0,
        "transAvailable":"",
        "country": {
            "id": 0,
            "countryName": "",
            "natCurrency": "",
            "taxRate": 0.0,
            "portName": ""
        }    
    });


    const{productName,productDescription,productPrice,transAvailable,country}=product;
    const onInputChange=(e)=>{
        setProduct({...product,[e.target.name]: e.target.value});
    };

    useEffect(() => {
        loadProduct();
    },[]);

    const onSubmit= async(e)=>{
        e.preventDefault();
        await axios.put(`http://localhost:8080/product/${id}/`, product);
         navigate(`/viewproduct/${id}`);
    };

    const loadProduct =async ()=>{
        const result=await axios.get(`http://localhost:8080/product/${id}/`);
        setProduct(result.data);
    };

  return (
    <div className="container">
        <div className ="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center">Edit Product</h2>
                <form onSubmit={(e) => onSubmit(e)}>
                <div className="mb-3 mt-4">
                    <label htmlFor="ProductName" className="form-label">
                        Product to edit
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter product"
                        name="productName"
                        value={productName}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="ProductDescription" className="form-label">
                        UPC/ID #
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter UPC/ID #"
                        name="productDescription"
                        value={productDescription}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="Price" className="form-label">
                        Price
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter price"
                        name="productPrice"
                        value={productPrice}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="Country" className="form-label">
                        Country (non-editable)
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter country ID"
                        name="countryNOCHANGE"
                        value={country.countryName}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="TransAvailable" className="form-label">
                        Country's Provisioner Trade Type
                    </label>
                    <br></br>
                    <select   
                       name="transAvailable"
                       value={transAvailable}
                       onChange={(e)=>onInputChange(e)}>
                    <option value="">Choose a trade type</option>
                    <option value="buy">buy</option>
                    <option value="sell">sell</option>
                    </select>
                </div>
                <br></br>

                <button type="submit" className="btn btn-outline-primary" >
                    Submit
                </button>
                <Link className="btn btn-outline-danger mx-2" to="/">
                    Cancel
                </Link>
                </form>
            </div>
        </div>
    </div>    
  );
}