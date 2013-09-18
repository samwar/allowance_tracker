# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table allowance (
  id                        varchar(255) not null,
  allowance                 double,
  remainder                 double,
  start_date                timestamp,
  constraint pk_allowance primary key (id))
;

create table purchase (
  id                        varchar(255) not null,
  amount                    double,
  type                      varchar(255),
  constraint pk_purchase primary key (id))
;

create sequence allowance_seq;

create sequence purchase_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists allowance;

drop table if exists purchase;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists allowance_seq;

drop sequence if exists purchase_seq;

