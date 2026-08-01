import React from 'react';

// Greeting Component - Accepts props
function Greeting(props) {
  return (
    <div style={{ 
      backgroundColor: '#f0f8ff',
      padding: '20px',
      borderRadius: '10px',
      margin: '10px 0'
    }}>
      <h2>Hello, {props.name}!</h2>
      <p>You are {props.age} years old.</p>
      <p>Welcome to React Components!</p>
    </div>
  );
}

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>React Exercise 3: Components and Props</h1>
      
      <Greeting name="John" age="25" />
      <Greeting name="Jane" age="30" />
      <Greeting name="Alice" age="22" />
      
    </div>
  );
}

export default App;
