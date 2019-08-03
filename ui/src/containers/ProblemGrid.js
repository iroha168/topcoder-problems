import React, {Component} from 'react';
import axios from "axios";

class ProblemGrid extends Component {
  constructor(props) {
    super(props)
    this.state = {data: ""}
  }

   componentDidMount() {
    try {
      axios.get("/api/srmproblems").then(res => this.setState({data: res.data}));
    } catch (error) {
      console.log("error!!");
    }
  }


  render() {
    console.log(this.state.data);
    return (
      <div>
        {[...this.state.data].map(problem=>
        <tr>
          <td><a href="#">SRM {problem.number}</a></td>
          <td><a href="#">Problem 1</a></td>
          <td><a href="#">Problem 2</a></td>
          <td><a href="#">Problem 3</a></td>
        </tr>
        )}
      </div>
    );
  }
}

export default ProblemGrid;
