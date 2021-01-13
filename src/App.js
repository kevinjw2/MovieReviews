import './App.css';
import MySearchbar from './Components/MySearchbar'
import { useState } from 'react'
import {BrowserRouter as Router} from 'react-router-dom'
import posts from './Components/Titles'
import MyHeader from './Components/MyHeader'

const filterPosts = (posts, query) => {
  if (!query) {
      return posts;
  }

  return posts.filter((post) => {
      const postName = post.name.toLowerCase();
      return postName.includes(query.toLowerCase());
  });
};

function App() {
  const { search } = window.location
  const query = new URLSearchParams(search).get('s')
  const [searchQuery, setSearchQuery] = useState(query || '')
  const filteredPosts = filterPosts(posts, searchQuery)

  return (
    <Router>
      <div className="App">
        <MyHeader />
        <MySearchbar 
            searchQuery={searchQuery}
            setSearchQuery={setSearchQuery}
        />
        <ul>
          {filteredPosts.map(post => (
            <li key={post.id}>{post.name}</li>
          ))}
        </ul>
      </div>
    </Router>
  );
}

export default App;
