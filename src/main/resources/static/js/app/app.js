console.log("app");



/*
const userAction = async () => {
	  const response = await fetch('http://localhost/movies.json');
	  const myJson = await response.json(); //extract JSON from the http response
	  // do something with myJson
	  console.log(myJson);
	  }
*/

const userAction = async () => {
	let user='user';
	let	password='ea74e8e8-c835-4472-a90e-14974b22adef';
	let	headers = new Headers();
		headers.append('Content-Type','text/json');
		headers.append('Authorization', 'Basic ' + (user + ":" + password).toString('base64'));
	
	const response = await fetch('http://localhost:8083/demo/users', {
	    method: 'GET',	 
	    headers:headers
	  });
	  const myJson = await response.json(); //extract JSON from the http response
	  console.log(myJson);
	}
userAction();

/*
function getUser(name){
	 fetch(`https://api.github.com/users/${name}`)
	  .then(function(response) {
	    return response.json();
	  })
	  .then(function(json) {
	    console.log(json);
	  });
	};

	//get user data
	getUser('yourUsernameHere');
	*/

/*
function getUser(name){
	 fetch(`http://localhost:8083/demo/users`)
	  .then(function(response) {
	    return response.json();
	  })
	  .then(function(json) {
	    console.log(json);
	  });
	};

	//get user data
	getUser('your');
	
	*/
