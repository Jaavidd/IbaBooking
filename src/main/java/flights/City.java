package flights;

import java.util.Arrays;
import java.util.List;

public class City {

        private final List<String> cities = Arrays.asList(
                "Baku", "Moscow", "Berlin", "Minsk", "Brussels",
                "Zagreb", "Copenhagen", "Helsinki", "Vienna",
                "Paris", "Athens", "Budapest", "Rome", "Riga",
                "Vilnius", "Podgorica", "Amsterdam", "Oslo",
                "Skopje", "Warsaw", "Lisbon", "Bucharest",
                "Belgrade", "Madrid", "Bern", "Stockholm",
                "London", "Kiev");

        public String getRandomCity() {
            return cities.get((int) (cities.size() * Math.random()));
        }

}
