CAP Theorem (Brewer's Theorem)
Definition:
The CAP theorem states that in a distributed data system, it is impossible to simultaneously achieve all three of the following properties:

Consistency (C): Every read receives the most recent write or an error. All nodes see the same data at the same time.

Availability (A): Every request (read or write) receives a response, without a guarantee that it contains the latest data. The system remains operational even during node failures.

Partition Tolerance (P): The system continues to operate despite arbitrary message loss or failure of part of the network.


Why is CAP important?
CAP theorem helps architects and engineers understand the trade-offs when designing distributed systems. It highlights that in the presence of a network partition, a system must choose between consistency and availability.

Scenarios in CAP:
CP (Consistency + Partition Tolerance):

Prioritizes consistency and partition tolerance over availability.

Example: MongoDB (in certain configurations), Redis in master-slave mode.

Use Case: Banking systems where data accuracy is crucial.

AP (Availability + Partition Tolerance):

Prioritizes availability and partition tolerance over consistency.

Example: Cassandra, DynamoDB.

Use Case: Social media systems where uptime is prioritized and eventual consistency is acceptable.

CA (Consistency + Availability):

Prioritizes consistency and availability, but sacrifices partition tolerance.

This scenario is unrealistic in distributed systems since network partitions are unavoidable.

Understanding Partition Tolerance:
Partition tolerance is the ability of the system to continue operating even if some network segments fail or become unreachable. In practice, a system must always tolerate partitions, making the choice effectively between consistency and availability.

Eventual Consistency vs. Strong Consistency:
Eventual Consistency: Data updates will propagate eventually, and all nodes will converge to the same state. Suitable for AP systems.

Strong Consistency: Data is immediately consistent across all nodes, suitable for CP systems.


