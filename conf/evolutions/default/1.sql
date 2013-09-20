# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table allowance (
  id                        varchar(255) not null,
  allowance                 float,
  remainder                 float,
  start_date                timestamp,
  constraint pk_allowance primary key (id))
;

create table purchase (
  id                        varchar(255) not null,
  amount                    float,
  purchase_type             varchar(255),
  purchase_date             timestamp,
  allowance_id              varchar(255),
  constraint pk_purchase primary key (id))
;

create sequence allowance_seq;

create sequence purchase_seq;

alter table purchase add constraint fk_purchase_allowance_1 foreign key (allowance_id) references allowance (id) on delete restrict on update restrict;
create index ix_purchase_allowance_1 on purchase (allowance_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists allowance;

drop table if exists purchase;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists allowance_seq;

drop sequence if exists purchase_seq;

