This project permit run the benchmark tas using cassandra as data base.

The cassandra database should be installed as docker instance.

To create a cassandra instance under docker use the next command:

$ docker run --name my-cassandra -d cassandra:3.11

To connect to cassandra command line interface use the next command:

$ docker run -it --link my-cassandra:cassandra --rm cassandra cqlsh cassandra

The structure to be created into cassandra is the next:

-- Temporary transaction structure
CREATE TYPE transaction_fee_type (
    discount_rate decimal,
    per_transaction_fee decimal,
    reserve decimal
);

CREATE TABLE transaction_ (
    id text PRIMARY KEY,
    href text,
    veea_merchant_id text,
    merchant_name text,
    vantiv_mid text,
    amount decimal,
    is_pended boolean,
    transaction_fees frozen<transaction_fee_type>
);


The main.Main class run the test, calling this way on command line:

$ sbt "runMain main.Main"
