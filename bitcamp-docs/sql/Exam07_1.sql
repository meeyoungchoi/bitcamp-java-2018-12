/* distinct 와 all */

/* 모든 데이터를 가져온다.*/
select all loc from room;

/* all은 생략할 수 있다*/
select loc from room;

/* 중복 값을 한 개만 추출할 때 distinct 를 붙인다.
 * 중복된건 제거하고 한개만 나온다.*/
select distinct loc from room;  

/* 컬럼이 2 개 이상일 때 
    그 컬럼들의 값이 중복될 경우만 한 개로 간주한다.
    loc와 name 이 똑같으면 그중에 한개만 출력된다.*/
select distinct loc, name from room;
--update test1 set content = 'xxx';
--select distinct title, content from test1;
--title과 content가 중복될경우 그중 한개만 출력해라
--select distinct no, title, content from test1;
