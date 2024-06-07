import axios from 'axios'
import React, {useEffect, useState } from 'react'
import { Link, useNavigate, useParams} from 'react-router-dom'
import "./../styles.css";


export default function ArbitrageProduct() {

    let navigate=useNavigate();

    useEffect(()=>{
        loadProduct();
        loadProduct2();
        loadCountry();
        loadCountry2();
    },[]);

    const {prodId1,prodId2, countId1, countId2} = useParams();

    const loadProduct=async()=>{
        const result=await axios.get(`http://localhost:8080/product/${prodId1}`);
        setProduct(result.data);
    };
    const loadProduct2=async()=>{
        const result=await axios.get(`http://localhost:8080/product/${prodId2}`);
        setProduct2(result.data);
    };
    const loadCountry=async()=>{
        const result=await axios.get(`http://localhost:8080/country/${countId1}`);
        setCountry(result.data);
    };
    const loadCountry2=async()=>{
        const result=await axios.get(`http://localhost:8080/country/${countId2}`);
        setCountry2(result.data);
    };


    const [product, setProduct]= useState({
        id: 0,
        productName:"",
        productDescription:"",
        productPrice: "",
        transAvailable:"",
        country: {
            id: 1,
            countryName: "",
            natCurrency: "",
            taxRate: 0.0,
            portName: ""
        } 
    });

    const [product2, setProduct2]= useState({
        id: 0,
        productName:"",
        productDescription:"",
        productPrice: "",
        transAvailable:"",
        country: {
            id: 1,
            countryName: "",
            natCurrency: "",
            taxRate: 0.0,
            portName: ""
        } 
    });

    const [country, setCountry] = useState({
        countryName: "",
        natCurrency: "",
        taxRate: 0.0,
        portName: ""
    });

    const [country2, setCountry2] = useState({
        countryName: "",
        natCurrency: "",
        taxRate: 0.0,
        portName: ""
    });

    const [newProvisioner, setNewProvisioner] = useState({
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

    const [newProvisioner2, setNewProvisioner2] = useState({
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

    const onInputChange=(e)=>{   
        setNewProvisioner({...newProvisioner,[e.target.name]: e.target.value});   
    };

    const onInputChange2=(e)=>{
        setNewProvisioner2({...newProvisioner2,[e.target.name]: e.target.value});
    };

    const onSubmit= async(e)=>{
                     
                         if(newProvisioner.provisionerName === ''){
                            alert("Enter 1st provisioner name");
                         }
                         if(newProvisioner2.provisionerName === ''){
                            alert("Enter 2nd provisioner name");
                         }
                         if(newProvisioner.productQuantity === ''){
                            alert("Enter product quantity(left column)")
                         }
                          
        if(newProvisioner2.productQuantity <= newProvisioner.productQuantity){
        e.preventDefault();
      const prov1 = await axios.post(`http://localhost:8080/country/${countId1}/product/${prodId1}`, newProvisioner);
      const prov2 = await axios.post(`http://localhost:8080/country/${countId2}/product/${prodId2}`, newProvisioner2);
        const provData1 = prov1.data;
        const provData2 = prov2.data;
         navigate(`/confirmarbitrage/${provData1.id}/${provData2.id}`);
    
        } 
        else {
            alert("Product quantity to be sold must be equal or less than the quantity to be purchased");
            window.location.reload();
        }
    };

    const onSubmit2= async(e)=>{
        e.preventDefault();
        await axios.post(`http://localhost:8080/country/${countId2}/product/${prodId2}`, newProvisioner2);
         navigate("/productadded");
    };
  
  return (
    <div className="mt-4">
        <div className ="container">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h2 className="text-center">Arbitrage Pair Details</h2>
                <br></br>               
                <div style = {{display: 'flex', justifyContent:'center', alignItems:'center'}}>
            <div className="card" style = {{width: '50vh'}}>
                <div className="card-header">
                    SELLER
                    <ul className="list-group list-group-flush">
                        <li className="list-group-item">
                            <b>Product: </b>
                            {product.productName}
                        </li>
                        <li className="list-group-item">
                            <b>UPC/ID #: </b>
                            {product.productDescription}
                        </li>
                        <li className="list-group-item">
                            <b>Price: $</b>
                            {product.productPrice}
                            <span> US </span>
                        </li>
                        <li className="list-group-item">
                            <b>Trade type: </b>
                            {product.transAvailable}
                        </li>
                        <li className="list-group-item">
                            <b>Country: </b>
                            {product.country.countryName}
                        </li>
                        <li className="list-group-item">
                            <b>National currency: </b>
                            {product.country.natCurrency}
                        </li>
                        <li className="list-group-item">
                            <b>Tax rate: </b>
                            {product.country.taxRate}
                            <span>% </span> 
                        </li>
                        <li className="list-group-item">
                            <b>Port: </b>
                            {product.country.portName}
                        </li>
                             
                    </ul>
                </div>
            </div>    


            <div className="card" style = {{width: '50vh'}}>
                <div className="card-header">
                    BUYER
                    <ul className="list-group list-group-flush">
                        <li className="list-group-item">
                            <b>Product: </b>
                            {product2.productName}
                        </li>
                        <li className="list-group-item">
                            <b>UPC/ID #: </b>
                            {product2.productDescription}
                        </li>
                        <li className="list-group-item">
                            <b>Price: $</b>
                            {product2.productPrice}
                            <span> US </span> 
                        </li>
                        <li className="list-group-item">
                            <b>Trade type: </b>
                            {product2.transAvailable}
                        </li>
                        <li className="list-group-item">
                            <b>Country: </b>
                            {product2.country.countryName}
                        </li>
                        <li className="list-group-item">
                            <b>National currency: </b>
                            {product2.country.natCurrency}
                        </li>
                        <li className="list-group-item">
                            <b>Tax rate: </b>
                            {product2.country.taxRate}
                            <span>% </span> 
                        </li>
                        <li className="list-group-item">
                            <b>Port: </b>
                            {product2.country.portName}
                        </li>
                             
                    </ul>
                </div>
            </div>   
        </div> 



        <div style = {{display: 'flex', justifyContent:'center', alignItems:'center', marginTop: '6vh'  }}>        
        <div style = {{width: '50vh', justifyContent:'center'}}><h4>Buy from the seller</h4></div>
        <div style = {{width: '50vh', justifyContent:'center'}}><h4>Sell to the buyer</h4></div>
        </div>

                <div style = {{display: 'flex', justifyContent:'center', alignItems:'center'}}>
                <div className="card" style = {{width: '50vh'}}>
                <div className="card-header">
                <form onSubmit={(e) => onSubmit(e)}>
                <div className="mb-3 mt-4">
                        <label htmlFor="CountryOfBusiness" className="form-label">
                            Country of business
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter country of business"
                            name="countryOfBusiness"
                            value={newProvisioner.countryOfBusiness = country.countryName}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    
                    <div className="mb-3">
                        <label htmlFor="ProvisionerName" className="form-label">
                            Provisioner Name
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            id="provNameInputID1"
                            style={{border: 'solid', borderColor: 'blue'}}
                            placeholder="Enter provisioner name"
                            name="provisionerName"
                            value={newProvisioner.provisionerName}
                            onChange={ (e)=> onInputChange(e) }         
                            
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="ProductQuantity" className="form-label">
                            Product
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter product name"
                            name="productName"
                            value={product.productName}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="ProductPrice" className="form-label">
                            Product Price
                        </label>
                        <input
                            type={"number"}
                            className="form-control"
                            placeholder="Enter product price"
                            name="productPrice"
                            value={product.productPrice}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="ProductQuantity" className="form-label">
                            Product Quantity
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter product quantity"
                            name="productQuantity"
                            style={{border: 'solid', borderColor: 'blue'}}
                            maxLength={6}
                            value={newProvisioner.productQuantity}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="PurchaseTotal" className="form-label">
                            <b>Total cost including tax</b>
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter purchase total"
                            name="purchaseTotal"
                            value={newProvisioner.purchaseTotal = ((newProvisioner.productQuantity * product.productPrice) + ((newProvisioner.productQuantity * product.productPrice)*(country.taxRate/100))).toFixed(2)}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="CountryTax" className="form-label">
                            Country sales tax percentage
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter country tax rate"
                            name="countryTax"
                            value={(country.taxRate).toFixed(2)}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="TransType" className="form-label">
                            Ship transaction type
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter transaction type"
                            name="transType"
                            value= {newProvisioner.transType = product2.transAvailable}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>

                    <br></br>
                    <Link className="btn btn-outline-danger mx-2" to="/">
                        Cancel
                    </Link>
                </form>
                </div>
                </div>



                <div className="card" style = {{width: '50vh'}}>
                <div className="card-header">
                <form onSubmit={(e) => onSubmit(e)}>
                <div className="mb-3 mt-4">
                        <label htmlFor="CountryOfBusiness" className="form-label">
                            Country of business
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter country of business"
                            name="countryOfBusiness"
                            value={newProvisioner2.countryOfBusiness = country2.countryName}
                            onChange={(e)=>onInputChange2(e)}
                        />
                    </div>
                    
                    <div className="mb-3">
                        <label htmlFor="ProvisionerName" className="form-label">
                            Provisioner Name
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter provisioner name"
                            style={{border: 'solid', borderColor: 'blue'}}
                            name="provisionerName"
                            value={newProvisioner2.provisionerName}
                            onChange={(e)=>onInputChange2(e)}
                        />

                    </div>

                    <div className="mb-3">
                        <label htmlFor="ProductQuantity" className="form-label">
                            Product
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter product name"
                            name="productName"
                            value={product2.productName}
                            onChange={(e)=>onInputChange2(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="ProductPrice" className="form-label">
                            Product Price
                        </label>
                        <input
                            type={"number"}
                            className="form-control"
                            placeholder="Enter product price"
                            name="productPrice"
                            value={product2.productPrice}
                            onChange={(e)=>onInputChange2(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="ProductQuantity" className="form-label">
                            Product Quantity
                        </label>
                        <input
                            type={"text"}
                            className="form-control"                           
                            name="productQuantity"
                            maxLength={6}
                            value={newProvisioner2.productQuantity = newProvisioner.productQuantity}
                            onChange={(e)=>onInputChange2(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="PurchaseTotal" className="form-label">
                            <b>Total sale</b>
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter purchase total"
                            name="purchaseTotal"
                            value={newProvisioner2.purchaseTotal = (newProvisioner2.productQuantity * product2.productPrice).toFixed(2)}
                            onChange={(e)=>onInputChange2(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="NetProfit" className="form-label">
                            <b>Net transaction profit</b>
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter country tax rate"
                            name="netProfit"
                            value={     
                                ((newProvisioner2.productQuantity * product2.productPrice) - ((newProvisioner2.productQuantity * product.productPrice) + ((newProvisioner2.productQuantity * product.productPrice)*(country.taxRate/100)))).toFixed(2)}
                            onChange={(e)=>onInputChange2(e)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="TransType" className="form-label">
                            Ship transaction type
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter transaction type"
                            name="transType"
                            value= {newProvisioner2.transType = product.transAvailable}
                            onChange={(e)=>onInputChange2(e)}
                        />
                    </div>
                    <br></br>
                    <div className=" text-left">
                    <button type="submit" className="btn btn-outline-primary" >
                        Submit
                    </button>
                    </div>
      
                </form>
                </div>
                </div>
                </div>
                
            </div>
        </div>
    </div>    
  );

}