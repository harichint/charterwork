# charterwork
Project Name: Retailer Rewards API
Logic:
•$120 purchase: (120-100)*2 + (100-50)*1 = 40 + 50 = 90 points.
•$80 purchase: (80-50)*1 = 30 points.

API Endpoint:
GET /api/rewards/{customerId}?months=3

How to Run:
1. ./gradlew bootRun
2. 2.Access http://localhost:8080/api/rewards/CUST001
