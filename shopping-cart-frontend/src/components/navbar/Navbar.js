


import { Link } from "react-router-dom";


const navbar =() =>{


    return (
        <nav className="navbar navbar-default navbar-static-top">
          <div className="navbar-header">
            
            <Link className="navbar-brand" to="/">
              Shopping Cart
            </Link>
          </div>
          <div className="container">
            <ul className="nav navbar-nav">
              <li className="active">
                <Link to="productForm">Add Product</Link>
              </li>
            </ul>
          </div>
        </nav>
    )
}


export default navbar;