import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Cart from '../Cart/Cart'
import Login from '../Login/Login'
import Registration from '../Login/Registration'
import Products from '../Products/Products'

export default function Routee({loginUpdate,productItems,cartItems,addProduct,removeProduct,clearCart,removeOneProduct,loginStatus}) {
  return (
    <div>
        <Routes>
          <Route path="/" element={<Products productItems={productItems} addProduct={addProduct}/>}/>
          <Route path="/login" element={<Login loginStatus={loginStatus} loginUpdate={loginUpdate} />}/>
          <Route path="/signup" element={<Registration cartItems={cartItems} />}/>
          <Route path="/cart" element={<Cart cartItems={cartItems} addProduct={addProduct} removeProduct={removeProduct} removeOneProduct={removeOneProduct} clearCart={clearCart}/>}/>
        </Routes>
        </div>
  )
}
