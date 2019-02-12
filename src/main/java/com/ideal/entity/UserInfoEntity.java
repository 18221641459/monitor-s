package com.ideal.entity;

import java.util.Date;

public class UserInfoEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.id
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_name
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.wechat_id
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    private String wechatId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.cell_phone
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    private String cellPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.email
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.password
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.contact_address
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    private String contactAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.register_date
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    private Date registerDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.open_id
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    private String openId;
    
    
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.id
     *
     * @return the value of user_info.id
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.id
     *
     * @param id the value for user_info.id
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_name
     *
     * @return the value of user_info.user_name
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_name
     *
     * @param userName the value for user_info.user_name
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.wechat_id
     *
     * @return the value of user_info.wechat_id
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public String getWechatId() {
        return wechatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.wechat_id
     *
     * @param wechatId the value for user_info.wechat_id
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.cell_phone
     *
     * @return the value of user_info.cell_phone
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.cell_phone
     *
     * @param cellPhone the value for user_info.cell_phone
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone == null ? null : cellPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.email
     *
     * @return the value of user_info.email
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.email
     *
     * @param email the value for user_info.email
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.password
     *
     * @return the value of user_info.password
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.password
     *
     * @param password the value for user_info.password
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.contact_address
     *
     * @return the value of user_info.contact_address
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.contact_address
     *
     * @param contactAddress the value for user_info.contact_address
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.register_date
     *
     * @return the value of user_info.register_date
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.register_date
     *
     * @param registerDate the value for user_info.register_date
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.open_id
     *
     * @return the value of user_info.open_id
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.open_id
     *
     * @param openId the value for user_info.open_id
     *
     * @mbg.generated Wed Jan 23 13:22:19 CST 2019
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}
    
    
    
    
    
    
}