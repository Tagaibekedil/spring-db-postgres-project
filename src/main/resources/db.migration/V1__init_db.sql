create table  public.idea
(
id                  bigint  primary key,
login               varchar(200) not null,
created_dt          timestamp now(),
last_active_dt      timestamp now(),
is_actual  boolean  true
);