use df0044a4674554a49bbdf4611e80763cc;
drop table if exists users;
create table users
(
   uid                 int not null auto_increment,
   uname           varchar(200),
   upwd              varchar(200),
   primary key (uid)
)
charset=utf8 ENGINE=InnoDB;

INSERT INTO users(uname, upwd) VALUES("ykz1", "198525");
INSERT INTO users(uname, upwd) VALUES("ykz2", "198525");
INSERT INTO users(uname, upwd) VALUES("ykz3", "198525");
INSERT INTO users(uname, upwd) VALUES("ykz4", "198525");
INSERT INTO users(uname, upwd) VALUES("ykz5", "198525");
INSERT INTO users(uname, upwd) VALUES("ykz6", "198525");
INSERT INTO users(uname, upwd) VALUES("ykz7", "198525");
INSERT INTO users(uname, upwd) VALUES("ykz8", "198525");
INSERT INTO users(uname, upwd) VALUES("ykz9", "198525");
