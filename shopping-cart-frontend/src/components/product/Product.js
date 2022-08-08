


import "./Product.css"


const product = ({product})=>{

    const imgURL = product.imageURL==null?"/image-not-found.png":product.imageURL;
    return (<div className="card">

        <img src={imgURL} alt={product.description}/>
        <p>
            {product.description}
        </p>

        <p>
            {product.quantity}
        </p>
    </div>) ; 
}


export default product; 

