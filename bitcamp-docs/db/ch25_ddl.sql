-- 게시판 테이블 삭제
drop table x_board if exists x_board;

-- 게시물 첨부파일 테이블 삭제
drop table x_board_file if exists x_board_file restrict;

--게시판 테이블 생성
create table x_board (
	board_id int not null primary key auto_increment,
	title varchar(255) not null,
	contents text not null,
	created_date datetime default now(),--지금 날짜로 값을 고정한다.
	view_count int null default 0--0으로 값을 고정한다.
);

-- 게시물 첨부파일 테이블 생성
create table x_board_file (
  board_file_id int not null primary key auto_increment,
  file_path varchar(255) not null,
  board_id int not null,
  constraint fk_board_file foreign key (board_id) references x_board(board_id)
);


--게시물 처
insert into x_board_file(board_file_id, file_path, board_id) 
values(101, 'a1.gif', 1);
insert into x_board_file(board_file_id, file_path, board_id) 
values(102, 'a2.gif', 1);
insert into x_board_file(board_file_id, file_path, board_id) 
values(103, 'a3.gif', 1);

insert into x_board_file(board_file_id, file_path, board_id) 
values(104, 'b1.gif', 2);
insert into x_board_file(board_file_id, file_path, board_id) 
values(105, 'b2.gif', 2);

insert into x_board_file(board_file_id, file_path, board_id) 
values(106, 'c1.gif', 3);
insert into x_board_file(board_file_id, file_path, board_id) 
values(107, 'c2.gif', 3);
insert into x_board_file(board_file_id, file_path, board_id) 
values(108, 'c3.gif', 3);
insert into x_board_file(board_file_id, file_path, board_id) 

values(109, 'd1.gif', 4);
insert into x_board_file(board_file_id, file_path, board_id) 

values(108, 'e1.gif', 5);
insert into x_board_file(board_file_id, file_path, board_id) 


--데이터 입력
insert into x_board(, title, contents) 
values(1, '제목1', '내용');

insert into x_board( title, contents) 
values(2, '제목2', '내용');

insert into x_board(title, contents) 
values(3, '제목3', '내용');

insert into x_board(title, contents) 
values(4, '제목4', '내용');

insert into x_board(title, contents) 
values('제목5', '내용');

insert into x_board(title, contents) 
values(5, '제목6', '내용');

insert into x_board(title, contents) 
values(6, '제목7', '내용');

--데이터 조회
--*--다주고 싶을 때
select																												
	board_id,
	title,
	created_date
from
x_board
order by board_id desc;


select																												
	board_id,
	title,
	contents,
	created_date,
	view_count
from
x_board
where
board_id = 3;
 --board_id = 1 and title = '제목3';
 
--데이터 변경
update x_board set
	view_count = view_count + 1,
	created_date = now()
where
	board_id = 3;
	
	
	--데이터 삭제
	delete from x_board
	where
	board_id = 3;
	
	--게시물 데이터와 첨부파일 데이터를 함께 조회하기
	--from  ~ : 다 나와야 하는 테이블
	select
	b.board_id,
	b.title,
	b.contents,
	b.created_date,
	b.view_count,
	f.board_file_id,
	f.file_path,
	from x_board b
		left outer join x_board_file f on b.board_id = f.board_id
	where 
		b.board_id = 1;
		
