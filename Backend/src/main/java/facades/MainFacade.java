package facades;

import dtos.BoatDTO;
import dtos.HarbourDTO;
import entities.Boat;
import entities.Harbour;
import entities.Owner;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MainFacade {
    private static EntityManagerFactory emf;
    private static MainFacade instance;

    private MainFacade() {
    }

    public static MainFacade getMainFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MainFacade();
        }
        return instance;
    }

    public boolean CreateBoat(BoatDTO bDto) {
        EntityManager em = emf.createEntityManager();
        Owner owner = em.find(Owner.class, bDto.getName());

        if (owner != null) {
            Harbour harbour = em.find(Harbour.class, bDto.getId());

            if (harbour!= null) {

                }

            em.getTransaction().begin();
            em.merge(owner);
            em.merge(harbour);
            em.getTransaction().commit();

        }

        return true;
    }
}
