DROP TABLE order_requests IF EXISTS;
CREATE TABLE order_requests (
  id         INTEGER IDENTITY PRIMARY KEY,
  user_id        VARCHAR(30),
  currency_from  VARCHAR(3),
  currency_to  VARCHAR(3),
  amount_sell    DECIMAL(20, 2),
  amount_buy     DECIMAL(20, 2),
  rate          DECIMAL(20, 4),
  time_placed    TIMESTAMP,
  originating_country  VARCHAR(2)
);
CREATE INDEX order_requests_user_id ON order_requests (user_id);



DROP TABLE order_results IF EXISTS;
CREATE TABLE order_results (
  id         INTEGER IDENTITY PRIMARY KEY,
  user_id        VARCHAR(30),
  order_request_id     INTEGER NOT NULL,
  order_result_status  VARCHAR(10),
  time_executed    TIMESTAMP,
  execution_venue  VARCHAR(10)
);
CREATE INDEX order_results_user_id ON order_results (user_id);
ALTER TABLE order_results ADD CONSTRAINT fk_order_results_order_requests FOREIGN KEY (order_request_id) REFERENCES order_requests (id);





