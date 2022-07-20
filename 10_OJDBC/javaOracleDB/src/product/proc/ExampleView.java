package product.proc;

import java.sql.Date;
import java.util.Scanner;

import product.model.ProductDAO;
import product.model.ProductDTO;

public class ExampleView {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("상품코드: ");
		int productCode = Integer.parseInt(scanner.nextLine());
		
		ProductDTO productDto = new ProductDTO();
		productDto.setProductCode(productCode);
		
		ProductDAO productDao = new ProductDAO();
		ProductDTO resultDto = productDao.getSelectOne(productDto);
		
		System.out.println("productCode: " + resultDto.getProductCode());
		System.out.println("productName: " + resultDto.getProductName());
		System.out.println("productPrice: " + resultDto.getProductPrice());
		System.out.println("productContent: " + resultDto.getProductContent());
		System.out.println("vender: " + resultDto.getVender());
		System.out.println("regiDate: " + resultDto.getRegiDate());
	}//end main
}//end ExampleView
