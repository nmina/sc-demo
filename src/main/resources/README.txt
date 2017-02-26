Importing Cassandra sample keyspace and creates a table under the specified keyspace
* to import cqlsh-file-import.txt into your cassandra instance,
  make sure you have a cassandra server running. If you don't, execute
  ~/Cassandra-home/bin/cassandra

* next, execute the following cqlsh command:
  > cqlsh --file=/path/to/cqlsh-file-import.txt

* Note that the command will not generate any success message when its done. To verify, enter the cqlsh command, and
  execute the following:
  > DESCRIBE KEYSPACES
    - you should see the keyspace from cqlsh-file-import.txt listed in there.

* To further verify the data, execute the following inside cqlsh:
  > DESCRIBE KEYSPACE <keyspace name>