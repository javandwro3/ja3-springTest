package pl.jwrabel.trainings.javandwro3.ja3springTest;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by jakubwrabel on 31/05/2017.
 */
public class Customer {
	private int id;
	private String name;
	private String surname;
	private String pesel;

	public Customer(int id, String name, String surname, String pesel) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.pesel = pesel;
	}

	public Customer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", pesel='" + pesel + '\'' +
				'}';
	}
}
