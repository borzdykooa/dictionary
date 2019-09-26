CREATE DATABASE dictionary_storage;

CREATE DATABASE dictionary_schema;

SET search_path TO dictionary_schema;

CREATE TABLE dictionary_1 (
  word         VARCHAR(50) NOT NULL,
  reference_id BIGINT
);

CREATE TABLE dictionary_2 (
  word         VARCHAR(50) NOT NULL,
  reference_id BIGINT
);

INSERT INTO dictionary_1 (word, reference_id) VALUES
  ('абажур',1),
  ('кинотеатр',2),
  ('самолет',3),
  ('человек',4);

INSERT INTO dictionary_2 (word, reference_id) VALUES
  ('кинотеатр',15),
  ('музыка',16),
  ('самолет',17);
