package pl.peersoft.model.chat;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Player {

    public Player() {}

    public Player(Long id, String uuid, String firstName) {
        this.id = id;
        this.uuid = uuid;
        this.firstName = firstName;
    }

    @Id
    private Long id;

    private String uuid;

    @Column(name = "first_name")
    private String firstName;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    List<Chat> chats;

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", chats=" + chats +
                '}';
    }
}


