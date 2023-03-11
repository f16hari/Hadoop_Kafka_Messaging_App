import React from "react";
import Alert from 'react-bootstrap/Alert';
import Badge from 'react-bootstrap/Badge';
import ProgressBar from 'react-bootstrap/ProgressBar';

export function Card(props) {
    const percentage = parseInt((props.count) / props.totalCount * 100)
    return (
        <Alert variant="primary" style={cardStyle}>
            
            <Badge pill bg="primary" style={badgeStyle}>{props.name}</Badge>
            <ProgressBar variant="success" style={progressBarStyle} now={percentage} label={`${percentage}%`}/>
        </Alert>
    );
}

const cardStyle = {
    display:"flex", 
    flexDirection:"row",
}

const badgeStyle = {
    fontSize: "15px",
    marginRight: "10px",
    width: "25%"
}

const progressBarStyle = {
    width: "100%",
    height: "25px"
}