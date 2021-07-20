import Container from '@material-ui/core/Container';
import { makeStyles } from '@material-ui/core/styles';


export const useStyles = makeStyles((theme) => ({
  root: {
    '& .MuiTextField-root': {
      margin: theme.spacing(1),
    },
  },
  button: {
    margin: theme.spacing(1),
  },
  
  centered: {
    display: 'flex',  
    fontSize: 24, 
    justifyContent:'center', 
    alignItems:'center',
  }
}))
  

const Home = () => {
    const classes = useStyles();
    return ( 
      <Container>
        <h1 className = {classes.centered} style = {{fontSize: 30, height: '10vh'}}>
            Welcome to Peer Resume Reviewer
        </h1>
        
        <div className = {classes.centered}>
          Below is a list of reviews for your resume
        </div>
            
        <div className = {classes.centered}  style = {{height: '70vh'}}>
          If you haven't already, visit "Resume Page" at the top right to create and submit a resume.
          <br></br><br></br>
          If you've already submitted a resume, check out the peer review page to review other resumes.
          <br></br><br></br>
          For more info, contact us.
        </div>
      </Container>
    );
  
  }
export default Home
