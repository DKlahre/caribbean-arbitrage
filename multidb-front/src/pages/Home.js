

import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import cruiseChart from "./cruiseChart.jpg";
import Button from 'react-bootstrap/Button';
import Collapse from 'react-bootstrap/Collapse';



export default function HomePass() {

    const [open, setOpen] = useState(false);

  return(
    <div className="mt-4">     
      <div className='container'>
      <table className="table border shadow">
    <thead><h1>Occidental Cruises Purser App</h1></thead>
 
    <tbody>
          {         
            <div style={{display: 'flex', flexDirection: 'row', justifyContent: 'center'}}>
            <div style={{display: 'flex', flexDirection: 'column'}}>
               
                <Link style={{width:"250px", marginTop: "24px" }} className="btn btn-primary mx-2" to="/searchproductamongcountries">
                    Arbitrage Search 
                </Link>
                <Link style={{width:"250px", marginTop: "7px" }} className="btn btn-danger mx-2" to="/addproduct">
                    Add Product
                </Link>
                <Link style={{width:"250px", marginTop: "7px" }} className="btn btn-success mx-2" to="/showproducts">
                    View & Edit Products
                </Link>
                <Link style={{width:"250px", marginTop: "7px" }} className="btn btn-warning mx-2" to="/searchproductsbycountry">
                    Search Products by Country 
                </Link>
                <Link style={{width:"250px", marginTop: "7px" }} className="btn btn-primary mx-2" to="/searchcountriesbyproduct">
                    Search Countries by Product
                </Link>
                <Link style={{width:"250px", marginTop: "7px" }} className="btn btn-danger mx-2" to="/searchtransactionsbydate">
                    Search Transactions by Date
                </Link>
                <Link style={{width:"250px", marginTop: "7px" }} className="btn btn-success mx-2" to="/barborderoptions">
                    Barbados Liquor Orders
                </Link>
                <Link style={{width:"250px", marginTop: "7px" }} className="btn btn-warning mx-2" to="/barbordertoiletries">
                    Martinique Toiletry Orders
                </Link>
              
            </div>

            <div style={{display: 'flex', flexDirection: 'column'}}> 
                <label>Submit order at least 24 hours before provisioning</label>
                <img src={cruiseChart} width={450}  />
            </div>
            </div>
           
          }

    </tbody>

<br></br>

      <Button
        onClick={() => setOpen(!open)}
        aria-controls="collapse-text"
        aria-expanded={open}
      >
        Nuts & Bolts
      </Button>
      <div style = {{display: 'flex', justifyContent:'center', alignItems:'center'}}>
      <div style = {{ width: '75vh', paddingTop: '16px'}}>
      <Collapse in={open}>
        <div id="collapse-text" style = {{width: '75vh', textAlign: 'left', fontSize: 17}} >
          <li>4 databases manually created on Java Spring backend (Employees, Passengers, Ship Supplies, Trade)</li>
          <li>Many to one DB relationships (provisioner =&gt; product // provisioner =&gt; country // product =&gt; country)</li>
          <li>Sales tax and currency conversion on front AND backend</li>
          <li>All transactions recorded and searchable except toiletry and liquor orders</li>
          <li>Real world arbitrage application for cruise ship industry</li>
        </div>
      </Collapse>
    </div>
    </div>
    
</table>

</div>
</div>
    
)
}