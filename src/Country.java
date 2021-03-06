/**
 * 
 */

/**
 * @author Mariah
 *
 */
public class Country {

	private String countryName;
	private int population;

	public Country() {
	}

	public Country(String countryName, int population) {
		this.countryName = countryName;
		this.population = population;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return String.format("Country: %-20s Population: %15d", getCountryName(), getPopulation());
	}

}
