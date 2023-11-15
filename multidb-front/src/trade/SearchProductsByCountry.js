import axios from 'axios'
import React, {useState} from 'react'
import { Link, useNavigate} from 'react-router-dom'

export default function SearchProductsByCountry() {

    let navigate=useNavigate();

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

    const{transAvailable,countryId}=product;
    const onInputChange=(e)=>{
        setProduct({...product,[e.target.name]: e.target.value});
    };

    const onSubmit= async(e)=>{
        e.preventDefault();
         navigate(`/showproductsbycountry/${countryId}/${transAvailable}`);
    };

  return (
    <div className="container">
        <div className ="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center">Search products by country and listed trade type</h2>
                <form onSubmit={(e) => onSubmit(e)}>
                <br></br>
                
                <div className="mb-3">
                    <label htmlFor="CountryId" className="form-label">
                        Carribean Country
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
                        Country's Provisioner Trade Type
                    </label>
                    <br></br>
                    <select   
                       name="transAvailable"
                       value={transAvailable}
                       onChange={(e)=>onInputChange(e)}>
                    <option value="">Choose provisioner trade type</option>
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