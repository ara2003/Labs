package com.example.lab;


public enum ReturnType {
	
	ELEMENT {
		
		@Override
		public Type toType() {
			return Type.ELEMENT;
		}
	},
	LIST {
		
		@Override
		public Type toType() {
			return Type.LIST;
		}
	},
	VOID {
		
		@Override
		public Type toType() {
			throw new UnsupportedOperationException("convert void to type");
		}
	},;
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
	
	public abstract Type toType();
}
