package com.realdolmen.candyshop.dao;

import com.realdolmen.candyshop.entities.Person;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by vdabcursist on 08/08/2017.
 */
public class PersonDAOTest {
    private static EntityManagerFactory emf;
    private static PersonDAOImpl dao;
    private EntityManager em;
    private EntityTransaction tx;

    @BeforeClass
    public static void setup() {
        emf=Persistence.createEntityManagerFactory("Test");
        dao = new PersonDAOImpl();


    }

    @Before
    public void init () {
        em = emf.createEntityManager();
        dao.em = em;
        tx = em.getTransaction(); // transaction ophalen
        tx.begin();
    }
    @After
    public void destroy() {
        tx.rollback();
        em.close();
        System.out.println("@After is rolledback!");
    }

    @AfterClass
    public static void cleanup(){
        emf.close();

    }

    @Test
    public void shouldSafePerson() {

        Person p = new Person("Theo", "Tester");
        Long id = dao.createPerson(p);
        assertNotNull(id);
        assertEquals(new Long (3L),id);  //nota: 3 is standaard een int , een 3L is een literal Long ,
        // een 3,0f is een float )

    }

    @Test
    public void shouldFindAllPeople() {
        List<Person> people = dao.findAllPeople();
        assertNotNull(people);
        assertEquals(2,people.size());
        System.out.println("@Test is finised!");
    }



}
