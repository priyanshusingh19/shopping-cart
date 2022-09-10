import React ,{useState,useEffect} from 'react'
//import {useHistory} from 'react-router-dom'
import "./Registration.css";
import axios from 'axios';

export default function Registration({cartItems}) {
    const[name,setName] = useState("");
    const[emailId,setEmail] = useState("");
    const[password,setPassword] = useState("");



   async function SignUp()
    {
       // alert("hey")
      //  console.log("fyyjvhvlk"); 
        let item={name,emailId,password};
     //   console.log(item); 
        //alert("hiiiii")

     /*  let resultr = await fetch("http://localhost:9000/user/registration" ,{
            method:'POST',
            body:JSON.stringify(item),
            headers:{
            "Content-Type":'application/json',
            "Accept":'application/json'
            }
        })
       // alert("wait")
        console.log("submit");
*/
        axios.post("http://localhost:9000/user/registration",{
          emailId:emailId,
          password:password,
          name:name
      }).then(result=>{
          console.log(result)
          
         // console.log(result.data.message)
         // console.log(result.data.token)
         axios.post("http://localhost:9000/products/addUser",{
          userName:emailId,
          cart:cartItems
      }).then(result=>{
          console.log(result) 
         // console.log(result.data.message)
         // console.log(result.data.token)
      }).catch(
          error=>{
              alert(error)
          }
      )
      }).catch(
          error=>{
              console.log(error)
          }
      )
     // alert("hi");

    };
return (
  <body className='body'>
    <div className="col-sm-6 offset-sm-3">
<form className='form'>
    <label for="name"> Name </label>
    <input type="text" value = {name} onChange={(e)=>setName(e.target.value)} className="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter Your Name" />
    <br />
    <label for="Email">Email address</label>
    <input type="email" value = {emailId} onChange={(e)=>setEmail(e.target.value)} className="form-control" id="Email" aria-describedby="emailHelp" placeholder="Enter email"/>
    <br />
    <label for="Password">Password</label>
    <input type="password" value= {password} onChange={(e)=>setPassword(e.target.value)}  className="form-control" id="Password" placeholder="Password"/>    
    <br />
   <button onClick={SignUp} type="submit" className="btn">Submit</button>
</form>
    </div>
    </body>
  )
}
