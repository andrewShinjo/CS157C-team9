import React from 'react';
import Button from '@material-ui/core/Button';
import {useStyles} from './Components/Home.js';
import { useHistory } from "react-router"
import { BrowserRouter, Route, Switch,} from 'react-router-dom';
import Home from './Components/Home';
import ResumePage from './Components/Resume';
import PeerReview from './Components/PeerReview';
import ContactUs from './Components/ContactUs';

const App = () => {
  const classes = useStyles();
  let history = useHistory();
  const routeChange = (path) =>{ 
    history.push(path);
  }


  return(
    <div> 
      <h1 style={{ display: "flex", marginLeft: 40 }}>Resume Reviewer
        <Button style={{ marginLeft: "auto" }}
          className={classes.button}
          variant="contained" 
          color = "secondary"
          onClick = {() => routeChange("/home")}
        >Home</Button>
       
        <Button
          className={classes.button}
          variant="contained" 
          color = "secondary"
          onClick = {() => routeChange("/resume-page")}
        >Resume Page</Button>
      
        <Button
          className={classes.button}
          variant="contained" 
          color = "secondary"
          onClick = {() => routeChange("/peer-review")}
        >Peer Review Page</Button>
        <Button
          className={classes.button}
          variant="contained" 
          color = "secondary"
          onClick = {() => routeChange("/contact-us")}
        >Contact Us</Button>
      </h1>

  <BrowserRouter>
        <Switch>
          <Route path = "/home" component ={Home}>
          </Route>
          <Route path = "/resume-page" component ={ResumePage}>
          </Route>
          <Route  path = "/peer-review" component ={PeerReview}>
          </Route>
          <Route path = "/contact-us" component ={ContactUs}>
          </Route>
        </Switch>
    </BrowserRouter>
  </div>  
  );
}
export default App;
