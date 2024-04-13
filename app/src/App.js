import './App.css';
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import EmployeeComponent from './components/EmployeeComponent';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          {/* // http://localhost:3000 */}
            <Route path='/' element = {<ListEmployeeComponent />}></Route>
            {/* // http://localhost:3000/employees */}
            <Route path='/employees' element = {<ListEmployeeComponent />}></Route>
            {/* // http://localhost:3000/add-employees */}
            <Route path='/add-employee' element = {<EmployeeComponent />}></Route>
            {/* // http://localhost:3000/edit-employee/1 */}
            <Route path='/edit-employee/:id' element = {<EmployeeComponent />}></Route>
        </Routes>
      </BrowserRouter>

    </>
  );
}

export default App;
