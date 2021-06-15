create table if not exists car (
    id identity,
    make varchar(100) not null unique,
    model varchar(100) not null,
    dateYear varchar(100) not null,
    image varchar (100) not null
    );
