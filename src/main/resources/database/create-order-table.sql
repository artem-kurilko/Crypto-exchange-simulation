create table order(id bigint primary key auto_increment,
                   symbol varchar(25) not null,
                   side varchar(25) not null,
                   quantity varchar(255) not null,
                   price varchar(255) not null,
                   status varchar(100) not null,
                   created_at not null,
                   ?????client_order_id bigint not null,
                   cum_quantity varchar(255));