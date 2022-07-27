package com.ssafy.collectionhw.copy;

public class UserManagerImpl implements IUserManager {
	
	// ArrayList 를 사용하여 사용자 리스트 관리하기
	private __________ userList = new _____________;

	private final int MAX_SIZE = 100;

	private static UserManagerImpl um = new UserManagerImpl();

	private UserManagerImpl() {
	};

	public static UserManagerImpl getInstance() {
		return um;
	}
	
	// ArrayList의 사용 방법에 맞게 구현
	public void add(User user) {
		if (________ < MAX_SIZE) {
			userList.______;
		} else {
			System.out.println("유저의 수가 100을 넘었습니다. 등록 불가.");
		}
	}
	
	// ArrayList를 배열로 변환하여 반환
	public User[] getList() {

		User[] res = new User[_______];

		return this.userList.toArray(res);
	}
	
	// ArrayList의 사용 방법에 맞게 구현
	public User[] getUsers() {

		__________ list = new __________;

		for (int i = 0; i < __________; i++) {
			if (!(__________ instanceof VipUser)) {
				list.__________(__________);
			}
		}

		User[] res = new User[__________];

		return list.toArray(res);

	}	

	// ArrayList의 사용 방법에 맞게 구현
	public VipUser[] getVipUsers() {

		__________ list = new __________;

		for (int i = 0; i < __________; i++) {
			if (!(__________ instanceof VipUser)) {
				list.__________((VipUser) __________);
			}
		}
		
		VipUser[] res = new VipUser[__________];

		return list.toArray(res);

	}
	
	// ArrayList의 사용 방법에 맞게 구현
	public User[] searchByName(String name) {

		__________ list = new __________;

		for (int i = 0; i < _________; i++) {
			if (__________.getName().contains(name)) {
				list.__________(__________);
			}
		}
		
		// 주어진 단어를 포함하는 사용자가 없으면 null을 반환한다.
		if(__________ == 0)
			return null;
		
		User[] res = new User[__________];

		return list.toArray(res);
	}
	
	// ArrayList의 사용 방법에 맞게 구현
	public double getAgeAvg() {

		int sum = 0;

		for (int i = 0; i < _________; i++) {
			sum += ________.getAge();
		}

		return sum / _________;

	}

}