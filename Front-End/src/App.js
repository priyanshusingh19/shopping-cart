import './App.css';
import Header from './component/Header/Header';
import Registration from './component/Login/Registration';
import Login from './component/Login/Login';
import data from './component/back/data/data';
import axios from 'axios';
import { BrowserRouter as Router } from "react-router-dom";
import Routee from './component/Routee/Routee';
import { useState ,useEffect } from "react";

function App() {
  const [cartItems, setCartItems] = useState([]);
  const [ls, setLs] = useState(false);
 // const { productItems }=data;
  const [productItems,setProductItems] = useState([]);
  
      useEffect(() => {
        axios.get('http://localhost:9000/products/getAllProducts'
)
.then(Response => {
console.log(Response.data);
setProductItems(Response.data)
}

  ).catch(err=>
    {
    console.log(err);
    alert("no response from server")
    })
       
      }, []);
    

  const [cart, setCart] = useState(cartItems);
  const [token,setToken]=useState("");
  console.log(token);
  const [userName, setUserName] = useState();
  const [name, setName] = useState();
  const [emailId, setEmail] = useState();
  const [password, setPassword] = useState();
  //console.log(productItems);
  //console.log(cartItems);
  
  function LoginUpdate(email,user) {
  setUserName(email);
  console.log(email);
  setEmail(email);
  let str1 = "Bearer ";
  let token = str1+user.token;
  setToken(token);
  let config = {
    headers: {'Authorization': token}
  }
  
  axios.get(`http://localhost:9000/products/findUser/${email}`,config
  )
  .then(Response => {
  //setProductItems(Response.data);
  //setProductItems(Response.data);
  console.log(Response.data.cart);
  setCartItems(Response.data.cart);
  //console.log(cart);
 // alert("check response")
  //setProductItems(Response.data)
  } 
    ).catch(err=>
      {
      console.log(err);
      })



    };

 useEffect(() => {
   setUserName(emailId);
    if(ls)
    {
      console.log(token)
     // alert("hoiii")
      const config = { headers:{"Content-Type": 'application/json',
      "Accept": 'application/json',
      'Authorization': token}};
      axios.put(`http://localhost:9000/products/updateUser/${emailId}`,{"userName":userName,"cart":cartItems},config).then(r=>console.log(r))
  }}, [cartItems]);



   // navigate('/cart');
  function loginStatus() {
    // alert("hiiiiiiiiiiii")
    setLs(current => !current);
    if(!ls)
    {
      clearCart();
    }
    //console.log(ls);
  };
  function clearCart() {
    setCartItems([]);
  };
  

   function removeOneProduct(product) {

     setCartItems(cartItems.filter((item) => item.id !== product.id));

  };

  function addProduct(product) {
    //alert(cartItems.length)
    const ProductExist = cartItems.find((item) => item.id === product.id);
    if (ProductExist) {
       setCartItems(
        cartItems.map((item) => item.id === product.id ?
          {
            ...ProductExist, quantity: ProductExist.quantity + 1
          } : item)
      );
    }
    else {
      setCartItems([...cartItems, { ...product, quantity: 1 }]);
    }
  };

   function removeProduct(product) {
    const ProductExist = cartItems.find((item) => item.id === product.id);
    if (ProductExist.quantity === 1) {
      setCartItems(cartItems.filter((item) => item.id !== product.id));
    }
    else {
      setCartItems(cartItems.map((item) => item.id === product.id ? { ...ProductExist, quantity: ProductExist.quantity - 1 } : item)
      )
    }

     
  };
  return (
    <>
      <Router>
        <Header cartItems={cartItems} ls={ls} loginStatus={loginStatus} clearCart = {clearCart} />
        <Routee loginUpdate={LoginUpdate} loginStatus={loginStatus} productItems={productItems} cartItems={cartItems} addProduct={addProduct} removeProduct={removeProduct} clearCart={clearCart} removeOneProduct={removeOneProduct} />
      </Router>
    </>
  );
}

export default App;
