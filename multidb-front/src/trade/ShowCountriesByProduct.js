import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';


export default function ShowCountriesByProduct() {
  const [products, setProducts] = useState([]);

  const {productDescription,transAvailable} = useParams();

  useEffect(() => {
   loadProducts();
  },[]);

  const loadProducts= async ()=>{
    const result= await axios.get(`http://localhost:8080/countriesbyprod/productdesc/${productDescription}/transavailable/${transAvailable}`);
    setProducts(result.data);
  };

  const deleteProduct=async (id)=>{
    await axios.delete(`http://localhost:8080/product/${id}`);
    loadProducts();
  }

  return (
    <div className="mt-4">
    <div className='container'>
    <h2 className="text-center">Caribbean Arbitrage Opportunies</h2>
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
            {/* <button className="btn btn-danger mx-2"
            onClick={() => deleteProduct(product.id)}
            >Delete</button> */}
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