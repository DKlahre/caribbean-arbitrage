
import './App.css';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Footer from './layout/Navbar';
import Home from './pages/Home';
import AddPassenger from './users/AddPassenger';
import AddEmployee from './users/AddEmployee';
import EditPass from './users/EditPassenger';
import EditEmp from './users/EditEmployee';
import ViewPass from './users/ViewPassenger';
import ViewEmp from './users/ViewEmployee';
import HomePass from './pages/HomePass';
import HomeEmp from './pages/HomeEmp';
import ViewCountries from './pages/ViewCountries'
import ViewAllBarbOrders from './orders/ViewAllBarbOrders';
import BarbOrderOptions from './orders/BarbOrderOptions';
import BarbOrderToiletries from './orders/BarbOrderToiletries';
import CreateBarbOrder from './orders/CreateBarbOrder';
import CreateBarbToilOrder from './orders/CreateBarbToilOrder';
import ConfirmSubmitOrder from './orders/ConfirmSubmitOrder';
import ConfirmSubmitToilOrder from './orders/ConfirmSubmitToilOrder';
import ConfirmationPage from './orders/ConfirmationPage';
import ConfirmationToilPage from './orders/ConfirmationToilPage';

import ShowProducts from './trade/ShowProducts';
import AddProduct from './trade/AddProduct';
import EditProduct from'./trade/EditProduct';
import ViewProduct from './trade/ViewProduct';
import ShowProductsByCountry from './trade/ShowProductsByCountry';
import ShowCountriesByProduct from './trade/ShowCountriesByProduct';
import SearchProductsByCountry from './trade/SearchProductsByCountry';
import SearchCountriesByProduct from './trade/SearchCountriesByProduct';
import SearchProductAmongCountries from './trade/SearchProductAmongCountries';
import ArbitrageProduct from './trade/ArbitrageProduct';
import ConfirmArbitrage from './trade/ConfirmArbitrage';
import ProductAdded from './trade/ProductAdded';
import SearchTransactionsByDate from './trade/SearchTransactionsByDate';
import ShowTransactionsByDate from './trade/ShowTransactionsByDate'


function App() {
  return (
    <div className="App">
      <Router>      
        <Navbar/>

        <Routes>
        <Route exact path="/" element={<Home />} />
        <Route exact path="/addpass" element={<AddPassenger />} />
        <Route exact path="/addemp" element={<AddEmployee />} />
        <Route exact path="/editpass/:id" element={<EditPass />}/>
        <Route exact path="/editemp/:id" element={<EditEmp />}/>
        <Route exact path="/viewpass/:id" element={<ViewPass />}/>
        <Route exact path="/viewemp/:id" element={<ViewEmp />}/>
        <Route exact path="/homepass" element={<HomePass />}/>
        <Route exact path="/homeemp" element={<HomeEmp />}/>
        <Route exact path="/viewcountries" element={<ViewCountries />}/>
        <Route exact path="/viewallbarborders" element={<ViewAllBarbOrders />}/>
        <Route exact path="/barborderoptions" element={<BarbOrderOptions />}/>
        <Route exact path="/barbordertoiletries" element={<BarbOrderToiletries />}/>
        <Route exact path="/createbarborder/:id" element={<CreateBarbOrder />}/>
        <Route exact path="/createbarbtoilorder/:id" element={<CreateBarbToilOrder />}/>
        <Route exact path="/confirmsubmitorder/:id" element={<ConfirmSubmitOrder />}/>
        <Route exact path="/confirmsubmittoilorder/:id" element={<ConfirmSubmitToilOrder />}/>
        <Route exact path="/confirmationpage" element={<ConfirmationPage />}/>
        <Route exact path="/confirmationtoilpage" element={<ConfirmationToilPage />}/>

        <Route exact path="/showproducts" element={<ShowProducts />}/>
        <Route exact path="/addproduct" element={<AddProduct />}/>
        <Route exact path="/editproduct/:id" element={<EditProduct />}/>
        <Route exact path="/viewproduct/:id" element={<ViewProduct />}/>
        <Route exact path="/showproductsbycountry/:countryId/:transAvailable" element={<ShowProductsByCountry />}/>
        <Route exact path="/searchproductsbycountry" element={<SearchProductsByCountry />}/>
        <Route exact path="/searchcountriesbyproduct" element={<SearchCountriesByProduct />}/>
        <Route exact path="/showcountriesbyproduct/:productDescription/:transAvailable" element={<ShowCountriesByProduct />}/>
        <Route exact path="/searchproductamongcountries" element={<SearchProductAmongCountries/>}/>
        <Route exact path="/arbitrageproduct/:prodId1/:prodId2/:countId1/:countId2" element={<ArbitrageProduct/>}/>
        <Route exact path="/confirmarbitrage/:provisionerId1/:provisionerId2" element={<ConfirmArbitrage/>}/>
        <Route exact path="/productadded/:id" element = {<ProductAdded/>}/>
        <Route exact path="/searchtransactionsbydate" element={<SearchTransactionsByDate/>}/>
        <Route exact path="/showtransactionsbydate/:firstDate/:secondDate/:transType" element={<ShowTransactionsByDate/>}/>
        </Routes>
         
      </Router>

    </div>
  );
}

export default App;

