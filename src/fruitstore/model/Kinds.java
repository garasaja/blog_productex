package fruitstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Kinds {
	private int id;
	private String name;
	private int price;
	private int countprice;
	private String type;
}
