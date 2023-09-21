import AuthContext from "./context/AuthProvider"
import { useNavigate, Link } from "react-router-dom"
import { useContext } from "react";
import useAuth from "./hooks/useAuth";
import axios from "./api/axios";

function UnauthorizedPage() {


  return (
    <main>
        <h1>Access denied for this resource</h1>

        <hr />

        <Link to={"/"}>Back to login</Link>


    </main>
  )
}

export default UnauthorizedPage