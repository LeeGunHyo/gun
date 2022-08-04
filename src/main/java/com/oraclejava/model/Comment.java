package com.oraclejava.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "player_comment")
public class Comment {

    public Comment(){}
    public Comment(String comment,Player player){
        this.comment = comment;
        this.player = player;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "comment_seq")
    @SequenceGenerator(name = "comment_seq", allocationSize = 1,
            sequenceName = "PLAYER_COMMENT_SEQ")
    private int id;

    @Column(name = "comment_story")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "playerId")
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
