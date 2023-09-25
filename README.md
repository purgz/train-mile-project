# train-mile-project
Spring boot train mileage project. 

Now implemented spring security with custom user details and hibernate.

Rest api to create a train journey based on the crs codes of the stations visited. Then calculates the mileage of the journey and stores in database.

A user can login with spring security http basic authentication and then only retrieve their own journey data unless the user is an admin.

Now working on building a simple frontend using react.js