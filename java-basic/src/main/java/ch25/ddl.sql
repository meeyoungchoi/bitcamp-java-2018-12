--기존 테이블 삭제
drop table x_board;

--게시판 테이블 생성
create table x_board (
	board_id int not null primary key auto_increment,
	title varchar(255) not null,
	contents text not null,
	created_date datetime default now(),--지금 날짜로 값을 고정한다.
	view_count int null default 0--0으로 값을 고정한다.
);

--데이터 입력
insert into x_board(title, contents) 
values('제목1', '내용');

insert into x_board( title, contents) 
values('제목2', '내용');

insert into x_board(title, contents) 
values('제목3', '내용');

insert into x_board(title, contents) 
values('제목4', '내용');

insert into x_board(title, contents) 
values('제목5', '내용');

insert into x_board(title, contents) 
values('제목6', '내용');

insert into x_board(title, contents) 
values('제목7', '내용');

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
