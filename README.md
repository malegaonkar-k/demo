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
###
http://localhost:8083/demo/hi
http://localhost:8083/demo/users/1 --using path parameter
http://localhost:8083/demo/users



