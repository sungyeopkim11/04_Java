package list.service;

import java.util.ArrayList;
import java.util.List;

import list.dto.CafeDTO;

// service : 기능(비즈니스 로직) 제공용 클래스
public class CafeService {
	
	// CafeDTO 객체 참조 변수만을 저장하는
	// ArrayList 객체 생성
	// -> <CafeDTO> == 제네릭(타입 제한)
	private List<CafeDTO> cafeList = new ArrayList<CafeDTO>();
	
	// 기본 생성자
	public CafeService() {
		cafeList.add(new CafeDTO("스타벅스", "아메리카노", 4500));
		cafeList.add(new CafeDTO("바나프레소", "아메리카노", 1800));
		cafeList.add(new CafeDTO("메가커피", "아메리카노", 2000));
		cafeList.add(new CafeDTO("꽁트커피", "아메리카노", 1400));
	}

	/**
	 * cafeList를 반환하는 서비스 메서드
	 * @return
	 */
	public List<CafeDTO> selectAll() {
		
		return cafeList;
	}

	public CafeDTO selectIndex(int index) {
		
		
		if(index < 0 || index >= cafeList.size()) return null;
		return cafeList.get(index);
	}

	public List<CafeDTO> selectStore(String store) {
		
		List<CafeDTO> searchList = new ArrayList<CafeDTO>();
		
		for(CafeDTO storename : cafeList) {
			
			if(storename.getStore().contains(store)) {
				
				searchList.add(storename);
			}
		}
		
		return searchList;
	}

	public List<CafeDTO> selectPrice(int min, int max) {

		List<CafeDTO> searchList = new ArrayList<CafeDTO>();
		
		for(CafeDTO storename : cafeList) {
			int price = storename.getPrice();
			
			if(price >= min && price <= max) {
				searchList.add(storename);
			}
		}

		return searchList;
	}
	
	public boolean addCafe(CafeDTO newCafe) {
		return cafeList.add(newCafe);
	}

	public String removeCafe(int index) {
		
		if(index < 0 || index >= cafeList.size()) {
			return null;
		}
		
		return cafeList.remove(index).getStore();
	}
	

}
