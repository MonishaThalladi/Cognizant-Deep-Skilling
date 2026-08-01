import React, { useState, useEffect } from 'react';

function App() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);

  // Fetch data when component loads
  useEffect(() => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        setPosts(data.slice(0, 10)); // Get only first 10 posts
        setLoading(false);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
        setLoading(false);
      });
  }, []);

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>React Exercise 9: Calling API with Fetch</h1>
      
      {loading ? (
        <p>Loading posts...</p>
      ) : (
        <div>
          <p>Showing {posts.length} posts from JSONPlaceholder API</p>
          {posts.map(post => (
            <div key={post.id} style={{
              backgroundColor: '#f8f9fa',
              padding: '15px',
              margin: '10px 0',
              borderRadius: '8px',
              border: '1px solid #ddd'
            }}>
              <h3>{post.title}</h3>
              <p>{post.body}</p>
              <small>Post ID: {post.id}</small>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default App;
