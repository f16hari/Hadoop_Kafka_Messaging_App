import React, { Fragment, useState } from "react";
import { Card } from "../Components/Card";
import { Toolbar } from "../Components/Toolbar";

export function Dashboard() {
  const [wordCounts, setWordCounts] = useState([
    { word: "Twitter", count: 12 },
    { word: "Elon", count: 10 },
  ]);
  const [totalCount, setTotalCount] = useState(22)

  return (
    <Fragment>
      <h3>Dashboard</h3>
      <Toolbar></Toolbar>
      <hr></hr>
      <div>
        {wordCounts.map((wordCount) => ( <Card name={wordCount.word} count={wordCount.count} totalCount={totalCount}/>))}
      </div>
    </Fragment>
  );
}

function fetchWordCounts(noOfWordsToFetch){
  console.log("Fetching Word Counts...");
}

function fetchTotalNumberOfWords(){
  console.log("Fetching totatl number of words...");
}