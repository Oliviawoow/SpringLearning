DROP INDEX idx_number_integer;
DROP INDEX idx_number_long;
DROP INDEX idx_number_big_decimal;
DROP INDEX idx_boolean_value;
ALTER TABLE samples DROP COLUMN number_integer;
ALTER TABLE samples DROP COLUMN number_long;
ALTER TABLE samples DROP COLUMN number_big_decimal;
ALTER TABLE samples DROP COLUMN boolean_value;
