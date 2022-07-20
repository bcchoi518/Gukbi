package product.proc;

import java.util.ArrayList;
import java.util.Scanner;

import product.model.ProductDAO;
import product.model.ProductDTO;

public class Example {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductDTO arguDto = new ProductDTO();
		ProductDAO productDao = new ProductDAO();
		ProductDTO resultDto = new ProductDTO();
		int result = 0;
		
		MENU:
		while (true) {
			System.out.print("상품관리메뉴선택(0:종료, 1:목록, 2:상세, 3:추가, 4:수정, 5:삭제) : ");
			String choice = scanner.nextLine();
			
			switch(choice) {
				case "1":
					ArrayList<ProductDTO> list = productDao.getSelectAll();
					for (int i = 0; i < list.size(); i++) {
						resultDto = list.get(i);
						resultDto.display("list");
					}//end for
					break;
				case "2":
					arguDto.dataInput("view");
					resultDto = productDao.getSelectOne(arguDto);
					if (resultDto.getRegiDate() != null) {
						resultDto.display("view");
					}//end if
					break;
				case "3":
					arguDto.dataInput("chuga");
					result = productDao.setInsert(arguDto);
					break;
				case "4":
					arguDto.dataInput("sujung");
					result = productDao.setUpdate(arguDto);
					break;
				case "5":
					arguDto.dataInput("sakje");
					result = productDao.setDelete(arguDto);
					break;
				default:
					System.out.println("-- 상품관리 프로그램종료 --");
					break MENU;
			}//end switch
		}//end while
	}//end main
}//end Example
