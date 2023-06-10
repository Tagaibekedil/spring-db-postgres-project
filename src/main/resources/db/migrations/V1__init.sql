create table  public.ideas
(
id              bigint   primary key ,
idea_text       varchar(200),
user_id         int,
created_dt      timestamp default now(),
last_active_dt  timestamp default now()
);
insert into public.ideas (id,idea_text,user_id,last_active_dt) VALUES (1,'ides',1,'2009-06-04 22:00:00'),(2,'test',1,'2009-06-04 22:00:00');

create table public.users
(
    id          bigint primary key ,
    login       varchar(20),
    email       varchar(20),
    first_name   varchar(50),
    last_name    varchar(50),
    birth_date   timestamp,
    last_active_dt  timestamp default now(),
    is_actual    boolean default true,
    created_dt   timestamp default now()

);insert into public.users(id, login, email, first_name, last_name)
                           VALUES    (1,'test','email@email','test1','testov1' );


/*
 private Long id;

        private String login;

        private String email;

        private String firstName;

        private String lastName;

        private LocalDate birthDate;

        private LocalDateTime Last_active_dt;

        private boolean is_actual;

        private LocalDateTime createdDt;

 */
