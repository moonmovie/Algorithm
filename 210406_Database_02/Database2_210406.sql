use homework;
CREATE TABLE dept
    ( deptno   	INT(4) NOT NULL
    , dname  	VARCHAR(14) NOT NULL
    , loc       varchar(13) NOT NULL
	, primary key(deptno)
    ) engine=InnoDB default charset=utf8;

CREATE TABLE emp
    ( empno    	INT(4) NOT NULL
    , ename  	VARCHAR(10) NOT NULL
    , job       varchar(10) NOT NULL
    , mgr       INT(4) NOT NULL
    , hiredate  datetime default current_timestamp
    , sal      	decimal(7,2) NOT NULL
    , comm      decimal(7,2) NOT NULL
    , deptno    INT(2) NOT NULL
    , primary key(empno)
    , foreign key(deptno) references dept (deptno)
    ) engine=InnoDB default charset=utf8;
    
    commit;
 alter table dept change ioc loc varchar(13);
alter table emp modify mgr int(4); 
 alter table cmp rename emp;
 desc emp;
INSERT INTO dept VALUES 
        ( 10
        , 'Administration'
        , "Oxford"
        );

INSERT INTO dept VALUES 
        ( 20
        , 'Marketing'
        , "Singapore"
        );
                                
INSERT INTO dept VALUES 
        ( 30
        , 'Purchasing'
        , "Chicago"
	);
                
INSERT INTO dept VALUES 
        ( 40
        , 'Resources'
        , "Sydney"
        );

INSERT INTO dept VALUES 
        ( 50
        , 'Shipping'
        , "Beijing"
        );
                
INSERT INTO dept VALUES 
        ( 60
        , 'IT'
        , "Toronto"
        );

INSERT INTO dept VALUES 
        ( 70
        , 'President'
        , "Toronto"
        );   
INSERT INTO dept VALUES 
        ( 80
        , 'Accountant'
        , "Chicago"
        ); 
INSERT INTO emp VALUES 
        ( 100
        , 'jones'
        , 'President'
        , null
        , DATE_FORMAT('1987-10-17', '%Y-%m-%d')
        , 24000
        , 0.8
        , 80
        );

INSERT INTO emp VALUES 
        ( 101
        , 'Neena'
        , 'Accountant'
        , '100'
        , DATE_FORMAT('1989-11-21', '%Y-%m-%d')
        , 17000
        , 0.5
        , 30
        );

INSERT INTO emp VALUES 
        ( 102
        , 'Lex'
        , 'Programmer'
        , 100
        , DATE_FORMAT('1993-04-13', '%Y-%m-%d')
        , 17000
        , 0.8
        , 60
        );

INSERT INTO emp VALUES 
        ( 103
        , 'steven'
        , 'Stock Mgr'
        , 100
        , DATE_FORMAT('1990-01-03', '%Y-%m-%d')
        , 9000
        , 0.4
        , 30
        );

INSERT INTO emp VALUES 
        ( 104
        , 'blake'
        , 'Clerk'
        , 103
        , DATE_FORMAT('1991-05-21', '%Y-%m-%d')
        , 6000
        , 0.3
        , 30
        );

INSERT INTO emp VALUES 
        ( 105
        , 'David'
        , 'Accountant'
        , 103
        , DATE_FORMAT('1997-06-25', '%Y-%m-%d')
        , 4800
        , 0.1
        , 80
        );

INSERT INTO emp VALUES 
        ( 106
        , 'Valli'
        , 'Sales Mgr'
        , 101
        , DATE_FORMAT('1998-09-05', '%Y-%m-%d')
        , 4800
        , 103
        , 80
        );
        
select * from dept;
select * from emp;
-- 1
select e.empno, e.ename, e.job, e.sal, d.loc
from emp e join dept d
on e.deptno = d.deptno
where d.loc="Chicago";
-- 2
select e.empno, e.ename, e.job, e.deptno
from emp e
where e.empno not in(
			select distinct em.mgr
			from emp em join emp m
			on em.mgr = m.empno
);
select * from emp;
-- 3
select e.empno, e.ename, e.job, e.mgr
from emp e
where e.mgr = (
			select m.mgr
			from emp m
			where m.ename = "blake"
);
-- 4
select  e.empno, e.ename, e.job, e.hiredate
from emp e
order by hiredate asc limit 5;

-- 5
select e.ename, e.job, d.dname
from emp e join dept d
on e.deptno = d.deptno
where e.mgr = (
			select m.empno
			from emp m
			where m.ename = "jones"
);