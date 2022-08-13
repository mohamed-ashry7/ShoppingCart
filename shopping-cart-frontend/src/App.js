import React, { Component } from "react";

import axios from "axios";
import ProductGrid from "./components/product/ProductGrid";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import extract from "./utils/extractJsonKey";
import Navbar from "./components/navbar/Navbar"
import ProductForm from './components/product/productForm'
const productsURL = "http://localhost:8080/products";

class App extends Component {
  state = {
    products: [],
  };

  componentDidMount() {
    axios.get(productsURL).then((res) => {
      // console.log(res);
      const theProducts = [...extract(res, "products")];
      this.setState({
        products: theProducts,
      });
    });
  }

  submitForm =(e)=>{
    e.preventDefault();
    
    const product = {
      code:e.target[0].value,
      description:e.target[1].value,
      imageURL:e.target[2].value,
      quantity:e.target[3].value,
      price:e.target[4].value,

    }
    const req = {
      headers:{
        "content-type":"application/json"
      },
      body:JSON.stringify(product)
    }
    axios.post(productsURL,product).then(
      (res)=>{
        console.log(res);
      }
    ).catch((err)=>{
      console.log(err);
    });
  } 
  render() {
    return (

      <BrowserRouter>
      <Navbar />
      <React.Fragment>
        
        <Routes>

        <Route path="/" element={<ProductGrid products={this.state.products} />}></Route>

        
        <Route path="/productForm" element={<ProductForm  submitForm={this.submitForm}/>} />

        <Route path="*" element={<div>No Page Found</div>} />

        </Routes>
      </React.Fragment>
      </BrowserRouter>
    );
  }
}

export default App;
