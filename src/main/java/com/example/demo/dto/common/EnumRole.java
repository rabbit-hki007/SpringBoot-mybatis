package com.example.demo.dto.common;

public enum EnumRole {

	USER ("30", "ROLE_USER"),
	ADMIN("10", "ROLE_ADMIN" )
	;
	
	private final String rolecode;
    private final String rolename;
    
	private EnumRole(String rolecode, String rolename) {
		this.rolecode = rolecode;
		this.rolename = rolename;
	}
	
	public String getRolecode() {
		return rolecode;
	}
	public String getRolename() {
		return rolename;
	}

    
}
