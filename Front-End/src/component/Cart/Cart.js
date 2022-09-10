import React from 'react';
//import history from '../History';
import Registration from '../Login/Registration';
import "./Cart.css";
import { useHistory } from "react-router-dom";
import { useNavigate } from 'react-router-dom';



export default function Cart({ cartItems, addProduct, removeProduct, clearCart, removeOneProduct }) {
    const totalPrice = cartItems.reduce((price, cartItem) => price + cartItem.quantity * cartItem.price, 0);
    const navigate = useNavigate();
    function Buy() {
        navigate('/login');
    };

    return (
        <div className='cart-item'>
            <h2 className='cart-items-header'> <b>Cart Items</b></h2>
            <div className='clear-Cart'>
                {cartItems.length >= 1 && (
                    <button className='clear-Cart-button' onClick={() => clearCart()}> Clear Cart</button>
                )}

            </div>
            {cartItems.length === 0 && (
                <div className='cart-items-empty'> No items in the cart.</div>
            )}
            <div>
                {
                    cartItems.map((cartItem) => (
                        <div key={cartItem.id} className="cart-items-list">
                            <img className='cart-items-image' src={cartItem.path} alt={cartItem.name} />
                            <div className='cart-items-name'>{cartItem.name}</div>
                            <div className='cart-items-function'>
                                <button className='add' onClick={() => addProduct(cartItem)}>+</button>
                                <button className='remove' onClick={() => removeProduct(cartItem)}>-</button>
                                <button className='remove-all' onClick={() => removeOneProduct(cartItem)}>Remove</button>
                            </div>
                            <div className='cart-items-price'>
                                {cartItem.quantity} * <span>&#8377;</span>{cartItem.price}
                            </div>
                        </div >
                    ))}
            </div>
            <div className='total-price-name'>
                Total Price
                <div className='total-price'> <span>&#8377;</span> {totalPrice}</div>
                <br />
                <button className='Buy' onClick={Buy} >Buy</button>

            </div>
        </div>
    )
}
