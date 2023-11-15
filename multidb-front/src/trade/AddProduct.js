import axios from 'axios'
import React, { useState } from 'react'
import { Link, useNavigate} from 'react-router-dom'
import "./../styles.css";


export default function AddProduct() {

    let navigate=useNavigate();


    const [newProduct,setNewProduct]= useState({
        id: "",
        productName:"",
        productDescription:"",
        productPrice:"",
        transAvailable:"",
        countryId:0
    });

    const{productName, productDescription, productPrice, transAvailable, countryId}=newProduct;


    const onInputChange=(e)=>{
        setNewProduct({...newProduct,[e.target.name]: e.target.value});
    };

    const onSubmit= async(e)=>{
        e.preventDefault();
        const temp = await axios.post(`http://localhost:8080/productpluscountry/${countryId}`, newProduct);
         navigate(`/productadded/${temp.data.id}`);
    };
  
  return (
    <div className="container">
        <div className ="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center">Add Product/Country Pair</h2>
                <br></br>
                <form onSubmit={(e) => onSubmit(e)}>

                <div className="mb-3">
                    <label htmlFor="ProductName" className="form-label">
                        Product Name
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter product name"
                        name="productName"
                        value={productName}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="ProductDescription" className="form-label">
                        Product UPC/ID#
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter UPC/ID#"
                        name="productDescription"
                        value={productDescription}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="ProductPrice" className="form-label">
                        Product Price US$
                    </label>
                    <input
                        type={"text"}
                        className="form-control"
                        placeholder="Enter product price"
                        name="productPrice"
                        value={productPrice}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="CountryId" className="form-label">
                        Country
                    </label>
                    <br></br>
                    <select   
                       name="countryId"
                       value={countryId}
                       onChange={(e)=>onInputChange(e)}>
                    <option value="0">Choose a country</option>
                    <option value="1">Anguilla</option>
                    <option value="2">US Virgin Islands</option>
                    <option value="3">British Virgin Islands</option>
                    <option value="4">Antigua</option>
                    <option value="5">St. Kitts</option>
                    <option value="6">Montserrat</option>
                    <option value="7">Guadaloupe</option>
                    <option value="8">Dominica</option>
                    <option value="9">Martinique</option>
                    <option value="10">St. Lucia</option>
                    <option value="11">Barbados</option>
                    <option value="12">St. Vincent</option>
                    <option value="13">Trinidad</option>
                    </select>
                </div>

                <div className="mb-3">
                    <label htmlFor="TransAvailable" className="form-label">
                        Trade Type
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