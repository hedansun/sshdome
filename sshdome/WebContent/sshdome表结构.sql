---------------------------------------------
-- Export file for user SCOTT              --
-- Created by sp.hed on 2014-4-1, 11:20:05 --
---------------------------------------------

spool dome��ṹ.log

prompt
prompt Creating table T_COMMENT
prompt ========================
prompt
create table T_COMMENT
(
  id             NUMBER(20) not null,
  userid         NUMBER(20),
  contentid      NUMBER(20),
  commentcontent VARCHAR2(1000),
  datetime       DATE default (sysdate)
)
;
comment on table T_COMMENT
  is '���۱�';
comment on column T_COMMENT.userid
  is '�û���id';
comment on column T_COMMENT.contentid
  is '���ݱ�id';
comment on column T_COMMENT.commentcontent
  is '��������';
comment on column T_COMMENT.datetime
  is '����ʱ��';
alter table T_COMMENT
  add primary key (ID);

prompt
prompt Creating table T_CONTENT
prompt ========================
prompt
create table T_CONTENT
(
  id            NUMBER(20) not null,
  menuid        NUMBER(20),
  userid        NUMBER(20),
  datetime      DATE default (sysdate),
  contenttitle  VARCHAR2(100),
  contentbody   CLOB,
  hits          NUMBER(20) default 0,
  commentnumber NUMBER(20) default 0
)
;
comment on table T_CONTENT
  is '���±�';
comment on column T_CONTENT.id
  is 'id';
comment on column T_CONTENT.menuid
  is '���id';
comment on column T_CONTENT.userid
  is '�û�id';
comment on column T_CONTENT.datetime
  is 'ʱ��';
comment on column T_CONTENT.contenttitle
  is '���ݱ���';
comment on column T_CONTENT.contentbody
  is '����';
comment on column T_CONTENT.hits
  is '�������';
comment on column T_CONTENT.commentnumber
  is '��������';
alter table T_CONTENT
  add primary key (ID);

prompt
prompt Creating table T_MENU
prompt =====================
prompt
create table T_MENU
(
  id       NUMBER(20) not null,
  pid      NUMBER(20),
  menuname VARCHAR2(100),
  orderof  NUMBER(20),
  show     NUMBER(20)
)
;
comment on table T_MENU
  is '�˵���';
comment on column T_MENU.id
  is 'id';
comment on column T_MENU.pid
  is '��id';
comment on column T_MENU.menuname
  is '�˵���';
comment on column T_MENU.orderof
  is '˳��';
comment on column T_MENU.show
  is '�Ƿ���ʾ';
alter table T_MENU
  add primary key (ID);

prompt
prompt Creating table T_USER
prompt =====================
prompt
create table T_USER
(
  id       NUMBER(20) not null,
  username VARCHAR2(100),
  password VARCHAR2(100),
  age      NUMBER(20),
  sex      VARCHAR2(2),
  email    VARCHAR2(100)
)
;
comment on table T_USER
  is '�û���';
comment on column T_USER.id
  is 'id';
comment on column T_USER.username
  is '�û���';
comment on column T_USER.password
  is '����';
comment on column T_USER.age
  is '����';
comment on column T_USER.sex
  is '�Ա�';
comment on column T_USER.email
  is '����';
alter table T_USER
  add primary key (ID);

prompt
prompt Creating sequence T_COMMENT_SEQ
prompt ===============================
prompt
create sequence T_COMMENT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence T_CONTENT_SEQ
prompt ===============================
prompt
create sequence T_CONTENT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence T_MENU_SEQ
prompt ============================
prompt
create sequence T_MENU_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence T_USER_SEQ
prompt ============================
prompt
create sequence T_USER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating package PKG_TEST
prompt =========================
prompt
create or replace package pkg_test as
procedure p_test;
end pkg_test;
/

prompt
prompt Creating package body PKG_TEST
prompt ==============================
prompt
create or replace package body pkg_test as
procedure p_test as
begin
  for emp in (select * from emp) loop
    execute immediate 'insert into test values ('''||emp.ename||''')';
  end loop;
end p_test;
end pkg_test;
/


spool off
