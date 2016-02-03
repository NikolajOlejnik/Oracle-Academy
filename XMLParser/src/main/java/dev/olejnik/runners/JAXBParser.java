package dev.olejnik.runners;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import dev.olejnik.models.Goods;
import dev.olejnik.models.Shop;

public class JAXBParser {

	public static void main(String[] args) {

		Shop firstShop = new Shop();

		Goods first = new Goods();

		first.setId(1);
		first.setCategory("Phones");
		first.setPrice(23.5);
		first.setName("Iphone 5");
		first.setDescription("Old phone");

		Goods second = new Goods();

		second.setId(2);
		second.setCategory("Phones");
		second.setPrice(234234.555);
		second.setName("Iphone 6s");
		second.setDescription("New phone");

		ArrayList<Goods> goods = new ArrayList<>();

		goods.add(first);
		goods.add(second);

		firstShop.setGoods(goods);

		try {

			JAXBContext jc = JAXBContext.newInstance(Shop.class);

			File firstFile = new File("XMLout.xml");
			File secondFile = new File("XMLFile.xml");

			Marshaller m = jc.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(firstShop, firstFile);

			m.marshal(firstShop, System.out);

			Unmarshaller u = jc.createUnmarshaller();

			Shop secondShop = (Shop) u.unmarshal(secondFile);

			ArrayList<Goods> secondGoods = secondShop.getGoods();

			for (Goods good : secondGoods) {
				System.out.println(good.getName());
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}