# Kafta Streams Demo

Use cases
 * Process a log to see what's happening on the web - security application
 * It's also use in data science

kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic test-stream-in  create topic in

kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic test-stream-out create topic out

kafka-topics.sh --list --zookeeper zookeeper:2181  list topics

kafka-console-producer.sh --broker-list localhost:9092 --topic test-stream-in create producer 
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-stream-out --from-beginning create consumer 