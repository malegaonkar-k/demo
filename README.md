"#demo "

# spring boot + spring jpa data rest services demo.
# used H2 embended database configuration setting as well mysql db configuration.
# maven configured plugin with custom jdk compiler(OpenJDK win_x64\zulu8.38.0.13-ca-jdk8.0.212-win_x64).
# Every build follows a specified	life cycle. Maven comes with a default life cycle that includes the most common build phases like compiling, testing and packaging.

The following lists gives an overview of the important Maven life cycle phases.

validate - checks if the project is correct and all information is available

compile - compiles source code in binary artifacts

test - executes the tests

package - takes the compiled code and package it, for example

integration-test - takes the packaged result and executes additional tests, which require the packaging

verify - performs checks if the package is valid

install - install the result of the package phase into the local Maven repository

deploy - deploys the package to a target, i.e. remote repository

###
users/seekers
users/providers
users/agents
### api
http://localhost:8083/demo/hi<br>
http://localhost:8083/demo/users/1 --using path parameter<br>
http://localhost:8083/demo/users<br>

### Exception handling in spring boot rest
1. defualt exception/error handling : by spring boot return response but on console exception stack trace will be printed  with exception message ie. of in built exception or custom exception, under the hood uses springs DefaultErrorController which extends AbstractErrorController<br>
 =>  this will handle custom as well as inbuilt exception thrown from controller.
 =>  we can add global exception handler using @ControllerAdvice to the exception handling class which will be extending from ResponceEntityExceptionHandler 
 and provide different methods for different exception annoteted with <br>
 this will response 404-not found with not stack trace on console.<br>
 @ExceptionHandler(CustomException.class)<br>
Example like <br>
	
    @ControllerAdvice
	public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    // Let Spring BasicErrorController handle the exception, we just override the status code
    @ExceptionHandler(BookNotFoundException.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
    }



### JSR 303 Validation error
#### 3.1 For Spring @valid validation errors, it will throw handleMethodArgumentNotValid
 on method @valid RequestBody, @validate on controller class