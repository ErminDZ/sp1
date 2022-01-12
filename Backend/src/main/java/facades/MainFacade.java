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
        Owner owner = em.find(Owner.class,bDto.getName());

        if (owner != null) {
            Boat boat = em.find(Boat.class, bDto.getId());

            if (boat!= null) {
                }

            em.getTransaction().begin();
            em.merge(owner);
            em.getTransaction().commit();

        }

        return true;
    }

    public boolean AddBoatToHarbour(BoatDTO bDto) {
        EntityManager em = emf.createEntityManager();
        Harbour harbour = em.find(Harbour.class, bDto);

        if (harbour != null) {
            Boat boat = em.find(Boat.class, bDto.getId());

            if (boat!= null) {
                harbour.addboats(boat);
                boat.setHarbour(harbour);
            }

            em.getTransaction().begin();
            em.merge(harbour);
            em.merge(boat);
            em.getTransaction().commit();

        }

        return true;
    }


}
