import AuthContext from "./context/AuthProvider"
import { useNavigate, Link } from "react-router-dom"
import { useContext, useEffect, useState } from "react";
import useAuth from "./hooks/useAuth";
import axios from "./api/axios";

function Home() {

  const {auth} = useAuth();
  const {setAuth} = useContext(AuthContext);
  const navigate = useNavigate();

  const [apiPath, setApiPath] = useState('');

  //console.log(auth.username, auth.password);

  //want the home page to display all journeys with option to go to each journey in its own induvidual page

  // mock function until proper crud implementation with frontend - just to test the api call
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
    setApiPath("/journey/journeys/");
  },[])
  
  useEffect(() =>{
    getJourneys();
  })

  return (
    <main>
      HOME PAGE
      <hr />
      api route: 
      {apiPath}
    </main>
  )
}

export default Home