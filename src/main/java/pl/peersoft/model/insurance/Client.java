package pl.peersoft.model.insurance;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String pesel;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime birthday;

	@OneToOne
	private Address address;

	@OneToMany(mappedBy = "client")
	private Set<Insurance> insurance;

	@ManyToMany
	@JoinTable(
			name = "clients_offers",
			joinColumns = {@JoinColumn(name = "client_id")},
			inverseJoinColumns = {@JoinColumn(name = "offer_id")}
	)
	private Set<Offer> offers;

	public Client(String firstName,
				  String lastName,
				  String pesel,
				  LocalDateTime createdAt,
				  LocalDateTime updatedAt,
				  LocalDateTime birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.birthday = birthday;
	}

	public Client() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Client{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", pesel='" + pesel + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", birthday=" + birthday +
				", address=" + address +
				", insurance=" + insurance +
				", offers=" + offers +
				'}';
	}
}