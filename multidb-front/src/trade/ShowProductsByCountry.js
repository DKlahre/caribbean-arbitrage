import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';


export default function ShowProductsByCountry() {
  const [products, setProducts] = useState([]);
  const {countryId,transAvailable} = useParams();

  useEffect(() => {
   loadProductsByCountry(countryId,transAvailable);
  },[]);

  const loadProductsByCountry= async (countryId,transAvailable)=>{
    const result= await axios.get(`http://localhost:8080/prodsbycountry/country/${countryId}/transavailable/${transAvailable}`);
    setProducts(result.data);
  };

  return (
    <div className="mt-4">
    <div className='container'>
    <h2 className="text-center">Products By Country</h2>
    <br></br>
            <table className="table border shadow">
      <thead>
        <tr>
          <th scope="col">Product</th>
          <th scope="col">UPC/ID #</th>
          <th scope="col">Price US$</th>
          <th scope="col">Trade type</th>
          <th scope="col">Country</th>
        </tr>
      </thead>
      <tbody>

        {
        products.map((product,index) => (
          <tr scope="row" key={index}>
          <td>{product.productName}</td>
          <td>{product.productDescription}</td> 
          <td>{product.productPrice}</td>
          <td>{product.transAvailable}</td>
          <td>{product.country.countryName}</td>
          <td>
            <Link className="btn btn-outline-primary mx-2"
            to={`/editproduct/${product.id}`}>
              Edit</Link>

          </td>
        </tr>
        ))
    }

      </tbody>
    </table>

    </div>
    </div>
  )
}