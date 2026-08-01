import React, { useState } from 'react';

function App() {
  const [name, setName] = useState('');

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>React Exercise 2: State and Events</h1>
      <input
        type="text"
        placeholder="Enter your name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <p>Hello, {name || 'Guest'}!</p>
    </div>
  );
}

export default App;
