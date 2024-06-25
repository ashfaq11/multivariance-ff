Harness Multivariate Flag:

Multivariate Feature Flags allow you to serve different variations of a flag to multiple user groups at one time. There is no limit to the number of variations that you can add to a multivariate flag, and you can use strings, numbers, or JSON to define the different variants.
In our example, we have created one feature flag with five variations: Multivariate_String. This will return different string values for each variation. The variations are created for CRUD operations for each feature flag:
•	Variation_C: Create
•	Variation_U: Update
•	Variation_R: Read
•	Variation_D: Delete
•	Variation_A: All
Target Users with Flags
Feature Flag targeting allows you to serve a particular variation of a flag to a specific target when the flag is enabled. Targets are anything that can be uniquely identified. We refer to these targets as users, but they could also be apps, machines, resources, emails, etc.
In our example, we have created ten targets. Five targets have been assigned to a group for normal read operations, and five target users are in the admin group with all permissions:
1.	user11@trinet.com
2.	user12@trinet.com
3.	user13@trinet.com
4.	user14@trinet.com
5.	user15@trinet.com
6.	user16@trinet.com
7.	user17@trinet.com
8.	user18@trinet.com
9.	user19@trinet.com
10.	user20@trinet.com
    
Add and Manage Target Groups
Target groups are collections of targets that allow you to serve Feature Flag Variations to a list of users in bulk. You can group targets either by picking individual targets or by defining rules that automatically map targets to a target group.
In our example, we have created two target groups:
1.	Admin_Group
2.	Normal_Group
   
Targets included in each group:
•	Admin_Group
o	user11@trinet.com
o	user12@trinet.com
o	user13@trinet.com
o	user14@trinet.com
o	user15@trinet.com
•	Normal_Group
o	user16@trinet.com
o	user17@trinet.com
o	user18@trinet.com
o	user19@trinet.com
o	user20@trinet.com

Target Specific Users or Groups When a Flag is Changed
In our example, we have two target groups and one feature flag, each with five variations. We are targeting Admin_Group to Variation_A and NonAdmin_Group to Variation_R. Similarly, we can target other variations to any target or target group.
Percentage Rollout
You can select a percentage of targets to be served each variation. For example, to increment how many users have access to a feature over time, you could use a percentage rollout to give 10% of users access to a feature, then 50%, then 100%. The users are selected randomly from the target group you target, and when you increase the percentage, all original users maintain their access to the feature. We can only ensure that identifiable targets maintain their access; we can't maintain access for anonymous users.
In our example, we created one target group named “PercentageRollout_Group” and targeted five users:
1.	user1@trinet.com
2.	user2@trinet.com
3.	user3@trinet.com
4.	user4@trinet.com
5.	user5@trinet.com
The percentage was allocated like 20% for the TRUE variation and 80% for the FALSE variation at the first stage. In this case, only one user will see the TRUE variation, and there will be no change for the rest of the users.

endpoints:

Host:port://User/flag/string-variation?userEmail=user1@trinet.com

Host:port://User/flag/percentage-rollout?userEmail=user1@trinet.com

