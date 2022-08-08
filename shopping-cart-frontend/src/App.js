

import React, {Component} from "react"; 

import axios from "axios";
import ProductGrid from "./components/product/ProductGrid";

const backendURL = "http://localhost:8080"; 

class App extends Component {



  state = {
    products:[]
  }


  componentDidMount(){
    axios.get(backendURL)
    .then(res => {
      const theProducts = [...res.data] 
      this.setState({
        products:theProducts
      })
    });
  }

  render(){


    return (
      <ProductGrid products={this.state.products}/>
    );
  }
}

export default App;
