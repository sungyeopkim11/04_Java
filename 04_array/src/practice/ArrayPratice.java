package practice;

import java.util.Scanner;

public class ArrayPratice {
	
	Scanner sc = new Scanner(System.in);
	/**
	 * 길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
	 */
	public void practice1(){
		int[] arr = new int[9];
		
		// 배열 요소 초기화
		for(int i=0; i<arr.length; i++) { // 배열 선언,할당
			arr[i] = i + 1;
		}
		
		// 출력 및 합계
		int sum = 0;
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i] + " ");
			
			if(i % 2 == 0) {
				sum += arr[i];
				
			}
		}
		
		System.out.println("\n짝수 번째 인덱스 합 : " + sum);
	}
	
	/**
	 * 길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
	 */
	public void practice2(){
		int[] arr = new int[9];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr.length - i;
		}
		
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
			
			if(i % 2 == 1) {
				sum += arr[i];
			}
			
		}
		System.out.println("\n홀수 번째 인덱스 합 : " + sum);
	}
	
	public void practice3(){
		
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input]; // 입력 받은 크기 만큼의 배열 할당
		
		for(int i=1; i<=arr.length; i++) {
			System.out.print(i + " ");
		}
	}
	
	public void practice4(){
		
		int[] arr = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt(); // 요소 마다 입력 값 대입
		}
		
		System.out.print("검색할 값 :");
		int search = sc.nextInt();
		
		// 검색 값이 존재하면 true
		// 없으면 false
		boolean flag = false;
		
		for(int i=0; i<arr.length; i++) {
			
			// i번째 요소에 저장된 값과 검색할 값이 같은 경우
			if(arr[i] == search) {
				System.out.println("인덱스 : " + i);
				flag = true; // 같은 값이 있으니 true로 변경
			}
		}
		
		if(!flag) { // flag == false
			System.out.println("일치하는 값이 존재하지 않습니다");
		}
		
		
	}
	
	
	public void practice5(){
		System.out.print("정수 :");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 :",i);
			arr[i] = sc.nextInt();
			
			sum += arr[i];
		}
		
		// 한 줄 출력
		for(int value : arr) System.out.print(value + " ");
		
		// 합계 출력
		System.out.println("\n총 합 : " + sum);
		
	}
	// 문자열.length() : 문자열의 길이
	// 문자열.charAt(index) : 문자열 중 index번째 문자(char) 반환
	public void practice6(){
		
		char[] arr = new char[14];
		
		System.out.print("주민등록번호(-포함) : ");
		String str = sc.next();
		
		// 주민등록번호를 char 배열 요소로 하나씩 대입
		for(int i=0; i<str.length(); i++) {
			
			if(i <= 7) arr[i] = str.charAt(i); // 성별 까지
			else       arr[i] = '*';           // 성별 이후
			
			System.out.print(arr[i]); // 출력
				
			
		}
	}
			

}
