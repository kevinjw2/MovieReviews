import React from 'react'

const Filterbar = props => {
    return (
        <form action ='#'>
            <div >
        <select name="type">
          <option value="" disabled>
            Genre
          </option>
          <option value="Horror">Horror</option>
          <option value="Spooky">Action</option>
          <option value="Action">Thriller</option>
          <option value="Thriller">Sad</option>
        </select>
            </div>
        </form>
    )
}

export default Filterbar
