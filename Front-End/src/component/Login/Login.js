import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom';
import "./Registration.css";
import axios  from 'axios';

export default function Login({ loginStatus,loginUpdate }) {
    const navigate = useNavigate();
    //alert("check1");
    const [emaill, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [data, setData] = useState([]);
    useEffect(() => {
        fetch('http://localhost:8000/user')
            .then(
                res =>
                    res.json())
            .then(dataa => setData(dataa));
    }, []);


   // console.log(data);



    function Loginn() {
        axios.post("http://localhost:9000/user/login",{
            emailId:emaill,
            password:password
        }).then(result=>{
           // console.log(result)
            //console.log(result.data.message)
            //console.log(result.data.token)
            loginStatus();
            loginUpdate(emaill,result.data);
            navigate('/');
        }).catch(
            error=>{
                console.log(error)
                alert("Wrong email or password")
            }
        )
        



      /*  const user = data.find((item) => item.email === emaill);
        if (user) {
            if (user.password === password) {
                console.log("login succesful");
                loginStatus();
                loginUpdate(user);

                    navigate('/');
            }
            else {
                alert("wrong password")
                console.log("wrong password");
            }
        }
        else {
            alert("user not found");
            console.log("user not found");
        }

*/

    };


    return (
        <body className='body'> 
        <div className="col-sm-6 offset-sm-3">
            <br /> <h1 className='title'>Login</h1>

            <form className='form' onSubmit={(e) => { e.preventDefault(); /* DO SOMETHING HERE */ }}>

                <label for="Email">Email address</label>
                <input type="email" value={emaill} onChange={(e) => setEmail(e.target.value)} className="form-control" id="Email" aria-describedby="emailHelp" placeholder="Enter email" />
                <br />
                <label for="Password">Password</label>
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} className="form-control" id="Password" placeholder="Password" />
                <br />
                <button onClick={() => { Loginn() }} type="submit" className="btn btn-primary">Login</button>
            </form>
        </div>
        </body>
    )
}
