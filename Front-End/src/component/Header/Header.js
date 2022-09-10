import React from 'react'
import { Link } from "react-router-dom";
import "./Header.css";
export default function Header({ cartItems, ls, loginStatus,clearCart }) {
    function logout() {
       // LoginStatus({"abc":1});
        console.log(ls);
        loginStatus();
    }
    return (
        <header className='header'>
            <div>
                <h1>
                    <Link to="/" className='logo' >
                        Shopping Site
                    </Link>
                </h1>
            </div>
            <div className='header-links'>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                </ul>
                <ul>
                    <li>
                        <Link to="/cart" className='cart'>
                            <i class="fas fa-shopping-cart" />
                            Cart
                            <span className='cart-length'>
                                {cartItems.length === 0 ? "" : cartItems.length} </span> </Link>
                    </li>
                </ul>
                <ul className='login'>
                    {!ls ?
                        <>
                            <li>
                                <Link to="/login">LogIn</Link>
                            </li>
                            <li>
                                <Link to="/signup">SignUp</Link>
                            </li>
                        </> :
                        <button onClick={logout} className='logout'>Logout</button>
                    }
                </ul>
            </div>

        </header>
    )
}
