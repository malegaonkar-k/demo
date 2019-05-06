



/*
const userAction = async () => {
	  const response = await fetch('http://localhost/movies.json');
	  const myJson = await response.json(); //extract JSON from the http response
	  // do something with myJson
	  console.log(myJson);
	  }
*/

export const userAction = async () => {
    //	let user='user';
    //	let	password='ea74e8e8-c835-4472-a90e-14974b22adef';
    //	let	headers = new Headers();
    //	headers.append('Content-Type','text/json');
    //	headers.append('Authorization', 'Basic ' + (user + ":" + password).toString('base64'));
console.log("rest call ...");
	const response = await fetch('http://localhost:8083/demo/users', {
	    method: 'GET',	 
	  });
	  const myJson = await response.json(); //extract JSON from the http response
	  console.log(myJson);
	}
	console.log("call service");



function   getUser(id){
	 const response=fetch(`http://localhost:8083/demo/users/${id}`, { 
		 method:'GET',
		})
	  .then(function(response) {
			return response.json();
			
	  })
	  .then(function(json) {
	    console.log(json);
	  });
	};

	//get user data
	getUser('1');


