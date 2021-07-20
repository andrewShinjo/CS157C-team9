import {useStyles} from './Home.js';

const ContactUs= () => {
    const classes = useStyles();
    return (
        <div>
            <h1 className = {classes.centered}>Contact Us:
            </h1>
            <div className = {classes.centered} style = {{fontSize: 20, height:'10vh'}}>
            Martin Nguyen: martin.nguyen02@sjsu.edu 
            <br></br>
            Andrew Shinjo: andrew.shinjo@sjsu.edu
            <br></br>
            Xiang Liu: xiang.liu@sjsu.edu
            </div>
        </div>
    );
}
export default ContactUs