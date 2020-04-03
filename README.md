## DB設定

- データベース名：notice_board
- テーブル
	- users
	- messages
	- comments
	- branches
	- positions
- ユーザーIDとパスワード：mvc-config.xmlを編集してください

## DDL
```
-- usersテーブル
create table users (
	id integer primary key auto_increment,
	login_id varchar(20) not null unique,
	password varchar(255) not null,
	name varchar(10) not null,
	branch_id integer not null,
	position_id integer not null,
	is_working tinyint not null,
	created_at timestamp not null,
	updated_at timestamp not null
);

-- messagesテーブル
create table messages (
	id integer primary key auto_increment,
	user_id integer not null,
	subject varchar(30) not null,
	text varchar(1000) not null,
	category varchar(10) not null,
	created_at timestamp not null,
	updated_at timestamp not null
);

-- commentsテーブル
create table comments (
	id integer primary key auto_increment,
	user_id integer not null,
	message_id integer not null,
	text varchar(500) not null,
	created_at timestamp not null,
	updated_at timestamp not null
);

-- branchesテーブル
create table branches (
	id integer primary key auto_increment,
	name varchar(20) not null,
	created_at timestamp not null,
	updated_at timestamp not null
);

-- positionsテーブル
create table positions (
	id integer primary key auto_increment,
	name varchar(20) not null,
	created_at timestamp not null,
	updated_at timestamp not null
);
```

```
-- 部署作成
insert into branches (name, created_at, updated_at) values ('本社', current_timestamp,  current_timestamp);
insert into branches (name, created_at, updated_at) values ('A支社', current_timestamp,  current_timestamp);
insert into branches (name, created_at, updated_at) values ('B支社', current_timestamp,  current_timestamp);
insert into branches (name, created_at, updated_at) values ('C支社', current_timestamp,  current_timestamp);

-- 役職作成
insert into positions (name, created_at, updated_at) values ('総務人事部', current_timestamp,  current_timestamp);
insert into positions (name, created_at, updated_at) values ('情報管理部', current_timestamp,  current_timestamp);
insert into positions (name, created_at, updated_at) values ('営業部', current_timestamp,  current_timestamp);
insert into positions (name, created_at, updated_at) values ('技術部', current_timestamp,  current_timestamp);

-- 管理者
insert into users (login_id, password, name, branch_id, position_id, is_working, created_at, updated_at) values ('adminuser', 'BhocDqIOa12QrOPA2HkwS1LHUe9T5izPFZ4fsh2VTC8=', 'adminuser', 1, 1, 1, current_timestamp, current_timestamp);
