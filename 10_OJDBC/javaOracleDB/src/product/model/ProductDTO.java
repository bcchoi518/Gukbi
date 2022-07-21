package product.model;

import java.sql.Date;
import java.util.Scanner;

public class ProductDTO {
	private int productCode;
	private String productName;
	private int productPrice;
	private String productContent;
	private String vender;
	private Date regiDate;
	
	public ProductDTO() {
	}
	
	public void dataInput(String gubun) {
		Scanner scanner = new Scanner(System.in);
		if (gubun.equals("view") || gubun.equals("sujung") || gubun.equals("sakje")) {
			String imsi = "상세보기";
			if (gubun.equals("sujung")) {
				imsi = "수정";
			} else if (gubun.equals("sakje")) {
				imsi = "삭제";
			}//end if
			System.out.print(imsi + "할 상품코드: ");
			productCode = Integer.parseInt(scanner.nextLine());
			
			ProductDAO productDao = new ProductDAO();
			int result = productDao.dataCheck(productCode);
			if (result == 0) {
				System.out.println("─── Info ─────────────────────────────────────────────────────────────────────────");
				System.out.println("데이터가 없습니다.");
				System.out.println("──────────────────────────────────────────────────────────────────────────────────");
				return;
			}//end if
		}//end if
		if (gubun.equals("chuga") || gubun.equals("sujung")) {
		System.out.print("상품이름: ");
		productName = scanner.nextLine();
		System.out.print("상품가격: ");
		productPrice = Integer.parseInt(scanner.nextLine());
		System.out.print("상품설명: ");
		productContent = scanner.nextLine();
		System.out.print("제조사: ");
		vender = scanner.nextLine();
		}//end if
	}//end dataInput
	
	public void display(String gubun) {
		String msg = "";
		msg += productCode + "\t";
		msg += productName + "\t";
		msg += productPrice + "\t";
		if (gubun.equals("view")) {
			msg += productContent + "\t";
		}//end if
		msg += vender + "\t";
		msg += regiDate;
		
		System.out.println(msg);
	}//end display
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductContent() {
		return productContent;
	}
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	public String getVender() {
		return vender;
	}
	public void setVender(String vender) {
		this.vender = vender;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
}//end productDTO
