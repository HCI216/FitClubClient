package com.nju.FitClubClient.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "BrandsFood")
public class BrandsFood extends Food {
	
	private String brandsName;

	public String getBrandsName() {
		return brandsName;
	}

	public void setBrandsName(String brandsName) {
		this.brandsName = brandsName;
	}

}
