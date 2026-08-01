import React, { createContext, useState, useContext } from 'react';

// Create Theme Context
const ThemeContext = createContext();

// Theme Provider
function ThemeProvider({ children }) {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme(theme === 'light' ? 'dark' : 'light');
  };

  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      {children}
    </ThemeContext.Provider>
  );
}

// Custom Hook to use Theme
function useTheme() {
  return useContext(ThemeContext);
}

// Themed Component
function ThemedComponent() {
  const { theme, toggleTheme } = useTheme();

  const styles = {
    light: {
      backgroundColor: '#ffffff',
      color: '#000000',
      border: '2px solid #ddd'
    },
    dark: {
      backgroundColor: '#333333',
      color: '#ffffff',
      border: '2px solid #666'
    }
  };

  return (
    <div style={styles[theme]}>
      <h2>Themed Component</h2>
      <p>Current Theme: <strong>{theme}</strong></p>
      <button 
        onClick={toggleTheme}
        style={{
          padding: '10px 20px',
          backgroundColor: theme === 'light' ? '#333' : '#fff',
          color: theme === 'light' ? '#fff' : '#333',
          border: 'none',
          borderRadius: '4px',
          cursor: 'pointer'
        }}
      >
        Switch to {theme === 'light' ? 'Dark' : 'Light'} Theme
      </button>
    </div>
  );
}

function App() {
  return (
    <ThemeProvider>
      <div style={{ padding: '20px', fontFamily: 'Arial', maxWidth: '600px', margin: '0 auto' }}>
        <h1>React Exercise 13: Context API</h1>
        <ThemedComponent />
      </div>
    </ThemeProvider>
  );
}

export default App;
