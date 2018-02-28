package domain;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
	public class Person {
		private Long id;
		private String name;
		private String firstName;
		private  int age;
		private Home home;
		private ElectronicDevice electronicdevice;
		public Person() {
		}
		public Person(String name, Home home,ElectronicDevice electronicdevice) {
			this.name = name;
			this.home = home;
			this.electronicdevice= electronicdevice;
		}
		
		
		
		public Person(String name) {
			super();
			this.name = name;
		}
	
		@Id
		@GeneratedValue
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getFirstName() {return firstName;	}
		public void setFirstName(String lastName) {this.firstName = lastName;		}

		public int getAge() {return age;	}
		public void setAge(int age) {this.age = age;	}

		@ManyToOne
		public Home getHome() {
			return home;
		}
		public void setHome(Home home) {
			this.home = home;
		}
		@ManyToOne
		public ElectronicDevice getElectronicdevice() {
			return electronicdevice;
		}
		public void setElectronicdevice(ElectronicDevice electronicdevice) {
			this.electronicdevice = electronicdevice;
		}
		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + ", home=" + home + "]";
		}
	}
	

