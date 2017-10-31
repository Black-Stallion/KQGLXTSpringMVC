----------Orcale项目实训-----------
---用户表
--drop table Att_Admin
create table Att_Admin(
      AdminID int primary key,
      AdminAccount varchar2(50) not null,
      AdminPwd varchar2(50) not null,
      AdminState number not null,--是否启用此账户
      AdminRight number not null,--是否是超级管理员
      AdminName varchar2(50) not null
)
commit;
--select * from att_admin a inner join att_adminpopedom b on a.adminid=b.adminid where a.adminid =1001;
--select  * from Att_Admin;
insert into Att_Admin(AdminAccount,AdminPwd,AdminState,AdminRight,AdminName)values('dazhuzi','123456',1,1,'徐建柱');
insert into Att_Admin(AdminAccount,AdminPwd,AdminState,AdminRight,AdminName)values('zhuzi','123456',1,0,'建柱');
-----用户权限表
--drop table Att_AdminPopedom
create table Att_AdminPopedom(
       PopedomID int primary key,
       DepartmentID int ,--外键（部门编号）
       AdminID int --外键（用户编号）
)
----用户考勤记录表
--drop table Att_AttendanceRecord
create table Att_AttendanceRecord(
       AttendanceID int primary key,
       EmployeeID int not null,--外键(员工)
       CardNumber varchar2(100) not null,
       AttendanceDate date not null,
       AttendanceTime varchar2(100) not null,
       AttendanceFlag char(1),---(1 上午 2 下午)
       AttendanceType int,---外键（考勤类型表）
       AttendanceMemo varchar2(200),
       AdminID int,--外键（用户）
       TempDepartmentId int,---外键（部门）
       NoteId int ---外键（单据）   
) 
select * from Att_AttendanceRecord
--alter table Att_AttendanceRecord drop column NoteId;
--alter table Att_AttendanceRecord add (NoteId int);
----考勤状态表
--drop table Att_AttendanceType
create table Att_AttendanceType(
       TypeId int primary key,
       TypeName varchar2(20) not null,
       TypeCategory int not null---是否为请假类型（1 是 0 否）
)

-----部门表
--drop table Att_Department
create table Att_Department(
       DepartmentID int primary key,
       DepartmentName varchar2(100) not null,
       StartTimeAM varchar2(20) not null,
       EndTimeAM varchar2(20) not null,
       StartTimePM varchar2(20) not null,
       EndTimePM varchar2(20) not null,
       WeekType number not null,--是否支持礼拜
       ParentID int not null
)
--desc Att_Department;
--alter table Att_Department modify(StartTimeAm varchar(20));
--alter table Att_Department modify(EndTimeAm varchar(20));
--alter table Att_Department modify(StartTimePm varchar(20));
--alter table Att_Department modify(EndTimePm varchar(20));
----员工表
--drop table Att_Employees
select * from Att_Employees
create table Att_Employees(
       EmployeeID int primary key,
       EmployeeName varchar2(100) not null,
       EmployeeGender number not null,---(0女 1 男)
       PositionID int not null,---外键（职务）
       DepartmentID int not null,---外键（部门）
       CardNumber varchar2(100) not null,
       EmployeeStatc char(1) not null,--(员工状态 1 正常 0 停用)
       EmployeeMemo varchar2(200) 
)
-----单据表
--drop table Att_Notes
create table Att_Notes(
       NoteID int primary key,
       DepartmentID int not null,---外键（部门）
       EmployeeID int not null,--外键（员工）
       NoteType int not null,----外键（考勤状态）
       EmployeeIDs varchar2(1000),
       Cause varchar2(1000) not null,
       FillInTime date not null,
       DirectorSign varchar2(200),
       AdministrationSign varchar2(200),
       PresidentSign varchar2(200),
       StartDate date not null,
       StartTime varchar2(50),
       EndDate date not null,
       EndTime varchar2(50),
       Vehicle varchar2(50),
       OvertimeIDs varchar2(200),
       ProjectName varchar2(200),
       AdminID int not null,---外键（用户）
       NoteMemo varchar2(500),
       OperatorID int not null,--外键（员工)
       IsVerify number not null,----(0（审批） 否 1 是)
       isDaoXiu number not null--是否需要倒休 1 是2 否
)

select * from Att_Notes;
insert into Att_Notes(DepartmentID,EmployeeID,NoteType,Cause,FillInTime,DirectorSign,AdministrationSign,
PresidentSign,StartDate,StartTime,EndDate,EndTime,Vehicle,ProjectName,AdminID,OperatorID,IsVerify)values
(1003,1001,1,'出国',to_date('2016-03-25','YYYY-MM-DD'),'同意','同意','同意',to_date('2016-03-26','YYYY-MM-DD'),'下午',to_date('2016-03-30','YYYY-MM-DD'),'下午','轮船','出国','1002','1002',0);
----加班表
--drop table Att_OvertimeRecord
create table Att_OvertimeRecord(
     OvertimeID int primary key,
     EmployeeID int not null,---外键（员工）
     NoteID int not null,---外键（单据）
     OvertimeDate date not null,
     OvertimeFlag char(1) not null,---加班时间段 1 am 2 pm 3 晚上2小时
     OvertimeState char(1)
)
select * from Att_OvertimeRecord;
--alter table Att_OvertimeRecord drop column OvertimeStte;
--alter table Att_OvertimeRecord drop column OperatorID;
--alter table Att_OvertimeRecord add(OvertimeState char(1) not null)
--alter table Att_OvertimeRecord add(isDaoXiu number not null);--0需付费 1 需倒休
---职务表
--select * from Att_Position;
--drop table Att_Position
create table Att_Position(
       PositionID int primary key,
       PositionName varchar2(50) not null 
)


----创建自增
---用户表
--drop sequence seq_Admin
create sequence seq_Admin start with 1001 increment by 1;
--创建触发器
create or replace trigger tri_Admin
before insert on Att_Admin
for each row 
  begin
    select seq_Admin.nextval into :new.AdminID from dual;
  end;
 ---用户权限
-- drop sequence seq_AdminPopedom
 create sequence seq_AdminPopedom start with 1001 increment by 1;
 --触发器
 create or replace trigger tri_AdminPopedom
 before insert on Att_AdminPopedom
 for each row
   begin
     select seq_AdminPopedom.nextval into :new.PopedomID from dual;
   end;
   ---考勤表
 --  drop sequence seq_AttendanceRecord
 create sequence seq_AttendanceRecord start with 1001 increment by 1;
 ---触发器
 create or replace trigger tri_AttendanceRecord
 before insert on Att_AttendanceRecord
 for each row 
   begin
     select seq_AdminPopedom.nextval into :new.AttendanceID from dual;
   end;
 --- 考勤状态
--drop sequence seq_AttendanceType;
 create sequence seq_AttendanceType start with 1 increment by 1;
 ---触发器
 --drop trigger tri_AttendanceType
 create or replace trigger tri_AttendanceType
 before insert on Att_AttendanceType
 for each row 
   begin
     select seq_AttendanceType.nextval into :new.TypeId from dual;
   end;
   --添加数据
insert into Att_AttendanceType(typeName,Typecategory) values ('出勤',0);
insert into Att_AttendanceType(typeName,Typecategory) values ('公休',0);
insert into Att_AttendanceType(typeName,Typecategory) values ('迟到',0);
insert into Att_AttendanceType(typeName,Typecategory) values ('旷工',0);
insert into Att_AttendanceType(typeName,Typecategory) values ('外出',0);
insert into Att_AttendanceType(typeName,Typecategory) values ('出差',0);
insert into Att_AttendanceType(typeName,Typecategory) values ('加班',0);
insert into Att_AttendanceType(typeName,Typecategory) values ('倒休',0);
insert into Att_AttendanceType(typeName,Typecategory) values ('事假',1);
insert into Att_AttendanceType(typeName,Typecategory) values ('病假',1);
insert into Att_AttendanceType(typeName,Typecategory) values ('婚假',1);
insert into Att_AttendanceType(typeName,Typecategory) values ('丧假',1);
insert into Att_AttendanceType(typeName,Typecategory) values ('产假',1);
--select * from Att_AttendanceType
--部门状态
--drop sequence seq_Department
create sequence seq_Department start with 1001 increment by 1;
--触发器
create or replace trigger tri_Department
before insert on Att_Department
for each row
  begin
    select seq_Department.nextval into :new.DepartmentID from dual;
  end;

--员工序列
--drop sequence seq_Employees
create sequence seq_Employees start with 1001 increment by 1;
--触发器
create or replace trigger tri_Employees
before insert on Att_Employees
for each row
  begin
    select seq_Employees.nextval into :new.EmployeeID from dual;
  end;
  --单据表
--  drop sequence seq_Notes
create sequence seq_Notes start with 1001 increment by 1;
--触发器
create or replace trigger tri_Notes
before insert on Att_Notes
for each row
  begin
    select seq_Notes.nextval into :new.NoteID from dual;
  end;
  --加班明细表
  --drop sequence seq_OvertimeRecord
create sequence seq_OvertimeRecord start with 1001 increment by 1;
--触发器
create or replace trigger tri_OvertimeRecord
before insert on Att_OvertimeRecord
for each row
  begin
    select seq_OvertimeRecord.nextval into :new.OvertimeID from dual;
  end;
 --职务表
 --drop sequence seq_Position
create sequence seq_Position start with 1001 increment by 1;
--触发器
create or replace trigger tri_Position
before insert on Att_Position
for each row
  begin
    select seq_Position.nextval into :new.PositionID from dual;
  end;
  -----外键关系
   --alter table Att_AdminPopedom drop constraint fk_Att_AdminPopedom_Att_Admin
alter table Att_AdminPopedom add constraint fk_Att_AdminPopedom_Att_Admin foreign key (AdminID) references Att_Admin(AdminID);
    --  alter table Att_AdminPopedom drop constraint fk_AdminPopedom_Department
alter table Att_AdminPopedom add constraint fk_AdminPopedom_Department foreign key (DepartmentID) references Att_Department(DepartmentID);
    --  alter table Att_AttendanceRecord drop constraint fk_AttendanceRecord_Employees
alter table Att_AttendanceRecord add constraint fk_AttendanceRecord_Employees foreign key (EmployeeID) references Att_Employees(EmployeeID);
    --  alter table Att_AttendanceRecord drop constraint fk_Attendance_AttendanceType ;
alter table Att_AttendanceRecord add constraint fk_Attendance_AttendanceType foreign key (AttendanceType) references Att_AttendanceType(TypeId);
     -- alter table Att_AttendanceRecord drop constraint fk_AttendanceRecord_Admin
alter table Att_AttendanceRecord add constraint fk_AttendanceRecord_Admin foreign key (AdminID) references Att_Admin(AdminID);
     -- alter table Att_AttendanceRecord drop constraint fk_AttendanceRecord_Department
alter table Att_AttendanceRecord add constraint fk_AttendanceRecord_Department foreign key (TempDepartmentId) references Att_Department(DepartmentID);
     -- alter table Att_AttendanceRecord drop constraint fk_AttendanceRecord_Notes
alter table Att_AttendanceRecord add constraint fk_AttendanceRecord_Notes foreign key (NoteId) references Att_Notes(NoteId);
    --  alter table Att_Employees drop constraint fk_Employees_Position
alter table Att_Employees add constraint fk_Employees_Position foreign key (PositionID) references Att_Position(PositionID);
    --  alter table Att_Employees drop constraint fk_Employees_Department
alter table Att_Employees add constraint fk_Employees_Department foreign key (DepartmentID) references Att_Department(DepartmentID);
    --  alter table Att_Notes drop constraint fk_Notes_Department
alter table Att_Notes add constraint fk_Notes_Department foreign key (DepartmentID) references Att_Department(DepartmentID);
      -- alter table Att_Notes drop constraint fk_Notes_Employees 
alter table Att_Notes add constraint fk_Notes_Employees foreign key (EmployeeID) references Att_Employees(EmployeeID);
   -- alter table Att_Notes drop constraint fk_Notes_AttendanceType 
alter table Att_Notes add constraint fk_Notes_AttendanceType foreign key (NoteType) references Att_AttendanceType(TypeId);
    --   alter table Att_Notes drop constraint fk_Notes_Admin
alter table Att_Notes add constraint fk_Notes_Admin foreign key (AdminID) references Att_Admin(AdminID);
     --  alter table Att_Notes drop constraint fk_Notes_Att_Employees
alter table Att_Notes add constraint fk_Notes_Att_Employees foreign key (OperatorID) references Att_Employees(EmployeeID);
     --  alter table Att_OvertimeRecord drop constraint fk_Overtime_Employees
alter table Att_OvertimeRecord add constraint fk_Overtime_Employees foreign key (EmployeeID) references Att_Employees(EmployeeID);
--alter table Att_OvertimeRecord drop constraint fk_Overtime_Employees;
--alter table Att_OvertimeRecord add constraint fk_Overtime_Att_Employees foreign key (OperatorID) references Att_Employees(EmployeeID);
      --  alter table Att_OvertimeRecord drop constraint fk_Overtime_Att_Notes
alter table Att_OvertimeRecord add constraint fk_Overtime_Att_Notes foreign key (NoteID) references Att_Notes(NoteID);
commit




