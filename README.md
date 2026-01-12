# charterwork
Project Name: Retailer Rewards API
Description: 

TechStack:
1. Springboot 3.2.12,
2. Gradle 8.11
3. JDK 23
4. Junit 5

Logic:
•$120 purchase: (120-100)*2 + (100-50)*1 = 40 + 50 = 90 points.
•$80 purchase: (80-50)*1 = 30 points.

API Endpoint:
------------
GET /api/rewards/{customerId}?months=3
ex:
1. http://localhost:8081/api/rewards/CUST001
2. http://localhost:8081/api/rewards/CUST001?months=3


How to Build:
1. Once project is cloned and imported into Intellij, let the import finish,
2. File > Invalidate Caches: Invalidate and restart.
3. from Gradle run: gradle --refresh-dependencies
4. From intellij Idea, run: gradle clean build 

How to Run:
1. Once Build succeeded, edit run configurations as shown in the docs. i named it CharterWork.
2. run the CharterWork and it will run the app on Embedded Tomcat server on port 8081
3.Access the endpoint http://localhost:8081/api/rewards/CUST001

docs:
the /docs/evidences folder contains the screenshots to outputs of G
1. Gradle run
2. Tomcat run
3. Endpoint output from browser (Any)
4. Project settings
5. the /docs/outcome has the request-response screenshot
