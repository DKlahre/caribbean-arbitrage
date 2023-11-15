import axios from 'axios'
import React, { useState } from 'react'
import { Link, useNavigate} from 'react-router-dom'

export default function SearchCountiresByProduct() {

    let navigate=useNavigate();

    const [product,setProduct]= useState({
        productName :"",
        productDescription :"",
        productPrice:0.0,
        transAvailable:"",
        country: {
            id: 0,
            countryName: "",
            natCurrency: "",
            taxRate: 0.0,
            portName: ""
        }    
    });

    const{productDescription, transAvailable}=product;

   const onInputChange=(e)=>{
    setProduct({...product,[e.target.name]: e.target.value});
    };

    const onSubmit= async(e)=>{
        e.preventDefault();
         navigate(`/showcountriesbyproduct/${productDescription}/${transAvailable}`);
    };

  return (
    <div className="container">
        <div className ="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center">Search countries by product and listed trade type</h2>
                <form onSubmit={(e) => onSubmit(e)}>
                <br></br>
                
                <div className="mb-3">
                    <label htmlFor="ProductDescription" className="form-label">
                        Product Name
                    </label>
                    <br></br>
                    <select   
                       name="productDescription"
                       value={productDescription}
                       onChange={(e)=>onInputChange(e)}>
                    <option value="">Choose product</option>
                    <option value="521344654762">Bulgar Wheat - Medium Grind</option>
                    <option value="503899122653">Yellow Cornmeal - Medium Grind</option>
                    <option value="385096579122">Machete - Stainless Steel 15 inch</option>
                    <option value="798501223965">Tire - Bridgestone - 195/65R15</option>
                    <option value="850173969225">Tire - Bridgestone - 205/65R15</option>
                    <option value="591786903225">Tire - Bridgestone - 235/75R15</option>
                    <option value="903225591786">Flour - Brother Ben's Flour 80 oz</option>
                    <option value="559017863229">Bullets - 22mm 20 pack</option>
                    <option value="325625901789">Bullets - 9mm 20 pack</option>
                    <option value="017893256259">Neopsporin 1 oz</option>
                    <option value="780325625199">Athletes Foot Cream 0.4 oz</option>
                    <option value="870392256519">Socks - Medium - Hanes 12 pair pack</option>
                    <option value="565103928729">Socks - Large Hanes 12 pair pack</option>
                    <option value="725928591036">Underwear - Medium Men's 6 pack</option>
                    <option value="928572591036">Underwear - Large Men's 6 pack</option>
                    <option value="591850369227">Smartphone - Galaxy 5G Samsung A54</option>
                    <option value="359229187550">Smartphone - Galaxy 5G Samsung A14</option>
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