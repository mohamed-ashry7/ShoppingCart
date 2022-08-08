

import Product from './Product';
import "./ProductGrid.css" ;

const productGrid = ({products})=>{
    return (
        <div className="grid-container">

        {products.map(
          product => (
            <Product product={product} key={product.id}/>
          )
        )}
      </div>
    )
}


export default productGrid ; 