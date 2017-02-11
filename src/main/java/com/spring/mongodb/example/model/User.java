package com.spring.mongodb.example.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = User.COLLECTION_NAME)
public class User extends AbstractDomain {

    public static final String COLLECTION_NAME = "user";

    public static final String FIELD_EMAIL_ADDRESS = "emailAddress";
    public static final String FIELD_USER_NAME = "userName";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_CREATE_DATE = "createDate";
    public static final String FIELD_MODIFY_DATE = "modifyDate";
    public static final String FIELD_DELETE_DATE = "deleteDate";

    @Indexed(unique = true)
    @Field(FIELD_EMAIL_ADDRESS)
    private String emailAddress;

    @Indexed(unique = true)
    @Field(FIELD_USER_NAME)
    private String userName;

    @Field(FIELD_PASSWORD)
    private String password;

    @Field(FIELD_CREATE_DATE)
    private Date createDate;

    @Field(FIELD_DELETE_DATE)
    private Date deleteDate = null;

    @Field(FIELD_MODIFY_DATE)
    private Date modifyDate;


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "emailAddress='" + emailAddress + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                ", deleteDate=" + deleteDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}





