BEGIN;

DROP TABLE IF EXISTS productDepo CASCADE;
CREATE TABLE productDepo (id bigserial PRIMARY KEY, title VARCHAR(255), cost int);
INSERT INTO productDepo (title, cost) VALUES
('milk', 10),
('bread', 20),
('butter', 100),
('cheese', 50),
('coca-cola', 140);
COMMIT;