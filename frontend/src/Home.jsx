import AuthContext from "./context/AuthProvider"
import { useNavigate, Link } from "react-router-dom"
import { useContext, useEffect } from "react";
import useAuth from "./hooks/useAuth";
import axios from "./api/axios";

function Home() {

  const {auth} = useAuth();
  const {setAuth} = useContext(AuthContext);
  const navigate = useNavigate();

  //console.log(auth.username, auth.password);

  const getJourneys = async () =>{
    try {

      const res = await axios.get("/journey/journeys/2",
      {
        auth: {
          username: auth.username,
          password: auth.password
        }
      }
      );

      console.log(res.data);
  
    } catch (error) {

      navigate("/unauthorized");
    }
  }

  useEffect(() =>{
    getJourneys();
  })

  return (
    <main>
      HOME PAGE
    </main>
  )
}

export default Home