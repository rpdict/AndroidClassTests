package com.example.chapter6_sms;

public class SmsInfo {
	/**
     * ��������
     */
    private String smsbody;
    /**
     * ���Ͷ��ŵĵ绰����
     */
    private String phoneNumber;
    /**
     * ���Ͷ��ŵ����ں�ʱ��
     */
    private String date;
    /**
     * ���Ͷ����˵�����
     */
    private String name;
    /**
     * ��������1�ǽ��յ��ģ�2���ѷ���
     */
    private String type;
    
    public SmsInfo() {
		super();
	}

	public SmsInfo(String smsbody, String phoneNumber, String date, String name, String type) {
		super();
		this.smsbody = smsbody;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.name = name;
		this.type = type;
	}

	public String getSmsbody() {
        return smsbody;
    }
 
    public void setSmsbody(String smsbody) {
        this.smsbody = smsbody;
    }
 
    public String getPhoneNumber() {
        return phoneNumber;
    }
 
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
 
    public String getDate() {
        return date;
    }
 
    public void setDate(String date) {
        this.date = date;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
}
