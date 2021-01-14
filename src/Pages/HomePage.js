import React from "react"
import MyHeader from "../Components/MyHeader"
import MySearchbar from '../Components/MySearchbar'
import { useState } from 'react'
import {BrowserRouter as Router} from 'react-router-dom'
import posts from '../Components/Titles'
import Filterbar from '../Components/Filterbar'

const filterPosts = (postss, query) => {
    if (!query) {
        return postss;
    }
  
    return postss.filter((post) => {
        const postName = post.name.toLowerCase();
        return postName.includes(query.toLowerCase());
    });
}; 



function HomePage() {
    
    const { search } = window.location
    const query = new URLSearchParams(search).get('s')
    const [searchQuery, setSearchQuery] = useState(query || '')
    const filteredPosts = filterPosts(posts, searchQuery)

  return (
    <Router>
      <div >
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

export default HomePage