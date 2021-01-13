import React from 'react'
import { useHistory } from 'react-router-dom'

const MySearchbar = ({ searchQuery, setSearchQuery }) => {
    const history = useHistory();
    const onSubmit = e => {
        history.push(`?s=${searchQuery}`)
        e.preventDefault()
    };

    return <form action="/" method="get" autoComplete="off" onSubmit={onSubmit}>
        <label htmlFor="header-search">
            <span className="visually-hidden" > Search Movie titles </span> 
        </label>
        <input 
            value={searchQuery}
            onInput={e => setSearchQuery(e.target.value)}
            type ="text"
            id="header-search"
            placeholder="Search Movie Titles"
            name="s"
        />
        <button type ="submit">Search</button>
        <button type ="button">Personal list </button>
    </form>
}

export default MySearchbar
