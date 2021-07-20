import Container from '@material-ui/core/Container';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import ButtonGroup from '@material-ui/core/ButtonGroup';
import {useStyles} from './Home.js';


const PeerReview= () => {
    const classes = useStyles()

    const handleSubmit = (e) => {
        e.preventDefault();
        
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
              style = {{ width: window.innerWidth * .5}}
              variant="outlined"
              multiline
              value = "Looking for SWE Internship" 
            />  
           
            <ButtonGroup size="large" color="primary" style = {{marginLeft: window.innerWidth * .1, height: '6vh'}}>
                <Button>5</Button>
                <Button>4</Button>
                <Button>3</Button>
                <Button>2</Button>
                <Button>1</Button>
             </ButtonGroup>

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
              style = {{ width: window.innerWidth * .5}}
              variant="outlined"
              multiline
              value = "Bachlors of Science, Computer Science at SJSU" 
            />   

            <ButtonGroup size="large" color="primary" style = {{marginLeft: window.innerWidth * .1, height: '6vh'}}>
                <Button>5</Button>
                <Button>4</Button>
                <Button>3</Button>
                <Button>2</Button>
                <Button>1</Button>
             </ButtonGroup>
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
              style = {{ width: window.innerWidth * .5}}
              variant="outlined"
              multiline
              value = "Proficient in full stack web development" 
            />  

            <ButtonGroup size="large" color="primary" style = {{marginLeft: window.innerWidth * .1, height: '6vh'}}>
                <Button>5</Button>
                <Button>4</Button>
                <Button>3</Button>
                <Button>2</Button>
                <Button>1</Button>
             </ButtonGroup>
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
              style = {{ width: window.innerWidth * .5}}
              variant="outlined"
              multiline
              value = "CEO of google" 
            />   

            <ButtonGroup size="large" color="primary" style = {{marginLeft: window.innerWidth * .1, height: '6vh'}}>
                <Button>5</Button>
                <Button>4</Button>
                <Button>3</Button>
                <Button>2</Button>
                <Button>1</Button>
             </ButtonGroup>
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
              style = {{ width: window.innerWidth * .5}}
              variant="outlined"
              multiline
              value = "Cybersecurity certification from SJSU" 
            />  

            <ButtonGroup 
            size="large" 
            color="primary" 
            style = {{marginLeft: window.innerWidth * .1, height: '6vh'}}>
                <Button>5</Button>
                <Button>4</Button>
                <Button>3</Button>
                <Button>2</Button>
                <Button>1</Button>
             </ButtonGroup> 
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