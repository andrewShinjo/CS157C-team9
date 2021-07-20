import Container from '@material-ui/core/Container';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import {useStyles} from './Home.js';
import ScoreHandler from './ScoreHandler.js'
import { useState } from 'react';

const PeerReview= () => {
    const classes = useStyles()

    const [scoreFields, setScoreFields] = useState([
      {category: '', score: '' }
    ]);
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("Ratings", scoreFields);
      };
      
    

  return (
    <Container>
      <h1> Review Resume </h1>
      <p style={{ fontSize: 20 }}>
          Rate each section of the following resume out of 5.
        Add additional comments at the bottom if necessary.</p>
      <form className={classes.root} onSubmit={handleSubmit} >
          <div>      
            <TextField 
              name="category"
              label="Category"
              InputProps={{
                readOnly: true,
              }}
              variant="filled"
              value = "Objective"
            />
            <br></br>
            <TextField
              name="description"
              label="Description"
              InputProps={{
                readOnly: true,
              }}
              style = {{ width: '50vw'}}
              variant="filled"
              multiline
              value = "Looking for SWE Internship" 
            />  
           
           <ScoreHandler>
            </ScoreHandler>

            <br></br> 
            <TextField
              name="category"
              label="Category"
              InputProps={{
                readOnly: true,
              }}
              variant="filled"
              value = "Education"
            />
            <br></br>
            <TextField
              name="description"
              label="Description"
              InputProps={{
                readOnly: true,
              }}
              style = {{ width: '50vw'}}
              variant="filled"
              multiline
              value = "Bachlors of Science, Computer Science at SJSU" 
            />   

            <ScoreHandler>
            </ScoreHandler>
            <br></br>

            <TextField
              name="category"
              label="Category"
              InputProps={{
                readOnly: true,
              }}
              variant="filled"
              value = "Qualifications"
            />
            <br></br>
            <TextField
              name="description"
              label="Description"
              InputProps={{
                readOnly: true,
              }}
              style = {{ width: '50vw'}}
              variant="filled"
              multiline
              value = "Proficient in full stack web development" 
            />  

            <ScoreHandler>
            </ScoreHandler>
            <br></br> 
            <TextField
              name="category"
              label="Category"
              InputProps={{
                readOnly: true,
              }}
              variant="filled"
              value = "Work Experience"
            />
            <br></br>
            <TextField
              name="description"
              label="Description"
              InputProps={{
                readOnly: true,
              }}
              style = {{ width: '50vw'}}
              variant="filled"
              multiline
              value = "CEO of google" 
            />   

            <ScoreHandler>
            </ScoreHandler>
            <br></br>
            <TextField
              name="category"
              label="Category"
              InputProps={{
                readOnly: true,
              }}
              variant="filled"
              value = "Certificates"
            />
            <br></br>
            <TextField
              name="description"
              label="Description"
              InputProps={{
                readOnly: true,
              }}
              style = {{ width: '50vw'}}
              variant="filled"
              multiline
              value = "Cybersecurity certification from SJSU" 
            />  
            <ScoreHandler>
            </ScoreHandler>
          </div>
              <br></br>
          <div>
            <TextField 
            name = "Additional Comments"
            label = "Additional Comments (optional)"
            variant = "outlined"
            style = {{ width: '75vw'}}
            ></TextField>
          </div>
        <Button
          className={classes.button}
          variant="contained" 
          color="primary" 
          type="submit" 
          onClick = {handleSubmit}
        >Submit</Button>
      </form>
    </Container>
  );
}
export default PeerReview