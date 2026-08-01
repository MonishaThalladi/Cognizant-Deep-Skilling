import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import About from './About';
import Contact from './Contact';

function App() {
  return (
    <BrowserRouter>
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>React Exercise 11: React Router</h1>
        
        {/* Navigation */}
        <nav style={{
          backgroundColor: '#f8f9fa',
          padding: '15px',
          borderRadius: '8px',
          marginBottom: '20px'
        }}>
          <Link to="/" style={{ marginRight: '15px', textDecoration: 'none', color: '#007bff' }}>Home</Link>
          <Link to="/about" style={{ marginRight: '15px', textDecoration: 'none', color: '#007bff' }}>About</Link>
          <Link to="/contact" style={{ textDecoration: 'none', color: '#007bff' }}>Contact</Link>
        </nav>

        {/* Pages */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
