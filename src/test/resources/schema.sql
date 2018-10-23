
insert into users (fname, lname, was_born) VALUES ('Сергей', 'Патрушев', 1985-05-15);

select * from users, pet;

CREATE TABLE user_pet
(
  usid int not null,
  p_id int not null,
  primary key (usid,p_id),
  foreign key (usid) references users (us_id),
  foreign key (p_id) references pet (p_id)
);

SELECT u.fname, p.p_name, p.p_type FROM users u NATURAL JOIN pet p;

SELECT users.fname, pet.p_name FROM users, pet natural JOIN user_pet;

select pet.p_name from users, pet where users.fname = 'Егор';


SELECT u.fname, p.p_name
FROM users u
  inner JOIN pet p
    inner JOIN user_pet up
     where up.us_id = u.us_id AND p.p_id = up.p_id;