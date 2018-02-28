package domain;




import java.util.ArrayList;
	import java.util.List;
	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
	@Entity
	public class Heater {
		private Long id;
		private String name;
		private List<Home> home = new ArrayList<Home>();
		public Heater() {
			super();
		}
		public Heater(String name) {
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
		@OneToMany(cascade = CascadeType.PERSIST)
		@JoinColumn(name="heaterid")
		public List<Home> getHome() {
			return home;
		}
		public void setHome(List<Home> home) {
			this.home = home;
		}
	


}
