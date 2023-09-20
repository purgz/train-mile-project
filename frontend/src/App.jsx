import './App.css'
import Login from './Login'
import {Outlet, Routes, Route} from "react-router-dom";
import Home from './Home';
import RequireAuth from './RequireAuth';

function App() {
  

  return (

    <Routes>
      
        <Route path = "/" element = {<Outlet/>}>

            <Route path="login" element = {<Login/>}></Route>

            <Route element={<RequireAuth/>}>
              <Route path = "/home" element = {<Home/>}></Route>
            </Route>
        </Route>

    </Routes>
  )
}

export default App
