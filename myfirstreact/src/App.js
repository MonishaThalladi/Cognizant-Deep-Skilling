import React from 'react';

// Greeting Component with Conditional Rendering
function Greeting(props) {
  const isAdult = props.age >= 18;

  return (
    <div style={{ 
      backgroundColor: isAdult ? '#d4edda' : '#f8d7da',
      padding: '20px',
      borderRadius: '10px',
      margin: '10px 0',
      border: isAdult ? '2px solid #28a745' : '2px solid #dc3545'
    }}>
      <h2>Hello, {props.name}!</h2>
      <p>You are {props.age} years old.</p>
      <p>Status: <strong>{isAdult ? '✅ Adult' : '❌ Minor'}</strong></p>
    </div>
  );
}

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>React Exercise 4: Conditional Rendering</h1>
      
      <Greeting name="John" age="25" />
      <Greeting name="Jane" age="16" />
      <Greeting name="Alice" age="22" />
      <Greeting name="Bob" age="10" />
      
    </div>
  );
}

export default App;
