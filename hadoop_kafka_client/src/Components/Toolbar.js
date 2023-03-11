import React, { Fragment } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

export function Toolbar(props){
    return (
        <div style={toobarStyle}>
            <Form.Control type="text" placeholder="Enter number of top trending words to fetch" style={noOfWordsToFetchInputStyle}/>
            <Button variant="primary">Refresh</Button>{' '}
        </div>
    );
}

const toobarStyle = {
    display:"flex",
    flexDirection:"row"
} 

const noOfWordsToFetchInputStyle = {
    marginRight: "5px",
    width: "30%"
}