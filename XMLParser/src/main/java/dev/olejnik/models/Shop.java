package dev.olejnik.models;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Shop")
public class Shop {

	private ArrayList<Goods> goods;

	public ArrayList<Goods> getGoods() {
		return goods;
	}

	public void setGoods(ArrayList<Goods> goods) {
		this.goods = goods;
	}

}
