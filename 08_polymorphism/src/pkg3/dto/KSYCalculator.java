package pkg3.dto;

// 인터페이스 상속 키워드 : implements(구현하다)

public class KSYCalculator implements Calculator{

	@Override
	public int plus(int a, int b) {
		int result = a + b;
		
		if(result > MAX_NUM) {
			System.out.println(MAX_NUM);
		} else if(result < MIN_NUM ) {
			System.out.println(MIN_NUM);
		}
		
		return result;
		
	}
	

	@Override
	public int minus(int a, int b) {
	
		int result = a - b;
		if(result > MAX_NUM) {
			System.out.println(MAX_NUM);
		} else if(result < MIN_NUM ) {
			System.out.println(MIN_NUM);
		}
		return result;
	}

	@Override
	public int div(int a, int b) {
	
		int result = a / b;
		return result;
	}

	@Override
	public int mod(int a, int b) {
	
		int result = a % b;
		return result;
	}

	@Override
	public int pow(int a, int x) {
		
		int result = 1;
		for(int i=0; i<x ; i++) {
			result *= a;
		}
		return result;
	}

	@Override
	public double aearOfCircle(double r) {
	
		
		return Calculator.PI * r * r;
	}

	@Override
	public String toBinary(int num) {
		
		String toBinary = Integer.toBinaryString(num);
		
		
		return toBinary;
	}

	@Override
	public String toHexadecimal(int num) {
		
		String toHexadecimal = Integer.toHexString(num);
		return toHexadecimal;
	}


	@Override
	public char[] multi(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
