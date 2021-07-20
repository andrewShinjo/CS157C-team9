import React, { useState } from 'react';
import ToggleButton from '@material-ui/lab/ToggleButton';
import ToggleButtonGroup from '@material-ui/lab/ToggleButtonGroup';

const ScoreHandler = () => {
    const [score, setScore] = useState();

    const handleScore = (event, newScore) => {
      setScore(newScore);
    };

    return (
        <ToggleButtonGroup 
            value = {score}
            exclusive
            //size="large" 
            color="primary" 
            onChange = {handleScore}
            style = {{marginLeft: window.innerWidth * .1, height: '6vh'}}
            >
                <ToggleButton 
                value = '5'
                style = {{width: '4vw'}}
                >5</ToggleButton>
                <ToggleButton 
                value = '4'
                style = {{width: '4vw'}}
                >4</ToggleButton>
                <ToggleButton 
                value = '3'
                style = {{width: '4vw'}}
                >3</ToggleButton>
                <ToggleButton 
                value = '2'
                style = {{width: '4vw'}}
                >2</ToggleButton>
                <ToggleButton 
                value = '1'
                style = {{width: '4vw'}}
                >1</ToggleButton>
             </ToggleButtonGroup> 
    )
}


export default ScoreHandler