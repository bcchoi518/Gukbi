package product.proc;

import java.util.Scanner;

import product.model.ProductDAO;
import product.model.ProductDTO;

public class ExampleChuga {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("상품이름: ");
		String productName = scanner.nextLine();
		System.out.print("상품가격: ");
		int productPrice = Integer.parseInt(scanner.nextLine());
		System.out.print("상품설명: ");
		String productContent = scanner.nextLine();
		System.out.print("제조사: ");
		String vender = scanner.nextLine();
		
		ProductDTO productDto = new ProductDTO();
		productDto.setProductName(productName);
		productDto.setProductPrice(productPrice);
		productDto.setProductContent(productContent);
		productDto.setVender(vender);
		
		ProductDAO productDao = new ProductDAO();
		int result = productDao.setInsert(productDto);
		
		if (result > 0) {
			System.out.println("-- Success insert !! --");
		} else {
			System.out.println("-- Fail insert !! --");
		}//end if
	}//end main
}//end ExampleChuga
