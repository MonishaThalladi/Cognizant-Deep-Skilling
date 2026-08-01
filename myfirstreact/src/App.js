import React from 'react';

function App() {
  // Array of items
  const fruits = [
    { id: 1, name: 'Apple', color: 'Red' },
    { id: 2, name: 'Banana', color: 'Yellow' },
    { id: 3, name: 'Orange', color: 'Orange' },
    { id: 4, name: 'Grapes', color: 'Purple' },
    { id: 5, name: 'Mango', color: 'Yellow' },
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>React Exercise 5: Lists and Keys</h1>
      
      <h2>Fruits List</h2>
      <ul style={{ listStyleType: 'none', padding: 0 }}>
        {fruits.map((fruit) => (
          <li key={fruit.id} style={{
            backgroundColor: '#f0f8ff',
            padding: '12px',
            margin: '8px 0',
            borderRadius: '8px',
            border: '2px solid #007bff'
          }}>
            <strong>{fruit.name}</strong> - Color: {fruit.color}
          </li>
        ))}
      </ul>
      
      <p>Total Fruits: <strong>{fruits.length}</strong></p>
    </div>
  );
}

export default App;
