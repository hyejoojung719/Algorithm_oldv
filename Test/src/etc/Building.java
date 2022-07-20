package etc;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Building {
	
	// 주변에 G가 없을 때 가로 세로 빌딩 갯수 카운트
	public static int cntBuilding(String[][] map ,int col, int row, int n) {
		
		int cnt = 0;
		// 가로
		for(int j=0; j<n; j++) {
			if(map[col][j].equals("B")) cnt++;
		}
		
		// 세로
		for(int j=0; j<n; j++) {
			if(map[j][row].equals("B")) cnt++;
		}
		
		return cnt-1;
	}
	
	public static void main(String[] args){
		
		// n*n 형태 부지
		// 구획 당 하나의 빌딩 
		// B : 빌딩을 세울 수 있는 구획
		// G : 공원
		// 인접 : 상하 좌우 대각선 모두 포함
		// 인접한 곳에 G가 있으면 2층 가능
		// 없으면 가로위치 빌딩B와 세로위치 빌딩B의 갯수만큼 빌딩을 세울 수 있음(현위치 B도 포함)
		
		// 가장 높이 세울 수 있는 빌딩은? 
		
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		
		for(int tc = 1; tc <= test_case; tc++) {
			int n = sc.nextInt();
			
			String[][] map = new String[n][n];
			int cnt = 0;
			int max = Integer.MIN_VALUE;
			
			// map 입력 받기
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.next();
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					// B글자인지 확인
					if(map[i][j].equals("B")) {
						
						
						//경계선과 인접 여부에 따라 케이스 나눔
						if(i==0) {// 윗면과 인접할 때  
							
							if(j==0) {
								// 왼쪽면과 인접
								if(map[i][j+1].equals("G")|| map[i+1][j].equals("G") || map[i+1][j+1].equals("G")) {
									cnt = 2;
								}else {
									cnt = cntBuilding(map, i, j, n);
								}
							}else if(j==n-1) {
								// 오른쪽면과 인접
								if(map[i][j-1].equals("G")|| map[i+1][j].equals("G") || map[i+1][j-1].equals("G")) {
									cnt = 2;
								}else {
									cnt = cntBuilding(map, i, j, n);
								}
								
							}else {
								// 옆면과 인접하지 않을 때 -> 좌우하대각선아래 
								if(map[i][j-1].equals("G") || map[i][j+1].equals("G") || map[i+1][j].equals("G") || map[i+1][j-1].equals("G") || map[i+1][j+1].equals("G")) {
									cnt = 2;
								}else {
									cnt = cntBuilding(map, i, j, n);
								}
							}
							
						}else if(i==n-1) {// 아랫면과 인접할 때
							
							if(j==0) {
								// 왼쪽면과 인접
								if(map[i][j+1].equals("G")|| map[i-1][j].equals("G") || map[i-1][j+1].equals("G")) {
									cnt = 2;
								}else {
									cnt = cntBuilding(map, i, j, n);
								}
								
							}else if(j==n-1) {
								// 오른쪽면과 인접
								if(map[i][j-1].equals("G")|| map[i-1][j].equals("G") || map[i-1][j-1].equals("G")) {
									cnt = 2;
								}else {
									cnt = cntBuilding(map, i, j, n);
								}
							}else {
								// 옆면과 인접하지 않을 때  -> 좌우상대각선위 
								if(map[i][j-1].equals("G") || map[i][j+1].equals("G") || map[i-1][j].equals("G") || map[i-1][j-1].equals("G") || map[i-1][j+1].equals("G")) {
									cnt = 2;
								}else {
									cnt = cntBuilding(map, i, j, n);
								}
							}
							
						}else {//인접하지 않을 때
							
							if(j==0) {
								// 왼쪽면과 인접 -> 우 하 대각선우측아래
								if(map[i][j+1].equals("G")|| map[i+1][j].equals("G") || map[i+1][j+1].equals("G")) {
									cnt = 2;
								}else {
									cnt = cntBuilding(map, i, j, n);
								}
								
							}else if(j==n-1) {
								// 오른쪽면과 인접 -> 좌 하 대각선 좌측아래
								if(map[i][j-1].equals("G")|| map[i+1][j].equals("G") || map[i+1][j-1].equals("G")) {
									cnt = 2;
								}else {
									cnt = cntBuilding(map, i, j, n);
								}
								
							}else {
								// 옆면과 인접하지 않을 때 -> 좌 우 상 하 대각선모두
								if(map[i][j-1].equals("G")|| map[i][j+1].equals("G") || map[i+1][j].equals("G") || 
										map[i-1][j].equals("G") || map[i+1][j-1].equals("G") || map[i+1][j+1].equals("G") || map[i-1][j-1].equals("G") || map[i-1][j+1].equals("G")) {
									cnt = 2;
								}else {
									cnt = cntBuilding(map, i, j, n);
								}
							}
						}
						
						if(max < cnt) max = cnt;
					}
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}
}
