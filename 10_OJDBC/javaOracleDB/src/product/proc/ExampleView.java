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
		ProductDTO dto = productDao.getSelectOne(productDto);
		
		System.out.println("productCode: " + dto.getProductCode());
		System.out.println("productName: " + dto.getProductName());
		System.out.println("productPrice: " + dto.getProductPrice());
		System.out.println("productContent: " + dto.getProductContent());
		System.out.println("vender: " + dto.getVender());
		System.out.println("regiDate: " + dto.getRegiDate());
	}//end main
}//end ExampleView
