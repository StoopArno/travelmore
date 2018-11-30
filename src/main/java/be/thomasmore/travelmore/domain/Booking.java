package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "booking")
@NamedQueries(
        {
                @NamedQuery(
                        name = Booking.FIND_ALL,
                        query = "SELECT b FROM Booking b"
                ),
                @NamedQuery(
                        name = Booking.FIND_BY_ID,
                        query = "SELECT b FROM Booking b WHERE b.id = :id"

                )
        }
)

public class Booking {

    //properties
    public static final String FIND_ALL = "Booking.findAll";
    public static final String FIND_BY_ID = "Booking.findById";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "isBetaald")
    private boolean isBetaald;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gebruikerID")
    private Gebruiker gebruiker;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "reisID")
    private Reis reis;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public boolean isBetaald() {
        return isBetaald;
    }
    public void setBetaald(boolean betaald) {
        isBetaald = betaald;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }
    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public Reis getReis() {
        return reis;
    }
    public void setReis(Reis reis) {
        this.reis = reis;
    }
}