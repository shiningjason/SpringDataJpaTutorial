package net.lustertech.training.data.domains;

public class Player {

    private Integer id;

    private String username;

    private String password;

    private String nickname;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
