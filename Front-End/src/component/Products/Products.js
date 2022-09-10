import React from 'react';
import "./Products.css";

export default function Products({ productItems, addProduct }) {
  return (
    <div className='products'>
      {
        productItems.map((productItem) => (
          <div className='card'>
            <div>
              <img className='product-image'
                src={productItem.path} alt={productItem.name} />
              <h3 className='products-name'> {productItem.name}</h3>
              <h3 className='products-price'> <span>&#8377;</span>{productItem.price}</h3>
            </div>
            <div>
              <button className='product-add-button' onClick={() => addProduct(productItem)}>Add to Cart</button>
            </div>
          </div>
        ))
      }
    </div>
  )
}
