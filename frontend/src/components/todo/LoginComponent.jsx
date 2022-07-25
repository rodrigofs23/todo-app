import React, { Component } from "react";
import AuthenticationService from "./AuthenticationService.js";

class LoginComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      username: "in28minutes",
      password: "",
      hasLoginFailed: false,
      showSuccessMessage: false,
    };
    this.handleChange = this.handleChange.bind(this);
    this.loginClicked = this.loginClicked.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
  }

  handleSubmit(event) {
    event.preventDefault();
    this.loginClicked();
  }

  loginClicked() {
    AuthenticationService.executeJwtAuthenticationService(
      this.state.username,
      this.state.password
    )
      .then((response) => {
        AuthenticationService.registerSuccessfulLoginForJwt(
          this.state.username,
          response.data.token
        );
        this.props.navigate(`/welcome/${this.state.username}`);
      })
      .catch(() => {
        this.setState({ showSuccessMessage: false });
        this.setState({ hasLoginFailed: true });
      });
  }

  render() {
    return (
      <div>
        <h1>Login</h1>
        <div className="container">
          <form onSubmit={this.handleSubmit}>
            {this.state.hasLoginFailed && (
              <div className="alert alert-warning">Invalid Credentials</div>
            )}
            {this.state.showSuccessMessage && <div>Login Sucessful</div>}
            Username:{" "}
            <input
              type="text"
              name="username"
              value={this.state.username}
              onChange={this.handleChange}
            />
            Password:{" "}
            <input
              type="password"
              name="password"
              value={this.state.password}
              onChange={this.handleChange}
            />
            <button className="btn btn-success" onClick={this.loginClicked}>
              Login
            </button>
          </form>
        </div>
      </div>
    );
  }
}

export default LoginComponent;
