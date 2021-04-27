

## ReadMe 

####Workers:
We have 3 workers in this project. Worker 1 produces trades' data to FSM thread(worker 2) to consume and process. Worker 2 maintains a 15-sec interval state and push results to client threads(Worker 3) based on the subscriptions.

####Data Structure:
1.Vectors to maintain a synchronize queue space.

2.List to maintain clients' subscriptions.

3.Map to maintain interval trading states.

####Design:
Multithreaded maven projects

### How to set up and run the application:
1.) Create a build by running the command 'mvn clean install'.

2.) copy jar 'trading-application-0.0.1-SNAPSHOT.jar' from target folder and paste it in the execution folder.

3.) Go to execution folder in terminal and run build with trades.json file path & clients.txt file path.

command: "java -jar trading-application-0.0.1-SNAPSHOT.jar  /Users/guest/Desktop/trades.json   /Users/guest/Desktop/clients.txt"

trades.json file path-> Absolute path to trades.json file which contains trading records. Sample file is available under target and src/main/resources folder.

clients.txt file path-> Absolute path to clients.txt file which contains clients details. Sample file is available under target  and src/main/resources folder.

