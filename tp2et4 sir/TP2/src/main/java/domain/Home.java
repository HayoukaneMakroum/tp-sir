package domain;


	import java.util.ArrayList;
import java.util.List;
	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	@Entity
	public class Home {
		private Long id;
		private String name;   
		private List<Person> person = new ArrayList<Person>();
		public Home() {
			super();
		}
		public Home(String name) { //test commit
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
		@OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
		public List<Person> getPerson() {
			return person;
		}
		public void setPerson(List<Person> person) {
			this.person = person;
		}
	


}
