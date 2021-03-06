package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GebruikerRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Gebruiker findById(int id) {
        return entityManager.find(Gebruiker.class, id);
    }

    public void insert(Gebruiker gebruiker) {
        entityManager.persist(gebruiker);
    }
    public List<Gebruiker> findGeruikerByEmail(Gebruiker gebruiker){
        return entityManager.createNamedQuery(Gebruiker.FIND_BY_EMAIL,Gebruiker.class).setParameter("email",gebruiker.getEmail()).getResultList();
    }

    public List<Gebruiker> findAll() {
        return entityManager.createNamedQuery(Gebruiker.FIND_ALL, Gebruiker.class).getResultList();
    }

    public void update (Gebruiker gebruiker) {
        entityManager.merge(gebruiker);
    }

    public void delete(int id) {
        Gebruiker gebruiker = entityManager.find(Gebruiker.class, id);
        entityManager.remove(gebruiker);
    }
}
