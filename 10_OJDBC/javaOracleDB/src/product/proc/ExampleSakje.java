package product.proc;

import java.util.Scanner;

import product.model.ProductDAO;
import product.model.ProductDTO;

public class ExampleSakje {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("상품코드: ");
		int productCode = Integer.parseInt(scanner.nextLine());
		
		ProductDTO productDto = new ProductDTO();
		productDto.setProductCode(productCode);
		
		ProductDAO productDao = new ProductDAO();
		int result = productDao.setDelete(productDto);
		
		if (result > 0) {
			System.out.println("-- Success delete --");
		} else {
			System.out.println("-- Fail delete --");
		}//end if
	}//end main
}//end ExampleSakje
