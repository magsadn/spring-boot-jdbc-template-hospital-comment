package com.magsad.springboothospitalapp.repository;

public class SQLConstants {
    public static final String SQL_FIND_HOSPITAL = "select * from hospital where id=?";
    public static final String SQL_FIND_ALL_HOSPITALS = "select * from hospital";
    public static final String SQL_DELETE_HOSPITAL = "delete from hospital where id=?";
    public static final String SQL_UPDATE_HOSPITAL = "update hospital set name=?,address=?,email=?,phone=? where id=?";
    public static final String SQL_INSERT_HOSPITAL = "insert into hospital (id,name,address,email,phone) values (nextval('hospital_id'),?,?,?,?)";

    public static final String SQL_FIND_COMMENT = "select * from comment where id=?";
    public static final String SQL_FIND_ALL_COMMENTS = "select * from comment";
    public static final String SQL_DELETE_COMMENT = "delete from comment where id=?";
    public static final String SQL_UPDATE_COMMENT = "update comment set author=?,comment=?,email=?,hospital_id=?,is_published=? where id=?";
    public static final String SQL_INSERT_COMMENT = "insert into comment (author,comment,email,hospital_id,is_published) values (nextval('comment_id'),?,?,?,?)";
    public static final String SQL_FIND_COMMENTS_BY_HOSPITAL = "select * from comment where hospital_id = ?";

}

//40:15
