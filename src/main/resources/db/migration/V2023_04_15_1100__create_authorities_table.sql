create table if not exists authorities
(
    id        BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    authority text not null
);
create unique index on authorities (authority);

insert into authorities(authority)
values ('ROLE_USER');