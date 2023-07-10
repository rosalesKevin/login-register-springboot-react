import {  useState } from "react";
import axios from "axios";
import { Link, useNavigate } from 'react-router-dom';

function Register() {

    let navigate=useNavigate();
  
    const [user,setUser]=useState({
        username:"",
        email:"",
        password:""
    })

    const{username, email, password}=user

    const onInputChange=(e)=> {
        setUser({...user,[e.target.name]:e.target.value})
    }

    const onSubmit=async (e)=>{
        e.preventDefault();
        await axios.post('http://localhost:8080/api/v1/user/register',user)
        navigate('/');
    }


    // async function save(event) {
    //     event.preventDefault();
    //     try {
    //       await axios.post("http://localhost:8080/api/v1/user/regsiter", {
    //       username: username,
    //       email: email,
    //       password: password,
    //       });
    //       alert("User Registation Successfully");

    //     } catch (err) {
    //       alert(err);
    //     }
    //   }
  
    return (
    <div>
    <div class="container mt-4" >
    <div class="card">
            <h1>Student Registation</h1>
    
            <form onSubmit={(e)=>onSubmit(e)}>
                <div className='mb-3'>
                    <label htmlFor='Username' className='form-label'>
                        Username
                    </label>
                    <input 
                    type={"text"}
                    className='form-control'
                    placeholder='Enter your username'
                    name='username'
                    value={username}
                    onChange={(e)=>onInputChange(e)} />
                </div>
                <div className='mb-3'>
                    <label htmlFor='Email' className='form-label'>
                        Email
                    </label>
                    <input 
                    type={"text"}
                    className='form-control'
                    placeholder='Enter your e-mail'
                    name='email'
                    value={email}
                    onChange={(e)=>onInputChange(e)} />
                </div>
                <div className='mb-3'>
                    <label htmlFor='Password' className='form-label'>
                        Password
                    </label>
                    <input 
                    type={"text"}
                    className='form-control'
                    placeholder='Enter your password'
                    name='password'
                    value={password}
                    onChange={(e)=>onInputChange(e)} />
                </div>

                <button type='submit' className='btn btn-outline-primary'>
                    Submit
                </button>
       
      </form>
    </div>
    </div>
     </div>
    );
  }
  
  export default Register;