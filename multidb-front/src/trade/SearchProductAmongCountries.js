
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Nav } from 'react-bootstrap';
import { Link, useNavigate } from 'react-router-dom'

export default function ShowProductAmongCountries() {


  let navigate=useNavigate();
  let temp = 0;

  const [arbProducts, setArbProducts] = useState([]);
  const [show, setShow] = useState(true);
  const [style, setStyle] = useState({ display: "none" });
  const [products, setProducts] = useState([]);
  const [product] = useState([]);
  const{id,productName, productDescription,productPrice,transAvailable,country}=product;


  const [product1,setProduct1]=useState(
    {
        productName:"",
        productDescription:"",
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


    const [product2,setProduct2]=useState(
      {
          productName:"",
          productDescription:"",
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

  function changeState() {
    setShow(!show);
  }

  useEffect(()=>{
    loadProducts();
  },[]);

  const checkListHandler = (prodId) => (e) => {
    setStyle({
      display: e.target.checked ? "block" : "none"
    });
    const newArbProducts = [...arbProducts];
    const index = newArbProducts.indexOf(prodId);
    if (index === -1) {
      newArbProducts.push(prodId);
    } else {
      newArbProducts.splice(index, 1);
    }
    setArbProducts(newArbProducts);
   console.log(newArbProducts);
  };


  const loadProducts= async ()=>{
    const result= await axios.get("http://localhost:8080/products");
    setProducts(result.data);
  };

const searchProduct=async (productDescription)=>{
    const result = await axios.get(`http://localhost:8080//productbydescription/productdesc/${productDescription}`);
    setProducts(result.data);
  }

  const submitChoices=async (arbProductsArray)=>{ 
    const length = arbProductsArray.length;
    if (length > 2 || length < 2){
      alert("An arbitrage transaction must have 2 provisioners");
      window.location.reload();
    }

    else{
      let[y,z] = arbProductsArray;
      var result1= await axios.get(`http://localhost:8080/product/${y}`);
      setProduct1(result1.data);
      const product1 = result1.data;
      var result2= await axios.get(`http://localhost:8080/product/${z}`);
      setProduct2(result2.data);
      const product2 = result2.data;

      var country1Id = product1.country.id;
      var country2Id = product2.country.id;
      var prod1Price = product1.productPrice;
      var prod2Price = product2.productPrice;
      var prod1ProdDesc = product1.productDescription; 
      var prod2ProdDesc = product2.productDescription;     
      var prod1TransAvail = product1.transAvailable;
      var prod2TransAvail = product2.transAvailable;
      var prod1Price = product1.productPrice;
      var prod2Price = product2.productPrice;
      var conditionsMet = true;

      if((prod1ProdDesc !== prod2ProdDesc)){
        alert("UPC symbol of both products must be the same");
        conditionsMet = false;
        window.location.reload();
      }

      if((prod1Price>prod2Price)){
        temp=y;
        y=z;
        z=temp;  
        country1Id = product2.country.id;
        country2Id = product1.country.id;
        conditionsMet = true;
      }

      if (prod1TransAvail === prod2TransAvail){
        alert("Arbitrage requires buy/sell trading pair");
        conditionsMet = false;
        window.location.reload();
      }

      if((prod1Price<prod2Price)&&(prod1TransAvail==="buy")&&(conditionsMet)){
        alert("Lower priced provisioner must be a seller");
        conditionsMet = false;
        window.location.reload();
      }

      if((prod2Price<prod1Price)&&(prod1TransAvail==="sell")&&(conditionsMet)){
        alert("Lower priced provisioner must be a seller");
        conditionsMet = false;
        window.location.reload();
      }

      if(conditionsMet){
      navigate(`/arbitrageproduct/${y}/${z}/${country1Id}/${country2Id}`);
      }


    } // end else block


  }

  return (
    <div className="mt-4">
    <div className='container'>
    <h2 className="text-center">Caribbean Arbitrage Opportunities</h2>
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
          {show ? (
          <div>   
        <button  className="btn btn-primary mx-2" onClick={() =>{changeState(); searchProduct(product.productDescription ); 
      }  }>Arbitrage search</button>
      </div>
        ) : (
          <div>
          <input
            type="checkbox"
            data-testid="my-checkbox"
            name="cb"
            onClick={checkListHandler(product.id)}
          />
          <div data-testid="my-div" style={style}>
            Pick only 2 from list
          </div> 
          
        </div>      
       )}
          </td>        
        </tr>            
        ))             
    }
      </tbody>
      <tfoot>
        <br></br>      
      <button  className="btn btn-warning mx-2"
            onClick={() => submitChoices(arbProducts)}
            >Submit Trading Pair</button>
            <Link className="navbar-brand" to="/searchproductamongcountries"> (Tick only 2 checkboxes)</Link>
        </tfoot>
      
    </table>

    </div>
    </div>
  )

}