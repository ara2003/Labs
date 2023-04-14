package com.example.lab;


public enum Type {
	
	ELEMENT {
		
		@Override
		public ReturnType toReturnType() {
			return ReturnType.ELEMENT;
		}
	},LIST {
		
		@Override
		public ReturnType toReturnType() {
			return ReturnType.LIST;
		}
	},;
	
	public abstract ReturnType toReturnType();
	
	
}
