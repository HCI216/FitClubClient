package com.nju.FitClubClient.Enum;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RegisterResult")
public enum RegisterResult {
	SUCCESS,NAME_DULP,SQLERROR
}
