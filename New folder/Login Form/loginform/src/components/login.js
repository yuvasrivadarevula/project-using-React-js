import React, { useState } from 'react';

function Login() {
    const FormStyle = {
        background:'pink',
        padding:'10px',
        width:'200px',
        height:'200px',
        position: 'fixed',
        top: '50%',
        left: '50%',
        'margin-top': '-100px',
        'margin-left': '-100px',
        border:'5px solid red',
    }

    const [user, setUser] = useState({ id: '', password: '' });

    const handleSubmit = (event) => {
      event.preventDefault();
      fetch('http://localhost:9595/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(user),
      })
      .then(response => response.json())
      .then(data => {
        if(data.id!="0"){

            alert('Hi '+data.name+', Login Successfull');
        }else{
            alert('Invalid Password or username, Try again!!');
        }
      })
      .catch(error => console.error('Error creating user:', error));
    };
  
    const handleChange = (event) => {
      const { name, value } = event.target;
      setUser(prevUser => ({ ...prevUser, [name]: value }));
    };
  
    return (
      <form onSubmit={handleSubmit} style={FormStyle}>
        <h1>Login</h1>
        <input
          type="text"
          name="id"
          value={user.id}
          onChange={handleChange}
          placeholder="User ID"
        />
        <input
          type="password"
          name="password"
          value={user.password}
          onChange={handleChange}
          placeholder="Password"
        />
        <button type="submit">Submit</button>
      </form>
    );
}
export default Login;