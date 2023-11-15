package com.codeinvestigator.multiple_datasources.pass;
import lombok.Data;
import javax.persistence.*;

@Data
@Table
@Entity
public class Passengers {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String ppNum;

    @Column
    private String gender;

    @Column
    private String country;

    @Column
    private String roomNum;

    @Column
    private boolean checkedIn;

    public static Passengers of(String name, String ppNum, String gender, String country, String roomNum, boolean checkedIn)
    {
        Passengers passenger = new Passengers();
        passenger.name = name;
        passenger.ppNum = ppNum;
        passenger.gender = gender;
        passenger.country = country;
        passenger.roomNum = roomNum;
        passenger.checkedIn = checkedIn;
        return passenger;
    }

}
