import React, { useState } from 'react';
import Container from '@material-ui/core/Container';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import RemoveIcon from '@material-ui/icons/Remove';
import AddIcon from '@material-ui/icons/Add';
//import Icon from '@material-ui/core/Icon';
import { v4 as uuidv4 } from 'uuid';

import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
  root: {
    '& .MuiTextField-root': {
      margin: theme.spacing(1),
    },
  },
  button: {
    margin: theme.spacing(1),
  }
}))

function App() {
  const classes = useStyles()
  const [inputFields, setInputFields] = useState([
    { id: uuidv4(), category: 'Objective', description: 'Looking for a Software Engineering Internship for Fall 2021' },
  ]);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("InputFields", inputFields);
  };

  const handleChangeInput = (id, event) => {
    const newInputFields = inputFields.map(i => {
      if(id === i.id) {
        i[event.target.name] = event.target.value
      }
      return i;
    })
    setInputFields(newInputFields);
  }

  const handleAddCategory = () => {
    setInputFields([...inputFields, { id: uuidv4(),  category: '', description: '' }])
  }

  const handleRemoveCategory = id => {
    const values  = [...inputFields];
    values.splice(values.findIndex(value => value.id === id), 1);
    setInputFields(values);
  }
  
  return (
    <Container>
      <h1>Create a Resume</h1>
      <p>Please fill in this form to create a Resume. 
        Enter your information in the form of bullet points in each description. 
        Use the '+' to add more categories to your resume</p>
      <form className={classes.root} onSubmit={handleSubmit}>
        { inputFields.map(inputField => (
          <div key={inputField.id}>
            <TextField
              name="category"
              label="Category"
              variant="filled"
              value={inputField.category}
              onChange={event => handleChangeInput(inputField.id, event)}
            />
            <IconButton disabled={inputFields.length === 1} onClick={() => handleRemoveCategory(inputField.id)}>
              <RemoveIcon />
            </IconButton>
            <IconButton
              onClick={handleAddCategory}
            >
              <AddIcon />
            </IconButton>
            <br></br>
            <TextField
              name="description"
              label="Description"
              style = {{ width: 1100}}
              variant="filled"
              multiline
              value={inputField.description}
              onChange={event => handleChangeInput(inputField.id, event)}
            />
          </div>
        )) }
        <Button
          className={classes.button}
          variant="contained" 
          color="primary" 
          type="submit" 
          //endIcon = {<Icon>send</Icon>}
          onClick = {handleSubmit}
        >Submit</Button>
      </form>
    </Container>
  );
}

export default App;
