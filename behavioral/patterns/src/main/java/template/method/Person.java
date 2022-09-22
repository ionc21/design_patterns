package template.method;

public class Person implements Comparable<Person> {

	private int age;
	private String name;
	private String phoneNumber;

	public Person() {

	}

	public Person(final String name, final String phoneNumber, final int age) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int compareTo(final Person o) {
		if (this.age > o.age) {
			return 1;
		}
		if (this.age < o.age) {
			return -1;
		}
		return 0;
	}

}
