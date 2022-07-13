package sungjuk.proc;

import java.util.ArrayList;

import sungjuk.model.SungjukDTO;

public class Example {
	public static void main(String[] args) {
		ArrayList<SungjukDTO> list = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			SungjukDTO dto = new SungjukDTO();
			dto.inputData();
			list.add(dto);
		}//end for
		
		for (int i = 0; i < list.size(); i++) {
			SungjukDTO dto = list.get(i);
			dto.sumTotal();
			dto.display();
		}//end for
	}// end main
}// end Example
