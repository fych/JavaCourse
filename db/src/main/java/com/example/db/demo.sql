create table `spring-demo`.order_tbl
(
    id        int         not null,
    userId    varchar(32) not null,
    productId int         not null,
    constraint order_tbl_id_uindex
        unique (id)
);

create table `spring-demo`.product_tbl
(
    id    int auto_increment
        primary key,
    name  varchar(64) null,
    type  int         null,
    price int         null
);

create table `spring-demo`.user_tbl
(
    uid    varchar(32)   not null
        primary key,
    name   varchar(32)   null,
    level  int default 0 null,
    points int default 0 null
);

