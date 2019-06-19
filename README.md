## DB設定

- データベース名：notice_board
- テーブル
	- users
	- messages
	- comments
	- branches
	- positions

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
