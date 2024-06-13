import React from 'react'
import './Login.css'

import { useState } from 'react'

const Login = () => {

  const[image,setimage]  = useState(false)

  const[currstate,setcurrstate] = useState("Login")

  return (

    <center> <div className='Login'>
    <form>
      <div className="login-tittle">
      <h2>{currstate}</h2>
      </div>
      <div className="login-input">

      {currstate==="Login"?<></>
      :<><p>Full Name</p><input type='text' placeholder='Full Name' required /></>}

      <p>Email</p>
      <input type='text' placeholder='Email' required />

      <p> Password</p>
      <input type='text' placeholder=' Password' required />

      {currstate==="Login"?<></>
      :<><p>Contact Number</p><input type='text' placeholder='Number' required /></>}
     

      {currstate==="Login"?<></>
        :<><p> Address</p><textarea placeholder=' Address' id='myTextarea' required ></textarea></>}
      <br/>
      <button type='submit' className='add-btn'>{currstate}</button>
      
            {currstate==="Login"
            ?<p>Create a New Account? <span onClick={()=>setcurrstate("Sign Up")}>Click Here</span></p>
            :<p>Already have An Account? <span onClick={()=> setcurrstate("Login")}>Login Here</span></p>
            }
            {/* onChange={(e) => setphoneNo(e.target.value) } */}
      </div>
    </form>
</div></center>
   
  )
}

export default Login