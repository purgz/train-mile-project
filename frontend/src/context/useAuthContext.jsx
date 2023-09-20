import { useContext } from "react";
import AuthContext from "./AuthProvider";

const useAuthContext = () =>{
    const user = useContext(AuthContext);
    if (user === undefined){
        throw new Error("useAuthContext can only be used inside authprovider");
    } 
    return user;
}

export default useAuthContext;