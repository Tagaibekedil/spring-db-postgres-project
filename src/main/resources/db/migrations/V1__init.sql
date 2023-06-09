create table  public.ideas
(
id              bigint   primary key ,
idea_text       varchar(200),
user_id         int,
created_dt      timestamp default now(),
last_active_dt  timestamp default now()
);
insert into public.ideas (id,idea_text,user_id) VALUES (1,'ides',1)
