CREATE TABLE IF NOT EXISTS "user"
(
    id                     BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    first_name             TEXT    NOT NULL,
    second_name            TEXT    NOT NULL,
    username               TEXT    NOT NULL,
    email_address          TEXT    NOT NULL,
    password               TEXT    NOT NULL,
    registration_completed BOOLEAN NOT NULL DEFAULT FALSE,
    expired                BOOLEAN NOT NULL DEFAULT FALSE,
    locked                 BOOLEAN NOT NULL DEFAULT FALSE,
    credentials_expired    BOOLEAN NOT NULL DEFAULT FALSE,
    enabled                BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE UNIQUE INDEX ON "user" (email_address);
CREATE UNIQUE INDEX ON "user" (username);