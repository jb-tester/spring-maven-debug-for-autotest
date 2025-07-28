## small project to test that spring debugger stops at breakpoints when running Maven Java application in the different ways

#### Prerequisites:

1. make sure that you have the Spring Debugger plugin installed in the idea
2. clone project and import project to idea

##### Steps:
1. put breakpoint to the `test1()` method in the `TestClientService` class
2. run application from idea (Spring Boot run configuration) in the debug mode
3. check that debugger stops at breakpoint
4. open the Threads&Variables tab of the Debug toolwindow:
    - check the 'bean'-like icon the `this` and `builder` nodes have
5. check that the evaluation field has the `Java/Spring Properties` switcher
6. switch to `Spring Properties` and enter `server` in the field
7. check that the completion list shows some properties
8. select`server.port` and check that the evaluated value is `8081`
9. stop the debug session using the stop button in the Debug toolwindow

##### Repeat steps 1-9 for the following configurations:

1. run application from idea (Spring Boot run configuration) in the debug mode with all defaults
2. run application from the Maven toolwindow: select the  `Plugins| spring-boot | spring-boot:run` node and invoke `Debug ...` from its context menu
3. in the `File | Settings | Build, Execution, Deployment | Build Tools | Maven | Runner` switch the `Delegate IDE build/run actions to Maven` checkbox to `true` and run the Spring Boot run configuration again


#### Check the test classes debug:
1. put breakpoint to the `myTest()` method in the `TestClientTest` class
2. start the test debug via the gutter icon in the test class
3. check that the debugger stops at the breakpoint
4. check that the `mockServer` and `testClientService` nodes have the `bean` icon

#####  Repeat steps 1-4 for the following configurations:
1. default settings
2. in the `File | Settings | Build, Execution, Deployment | Build Tools | Maven | Runner` switch the `Delegate IDE build/run actions to Maven` checkbox to `true` and run the test again

[//]: # (3. run the test from the Maven toolwindow: select the  `test` lifecycle node and invoke `Debug ...` from its context menu - this option doesn't work now)