
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.hname.model.City;
import com.hname.model.Hotel;
import com.hname.model.Room;

public class TestMain {
	public static void main(String[] args) {
		List<City> list = new ArrayList<>();
		list.add(new City(1, "Bengaluru"));
		list.add(new City(2, "Mysore"));
		list.add(new City(3, "Hubli"));

		Gson gson = new Gson();
		City city = new City();

		// 1. Java object to JSON, and save into a file
		gson.toJson(city);

		// 2. Java object to JSON, and assign to a String
		System.out.println(gson.toJson(list));

		List<Hotel> hotels = new ArrayList<>();
		hotels.add(new Hotel(1, "hotel1Name", "hotel1Address", "hotel1Phone"));
		hotels.add(new Hotel(2, "hotel2Name", "hotel2Address", "hotel2Phone"));
		hotels.add(new Hotel(3, "hotel3Name", "hotel3Address", "hotel3Phone"));
		hotels.add(new Hotel(4, "hotel4Name", "hotel4Address", "hotel4Phone"));
		hotels.add(new Hotel(5, "hotel5Name", "hotel5Address", "hotel5Phone"));
		hotels.add(new Hotel(6, "hotel6Name", "hotel6Address", "hotel6Phone"));
		System.out.println(gson.toJson(hotels));

		List<Room> rooms = new ArrayList<>();
		rooms.add(new Room(1, "Non-AC"));
		rooms.add(new Room(2, "AC"));
		rooms.add(new Room(3, "Non-AC"));
		System.out.println(gson.toJson(rooms));

	}

}
