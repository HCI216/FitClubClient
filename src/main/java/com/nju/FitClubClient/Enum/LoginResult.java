package com.nju.FitClubClient.Enum;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="LoginResult")
public enum LoginResult {
	SQL_ERROR,NO_SUCH_USER,USER_PASSWORD_NOT_MATCH,SUCCESS,Login_ALREADY
}
