insert into user values (10, now(), "Tamir");
insert into admin (userid) values (10);

insert into cs544ec.user values(20, now(), "Jack");
insert into cs544ec.volunteer values (20);

insert into cs544ec.user values(30, now(), "John");
insert into cs544ec.volunteer values (30);

insert into cs544ec.project values(10, "this is description", NOW() + INTERVAL 10 DAY, "Fairfield, IA", NOW() - INTERVAL 10 DAY, "INPROGRESS", 10);

insert into cs544ec.project values(20, "this is description 20", NOW() + INTERVAL 20 DAY, "Fairfield, IA", NOW() - INTERVAL 20 DAY, "NOTSTARTED", 10);

insert into cs544ec.admin_project values (10, 10);
insert into cs544ec.admin_project values (10, 20);

insert into cs544ec.beneficiary values (10, "this is information 10");
insert into cs544ec.beneficiary values (20, "this is information 20");

insert into cs544ec.project_beneficiary values (10, 10);
insert into cs544ec.project_beneficiary values (20, 20);

insert into cs544ec.task values(10, NOW() + INTERVAL 10 DAY, NOW() - INTERVAL 10 DAY, "NOTSTARTED", 10, 20);
insert into cs544ec.task values(20, NOW() + INTERVAL 20 DAY, NOW() - INTERVAL 20 DAY, "NOTSTARTED", 10, 30);
insert into cs544ec.task values(30, NOW() + INTERVAL 30 DAY, NOW() - INTERVAL 30 DAY, "NOTSTARTED", 20, 20);
insert into cs544ec.task values(40, NOW() + INTERVAL 40 DAY, NOW() - INTERVAL 40 DAY, "NOTSTARTED", 20, 30);

insert into cs544ec.task_resources values(10, 10, "VOLUNTEER");
insert into cs544ec.task_resources values(20, 20, "VOLUNTEER");
insert into cs544ec.task_resources values(30, 30, "VOLUNTEER");
insert into cs544ec.task_resources values(40, 40, "VOLUNTEER");

insert into cs544ec.volunteer_task values(20, 10);
insert into cs544ec.volunteer_task values(30, 20);