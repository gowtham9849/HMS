import React from 'react';
import ReactDOM from 'react-dom';
import Dashboard from './src/Login/Dashboard/dashboard';
import Login from './src/Login/Login';

const App = () => {
  return (
    <div>
      <Dashboard />
      <Login />
    </div>
  );
};

ReactDOM.render(<App />, document.getElementById('root'));
