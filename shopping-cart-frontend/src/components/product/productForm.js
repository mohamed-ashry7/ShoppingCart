import React from "react";

const productForm = ({submitForm}) => {
  return (
      <form onSubmit={submitForm}>
        <div className="form-group">
          <label >Code</label>
          <input
            type="text"
            className="form-control"
            placeholder="Code"
          />
        </div>
        
        <div className="form-group">
          <label >Description</label>
          <textarea
            type="text"
            className="form-control"
            placeholder="Description"
          />
        </div>
        <div className="form-group">
          <label >Image URL</label>
          <input
            type="text"
            className="form-control"
            placeholder="Image URL"
          />
        </div>
        <div className="form-group">
          <label >Quantity</label>
          <input
            type="number"
            className="form-control"
            placeholder="Quantity"
          />
        </div>
        <div className="form-group">
          <label >Price</label>
          <input
            className="form-control"
            placeholder="Price"
          />
        </div>
        

        <button type="submit" className="btn btn-default" >
          Submit
        </button>
      </form>
  );
};



export default productForm ;