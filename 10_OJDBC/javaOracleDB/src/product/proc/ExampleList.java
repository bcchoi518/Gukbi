package product.proc;

import java.sql.Date;
import java.util.ArrayList;

import product.model.ProductDAO;
import product.model.ProductDTO;

public class ExampleList {
	public static void main(String[] args) {
		ProductDAO productDao = new ProductDAO();
		ArrayList<ProductDTO> list = productDao.getSelectAll();
		
		for (int i = 0; i < list.size(); i++) {
			ProductDTO resultDto = list.get(i);
			int productCode = resultDto.getProductCode();
			String productName = resultDto.getProductName();
			int productPrice = resultDto.getProductPrice();
			String vender = resultDto.getVender();
			Date regiDate = resultDto.getRegiDate();
			
			System.out.println("productCode: " + productCode);
			System.out.println("productName: " + productName);
			System.out.println("productPrice: " + productPrice);
			System.out.println("vender: " + vender);
			System.out.println("regiDate: " + regiDate);
			System.out.println("------------------------------------");
		}//end for
	}//end main
}//end ExampleList
