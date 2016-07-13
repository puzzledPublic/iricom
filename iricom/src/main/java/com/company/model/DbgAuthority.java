package com.company.model;


public enum DbgAuthority {

    	ADMIN(0), DIAMOND(1), PLATINUM(2), GOLD(3), SILVER(4), BRONZE(5);
    	
    	private int value;
    	
    	private DbgAuthority(int value){
    		this.value = value;
    	}
    	public int getIntAuthValue(){
    		return value;
    	}
    	public static DbgAuthority valueOf(int value)
    	{
    		switch(value)
    		{
    		case 0: return ADMIN;
    		case 1: return DIAMOND;
    		case 2: return PLATINUM;
    		case 3: return GOLD;
    		case 4: return SILVER;
    		case 5: return BRONZE;
    		default: throw new AssertionError("Unknown value" + value);
    		}
    	}
    	
}
